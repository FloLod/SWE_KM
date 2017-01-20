package km_Views;

import km_Entities.UnlockedContent;

public class UnlockedContentView {
	public UserView student;
	public ContentView content;

	public UnlockedContentView() {
	}

	public UnlockedContentView(UnlockedContent unlocked) {
		this.student = new UserView(unlocked.getUserID());
		this.content = new ContentView(unlocked.getContent(), unlocked.getContent().getContentType());

	}

	public UnlockedContentView(UserView student, ContentView content) {
		super();
		this.student = student;
		this.content = content;
	}

	public UserView getStudent() {
		return student;
	}

	public void setStudent(UserView student) {
		this.student = student;
	}

	public ContentView getContent() {
		return content;
	}

	public void setContent(ContentView content) {
		this.content = content;
	}
}
