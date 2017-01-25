package km_Services;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import km_Entities.User;
import km_Views.UserView;

@ManagedBean
@SessionScoped
public class LoginServiceImpl implements LoginService {

	@Override
	@PostConstruct
	public UserView getLogin(String email, String pw) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = EntityManagerFactoryService.getEntityManagerFactory();
		if(emf == null){
			System.out.println("EMF IST NULL IN GET LOGIN");
		}
		EntityManager em = emf.createEntityManager();
		if(em == null){
			System.out.println("EM IST NULL IN GET LOGIN");
		}
		System.out.println("in getlogin");
		em.getTransaction().begin();
		Query q = em.createQuery("from "+User.class.getName()+" where email = :email");
		q.setParameter("email", email);
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
		em.close();
		UserView uv = new UserView(u);

		System.out.println("in getlogin userview geladen");
		

		System.out.println("in getlogin Userview"+uv.getFirstname()+uv.getLastname()+" Password:"+uv.getPasswort()+ " Email:"+uv.getEmail());
		
		
		if(uv.getPasswort().contentEquals(pw)){
			return uv;
		}

		System.out.println("in getlogin passwörter stimmen nicht");
		return null;
	}
}