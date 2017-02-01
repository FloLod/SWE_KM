package km_Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import km_Entities.*;

public class EntityManagerFactoryService {

		private static EntityManagerFactory emf;
		
		private EntityManagerFactoryService() {}
		
		public static EntityManagerFactory getEntityManagerFactory() {
			if (emf==null){
				emf = Persistence.createEntityManagerFactory("testproject");
				
			}
			return emf;
		}
		
		@Override
		protected void finalize() {

		}

		
}
