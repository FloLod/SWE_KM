package km_Views;

import java.util.Date;

import km_Entities.Admin;
import km_Entities.User;

public class UserView{
	private String firstname;
	private String lastname;
	private String email;
	private Date lastlogin;
	private String passwort;
	private boolean isAdmin;
	
	public UserView(){
		
	}
	
	public UserView(User user){
		
	}

	public UserView(Admin user){
		
	}
	
	public UserView(String firstname, String lastname, String email, Date lastlogin, String passwort) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.lastlogin = lastlogin;
		this.passwort = passwort;
	}

	
	public boolean isAdmin() {
		return isAdmin;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	
}