package km_Views;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EducationDiaryView {
	private int educationDiaryID;
	private int educationDiaryListId;
	private ClassView studentClass;
	private ContentView content;
	private int week;
	private Date startDate;
	private Date endDate;
	private List<EducationDiaryDayView> days;

	public EducationDiaryView() {
	}

	public EducationDiaryView(km_Entities.EducationDiary diary) {

		this.educationDiaryID = diary.getEducationDiaryID();
		this.educationDiaryListId = diary.getList().getEducationDiaryList();
		this.studentClass = new ClassView(diary.getStudentClass());
		this.content = new ContentView(diary.getContent(), diary.getContent().getContentType());
		this.week = diary.getWeeek();
		this.startDate = diary.getStartDate();
		this.endDate = diary.getEndDate();
		this.days = diary.getDays().stream().map(d -> new EducationDiaryDayView(d)).collect(Collectors.toList());
	}

	public EducationDiaryView(int educationDiaryID, int educationDiaryListId, ClassView studentClass,
			ContentView content, int week, Date startDate, Date endDate, List<EducationDiaryDayView> days) {
		super();
		this.educationDiaryID = educationDiaryID;
		this.educationDiaryListId = educationDiaryListId;
		this.studentClass = studentClass;
		this.content = content;
		this.week = week;
		this.startDate = startDate;
		this.endDate = endDate;
		this.days = days;
	}

	public EducationDiaryView(int educationDiaryID, ClassView studentClass, ContentView content, int week,
			Date startDate, Date endDate, List<EducationDiaryDayView> days) {
		super();
		this.educationDiaryID = educationDiaryID;
		this.studentClass = studentClass;
		this.content = content;
		this.week = week;
		this.startDate = startDate;
		this.endDate = endDate;
		this.days = days;
	}

	public EducationDiaryView(ClassView studentClass, ContentView content, int week,
			Date startDate, Date endDate, List<EducationDiaryDayView> days) {
		super();
		this.studentClass = studentClass;
		this.content = content;
		this.week = week;
		this.startDate = startDate;
		this.endDate = endDate;
		this.days = days;
	}

	public int getEducationDiaryID() {
		return educationDiaryID;
	}

	public void setEducationDiaryID(int educationDiaryID) {
		this.educationDiaryID = educationDiaryID;
	}

	public int getEducationDiaryListId() {
		return educationDiaryListId;
	}

	public void setEducationDiaryListId(int educationDiaryListId) {
		this.educationDiaryListId = educationDiaryListId;
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

	public List<EducationDiaryDayView> getDays() {
		return days;
	}

	public void setDays(List<EducationDiaryDayView> days) {
		this.days = days;
	}

}