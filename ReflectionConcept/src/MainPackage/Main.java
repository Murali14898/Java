package MainPackage;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

		//1 : different ways to get class object
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
		
		System.out.println(cl==cl1); 
		// Important : cl,cl1,cl2 all are equal because 
		/*
		 * They all refer to the same Class object in JVM.

           Because each class has only one Class object per ClassLoader.
		 */
		
		//2 : Accessing Fields Using Reflection
		Field[] feilds = cl.getDeclaredFields();
		for(Field f : feilds) {
			System.out.println(f.getName());
		}
		/*
		 * Difference between getFields() and getDeclaredFields() and getField(String name)
		 * getFields()--------------------
		 * Returns only public fields
           Includes fields from parent classes
           Does not return private/protected/default fields
         * getDeclaredFields()-------------------
         * Returns public, private, protected, default
           Does NOT include inherited fields
           Returns only fields declared in that class
         * getField(String name)------------------
         * Returns only one field
           Field must be public
           Searches current class + parent classes
           Throws NoSuchFieldException if not found
		 */
		
		//3 : Access private field
		Employee emp = new Employee();
		Field field = cl.getDeclaredField("name");
		Field field2 = cl.getDeclaredField("id");
		field.setAccessible(true);   // bypass private
		field2.setAccessible(true);
		field.set(emp, "Murali");
		field2.set(emp, 5);
		System.out.println(field.get(emp)+" "+field2.getInt(emp)); //get(emp) also works
		                                                         //setAccessible(true) breaks encapsulation.
		
		//4 : Access static field
		Field field3 = cl.getField("company");

        System.out.println(field.get(null));   // read static field

        field3.set(null, "Wipro");              // modify static field

        System.out.println(Employee.company);
		
		//5: Accessing Methods 
		     //a : Get all methods 
		Method[] methods = cl.getDeclaredMethods();

		for(Method m : methods){
		    System.out.println(m.getName());
		}
		     //b : Invoke Method without parameter
		Method method = cl.getDeclaredMethod("display");
		method.invoke(emp);
		
		    //c : Invoke Method with parameter
		Method m = cl.getDeclaredMethod("add", int.class, int.class);
		int result = (int) method.invoke(emp, 10, 20);
		System.out.println(result);  
	}

}
