package km_Views;

public class NotificationView {
	private int notificationID;
	private UserView student;
	private TextView text;
	
	private String notificationTypeName;
	private int notificationTypeID;
	
	public NotificationView(){}
	public NotificationView(km_Entities.Notification note, km_Entities.NotificationType notetype){
		this.notificationID = note.getNotificationID();
		this.student = new UserView(note.getStudent());
		this.text = new TextView(note.getText());
		
		this.notificationTypeID = notetype.getNotificationTypeID();
		this.notificationTypeName = notetype.getName();
	}
	
	public NotificationView(int notificationID, UserView student, TextView text, String notificationTypeName,
			int notificationTypeID) {
		super();
		this.notificationID = notificationID;
		this.student = student;
		this.text = text;
		this.notificationTypeName = notificationTypeName;
		this.notificationTypeID = notificationTypeID;
	}
	
	public int getNotificationID() {
		return notificationID;
	}
	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}
	public UserView getStudent() {
		return student;
	}
	public void setStudent(UserView student) {
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
