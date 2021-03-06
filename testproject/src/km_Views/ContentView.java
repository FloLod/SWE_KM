package km_Views;

import java.util.Date;

public class ContentView {

	private StudentView creator;
	private Date created;
	private Date changed;
	private int contentID;
	private int likes;

	// contenttype
	private int contentTypeID; // contentTypeID: 1 = EducationDiary
	private String contentTypeName;
	private int KarmaReward;
	private ClassView owner;

	public ContentView() {
	}

	public ContentView(km_Entities.Content cont, km_Entities.ContentType conttype) {
		this.creator = new StudentView(cont.getCreatorStudent());
		this.created = cont.getCreated();
		this.changed = cont.getCanged();
		this.contentID = cont.getContentID();
//		this.likes = cont.getLikes().size();

		this.contentTypeID = conttype.getContentTypeID();
		this.contentTypeName = conttype.getName();
		this.KarmaReward = conttype.getKarmaReward();
		this.owner = new ClassView(conttype.getStudentClass());
	}

	public ContentView(StudentView creator, Date created, Date changed, int contentID, int contentTypeID,
			String contentTypeName, int karmaReward, ClassView owner) {
		super();
		this.creator = creator;
		this.created = created;
		this.changed = changed;
		this.contentID = contentID;
		this.contentTypeID = contentTypeID;
		this.contentTypeName = contentTypeName;
		KarmaReward = karmaReward;
		this.owner = owner;
	}

	public ContentView(StudentView creator, Date created, Date changed, int contentTypeID, int karmaReward,
			ClassView owner) {
		super();
		this.creator = creator;
		this.created = created;
		this.changed = changed;
		this.contentTypeID = contentTypeID;
		KarmaReward = karmaReward;
		this.owner = owner;
	}

	public StudentView getCreator() {
		return creator;
	}

	public void setCreator(StudentView creator) {
		this.creator = creator;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getChanged() {
		return changed;
	}

	public void setChanged(Date changed) {
		this.changed = changed;
	}

	public int getContentID() {
		return contentID;
	}

	public void setContentID(int contentID) {
		this.contentID = contentID;
	}

	public int getContentTypeID() {
		return contentTypeID;
	}

	public void setContentTypeID(int contentTypeID) {
		this.contentTypeID = contentTypeID;
	}

	public String getContentTypeName() {
		return contentTypeName;
	}

	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

	public int getKarmaReward() {
		return KarmaReward;
	}

	public void setKarmaReward(int karmaReward) {
		KarmaReward = karmaReward;
	}

	public ClassView getOwner() {
		return owner;
	}

	public void setOwner(ClassView owner) {
		this.owner = owner;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

}
