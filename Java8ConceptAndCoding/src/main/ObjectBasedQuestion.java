package main;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
	//13. Highest salary per department
	public ObjectBasedQuestion heighestSalryPerDepartmet(List<Employee> list) {
		//method 1
		list.stream().collect(Collectors.groupingBy(emp->emp.getDepartment()))
		             .entrySet()
		             .stream()
		             .forEach(entry->System.out.println("department "+entry.getKey()+
		              " heighest salary is "+entry.getValue().stream().max(Comparator.comparing(Employee::getSalary)).get().getSalary()));
		//method 2
		Map<String, Optional<Employee>> map =
				list.stream()
				        .collect(Collectors.groupingBy(
				        Employee::getDepartment,
				        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
				));
		return this;
	}
	//14. Average salary per department
	public ObjectBasedQuestion averageSalryPerDepartmet(List<Employee> list) {
		
		//method 1
		Map<String,Double> map = list.stream()
				                     .collect(Collectors.groupingBy(Employee::getDepartment,
				                    		                        Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(map.toString());
		return this;
	}
	//15. Find duplicate employee names
	public ObjectBasedQuestion duplicateEmployeeNames(List<Employee> list) {
		list.stream().collect(Collectors.groupingBy(Employee::getName))
		             .entrySet()
		             .stream()
		             .filter(entry->entry.getValue().size()>1)
		             .forEach(entry->System.out.println(entry.getValue().get(0).getName()));
		return this;
	}
	//16. Find department with highest average salary
	public ObjectBasedQuestion heighestAverageSalryDepartmet(List<Employee> list) {
		Map.Entry<String,Double> ans = list.stream()
				                           .collect(Collectors.groupingBy(Employee::getDepartment, 
				                        		                          Collectors.averagingDouble(Employee::getSalary)))
		                                   .entrySet()
		                                   .stream()
		                                   .max(Map.Entry.comparingByValue())
		                                   .get();
		System.out.println("Department "+ans.getKey()+" Heighest average salary "+ans.getValue());
		return this;
	}
	//17. Find the nth highest salary
	public ObjectBasedQuestion nthHeighestSalaryEmployee(List<Employee> list,int n) {
		Employee emp = list.stream()
				           .sorted(Comparator.comparing(Employee::getSalary).reversed())
				           .skip(n-1)
				           .findFirst()
				           .get();
		System.out.println(emp.getName()+" having nth heighest salary");
		return this;
	}
	//18. Get salary statistics
	public ObjectBasedQuestion employeeSalaryStatics(List<Employee> list) {
		DoubleSummaryStatistics ds = list.stream()
				                         .collect((Collectors.summarizingDouble(Employee::getSalary)));
		System.out.println(ds.toString());
		return this;
	}
	//19. Convert List<Employee> to Map<id, name>
	public ObjectBasedQuestion listOfEmplyeeToMap(List<Employee> list) {
		Map<Integer, String> map =
		        list.stream()
		        .collect(Collectors.toMap(
		                Employee::getId,
		                Employee::getName
		        ));
		return this;
	}
	//20. Find the department having the most employees
	public ObjectBasedQuestion departmentWithHeighestEmployee(List<Employee> list) {
		String dept = list.stream()
		        .collect(Collectors.groupingBy(
		                Employee::getDepartment,
		                Collectors.counting()
		        ))
		        .entrySet()
		        .stream()
		        .max(Map.Entry.comparingByValue())
		        .get()
		        .getKey();
		return this;
	}
}
