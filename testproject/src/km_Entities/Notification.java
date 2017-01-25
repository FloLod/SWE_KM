package km_Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Notification{
	@Id
	@GeneratedValue
	private int notificationID;
	@ManyToOne
	private User student;
	@ManyToOne
	private NotificationType notificationType;
	@OneToOne(cascade = CascadeType.ALL)
	private Text text;
	
	public Notification(){}
	

	public Notification(User user, NotificationType notificationType, Text text) {
		super();
		this.student = user;
		this.notificationType = notificationType;
		this.text = text;
	}


	public int getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
	
	
}