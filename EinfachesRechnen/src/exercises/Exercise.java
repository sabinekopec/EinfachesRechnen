package exercises;
import java.util.List;
import java.util.Random;


public class Exercise extends ArithmeticOperations {
	
	public Exercise() {
		
	}
	
	private int number1;
	private int number2;
	private int[] numberRange;
	
	private String operation;
	
	private int exerciseType;
	
	private int result; //= calculation(number1, number2, operation);
	
	
	public void init() {
		numberRange = StartFrame.getNumberRange();
		number1 = getRandomNumber(numberRange[0],numberRange[1]);
		number2 = getRandomNumber(numberRange[0],numberRange[1]);
		operation = getRandomOperation(StartFrame.getArithmeticOperations());
		
		result = calculation(number1, number2, operation);
	}
	
//	int arithmeticOperations = StartFrame.getArithmeticOperations();

	
	public int getRandomNumber(int min, int max) { 
		// calls the static method randomNumber from class ArithmeticOperations:
		// generates random number between min and max, both inclusive.
		return randomNumber(min,max);
    } 
	
	public String getRandomOperation(List<String> list) {
		operation = list.get(new Random().nextInt(list.size()));
		return operation;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public int getNumber1() {
		return number1;
	}
	public int getNumber2() {
		return number2;
	}
	public int getResult() {
		return result;
	}
	
	public int getExerciseType() {
		exerciseType = randomNumber(1,3);
		return exerciseType;
	}
	
	public int calculation(int number1, int number2, String operation) {
		
		switch (operation) {
		case "+":
			result = sum(number1,number2);
			break;
		case "-":
			result = diff(number1,number2);
			break;
		case "*":
			result = product(number1,number2);
			break;
		case "/":
			if (number1 !=0 && number2 != 0 && (number1 % number2 == 0)) {
				result = ratio(number1,number2);
			} else {
				init();
			}
		}
		return result;
	}

	
	
}
