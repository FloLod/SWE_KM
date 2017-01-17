package km_Handler;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import km_Services.LoginService;
import km_Views.UserView;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="loginHandler")
@SessionScoped
public class LoginHandler implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 145257865L;
	private String email;
	private String password;
	private UserView user;	//deleted get/set for security reasons
	private boolean loggedIn;

	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;
	
	@ManagedProperty("#{loginServiceImpl}")
	private LoginService loginservice;
	
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
		
	public String login() {
		System.out.println("Login attempt by"+email+ " " + password); //TO DELETE
		user = loginservice.getLogin(email, password);
		FacesContext context = FacesContext.getCurrentInstance();
		if(user != null){
			context.getExternalContext().getSessionMap().put("user", user);
			return "loggedin";
		}
		context.addMessage(null, new FacesMessage("Unknown login, try again"));
        email = null;
        password = null;
		return null;
	}	
	
	public void validateEmail(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		if(!((String) value).matches(".+@.\\..+")){
			throw new ValidatorException(
					new FacesMessage("Fehlerhafte Emailsyntax!"));
		}
	}

	public void validatePassword(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		if(!(((String) value).length()<6)){
			throw new ValidatorException(
					new FacesMessage("Passwort zu kurz!"));
		}
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
	
}
