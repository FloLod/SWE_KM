package km_Services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import km_Entities.Activity;
import km_Entities.Content;
import km_Entities.ContentType;
import km_Entities.EducationDiary;
import km_Entities.EducationDiaryDay;
import km_Entities.EducationDiaryList;
import km_Entities.Student;
import km_Entities.StudentClass;
import km_Entities.User;
import km_Views.ActivityView;
import km_Views.ClassView;
import km_Views.EducationDiaryDayView;
import km_Views.EducationDiaryListView;
import km_Views.EducationDiaryView;
import km_Views.StudentView;

public class ExchangeCenterServiceImpl implements ExchangeCenterService {

	PDFService pdf = new PDFServiceImpl();

	ClassService cs = new ClassServiceImpl();
	StudentService ss = new StudentServiceImpl();
	ContentService cos = new ContentServiceImpl();

	@Override
	public void downloadEducationDiary(StudentView sv, EducationDiaryView edv, String filePath, String fachrichtung, String abteilung)
			throws FileNotFoundException {
		
		FacesContext fc = FacesContext.getCurrentInstance();
	    ExternalContext ec = fc.getExternalContext();
	    
	    ec.responseReset(); 
		ec.setResponseContentType("application/pdf");
		ec.setResponseHeader("Content-Disposition", "attachment;filename=Ausbildungsnachweis.pdf");
	    
	    try {
	    	ec.getResponseOutputStream().flush();
			OutputStream output = ec.getResponseOutputStream();

			pdf.createPDF(edv, output, fachrichtung, abteilung);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void uploadEducationDiary(EducationDiaryView edv, EducationDiaryListView edl,
			List<EducationDiaryDayView> days) {

		EducationDiary ed = parseDiaryView(edv, edl, true);
//
//		ed.setDays(days.stream().map(day -> this.parseDiaryView(day, true)).collect(Collectors.toList()));
//
//		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
//
//		em.getTransaction().begin();
//		em.persist(ed);
//		em.getTransaction().commit();

	}

	public EducationDiary parseDiaryView(EducationDiaryView edv, EducationDiaryListView edlv, boolean newElem) {
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		EducationDiary ed = null;
		if (!newElem) {
			ed = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager()
					.createQuery(
							"from km_Entities.EducationDiary where educationDiaryID = " + edv.getEducationDiaryID(),
							EducationDiary.class)
					.getSingleResult();
			if (ed == null)
				throw new NullPointerException("No such element in the database. Custom Error.");
			return ed;

		}

		List<EducationDiaryDay> edudaylist = new ArrayList<EducationDiaryDay>();
		for(EducationDiaryDayView d : edv.getDays()){
			EducationDiaryDay day = new EducationDiaryDay();
			day.setDay(d.getDayID());
			
			List<Activity> actions = new ArrayList<Activity>();
			for(ActivityView a: d.getActivityViews()){
				Activity act = new Activity();
				act.setDescription(a.getDescription());
				act.setDuration(a.getDuration());
				actions.add(act);
			}
			day.setActivity(actions);
			
			edudaylist.add(day);
		}
		StudentClass sc = cs.getStudentClass(edv.getStudentClass().getClassID());
		Student owner = ss.findStudentByUserId(edv.getContent().getCreator().getStudentID());
		
		Query getcontent = em.createQuery("from " + ContentType.class.getName() + " where Name = :name");
		getcontent.setParameter("name", edv.getContent().getContentTypeName());
		

		Content ct = new Content(owner ,
				((ContentType)getcontent.getSingleResult()), edv.getContent().getCreated(),
				edv.getContent().getChanged());
		
		ed = new EducationDiary();
		ed.setContent(ct);
		ed.setStudentClass(sc);
		ed.setDays(edudaylist);
		ed.setEndDate(edv.getEndDate());
		ed.setStartDate(edv.getStartDate());
		ed.setWeeek(5);
		EducationDiaryList edlist = new EducationDiaryList();
		
		
		try {
			em.getTransaction().begin();

			Query q = em.createQuery("from " + EducationDiaryList.class.getName() + " where id = :id");
			q.setParameter("id", edlv.getEdlId());
			
			edlist = (EducationDiaryList) q.getSingleResult();
			ed.setList(edlist);
			edlist.getEducationDiary().add(ed);
			em.persist(edlist);
			em.persist(ed);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			em.getTransaction().commit();
		}
		return ed;
	}

	
//	public EducationDiaryList parseDiaryView(EducationDiaryListView edl, boolean newElem) {
//		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
//		TypedQuery<EducationDiaryList> q = em.createQuery(
//				"from km_Entities.EducationDiaryList where EducationDiaryList = " + edl.getEdlId(),
//				EducationDiaryList.class);
//		EducationDiaryList ed = null;
//		if (!newElem) {
//			try {
//				ed = q.getSingleResult();
//				if (ed == null) {
//					throw new NullPointerException("No List found. Looking for another one...");
//					// Wenn keine ListenId vorhanden ist, muss eine andere
//					// gesucht werden...
//				}
//			} catch (NullPointerException e) {
//				e.printStackTrace();
//				// Diese findet sich im ersten Eintrag der ViewListe.
//				ed = em.createQuery(
//						"from km_Entities.EducationDiaryList where EducationDiaryList = " + em.createQuery(
//								"from km_Entities.EducationDiary where educationDiaryID = "
//										+ edl.getEducationDiaryList().get(0).getEducationDiaryListId(),
//								EducationDiary.class).getSingleResult(),
//						EducationDiaryList.class).getSingleResult();
//
//			}
//			return ed;
//		}
//
//		try {
//			if (edl.getEducationDiaryList() != null)
//				ed = new EducationDiaryList(cs.getStudentClass(edl.getStudentClass().getClassID()),
//						edl.getEducationDiaryList().stream().map(d -> this.parseDiaryView(d, false))
//								.collect(Collectors.toList()));
//			else
//				ed = new EducationDiaryList(cs.getStudentClass(edl.getStudentClass().getClassID()));
//
//			em.getTransaction().begin();
//			em.persist(ed);
//			em.getTransaction().commit();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			em.getTransaction().rollback();
//			em.getTransaction().commit();
//			throw e;
//		}
//		return ed;
//
//	}
//
//	public EducationDiaryDay parseDiaryView(EducationDiaryDayView edd, boolean newElem) {
//		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
//		TypedQuery<EducationDiaryDay> q = em.createQuery("from km_Entities.EducationDiaryDay where educationDiaryID = "
//				+ edd.getEducationDiaryID() + " and day = " + edd.getDayID(), EducationDiaryDay.class);
//		EducationDiaryDay ed = null;
//
//		if (!newElem) {
//			ed = q.getSingleResult();
//			if (ed == null)
//				throw new NullPointerException("No such EducationDiaryDay in the database...");
//			return ed;
//
//		}
//
//		try {
//			ed = new EducationDiaryDay(this.getEducationDiary(edd.getEducationDiaryID()), edd.getDayID(),
//					edd.getActivityViews().stream().map(a -> new Activity(a.getDescription(), a.getDuration()))
//							.collect(Collectors.toList()));
//
//			em.getTransaction().begin();
//			em.persist(ed);
//			em.getTransaction().commit();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			em.getTransaction().rollback();
//			throw e;
//		}
//
//		return ed;
//
//	}
//
	@Override
	public EducationDiaryListView getEducationDiaries(ClassView cv, Date from, Date until) {
		// TODO Auto-generated method stub
		return getEducationDiaries(cv);
	}

	@Override
	public EducationDiaryListView getEducationDiaries(ClassView cv) {
		// TODO Auto-generated method stub
		EducationDiaryList diarylist = null;
		StudentClass theclass = new StudentClass();
		theclass.setClassID(cv.getClassID());
		theclass.setEducationPath(cv.getEducationPath());
		theclass.setYear(cv.getYear());
		
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Query q1 = em.createQuery("from " + EducationDiaryList.class.getName() + " where studentClass = :class");
		q1.setParameter("class", theclass);

		Object result = null;
		try{
			result = q1.getSingleResult();
			diarylist = (EducationDiaryList) result;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		em.close();
		
		
		return new EducationDiaryListView(diarylist);
	}

	@Override
	public List<EducationDiaryDayView> getEducationDiary(EducationDiaryView edv) {
		// TODO Auto-generated method stub
		return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager()
				.createQuery("from km_Entities.EducationDiaryDay where educationDiaryID = " + edv.getEducationDiaryID(),
						EducationDiaryDay.class)
				.getResultList().stream().map(day -> new EducationDiaryDayView(day)).collect(Collectors.toList());
	}

	public EducationDiary getEducationDiary(int id) {
		return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager()
				.createQuery("from km_Entities.EducationDiary where educationDiaryID = " + id, EducationDiary.class)
				.getSingleResult();
	}

}
