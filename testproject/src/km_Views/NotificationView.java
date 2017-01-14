package km_Views;

public class NotificationView {
	private int notificationID;
	private StudentView student;
	private TextView text;
	
	private String notificationTypeName;
	private int notificationTypeID;
	
	public NotificationView(){}
	public NotificationView(km_Entities.Notification note, km_Entities.NotificationType notetype){}
	public NotificationView(int notificationID, StudentView student, TextView text, String notificationTypeName,
			int notificationTypeID) {
		super();
		this.notificationID = notificationID;
		this.student = student;
		this.text = text;
		this.notificationTypeName = notificationTypeName;
		this.notificationTypeID = notificationTypeID;
	}
	
	public km_Entities.Notification parseNotification(){
		return null;
	}
	
	public km_Entities.NotificationType parseNotificationType(){
		return null;
	}
	
	public int getNotificationID() {
		return notificationID;
	}
	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}
	public StudentView getStudent() {
		return student;
	}
	public void setStudent(StudentView student) {
		this.student = student;
	}
	public TextView getText() {
		return text;
	}
	public void setText(TextView text) {
		this.text = text;
	}
	public String getNotificationTypeName() {
		return notificationTypeName;
	}
	public void setNotificationTypeName(String notificationTypeName) {
		this.notificationTypeName = notificationTypeName;
	}
	public int getNotificationTypeID() {
		return notificationTypeID;
	}
	public void setNotificationTypeID(int notificationTypeID) {
		this.notificationTypeID = notificationTypeID;
	}
}
