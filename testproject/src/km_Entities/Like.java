package km_Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

//@Entity(name="Likes")
//@IdClass(LikeIdClass.class)
public class Like{
	@Id
	@GeneratedValue
	private int likeID;

	@ManyToOne
	private Student student;

	@ManyToOne
	private Content content;
	
	public Like(){}
	
	public int getLikeID() {
		return likeID;
	}

	public void setLikeID(int likeID) {
		this.likeID = likeID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
	
}