package km_Handler;

import java.util.List;

import javax.faces.bean.ManagedProperty;
import km_Views.*;

public class KnowledgeCenterHandler {
	private QuestionView question;
	private List<ReplyView> replys;
	private ReplyView reply;
	
	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
	
	public String overview(){return null;}
	public String selectQuestion(){return null;}
	public String createQuestion(){return null;}
	public String answerQuestion(){return null;}

	public void like(ContentView content){}
	
	public QuestionView getQuestion() {
		return question;
	}
	public void setQuestion(QuestionView question) {
		this.question = question;
	}
	public List<ReplyView> getReplys() {
		return replys;
	}
	public void setReplys(List<ReplyView> replys) {
		this.replys = replys;
	}
	public ReplyView getReply() {
		return reply;
	}
	public void setReply(ReplyView reply) {
		this.reply = reply;
	}
	
	
	
}
