package km_Views;

import java.util.List;

public class NotificationListView {
	
	private List<NotificationView> notificationViews;

	public List<NotificationView> getNotificationViews() {
		return notificationViews;
	}

	public void setNotificationViews(List<NotificationView> notificationViews) {
		this.notificationViews = notificationViews;
	}

	public NotificationListView(List<NotificationView> notificationViews) {
		super();
		this.notificationViews = notificationViews;
	}
	
	

}
