package km_Entities;

import java.io.Serializable;

public class LikeIdClass implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2530344275517072779L;
	private int student;
	private int content;
	public int getStudent() {
		return student;
	}
	public void setStudent(int student) {
		this.student = student;
	}
	public int getContent() {
		return content;
	}
	public void setContent(int content) {
		this.content = content;
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
		LikeIdClass other = (LikeIdClass) obj;
		if (content != other.content)
			return false;
		if (student != other.student)
			return false;
		return true;
	}

}
