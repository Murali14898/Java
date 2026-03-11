package main;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		List<Integer> list= List.of(2,6,1,9,5,7,4,3,11,10,2,9);
		List<String>  list1 = List.of("AbcDef","AgthjuiPo","bcAfeD");
		String s = "ABCBAD";
		int[] arr = {7,4,3,11,10,2};
		Map<String,Integer> map = Map.of("Ram",89,"Raj",76,"Raju",70,"Rahim",92);
		List<Employee> employeeList = List.of(new Employee(101,"Murali",50000,"Billing"),
				                              new Employee(102,"Raushan",55000,"Billing"),
				                              new Employee(103,"Ajit",63000,"MainFrame"),
				                              new Employee(104,"Chandan",85000,"Fsdgtl"),
				                              new Employee(105,"Abhishek",76000,"Fsdgtl"),
				                              new Employee(105,"Abhishek",76000,"Fsdgtl"),
				                              new Employee(106,"Swastik",92000,"MainFrame"),
				                              new Employee(107,"Ayush",65000,"Billing"));
//		NonObjectQuestions nonObj = new NonObjectQuestions().reverseAList(list)
//				                                            .firstNonRepeatCharacter(s)
//				                                            .findDuplicatesInAList(list)
//				                                            .convertToUpperCase(list1)
//				                                            .secondHeighestNumber(arr)
//				                                            .sumOfEvenNumbers(list)
//				                                            .checkOnlyEven(list)
//				                                            .sortAMapByValue(map)
//				                                            .removeDuplicates(list)
//				                                            .primeNumbersInAList(list)
//		                                                    .anagramsInList(list1);
		new ObjectBasedQuestion()
//		                         .getNameOfAllEmployee(employeeList)
//		                         .sortEmployeeBytheirSalary(employeeList)
//		                         .heighestSalaryEmployee(employeeList)
//		                         .heighestSalryPerDepartmet(employeeList)
//		                         .DuplicateEmployeeBasedOnName(employeeList)
//		                         .heighestAverageSalryDepartmet(employeeList)
//		                         .nthHeighestSalaryEmployee(employeeList, 3)
//		                         .employeeSalaryStatics(employeeList)
		                         .departmentsSecondHeighestSalry(employeeList);

	}

}
