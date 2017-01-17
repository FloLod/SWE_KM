package km_Views;

import java.util.List;

public class StudentView{
	private int studentID;
	private int karma;
	private UserView user;
	private ClassView studentClass;
	private boolean classSpeaker;
	private FileView companyPicture;
	
	public StudentView(){}
	public StudentView(km_Entities.Student student){
		this.studentID = student.getStudentID();
		this.karma = student.getKarma();
		this.user = new UserView(student.getUser());
		this.studentClass = new ClassView(student.getStudentClass());
		this.classSpeaker = student.isClassSpeaker();
		this.companyPicture = new FileView(student.getCompanyPicture());
		
	}
	
	public StudentView(int studentID, int karma, UserView user, ClassView studentClass, boolean classSpeaker,
			FileView companyPicture) {
		super();
		this.studentID = studentID;
		this.karma = karma;
		this.user = user;
		this.studentClass = studentClass;
		this.classSpeaker = classSpeaker;
		this.companyPicture = companyPicture;
	}
	public FileView getCompanyPicture() {
		return companyPicture;
	}
	public void setCompanyPicture(FileView companyPicture) {
		this.companyPicture = companyPicture;
	}
	public boolean isBlocked(){
		return false;
	}
	
	public List<ContentView> showLikes(){
		return null;
	}
	
	public boolean getClassSpeaker() {
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

	public UserView getUser() {
		return user;
	}

	public void setUser(UserView user) {
		this.user = user;
	}

	public ClassView getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(ClassView studentClass) {
		this.studentClass = studentClass;
	}
}