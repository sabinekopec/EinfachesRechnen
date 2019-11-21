package exercises;
import java.util.List;
import java.util.Random;
import org.apache.commons.math3.fraction.*;

public class Exercise extends ArithmeticOperations {
	
	public Exercise() {
		
	}
	
//	private Integer number1;
//	private Integer number2;
//	private Fraction fraction1, fraction2;
	private int[] numberRange;
	
	private String operation;
	
	private int exerciseType;
	
	private Number result,number1,number2; 
	
	boolean useFraction;
	
	
	public void init() {
		numberRange = StartFrame.getNumberRange();
		
		useFraction = StartFrame.getUseFraction();
		if (useFraction) {
			int random1 = (Integer) getRandomNumber(numberRange[0],numberRange[1]);
			int random2 = 0;
			while (random2 == 0) {
				random2 = (Integer) getRandomNumber(numberRange[0],numberRange[1]);
			}
			number1 = new Fraction(random1,random2);
			
			random1 = (Integer) getRandomNumber(numberRange[0],numberRange[1]);
			
			random2 = 0;
			while (random2 == 0) {
				random2 = (Integer) getRandomNumber(numberRange[0],numberRange[1]);
			}
			number2 = new Fraction(random1,random2);
			
		} else {
			number1 = (Integer) getRandomNumber(numberRange[0],numberRange[1]);
			number2 = (Integer) getRandomNumber(numberRange[0],numberRange[1]);

		}
//		numberRange = StartFrame.getNumberRange();
//		number1 = getRandomNumber(numberRange[0],numberRange[1]);
//		number2 = getRandomNumber(numberRange[0],numberRange[1]);
		operation = getRandomOperation(StartFrame.getArithmeticOperations());
		
		result = calculation(number1, number2, operation);
		
		exerciseType = super.randomNumber(1,3);
		System.out.println(exerciseType);
		System.out.println(number1.toString()+ operation+ number2.toString()+ "=" + result.toString());
		
	}

	
	public int getRandomNumber(int min, int max) { 
		// calls the static method randomNumber from class ArithmeticOperations:
		// generates random number between min and max, both inclusive.
		return super.randomNumber(min,max);
    } 
	
	public String getRandomOperation(List<String> list) {
		// select a random operation from the user-generated list operations
		operation = list.get(new Random().nextInt(list.size()));
		return operation;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public Number getNumber1() {
		return number1;
	}
	public Number getNumber2() {
		return number2;
	}
	public Number getResult() {
		return result;
	}
	
//	public Fraction getFraction1() {
//		return fraction1;
//	}
//	
//	public Fraction getFraction2() {
//		return fraction2;
//	}
	
	public int getExerciseType() {
		return exerciseType;
	}
	
	public Number calculation(Number number1, Number number2, String operation) {
		

		switch (operation) {
		case "+":
			if (number1 instanceof Integer) {
				result = sum( (Integer) number1,(Integer) number2);
			} else if (number1 instanceof Fraction) {
				result = sum((Fraction) number1, (Fraction)number2);
			}
			break;
		case "-":
			if (number1 instanceof Integer) {
				result = diff((Integer) number1,(Integer) number2);
			} else if (number1 instanceof Fraction) {
				result = diff((Fraction) number1, (Fraction)number2);
			}
			break;
		case "*":
			if (number1 instanceof Integer) {
				result = product((Integer) number1,(Integer) number2);
			} else if (number1 instanceof Fraction) {
				result = product((Fraction) number1, (Fraction)number2);
			}
			break;
//		case "/":
//			// avoid ambiguous solution (if nominator is zero), division by zero, 
//			// only show exercises where result is an integer
//			if (number1 !=0 && number2 != 0 && (number1 % number2 == 0)) {
//				result = ratio(number1,number2);
//			} else {
//				init();
//			}
		}
		return result;
	}

	
	
}
