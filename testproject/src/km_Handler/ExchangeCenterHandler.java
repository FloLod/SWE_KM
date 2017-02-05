package km_Handler;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import km_Views.*;

@ManagedBean
@SessionScoped
public class ExchangeCenterHandler implements Serializable{
	private StudentView student;
	private EducationDiaryListView diaries;
	private String filepath;

	private EducationDiaryView selectedDiary;
	private List<EducationDiaryDayView> days;

	private Date created;
	private int week;

	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;

	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(ServiceLocator serviceLocatorBean) {
		this.serviceLocator = serviceLocatorBean;
	}

	public String overview() {
		student = (StudentView) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("student");
		if(null != student)
			return "ToExchangeCenter";
		return "loginfailed";
	}

	public String selectEducationDiary(EducationDiaryView diary) {
		this.selectedDiary = diary;
		return "ToShowDiary";
	}

	public String uploadEducationDiary() {
		Calendar c = new GregorianCalendar();
		c.setTime(created);
		Calendar c2 = c;
		c2.add(Calendar.DAY_OF_MONTH, 5);

		this.getServiceLocator().getExchangeCenterService().uploadEducationDiary(
				new EducationDiaryView(this.getStudent().getStudentClass(),
						new ContentView(getStudent(), created, created, 1,
								this.getServiceLocator().getKarmaService().getKarmaReward(1),
								this.getStudent().getStudentClass()),
						week, c.getTime(), c2.getTime(), days),
				this.getDiaries(), days);

		this.days = new ArrayList<>();

		return overview();
	}

	public String newDiary() {
		return "ToDiaryCreation";
	}

	public String pdfdownload() {
		try {
			System.out.println("start");
			serviceLocator.getExchangeCenterService().downloadEducationDiary(getStudent(), selectedDiary,
					filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "";

	}

	public String like(ContentView content) {
		try {
			this.serviceLocator.getKarmaService().like(getStudent(), content);

			return "LikeSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "LikeRetry";
		}

	}

	public StudentView getStudent() {
		if (student == null)
			this.student = (StudentView) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("student");
		return student;
	}

	public void setStudent(StudentView student) {
		this.student = student;
	}

	public EducationDiaryListView getDiaries() {
		if (diaries == null)
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

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public List<EducationDiaryDayView> getDays() {
		if (days == null)
			days = new ArrayList<>();
		return days;
	}

	public void setDays(List<EducationDiaryDayView> days) {
		this.days = days;
	}
	
	public EducationDiaryDayView getDay(int index){
		return this.getDays().get(index);
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

}
