package km_Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(UnlockedContentIdClass.class)
public class UnlockedContent implements Serializable{
	@Id
	@ManyToOne
	private User userID;
	@Id
	@ManyToOne
	private Content content;

	public UnlockedContent() {
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
}
