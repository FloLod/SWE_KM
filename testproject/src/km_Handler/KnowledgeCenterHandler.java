package km_Handler;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import km_Views.*;

@ManagedBean
@SessionScoped
public class KnowledgeCenterHandler {
	private QuestionView question;
	private List<ReplyView> replys;
	private List<QuestionView> questions;
	public List<QuestionView> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionView> questions) {
		this.questions = questions;
	}
	private ReplyView reply;
	
	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
	
	public String overview(){
		try{
			questions = serviceLocator.getKnowledgeCenterService().showAllQuestions();
			this.reply = new ReplyView();
			reply.setText(new TextView());
			question = new QuestionView();
			question.setText(new TextView());
			return "ToKnowledgeCenter";
		}catch (Exception e) {
			return "retry";
		}
	}
	
	public String selectQuestion(QuestionView question){
		this.question = question;
		System.out.println(question.getQuestionID());
		try{
			replys = serviceLocator.getKnowledgeCenterService().showQA(question.getQuestionID());
		}catch (Exception e) {
			return "retry";
		}
		return "showquestion";
	}
	
	public String createQuestion(){
		try {
			
			question.setContent(new ContentView());
			serviceLocator.getKnowledgeCenterService().addQuestion(question);
		}catch (Exception e) {
			return "retry";
		}
		
		return overview();
	}
	
	public String answerQuestion(){
		try{
			serviceLocator.getKnowledgeCenterService().answerQuestion(question.getQuestionID(), reply);
		}catch (Exception e) {
			return "retry";
		}
		selectQuestion(question);
		return "success";
	}

	public void like(ContentView content){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		StudentView student = (StudentView) sessionMap.get("student");
		serviceLocator.getKarmaService().like(student, content);
	}
	
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
