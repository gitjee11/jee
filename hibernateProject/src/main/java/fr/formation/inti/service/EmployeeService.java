package fr.formation.inti.service;

import fr.formation.inti.dao.EmployeeDaoImpl;
import fr.formation.inti.entity.Employee;

public class EmployeeService {
	private EmployeeDaoImpl dao = new EmployeeDaoImpl(); 
	
	public Integer ajouterEmployee(Employee emp) {
		dao.beginTransaction();
		Integer empId = dao.save(emp);
		dao.commitTransaction();
		return empId;
	}

}
