package MainPackage;

import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) {

		// different ways to get class object
		Class<Employee> cl = Employee.class;
		
		System.out.println(cl.getName());
		
		Class<?> cl1 = new Employee().getClass();
		
		System.out.println(cl1.getPackageName());
		
		try {
			Class<?> cl2 = Class.forName("MainPackage.Employee"); // forname need full fledged package name
			System.out.println(cl2.getSimpleName());
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		//Accessing Fields Using Reflection
		Field[] feilds = cl.getDeclaredFields();
		for(Field f : feilds) {
			System.out.println(f.getName());
		}
		
	}

}
