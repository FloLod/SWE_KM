package km_Views;

import java.util.Date;

public class TimeTableView {
	private int timeTableID;
	private Date start;
	private Date end;
	private FileView file;
	private ClassView studentClass;

	public TimeTableView() {
	}

	public TimeTableView(km_Entities.TimeTable timetable) {
		this.timeTableID = timetable.getTimeTableID();
		this.start = timetable.getStartingDate();
		this.end = timetable.getEndDate();
		this.file = new FileView(timetable.getFile());
		this.studentClass = new ClassView(timetable.getStudentClass());
	}

	public TimeTableView(int timeTableID, Date start, Date end, FileView file, ClassView studentClass) {
		super();
		this.timeTableID = timeTableID;
		this.start = start;
		this.end = end;
		this.file = file;
		this.studentClass = studentClass;
	}

	public int getTimeTableID() {
		return timeTableID;
	}

	public void setTimeTableID(int timeTableID) {
		this.timeTableID = timeTableID;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public FileView getFile() {
		return file;
	}

	public void setFile(FileView file) {
		this.file = file;
	}

	public ClassView getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(ClassView studentClass) {
		this.studentClass = studentClass;
	}

}