package km_Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name ="admins")
public class Admin implements Serializable{
	@Id
	@GeneratedValue
	private int adminID;
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	public Admin(){}

	public Admin(User user) {
		super();
		this.user = user;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}