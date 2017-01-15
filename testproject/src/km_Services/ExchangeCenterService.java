package km_Services;

import java.util.List;

import km_Views.EducationDiaryDayView;
import km_Views.EducationDiaryListView;
import km_Views.EducationDiaryView;
import km_Views.StudentView;

public interface ExchangeCenterService {

	public void uploadEducationDiary( EducationDiaryView edv, EducationDiaryListView edl, List<EducationDiaryDayView> days);
	
	public void downloadEducationDiary(StudentView sv,EducationDiaryView edv);
	
	
}
