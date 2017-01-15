package km_Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(UnlockedContentIdClass.class)
public class UnlockedContent {
	@Id
	@ManyToOne
	private Student student;
	@Id
	@ManyToOne
	private Content content;
	
	public UnlockedContent(){}

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
