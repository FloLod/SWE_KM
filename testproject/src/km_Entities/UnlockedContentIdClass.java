package km_Entities;

import java.io.Serializable;

public class UnlockedContentIdClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer student;
	
	private Integer content;
	
	
	public Integer getStudentID() {
		return student;
	}
	public void setStudentID(Integer studentID) {
		this.student = studentID;
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
		result = prime * result + student;
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
		if (student != other.student)
			return false;
		return true;
	}
	
	
	
}
