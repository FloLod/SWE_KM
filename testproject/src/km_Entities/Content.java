package km_Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Content implements Serializable{
	@Id
	@GeneratedValue
	private int contentID;
	@ManyToOne
	private Student creatorStudent;
	@OneToOne(cascade = CascadeType.ALL)
	private ContentType contentType;
	private Date created;
	private Date canged;
//	@OneToMany(mappedBy = "content" , cascade = CascadeType.ALL)
//	private List<Like> likes;

	public Content() {
	}

	public Content(Student creatorStudent, ContentType contentType, Date created, Date canged) {
		super();
		this.creatorStudent = creatorStudent;
		this.contentType = contentType;
		this.created = created;
		this.canged = canged;
	}

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

//	public List<Like> getLikes() {
//		return likes;
//	}
//
//	public void setLikes(List<Like> likes) {
//		this.likes = likes;
//	}

}