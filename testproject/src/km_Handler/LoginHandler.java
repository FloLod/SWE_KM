package km_Handler;

import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import km_Views.UserView;


public class LoginHandler {
	private String username;
	private String password;
	private UserView user;
	private boolean loggedIn;

	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
		
	public String login() {
		return null;
	}	
	
	public void validateUsername(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
	}

	public void validatePassword(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserView getUser() {
		return user;
	}
	public void setUser(UserView user) {
		this.user = user;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
}
