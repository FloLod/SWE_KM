package km_Handler;

import javax.faces.bean.ManagedProperty;
import km_Views.*;
public class KlassenHandler {
	private ClassView studentClass;
	private NotificationView notification;
	
	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
	
	public String createClass(){return null;}
	public String showClasses(){return null;}
	public String selectClass(){return null;}
	
	
	public ClassView getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(ClassView studentClass) {
		this.studentClass = studentClass;
	}
	public NotificationView getNotification() {
		return notification;
	}
	public void setNotification(NotificationView notification) {
		this.notification = notification;
	}
	
	
	
}
