package fr.formation.afpa;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.formation.inti.entity.Department;
import fr.formation.inti.utils.HibernateUtils;

public class LifeCycleDemo {
	
	private static final Log log = LogFactory.getLog(LifeCycleDemo.class);
	
	public static void main(String[] args) {
		persist();
		log.info("fin programme");
	}

	/**
	 * example 
	 */
	public static void persist() {
		SessionFactory sf = HibernateUtils.getSessionFacory();

		Session session = sf.getCurrentSession();

		Department dept = new Department("developpement");
 
		session.getTransaction().begin();
		
//		session.save(dept);
//		session.persist(dept);
		session.saveOrUpdate(dept);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
