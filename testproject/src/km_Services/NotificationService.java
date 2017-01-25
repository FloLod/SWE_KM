package km_Services;

import java.util.List;

import km_Views.NotificationView;
import km_Views.UserView;

public interface NotificationService {

	public void sendNotification(UserView user, NotificationView not);
	
	public List<NotificationView> getNotifications(UserView user);
}
