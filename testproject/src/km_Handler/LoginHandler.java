package km_Handler;

import javax.faces.bean.ManagedBean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import km_Entities.Student;
import km_Services.LoginService;
import km_Services.StudentService;
import km_Views.StudentView;
import km_Views.UserView;

import java.io.Serializable;
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
		System.out.println("Login attempt by"+email+ " " + password); //TO DELETE

		System.out.println("vor getLogin");

		System.out.println("email:"+email);
		System.out.println("password:"+password);

		//System.out.println("LoginService:"+loginService.toString());
		
		user = loginService.getLogin(email, password);
		FacesContext context = FacesContext.getCurrentInstance();
		if(user != null){
			context.getExternalContext().getSessionMap().put("user", user);
			loggedIn = true;
			
			if(!user.isAdmin())
			{
				System.out.println(user.getUserId());
				//Student s = studentService.findStudentByUserId(user.getUserId()); //placeholder needs to be fixed!!!!!!!!!!!!!!!
				Student s = studentService.findStudentByUser(user); 

				System.out.println(s.getStudentID()+" name:"+s.getUser().getLastName());
				student = new StudentView(s); //fails
				context.getExternalContext().getSessionMap().put("student", student);
				return"student";
			}else{
				return "admin";
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
