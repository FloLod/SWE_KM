package km_Services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;

import km_Entities.Student;
import km_Entities.StudentClass;
import km_Entities.User;
//github.com/FloLod/SWE_KM
import km_Views.StudentView;

public class StudentServiceImpl implements StudentService{

	@Override
	public void addStudent(StudentView student) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		
		Student student2 = em.find(Student.class, student.getStudentID());
		
		if(student2 != null){
			em.getTransaction().begin();
			Student s = new Student();
			StudentClass sc = em.find(StudentClass.class, student.getStudentClass().getClassID());
			User user = new User();
			user.setFirstName(student.getUser().getFirstname());
			user.setLastName(student.getUser().getLastname());
			
			user.setPassword(student.getUser().getPasswort());
			user.seteMail(student.getUser().getEmail());
			s.setClassSpeaker(false);
			s.setKarma(0);
			s.setStudentClass(sc);
			s.setUser(user);
			em.persist(s);
			em.getTransaction().commit();
			em.close();
			
		}else{
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public void findStudent(int studentid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(int studentid) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		Student s = em.find(Student.class, studentid);
		
		if(s != null){
			em.remove(s);
			em.close();
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Student findStudentByUserId(int userid) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = EntityManagerFactoryService.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = (Query) em.createQuery("from student where user= :userid");
		q.setParameter(":userid", userid);
		em.close();
		Object result = null;
		Student s = null;
		try{
			result = q.uniqueResult();
			s = (Student) result;
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}

}
