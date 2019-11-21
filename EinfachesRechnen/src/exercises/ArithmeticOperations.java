package exercises;
import org.apache.commons.math3.fraction.*;

public class ArithmeticOperations {
	
	
	public int randomNumber(int min, int max) {
	    return (int) (min + Math.random() * (max + 1 - min) );
	}
	

	
	public static Integer sum(Integer number1, Integer number2) {
		return number1 + number2;
	}
	
	public static Integer diff(Integer number1, Integer number2) {
		return number1 - number2;
	}
	
	public static Integer product(Integer number1, Integer number2) {
		return number1 * number2;
	}
	
	public static Integer ratio(Integer number1, Integer number2) {
		return number1 / number2;
	}

	
	public static Fraction sum(Fraction fraction1, Fraction fraction2) {
		return fraction1.add(fraction2);
	}
	
	public static Fraction diff(Fraction fraction1, Fraction fraction2) {
		return fraction1.subtract(fraction2);
	}
	
	public static Fraction product(Fraction fraction1, Fraction fraction2) {
		return fraction1.multiply(fraction2);
	}
	
	public static Fraction ratio(Fraction fraction1, Fraction fraction2) {
		return fraction1.divide(fraction2);
	}

}
