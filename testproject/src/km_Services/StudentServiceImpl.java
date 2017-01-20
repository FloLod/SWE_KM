package km_Services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;

import km_Entities.Student;
import km_Views.StudentView;

public class StudentServiceImpl implements StudentService{

	@Override
	public void addStudent(StudentView student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findStudent(int studentid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(int studentid) {
		// TODO Auto-generated method stub
		
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
