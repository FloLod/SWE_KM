package km_Services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import km_Entities.StudentClass;
import km_Views.ClassView;
import km_Views.StudentView;

public class ClassServiceImpl implements ClassService {

	@Override
	public List<StudentView> getClass(int classID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addClass(int classID) throws IllegalArgumentException {
		// How are description and Year entered?
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();

		StudentClass check = em.find(StudentClass.class, classID);
		if (check != null) {
			em.getTransaction().begin();
			StudentClass c = new StudentClass();
			c.setClassID(classID);
			em.persist(c);
			em.getTransaction().commit();
		} else {
			em.close();
			throw new IllegalArgumentException();
		}
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
		System.out.println("Hi");
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
		return null;
	}

}
