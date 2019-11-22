package exercises;
import java.util.List;
import java.util.Random;
import org.apache.commons.math3.fraction.*;

public class Exercise extends ArithmeticOperations {
	
	public Exercise() {
		
	}
	
	private int[] numberRange;
	
	private String operation;
	
	private int exerciseType;
	
	private Fraction result,number1,number2; 
	
	
	public void init() {
		
		generateTwoNumbersForExercise();
		
		operation = getRandomOperation(StartFrame.getArithmeticOperations());
		
		result = calculation(number1, number2, operation);
		

//		System.out.println(exerciseType);
//		System.out.println(number1.toString()+ operation+ number2.toString()+ "=" + result.toString());
	}
		
	public void generateTwoNumbersForExercise() {
		/*
		 * get number range from user selection in StartFrame
		 * in case of integers, two random numbers are generated
		 * in case of fractions, four random numbers are needed to generate two fractions
		 */
		numberRange = StartFrame.getNumberRange();
		
		boolean useFraction = StartFrame.getUseFraction();
		
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
			int random1 = getRandomNumber(numberRange[0],numberRange[1]);
			int random2 = getRandomNumber(numberRange[0],numberRange[1]);
			number1 = new Fraction(random1);
			number2 = new Fraction(random2);

		}
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
	
	public int getExerciseType() {
		/*
		 * exerciseType refers to which number in the exercise is missing and needs to be inserted
		 * different exercise types:
		 * 1 -> number1 + ? = result
		 * 2 -> ? + number2 = result
		 * 3 -> number1 + number2 = ?
		 */
		exerciseType = super.randomNumber(1,3);
		return exerciseType;
	}
	
	
	
	public Fraction calculation(Fraction number1, Fraction number2, String operation) {

		switch (operation) {
		case " + ":
			result = sum(number1, number2);
			break;
		case " - ":
			result = diff(number1, number2);
			break;
		case " * ":
			result = product(number1, number2);
			break;
		case "   /   ": // that many spaces to have a visual separation between the division "/" and the fraction "/" in case of division of two fractions 

			if (number1.getDenominator()==1 && number2.getDenominator()==1 && (number1.getNumerator() % number2.getNumerator() != 0)) {
				// for integers (denominator = 1) only show exercises where result is an integer
				init();
			} else if (number1.equals(new Fraction(0)) && number2.equals(new Fraction(0))){
				// avoid ambiguous solution (if nominator is zero) and division by zero, 
				init();
			} else {
				result = ratio(number1,number2);
			} 
		}
		return result;
	}

	
	
}
