package exercises;

public class ArithmeticOperations {
	
	
	public static int randomNumber(int min, int max) {
	    return (int) (min + Math.random() * (max - min) );
	}
	
	
	public static int sum(int number1, int number2) {
		return number1 + number2;
	}
	
	public static int diff(int number1, int number2) {
		return number1 - number2;
	}
	
	public static int product(int number1, int number2) {
		return number1 * number2;
	}
	
	public static int ratio(int number1, int number2) {
		return number1 / number2;
	}

}
