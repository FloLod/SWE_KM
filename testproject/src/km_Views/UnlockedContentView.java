package km_Views;

import km_Entities.UnlockedContent;

public class UnlockedContentView {
	public StudentView student;
	public ContentView content;

	public UnlockedContentView() {
	}

	public UnlockedContentView(UnlockedContent unlocked) {
		this.student = new StudentView(unlocked.getStudent());
		this.content = new ContentView(unlocked.getContent(), unlocked.getContent().getContentType());

	}

	public UnlockedContentView(StudentView student, ContentView content) {
		super();
		this.student = student;
		this.content = content;
	}

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
