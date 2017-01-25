package km_Services;

import km_Views.ContentView;
import km_Views.StudentView;

public interface KarmaService {

	public int KarmaValue(int StudentID);
	
	public void reduceKarma(int StudentID);
	
	public void increaseKarma(int StudentID, ContentView content);
	
	public void like(StudentView student, ContentView content);
	
	public int getKarmaReward(int contentTypeId);
	
}
