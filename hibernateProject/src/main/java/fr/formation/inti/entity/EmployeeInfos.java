package fr.formation.inti.entity;

public class EmployeeInfos {
	
	private Integer empId;
	private String firstName;
	private String lastname;
	
	public EmployeeInfos() {
	}
	
	public EmployeeInfos(Integer empId, String firstName, String lastname) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastname = lastname;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "EmployeeInfos [empId=" + empId + ", firstName=" + firstName + ", lastname=" + lastname + "]";
	}
	
	
	
	

}
