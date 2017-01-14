package km_Entities;

public class Student{
	private int studentID;
	private int karma;
	private User user;
	private StudentClass studentClass;
	private File companyPicture;
	private boolean classSpeaker;
	
	public Student(){
		
	}

	
	public boolean isClassSpeaker() {
		return classSpeaker;
	}


	public void setClassSpeaker(boolean classSpeaker) {
		this.classSpeaker = classSpeaker;
	}


	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public File getCompanyPicture() {
		return companyPicture;
	}

	public void setCompanyPicture(File companyPicture) {
		this.companyPicture = companyPicture;
	}
	
	
}