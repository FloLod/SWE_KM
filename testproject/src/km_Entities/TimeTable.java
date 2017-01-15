package km_Entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TimeTable{
	@Id
	@GeneratedValue
	private int timeTableID;
	private Date startingDate;
	private Date endDate;
	@ManyToOne
	private File file;
	@ManyToOne
	private StudentClass studentClass;
	
	public TimeTable(){}

	public int getTimeTableID() {
		return timeTableID;
	}

	public void setTimeTableID(int timeTableID) {
		this.timeTableID = timeTableID;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}
	
	
	
}