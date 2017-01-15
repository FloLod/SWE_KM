package km_Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notification{
	@Id
	@GeneratedValue
	private int notificationID;
	@ManyToOne
	private Student student;
	@ManyToOne
	private NotificationType notificationType;
	@ManyToOne
	private Text text;
	
	public Notification(){}

	public int getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
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