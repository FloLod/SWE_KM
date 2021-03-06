package km_Services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import km_Entities.Student;
import km_Entities.StudentClass;
import km_Entities.User;
import km_Views.ClassView;
import km_Views.StudentView;

public class ClassServiceImpl implements ClassService {

	@Override
	public List<StudentView> getClass(int classID) {
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		
		TypedQuery<Student> query = em.createQuery("from km_Entities.Student s where s.studentClass.classID=:class", Student.class);
		query.setParameter("class", classID);
		List<Student> result = query.getResultList();
		List<StudentView> retList = new ArrayList<StudentView>();
		
		for (Student s  : result){
			retList.add(new StudentView(s));
		}
		
		
		
		return retList;
	}

	@Override
	public void addClass(ClassView studentClass) throws IllegalArgumentException {
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();

			em.getTransaction().begin();
			StudentClass c = new StudentClass();
			c.setEducationPath(studentClass.getEducationPath());
			c.setYear(studentClass.getYear());
			em.persist(c);
			em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void deleteClass(int classID) throws IllegalArgumentException {
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();

		StudentClass sc = em.find(StudentClass.class, classID);
		if (sc != null) {
			em.getTransaction().begin();
			em.remove(sc);
			em.getTransaction().commit();
		} else {
			em.close();
			throw new IllegalArgumentException();
		}
		em.close();
	}

	@Override
	public List<ClassView> getClasses() {
		List<ClassView> retList = new ArrayList<ClassView>();

		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<StudentClass> query = cb.createQuery(StudentClass.class);
		Root<StudentClass> c = query.from(StudentClass.class);
		query.select(c);
		query.orderBy(cb.desc(c.get("year")));
		List<StudentClass> classes = em.createQuery(query).getResultList();
		System.out.println(classes.get(0).getClassID());
		for (StudentClass studentClass : classes) {
			retList.add(new ClassView(studentClass));
		}
		return retList;
	}

	@Override
	public StudentClass getStudentClass(int classID) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		StudentClass retVal = em.find(StudentClass.class, classID);
		
		
		return retVal;
	}

	@Override
	public void addClassspeaker(StudentView studentView) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		
		Student s = em.find(Student.class, studentView.getStudentID());
		
		if (s != null){
			if(!s.isClassSpeaker()){
				em.getTransaction().begin();
				s.setClassSpeaker(true);
				em.persist(s);
				em.getTransaction().commit();
				em.close();
			}else{
				throw new IllegalArgumentException();
			}
		}else{
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public void createClassspeaker(StudentView classspeaker) {
		// TODO Auto-generated method stub
EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		
		
			em.getTransaction().begin();
			Student s = new Student();
			StudentClass sc = em.find(StudentClass.class, classspeaker.getStudentClass().getClassID());
			User user = new User();
			user.setFirstName(classspeaker.getUser().getFirstname());
			user.setLastName(classspeaker.getUser().getLastname());
			
			user.setPassword(classspeaker.getUser().getPasswort());
			user.seteMail(classspeaker.getUser().getEmail());
			s.setClassSpeaker(true);
			s.setKarma(0);
			s.setStudentClass(sc);
			s.setUser(user);
			em.persist(s);
			em.getTransaction().commit();
			em.close();
			
		
	}

}
