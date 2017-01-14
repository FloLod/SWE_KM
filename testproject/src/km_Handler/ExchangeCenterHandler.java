package km_Handler;

import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import km_Views.*;

public class ExchangeCenterHandler {
	private StudentView student;
	private EducationDiaryListView diary;
	private NotificationView notification;
	
	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
	
	public String overview(){return null;}
	public String selectEducationDiary(){return null;}
	public String uploadEducationDiary(){return null;}
	public String setExchangeCenter(){return null;}

	public void pdfActionListener(final ActionEvent event) { 
	}
	
	public void like(ContentView content){}
	public StudentView getStudent() {
		return student;
	}
	public void setStudent(StudentView student) {
		this.student = student;
	}
	public EducationDiaryListView getDiary() {
		return diary;
	}
	public void setDiary(EducationDiaryListView diary) {
		this.diary = diary;
	}
	public NotificationView getNotification() {
		return notification;
	}
	public void setNotification(NotificationView notification) {
		this.notification = notification;
	}
	
	
	
}
