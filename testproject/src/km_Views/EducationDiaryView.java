package km_Views;

import java.util.Date;

public class EducationDiaryView{
	private int educationDiaryID;
	private ClassView studentClass;
	private ContentView content;
	private int week;
	private Date startDate;
	private Date endDate;
	private EducationDiaryDayView[] days;
	
	public EducationDiaryView(){}
	public EducationDiaryView(km_Entities.EducationDiary diary){}
	
	public EducationDiaryView(int educationDiaryID, ClassView studentClass, ContentView content, int week,
			Date startDate, Date endDate, EducationDiaryDayView[] days) {
		super();
		this.educationDiaryID = educationDiaryID;
		this.studentClass = studentClass;
		this.content = content;
		this.week = week;
		this.startDate = startDate;
		this.endDate = endDate;
		this.days = days;
	}
	
	public km_Entities.EducationDiary  parseEducationDiary(){return null;}
	public int getEducationDiaryID() {
		return educationDiaryID;
	}
	public void setEducationDiaryID(int educationDiaryID) {
		this.educationDiaryID = educationDiaryID;
	}
	public ClassView getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(ClassView studentClass) {
		this.studentClass = studentClass;
	}
	public ContentView getContent() {
		return content;
	}
	public void setContent(ContentView content) {
		this.content = content;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public EducationDiaryDayView[] getDays() {
		return days;
	}
	public void setDays(EducationDiaryDayView[] days) {
		this.days = days;
	}
	
	
}