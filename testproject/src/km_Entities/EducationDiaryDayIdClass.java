package km_Entities;

import java.io.Serializable;


public class EducationDiaryDayIdClass implements Serializable{

	private km_Entities.EducationDiary educationDiaryID;
	private int day;
	public EducationDiary getEducationDiaryID() {
		return educationDiaryID;
	}
	public void setEducationDiaryID(EducationDiary educationDiaryID) {
		this.educationDiaryID = educationDiaryID;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + ((educationDiaryID == null) ? 0 : educationDiaryID.hashCode());
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
		EducationDiaryDayIdClass other = (EducationDiaryDayIdClass) obj;
		if (day != other.day)
			return false;
		if (educationDiaryID == null) {
			if (other.educationDiaryID != null)
				return false;
		} else if (!educationDiaryID.equals(other.educationDiaryID))
			return false;
		return true;
	}
	
	
}
