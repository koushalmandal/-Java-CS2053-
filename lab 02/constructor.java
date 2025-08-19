package prog2;

public class constructor {
	String brand;
	int year;
	
	constructor(String b, int y) {
		brand=b;
		year=y;
	}
	void display() {
		System.out.println("Car:"+brand + "("+year + ")");
	}
	public static void main(String [] args) {
		constructor c1= new constructor("toyota", 2020);
		constructor c2= new constructor("bmw", 2024);
		 
		c1.display();
		c2.display();		
	}

}
