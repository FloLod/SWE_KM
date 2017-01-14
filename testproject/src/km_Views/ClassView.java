package km_Views;

import java.util.Date;

public class ClassView{
	private int classID;
	private String educationPath;
	private Date year;
	
	public ClassView(){}
	public ClassView(km_Entities.StudentClass studentclass){}
	public ClassView(int classID, String educationPath, Date year) {
		super();
		this.classID = classID;
		this.educationPath = educationPath;
		this.year = year;
	}
	
	public km_Entities.StudentClass parseClass(){
		return null;
	}
	
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public String getEducationPath() {
		return educationPath;
	}
	public void setEducationPath(String educationPath) {
		this.educationPath = educationPath;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	
	
}