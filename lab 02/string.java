package prog1;

public class string {
	String name;
	int age;
	void displayInfo() {
		System.out.println("Name:"+ name +", Age:"+ age);
		
	}
	public static void main(String[] args) {
	 string s1 = new string();
	 s1.name = "koushal";
	 s1.age=19;
	 s1.displayInfo();
		
		
	}

}
