package km_Services;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import km_Entities.Student;
import km_Entities.StudentClass;
import km_Entities.User;
import km_Views.StudentView;
import km_Views.UserView;

@ManagedBean
@SessionScoped
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
			User user = em.find(User.class, student.getUser().getUserId());
			s.setClassSpeaker(student.getClassSpeaker());
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
		System.out.println("in findstudentbyid");
		Query q = em.createQuery("from "+Student.class.getName()+" where user= :userid");
		q.setParameter("userid", userid);	//crashes because no foreign key in hibernate
		System.out.println("in findstudentbyid query:"+q.toString());
		Object result = null;
		Student s = null;
		try{
			result = q.getSingleResult();
			s = (Student) result;
			System.out.println("findstudentbyid student: "+s.getStudentID()+" Klassensprecher: "+ s.isClassSpeaker() + " Lastname:"+s.getUser().getLastName());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		System.out.println("findstudentbyid raus");

		return s;
	}
	@Override
	public Student findStudentByUser(UserView user) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = EntityManagerFactoryService.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		System.out.println("in findstudentbyid");
		//
		Query q = em.createQuery("from "+User.class.getName()+" where email = :email");
		q.setParameter("email", user.getEmail());
		System.out.println("in getlogin query:" + q.toString());
		Object result = null;
		User u = null;
		try{
			result = q.getSingleResult();
			u = (User) result;
			System.out.println("in getlogin user name"+u.getFirstName()+u.getLastName()+"Password: "+u.getPassword()+" Email:"+u.geteMail());
		}catch(Exception e){
			e.printStackTrace();

			System.out.println("in getlogin gescheitert bei unique result");
		}
		
		q = em.createQuery("from "+Student.class.getName()+" where user= :userid");
		System.out.println("in findstudentbyid id:"+user);
		q.setParameter("userid", u);	//crashes because no foreign key in hibernate has to be a user but then no fit
		System.out.println("in findstudentbyid query:"+q.toString() +" "+q);
		result = null;
		Student s = null;
		try{
			result = q.getSingleResult();
			s = (Student) result;
			System.out.println("findstudentbyid student: "+s.getStudentID()+" Klassensprecher: "+ s.isClassSpeaker() + " Lastname:"+s.getUser().getLastName());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		System.out.println("findstudentbyid raus");

		return s;
	}

}
