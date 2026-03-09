package main;

public class EmployeeDto {
	private String name;
	
	private String department;
	
	private double salary;
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public EmployeeDto(Employee emp) {
		super();
		this.name = emp.getName();
		this.department = emp.getDepartment();
		this.salary = emp.getSalary();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
