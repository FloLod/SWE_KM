package km_Services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import km_Entities.Student;
import km_Entities.StudentClass;
import km_Entities.User;
//github.com/FloLod/SWE_KM

import km_Views.StudentView;
import km_Views.UserView;


public class StudentServiceImpl implements StudentService{

	@Override
	public void addStudent(StudentView student) throws IllegalArgumentException {
		EntityManager em =  EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();

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
		EntityManagerFactory emf = EntityManagerFactoryService.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Query q = em.createQuery("from "+Student.class.getName()+" where user= :userid");
		q.setParameter("userid", findUser(userid));	
		Object result = null;
		Student s = null;
		try{
			result = q.getSingleResult();
			s = (Student) result;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}

		return s;
	}
	
	@Override	
	public Student findStudentByUser(UserView user) {
		EntityManagerFactory emf = EntityManagerFactoryService.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Query q = em.createQuery("from "+User.class.getName()+" where email = :email");
		q.setParameter("email", user.getEmail());
		
		Object result = null;
		User u = null;
		try{
			result = q.getSingleResult();
			u = (User) result;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		q = em.createQuery("from "+Student.class.getName()+" where user= :userid");
		q.setParameter("userid", u);
		result = null;
		Student s = null;
		try{
			result = q.getSingleResult();
			s = (Student) result;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		System.out.println("findstudentbyid raus");

		return s;
	}

	private User findUser(int id)
	{
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		Query q = em.createQuery("from " + User.class.getName()+ " where userid = :id");
		q.setParameter("id", id);
		
		return (User)q.getSingleResult();
	}
}
