package km_Handler;

import java.io.FileNotFoundException;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import km_Views.*;

public class ExchangeCenterHandler {
	private StudentView student;
	private EducationDiaryListView diaries;
	private NotificationListView notification;
	private String filepath;
	
	private EducationDiaryView selectedDiary; 

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

	public String selectEducationDiary(int index) {
		this.selectedDiary = diaries.getEducationDiaryList().get(index);
		return "ToShowDiary";
	}

	public String uploadEducationDiary() {
		
		return "ToDiaryCreation";
	}

	public String setExchangeCenter() {
		return null;
	}

	public void pdfActionListener(final ActionEvent event) {
		try {
			serviceLocator.getExchangeCenterService().downloadEducationDiary(getStudent(), getSelectedDiary(), filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	public EducationDiaryListView getDiaries() {
		if(diaries == null)			
			this.diaries = serviceLocator.getExchangeCenterService().getEducationDiaries(student.getStudentClass());
		
		return diaries;
	}

	public void setDiaries(EducationDiaryListView diary) {
		this.diaries = diary;
	}
	public EducationDiaryView getSelectedDiary() {
		return selectedDiary;
	}

	public void setSelectedDiary(EducationDiaryView selectedDiary) {
		this.selectedDiary = selectedDiary;
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
