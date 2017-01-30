package km_Handler;

import javax.faces.bean.ManagedBean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import km_Entities.Admin;
import km_Entities.Student;
import km_Entities.StudentClass;
import km_Entities.User;
import km_Services.EntityManagerFactoryService;
import km_Services.LoginService;
import km_Services.StudentService;
import km_Views.StudentView;
import km_Views.UserView;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ManagedBean(name="loginHandler", eager=true)
@SessionScoped
public class LoginHandler implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 145257865L;
	private String email;
	private String password;
	private UserView user;	//deleted get/set for security reasons
	private StudentView student; //no get/set for security reasons
	
	private boolean loggedIn;

	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;
	
	@ManagedProperty("#{loginServiceImpl}")
	private LoginService loginService;
	

	@ManagedProperty("#{studentServiceImpl}")
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginservice) {
		this.loginService = loginservice;
	}
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
		
	public String login() {
		try{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		UserView user = (UserView) sessionMap.get("user");
		if(student!=null){
			this.user = user;
			System.out.println("user in session "+user.toString());
			return "student"; 	//additional check required to forward admin
		}else{
			System.out.println("no user in session");
		}
		}catch(Exception e){
			System.out.println("Fehler bei prüfen ob user im chache ");
			e.printStackTrace();
		}
		System.out.println("in login");
		
		System.out.println("Set up test user");
		try{
			EntityManagerFactory emf = EntityManagerFactoryService.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			
			Query q = em.createQuery("SELECT Count(*) from User");
			long count = (long)q.getSingleResult();
			
			if(count == 0){
				em.getTransaction().begin();
				User u1 = new User("Max", "Mustermann", "max.mustermann@education-siemens.com", null, "Geheim");
				User u2 = new User("Timo", "Böse", "blocked@education-siemens.com", null, "Geheim");
				User u3 = new User("Short", "Short", "short@short.com", null, "Short");
				User u4 = new User("Armin", "Admin", "admin@education-siemens.com", null, "Geheim");
				StudentClass sc1 = new StudentClass("FS",null);
				StudentClass sc2 = new StudentClass("FI",null);
				Student s1 = new Student(100, u1, sc1, null, true);
				Student s2 = new Student(3200, u2, sc2, null, true);
				Student s3 = new Student(10, u3, sc1, null, false);
				Admin a1 = new Admin(u4);
				
				em.persist(u1);
				em.persist(u2);
				em.persist(u3);
				em.persist(u4);
				em.persist(sc1);
				em.persist(sc2);
				em.persist(s1);
				em.persist(s2);
				em.persist(s3);
				em.persist(a1);
				em.getTransaction().commit();
			}

			em.close();
		}catch(Exception e){
			System.out.println("Fehler beim setup der testuser!!!");
			e.printStackTrace();
		}
		
		System.out.println("finished with setting up test user");
		
		System.out.println("Login attempt by "+email+ " using: " + password); //TO DELETE
		
		try{
			user = loginService.getLogin(email, password);
		}catch(Exception e){

			e.printStackTrace();
			throw new ValidatorException(
							new FacesMessage("Bitte wiederholen Sie den Login Vorgang!"));
			}
		FacesContext context = FacesContext.getCurrentInstance();
		if(user != null){
			context.getExternalContext().getSessionMap().put("user", user);
			loggedIn = true;
			
			if(!user.isAdmin())	//Bug hier, siehe User Konstruktor!
			{
				System.out.println(user.getUserId());
				//Student s = studentService.findStudentByUserId(user.getUserId()); //placeholder needs to be fixed!!!!!!!!!!!!!!!
				Student s = studentService.findStudentByUser(user); 
				if(null==s.getUser()){
					System.out.println("user null");
				}
				System.out.println(s.getStudentID()+" name:"+s.getUser().getLastName());
				student = new StudentView(s); //fails because no company picture, fixed by ignoring null company pics in constructor
				
				context.getExternalContext().getSessionMap().put("student", student);
				return"student";
			}else{
				return "admin";	//will never happen, see bug in condition above. REQUIRES FIX!
			}
		}
		context.addMessage(null, new FacesMessage("Unknown login, try again"));
        email = null;
        password = null;
        loggedIn = false;
		return null;
	}	
	
	public void validateEmail(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		System.out.println("in validateemail");
		if(value==null){
			throw new ValidatorException(
					new FacesMessage("Bitte geben sie eine Email Adresse ein!"));
		}
		if(!isValidEmailId(((String) value))){
			throw new ValidatorException(
					new FacesMessage("Fehlerhafte Emailsyntax!"));
		}
		System.out.println("out validateemail");
	}

	public void validatePassword(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {

		System.out.println("in validatepassword");
		if(value==null){
			throw new ValidatorException(
					new FacesMessage("Bitte geben sie ein Passwort ein!"));
		}
		if((((String) value).length()<6)){
			throw new ValidatorException(
					new FacesMessage("Passwort zu kurz!"));
		}
		System.out.println("out validatepassword");
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	private boolean isValidEmailId(String email) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern p = Pattern.compile(emailPattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

	
}
