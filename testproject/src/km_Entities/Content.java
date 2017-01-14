package km_Entities;

import java.util.Date;

public class Content{
	private int contentID;
	private Student creatorStudent;
	private ContentType contentType;
	private Date created;
	private Date canged;
	
	public Content(){}

	
	public ContentType getContentType() {
		return contentType;
	}


	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}


	public int getContentID() {
		return contentID;
	}

	public void setContentID(int contentID) {
		this.contentID = contentID;
	}

	public Student getCreatorStudent() {
		return creatorStudent;
	}

	public void setCreatorStudent(Student creatorStudent) {
		this.creatorStudent = creatorStudent;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCanged() {
		return canged;
	}

	public void setCanged(Date canged) {
		this.canged = canged;
	}
	
	
}