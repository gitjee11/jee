package fr.formation.inti.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.utils.HibernateUtils;


/**
 * save - saveOrUpdate - persit - merge - find - load - get - delete - remove - refresh - clear - lock
 * @author spring
 *
 */
public class EmployeeDaoImpl implements IEmployeeDao{

	private static final Log log = LogFactory.getLog(EmployeeDaoImpl.class);
	private SessionFactory sf = HibernateUtils.getSessionFacory();
	private Session session = sf.getCurrentSession();
	private Transaction tx = session.getTransaction();

	public Session getCurrentSessionOpen() {
		if (!session.isOpen())
			session = sf.openSession();

		return session;
	}
	public void beginTransaction() {
		if(!tx.isActive())
			tx = session.beginTransaction();
	}
	
	public void commitTransaction() {
		tx.commit();
	}
	
	public void rollBackTransaction() {
		tx.rollback();
	}
	public void closeSessionFactory() {
		session.close();
		sf.close();
	}

	@Override
	public Integer save(Employee e) {
		return (Integer) session.save(e);
	}

	@Override
	public void update(Employee e) {
		session.update(e);

	}

	@Override
	public void delete(Integer empId) {		
		Employee e = session.find(Employee.class, empId);
		session.delete(e);

	}

	

	@Override
	public Employee findById(Integer id) {
		return session.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		return session.createQuery("from Employee e").getResultList();

	}
	
}
