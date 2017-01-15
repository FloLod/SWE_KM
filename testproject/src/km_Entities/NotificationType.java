package km_Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NotificationType {
	
	@Id
	@GeneratedValue
	private int notificationTypeID;
	private String name;
	
	public int getNotificationTypeID() {
		return notificationTypeID;
	}
	public void setNotificationTypeID(int notificationTypeID) {
		this.notificationTypeID = notificationTypeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public NotificationType() {}


}
