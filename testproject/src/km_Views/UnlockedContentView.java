package km_Views;

import km_Entities.UnlockedContent;

public class UnlockedContentView {
	public StudentView student;
	public ContentView content;
	
	public UnlockedContentView(){}
	public UnlockedContentView(UnlockedContent unlocked){}	
	public UnlockedContentView(StudentView student, ContentView content) {
		super();
		this.student = student;
		this.content = content;
	}
	
	public UnlockedContent parseUnlockedContent(){return null;}
	public StudentView getStudent() {
		return student;
	}
	public void setStudent(StudentView student) {
		this.student = student;
	}
	public ContentView getContent() {
		return content;
	}
	public void setContent(ContentView content) {
		this.content = content;
	}
}
