package km_Entities;

public class ContentType{
	private int contentTypeID;
	private String Name;
	private int KarmaReward;
	private StudentClass studentClass;
	
	public ContentType(){}

	public int getContentTypeID() {
		return contentTypeID;
	}

	public void setContentTypeID(int contentTypeID) {
		this.contentTypeID = contentTypeID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getKarmaReward() {
		return KarmaReward;
	}

	public void setKarmaReward(int karmaReward) {
		KarmaReward = karmaReward;
	}

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}
	
	
}