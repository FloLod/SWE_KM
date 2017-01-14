package km_Handler;

import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import km_Views.*;

public class ExchangeMarketHandler {
	private NotificationView notification;
	private FileView file;
	
	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
	
	public String overview(){return null;}
	public String selectFile() {return null;}
	public String uploadFile(){return null;}

	public void like(ContentView content){}
	
	public void fileActionListener(final ActionEvent event) { 
	}
	
	public NotificationView getNotification() {
		return notification;
	}
	public void setNotification(NotificationView notification) {
		this.notification = notification;
	}
	public FileView getFile() {
		return file;
	}
	public void setFile(FileView file) {
		this.file = file;
	}
	 
}
