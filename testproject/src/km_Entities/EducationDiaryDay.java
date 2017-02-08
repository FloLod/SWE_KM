package km_Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@IdClass(EducationDiaryDayIdClass.class)
public class EducationDiaryDay implements Serializable{
	@ManyToOne
	@Id
	private km_Entities.EducationDiary educationDiaryID;
	@Id
	private int day;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Activity> activity;
	
	public EducationDiaryDay(){}
	
	

	public EducationDiaryDay(int day, List<Activity> activity) {
		super();
		this.day = day;
		this.activity = activity;
	}



	public EducationDiaryDay(EducationDiary educationDiaryID, int day, List<Activity> activity) {
		super();
		this.educationDiaryID = educationDiaryID;
		this.day = day;
		this.activity = activity;
	}



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

	public List<Activity> getActivity() {
		return activity;
	}

	public void setActivity(List<Activity> activity) {
		this.activity = activity;
	}
	
	
}