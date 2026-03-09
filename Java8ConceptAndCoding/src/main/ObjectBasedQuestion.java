package main;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectBasedQuestion {
	
	//1. Get name of all employee
	public ObjectBasedQuestion getNameOfAllEmployee(List<Employee> list) {
		List<String> nameList = list.stream().map(ele->ele.getName())
				                             .collect(Collectors.toList());
		System.out.println(nameList.toString());
		return this;
	}
	//2. Sort Employee in descending order by their salary
	public ObjectBasedQuestion sortEmployeeBytheirSalary(List<Employee> list) {
		List<EmployeeDto> sortedList = list.stream()
				                           .sorted((emp1,emp2)->Double.compare(emp2.getSalary(), emp1.getSalary()))
				                           .map(EmployeeDto::new)
				                           .collect(Collectors.toList());
		//EmployeeDto should have a parameter constructor to accept Employee obj
		sortedList.forEach(ele->System.out.println(ele.getName() +" From department  "+ele.getDepartment() +" with salary "+ele.getSalary()));
		
		List<Employee> sorted = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				                             .collect(Collectors.toList());
		sorted.forEach(ele->System.out.println(ele.getName() +" From department : "+ele.getDepartment() +" with salary "+ele.getSalary()));
		return this;
	}
	//3. Find Highest Salary Employee
	public ObjectBasedQuestion heighestSalaryEmployee(List<Employee> list) {
		Employee emp = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				                    .findFirst()
				                    .orElse(null);
		System.out.println(emp.getName() +" From department : "+emp.getDepartment() +" with heighest salary "+emp.getSalary());
		return this;
	}
	//4. Find Second Highest Salary
	public ObjectBasedQuestion secondHeighestSalary(List<Employee> list) {
		Employee emp = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				                    .skip(1)
				                    .findFirst()
				                    .orElse(null);
		System.out.println("Employee "+emp.getName()+" with second heighest salary " + emp.getSalary());
		return this;
	}
	//5. Count Employees in Each Department
	public ObjectBasedQuestion countEmployeeInDepartment(List<Employee> list) {
		list.stream().collect(Collectors.groupingBy(emp->emp.getDepartment(),Collectors.counting()))
		             .entrySet()
		             .stream()
		             .forEach(entry->System.out.println(entry.getKey()+" having "+entry.getValue()+" employees"));
		return this;
	}
	//6. Group Employees by Department
	public ObjectBasedQuestion groupEmployeeByTheirDepartment(List<Employee> list) {
		Map<String,List<Employee>> map = list.stream()
				                         .collect(Collectors.groupingBy(emp->emp.getDepartment()));
		return this;
	}
	//7. Check If Any Employee Salary > 80 thousand
	public ObjectBasedQuestion checkWithsalaryMoreThanEigtyThousand(List<Employee> list) {
		boolean ans = list.stream().anyMatch(emp->emp.getSalary()>80000);
		System.out.println(ans);
		return this;
	}
	//8. Convert List of Employees to Map
	public ObjectBasedQuestion listEmployeeToMap(List<Employee> list) {
		Map<Integer,Employee> map = list.stream()
		                                .collect(Collectors.toMap(Employee::getId, e->e));
		map.keySet().stream()
		            .forEach(id->System.out.println("Empoyee with id "+id+"name "+map.get(id).getName()));
		return this;
	}
	//9. Find Duplicate Objects Based on Name
	public ObjectBasedQuestion DuplicateEmployeeBasedOnName(List<Employee> list) {
		list.stream().collect(Collectors.groupingBy(emp->emp.getName()))
		             .entrySet()
		             .stream()
		             .filter(entry->entry.getValue().size()>1)
		             .forEach(entry->entry.getValue().stream().forEach(emp->System.out.println(emp.getName())));
		return this;
	}
	//10. Get Average Salary
	public ObjectBasedQuestion averageSlaryOfAllEmployee(List<Employee> list) {
		double avgSalary = list.stream().mapToDouble(emp->emp.getSalary())
				                        .average()
				                        .orElse(0.00);
		System.out.println(avgSalary);
		return this;
	}
	//11. Partition Employees by Salary
	public ObjectBasedQuestion partitationEmpByTheirSalary(List<Employee> list) {
		Map<Boolean,List<Employee>> map = list.stream().collect(Collectors.partitioningBy(emp->emp.getSalary()>70000));
		return this;
	}
	//12. Get Top 3 Highest Salary Employees
	public ObjectBasedQuestion top3HeighestSalaryEmployee(List<Employee> list) {
		List<Employee> top3HighSalaryEmployee = list.stream()
				                                    .sorted(Comparator.comparing(Employee::getSalary).reversed())
				                                    .limit(3)
				                                    .collect(Collectors.toList());
		System.out.println(top3HighSalaryEmployee.get(0).getName());
		System.out.println(top3HighSalaryEmployee.get(1).getName());
		System.out.println(top3HighSalaryEmployee.get(2).getName());
		return this;
	}
}
