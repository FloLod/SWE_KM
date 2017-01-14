package km_Services;

import java.util.List;

import km_Views.QuestionView;
import km_Views.ReplyView;

public interface KnowledgeCenterService {

	public void notifyforanswer();
	
	public void notifynewquestion();
	
	public void addQuestion(QuestionView question);
	
	public void updateThread(int id);
	
	public void deleteQuestion(int id);
	
	public List<ReplyView> showQA(int id);
	

}
