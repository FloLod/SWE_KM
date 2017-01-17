package km_Handler;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import km_Views.*;

public class ExchangeCenterHandler {
	private StudentView student;
	private EducationDiaryListView diary;
	private NotificationListView notification;

	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;

	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(ServiceLocator serviceLocatorBean) {
		this.serviceLocator = serviceLocatorBean;
	}

	public String overview() {
		return null;
	}

	public String selectEducationDiary() {
		return null;
	}

	public String uploadEducationDiary() {
		return null;
	}

	public String setExchangeCenter() {
		return null;
	}

	public void pdfActionListener(final ActionEvent event) {
	}

	public void like(ContentView content) {
		this.serviceLocator.getKarmaService().like(getStudent(), content);
		
	}

	public StudentView getStudent() {
		if(student == null)
			this.student = (StudentView) FacesContext.getCurrentInstance().getAttributes().get("student");
		return student;
	}

	public void setStudent(StudentView student) {
		this.student = student;
	}

	public EducationDiaryListView getDiary() {
		if(diary == null)			
			this.diary = serviceLocator.getExchangeCenterService().getEducationDiaries(student.getStudentClass());
		
		return diary;
		
	}

	public void setDiary(EducationDiaryListView diary) {
		this.diary = diary;
	}

	public NotificationListView getNotification() {
		if(notification == null)
			this.notification = new NotificationListView(serviceLocator.getNotificationService().getNotifications(student));
		return notification;
	}

	public void setNotification(NotificationListView notification) {
		this.notification = notification;
	}
	
	public NotificationView getNotification(int i){
		return this.notification.getNotificationViews().get(i);
	}

}
