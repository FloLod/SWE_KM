package km_Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import km_Entities.Category;
import km_Entities.Content;
import km_Entities.ContentType;
import km_Entities.Question;
import km_Entities.Reply;
import km_Entities.Student;
import km_Entities.Text;
import km_Views.QuestionView;
import km_Views.ReplyView;
import km_Views.StudentView;

public class KnowledgeCenterServiceImpl implements KnowledgeCenterService {

	@Override
	public void notifyforanswer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifynewquestion() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addQuestion(QuestionView question) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Question q = new Question();
		Category c = em.find(Category.class, question.getCategoryID());
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		StudentView student = (StudentView) sessionMap.get("student");
		Student s = em.find(Student.class, student.getStudentID());
		ContentType cot = em.find(ContentType.class, question.getContent().getContentID());
		Content co = new Content(s, cot, new Date(), new Date());
		Text t = new Text(question.getText().getHeading(), question.getText().getText());
		
		q.setCategory(c);
		q.setContent(co);
		q.setText(t);
		em.persist(q);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void updateThread(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteQuestion(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		Question q = em.find(Question.class, id);
		if (!q.equals(null)){
			em.getTransaction().begin();
			em.remove(q);
			em.getTransaction().commit();
			em.close();
			
		}else {
			throw new IllegalArgumentException();
		}
		
		
	}

	@Override
	public List<ReplyView> showQA(int id) throws IllegalArgumentException {
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		TypedQuery<Reply> query = em.createQuery("from km_Entities.Reply r where r.question.questionID=:question", Reply.class);
		query.setParameter("question", id);
		List<ReplyView> retList = new ArrayList<ReplyView>();
		
		if (query.getResultList() != null){
			List<Reply> replies = query.getResultList();
			for (Reply r : replies){
				retList.add(new ReplyView(r));
			}
		}
		else{
			throw new IllegalArgumentException();
		}
		
		return retList;
	}

	@Override
	public List<QuestionView> showAllQuestions() {
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		TypedQuery<Question> query = em.createQuery("from km_Entities.Question", Question.class);
		
		List<Question> questions = query.getResultList();
		List<QuestionView> retList = new ArrayList<QuestionView>();
		
		for(Question q : questions){
			retList.add(new QuestionView(q));
		}
		
		return retList;
	}

	@Override
	public void answerQuestion(int id, ReplyView reply) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Question q = em.find(Question.class, id);
		Reply r = new Reply();
		Text t = new Text(reply.getText().getHeading(), reply.getText().getText());
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		StudentView student = (StudentView) sessionMap.get("student");
		Student s = em.find(Student.class, student.getStudentID());
		ContentType ct = em.find(ContentType.class, reply.getContent().getContentTypeID());
		Content c = new Content(s, ct, new Date(), new Date());
		r.setQuestion(q);
		r.setText(t);
		r.setContent(c);
		em.persist(r);
		em.getTransaction().commit();
		em.close();
		
		
		
	}


}
