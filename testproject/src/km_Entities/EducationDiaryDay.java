package km_Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(EducationDiaryDayIdClass.class)
public class EducationDiaryDay{
	@ManyToOne
	@Id
	private km_Entities.EducationDiary educationDiaryID;
	@Id
	private int day;
	@ManyToOne
	private Activity activity;
	
	public EducationDiaryDay(){}

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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	
}