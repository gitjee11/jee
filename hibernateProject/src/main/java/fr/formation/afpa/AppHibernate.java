package fr.formation.afpa;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.EmployeeInfos;
import fr.formation.inti.utils.HibernateUtils;

public class AppHibernate {

	private static final Log log = LogFactory.getLog(AppHibernate.class);

	public static void main(String[] args) {
		queryUnique();

		log.info("fin programme");
	}

	/**
	 * example HQL
	 */
	public static void queryObject() {
		SessionFactory sf = HibernateUtils.getSessionFacory();

		Session session = sf.getCurrentSession();

		String hql = "select e from " + Employee.class.getName()
				+ " e  where e.department.deptId=:deptId order by e.firstName";

		session.getTransaction().begin();
		// Query
		Query<Employee> query = session.createQuery(hql);
		query.setParameter("deptId", 3);

		List<Employee> employees = query.getResultList();
		for (Employee e : employees) {
			log.info("----------- > " + e);
		}
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	/**
	 * example HQL get column empId, firstName, lastName
	 */
	public static void queryColomun() {
		SessionFactory sf = HibernateUtils.getSessionFacory();

		Session session = sf.getCurrentSession();

		String hql = "select e.empId, e.firstName, e.lastName from " + Employee.class.getName() + " e  ";

		session.getTransaction().begin();
		// Query
		Query<Object[]> query = session.createQuery(hql);

		List<Object[]> datas = query.getResultList();
		for (Object[] e : datas) {
			log.info("----------- > " + e[0] + " " + e[1] + " " + e[2]);
		}
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	/**
	 * example HQL get column empId, firstName, lastName
	 */
	public static void queryShortInfosEmployee() {
		SessionFactory sf = HibernateUtils.getSessionFacory();

		Session session = sf.getCurrentSession();

		String hql = "select new " + EmployeeInfos.class.getName() + "(e.empId,e.firstName,e.lastName) from "
				+ Employee.class.getName() + " e  ";

		session.getTransaction().begin();
		// Query
		Query<EmployeeInfos> query = session.createQuery(hql);

		List<EmployeeInfos> employees = query.getResultList();
		for (EmployeeInfos e : employees) {
			log.info("----------- > " + e);
		}
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	/**
	 * example HQL
	 */
	public static void queryUnique() {
		SessionFactory sf = HibernateUtils.getSessionFacory();

		Session session = sf.getCurrentSession();

		String hql = "select e from " + Employee.class.getName() + " e  where e.empId= :empId ";

		session.getTransaction().begin();
		// Query
		Query<Employee> query = session.createQuery(hql);
		query.setParameter("empId", 3);

		Employee emp = query.getSingleResult();
		log.info("----------- > " + emp);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
