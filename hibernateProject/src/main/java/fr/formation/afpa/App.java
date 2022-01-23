package fr.formation.afpa;

import java.util.Date;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EmployeeService service = new EmployeeService();
    	Employee emp = new Employee("yaya", "jean", new Date());
    	
    	service.ajouterEmployee(emp);
    }
}
