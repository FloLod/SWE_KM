package km_Handler;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import km_Views.*;

@ManagedBean
@SessionScoped
public class ExchangeCenterHandler implements Serializable{
	private static final long serialVersionUID = 1L;
	private StudentView student;
	private EducationDiaryListView diaries;
	private String filepath;
	private String fachrichtung, abteilung;

	private EducationDiaryView selectedDiary;
	private List<EducationDiaryDayView> days;

	private String thedate;
	private Date created;
	private int week;
	
	private String[] work;
	private String[] duration;

	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;

	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(ServiceLocator serviceLocatorBean) {
		this.serviceLocator = serviceLocatorBean;
	}
	
	public String convertDownload()
	{
		created = new Date(2016,02,03);
		duration[0] = "1";
		duration[1] = "2";
		duration[2] = "3";
		duration[3] = "4";
		duration[4] = "5";
		
		work[0] = "Mowork";
		work[1] = "Diwork";
		work[2] = "Miwork";
		work[3] = "Dowork";
		work[4] = "Frwork";
		
		Calendar c = new GregorianCalendar();
		c.setTime(created);
		Calendar c2 = c;
		c2.add(Calendar.DAY_OF_MONTH, 5);

		this.days = new ArrayList<>();
		EducationDiaryDayView day;
		
		for(int i = 0; i < 5; i++)
		{
			String[] daywork = work[i].split(";");
			
			String[] times = duration[i].split(";");
			Integer[] actiontime = new Integer[duration.length];
			
			for(int j = 0; j < duration[i].split(";").length; j++)
			{
				try{ actiontime[j] = Integer.parseInt(duration[i].split(";")[j]);}
				catch(Exception e){actiontime[j] = 0;}
			}
			
			day = new EducationDiaryDayView();
			
			List<ActivityView> activities = new ArrayList<ActivityView>();
			
			for(int k = 0; k < duration[i].split(";").length; k++)
			{
				ActivityView act = new ActivityView();
				act.setDescription(daywork[k]);
				act.setDuration(actiontime[k]);
				
				activities.add(act);
			}
			
			day.setActivityViews(activities);
			
			days.add(day);
		}
		
		ContentView content = new ContentView();
		content.setChanged(created);
		content.setContentTypeName("Nachweis");
		content.setCreated(created);
		content.setCreator(student);
		content.setOwner(student.getStudentClass());
		
		
		
		this.getServiceLocator().getExchangeCenterService().uploadEducationDiary(
				new EducationDiaryView(this.getStudent().getStudentClass(),
						content,
						week, c.getTime(), c2.getTime(), days),
				this.getDiaries(), days);		

		this.days = new ArrayList<>();
		return "created";
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
		work = new String[5];
		duration = new String[5];
		return "ToDiaryCreation";
	}

	public String pdfdownload() {
		try {
			serviceLocator.getExchangeCenterService().downloadEducationDiary(getStudent(), selectedDiary,
					filepath, fachrichtung, abteilung);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String prepareDownload()
	{
		fachrichtung = "";
		abteilung = "";
		return "fillHeaderInfos";
	}
	public String like(ContentView content) {
		try {
			this.serviceLocator.getKarmaService().like(getStudent(), content);

			return "LikeSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "LikeRetry";
		}

	}

	public String[] getWork() {
		return work;
	}

	public void setWork(String[] work) {
		this.work = work;
	}

	public String[] getDuration() {
		return duration;
	}

	public void setDuration(String[] duration) {
		this.duration = duration;
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

	public String getFachrichtung() {
		return fachrichtung;
	}

	public void setFachrichtung(String fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

	public String getAbteilung() {
		return abteilung;
	}

	public void setAbteilung(String abteilung) {
		this.abteilung = abteilung;
	}
	
	public String getThedate() {
		return thedate;
	}

	public void setThedate(String thedate) {
		this.thedate = thedate;
	}

	public void validateDate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		String v = (String)value;
		String[] s;
		if(v.contains("-"))
			s = v.split("-");
		else if(v.contains("."))
			s = v.split(".");
		else 
			throw new ValidatorException(new FacesMessage("use - or . as delimiter"));
		
		try
		{
			Calendar c = new GregorianCalendar();
			if(s[0].length() == 4)
				c.set(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
			else
				c.set(Integer.parseInt(s[2]), Integer.parseInt(s[1]), Integer.parseInt(s[0]));
			
			created = c.getTime();
		}
		catch(Exception e)
		{
			throw new ValidatorException(new FacesMessage("a date needs year, month and day"));
		}
	}
	
}
