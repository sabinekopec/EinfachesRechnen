package exercises;

import java.util.ArrayList;
import java.util.List;


public class GenerateListOfExercises {
	
	private Exercise exercise;
	
	private static List<String> listOfExercises = new ArrayList<String>();
	
	private List<String> listOfSolutions = new ArrayList<String>();
	private List<String> listOfSpaces = new ArrayList<String>();
	public GenerateListOfExercises() {
		
		int number1, number2, result, exerciseType;
		String operation;
		
		
		for (int i = 0; i<10; i++) {
			exercise = new Exercise();
			exercise.init();
			
			number1 = exercise.getNumber1();
			number2 = exercise.getNumber2();
			operation = exercise.getOperation();
			result = exercise.getResult();
			
			exerciseType = exercise.getExerciseType();
			
			System.out.println("in Klasse GenerateListOfExercises");
			System.out.println(Integer.toString(number1)+ operation+ Integer.toString(number2)+ "=" + Integer.toString(result));
			
			String listEntry = new String();
			int solution = 0;
			
			switch(exerciseType) {
			case 1:
				listEntry = String.format("%d %s __ = %d" , number1, operation, result);
				solution = number2;
				break;
			case 2:
				listEntry = String.format("__ %s %d = %d" , operation, number2, result);
				solution = number1;
				break;
			case 3:
				listEntry = String.format("%d %s %d = __" , number1, operation, number2);
				solution = result;
			}
			
			System.out.println("formatierter String");
			System.out.println(listEntry);
			
			listOfExercises.add(listEntry);
			listOfSolutions.add(Integer.toString(solution));
			listOfSpaces.add(" ");
			
		}
		String solutions = String.join(" ", listOfSolutions);
		
		listOfExercises.addAll(listOfSpaces);
		listOfExercises.add("Lösungen:");
		listOfExercises.add(solutions);
		
		new HandlingExercises();
	}
	
	
	public static List<String> getListOfExercises() {
		return listOfExercises;
	}

//	public static List<String> getListOfSolutions() {
//		return listOfSolutions;
//	}
	
}
