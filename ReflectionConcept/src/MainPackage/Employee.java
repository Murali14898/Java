package MainPackage;

public class Employee {
	public static String company;
	private int id;
	private String name;
	
	public Employee() {
	}

	public Employee(int id, String name) {
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void display() {
		System.out.println("Hi my name is : "+this.name);
	}
	
	public int add(int a, int b){
	    return a+b;
	}
}
