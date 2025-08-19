package prog3;

public class calculator {
	int add(int a, int b) {
		return a+b;
	}
	int subtract(int a, int b) {
		return a-b;
		
		}
	     
	public static void main(String[] args) {
		calculator calc = new calculator();
		System.out.println("Addition:"+ calc.add(20,5));
		System.out.println("Subraction:"+ calc.subtract(20,5));
		
		}

}
