package km_Entities;

import java.io.Serializable;

public class UnlockedContentIdClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer userID;
	
	private Integer content;
	
	
	public Integer getStudentID() {
		return userID;
	}
	public void setStudentID(Integer studentID) {
		this.userID = studentID;
	}
	public Integer getContentID() {
		return content;
	}
	public void setContentID(Integer contentID) {
		this.content = contentID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + content;
		result = prime * result + userID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnlockedContentIdClass other = (UnlockedContentIdClass) obj;
		if (content != other.content)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	
	
	
}
