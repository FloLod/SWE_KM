package km_Handler;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import km_Services.LoginService;
import km_Views.NotificationView;
import km_Views.UserView;

@ManagedBean
@SessionScoped
public class NotificationHandler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5439895366499126836L;
	private UserView User;
	private List<NotificationView> notifications;
	private NotificationView notification;

	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;

	@ManagedProperty("#{loginServiceImpl}")
	private LoginService loginService;

	public UserView getUser() {
		if (this.User == null)
			this.User = (UserView) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		return User;
	}

	public void setUser(UserView user) {
		User = user;
	}

	public List<NotificationView> getNotifications() {
		if (notifications == null)
			notifications = this.serviceLocator.getNotificationService().getNotifications(this.getUser());
		return notifications;
	}

	public void setNotifications(List<NotificationView> notifications) {
		this.notifications = notifications;
	}

	public NotificationView getNotification() {
		return notification;
	}

	public void setNotification(NotificationView notification) {
		this.notification = notification;
	}

	public String sendNotification() {
		try {
			this.serviceLocator.getNotificationService().sendNotification(getUser(), notification);
			return "SuccessSendNotification";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "RetrySendNotification";
		}
	}

}
