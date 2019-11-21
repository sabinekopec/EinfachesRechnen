package exercises;

import java.util.ArrayList;
import java.util.List;


public class GenerateListOfExercises {
	
	private Exercise exercise;
	
	private ArrayList<String> listOfExercises = new ArrayList<String>();
	
	private List<String> listOfSolutions = new ArrayList<String>();
	private List<String> listOfSpaces = new ArrayList<String>();
	
	
	/*
	 * generate ArrayList of 10 exercises, with solutions as last entry 
	 * (some space in between to avoid the student spying on the solutions)
	 */
	
	public GenerateListOfExercises() {
		
		Number number1;
		Number number2;
		int exerciseType;
		Number result;
		String operation;
		
		
		for (int i = 0; i<10; i++) {
			
			exercise = new Exercise();
			exercise.init();
			
			number1 = exercise.getNumber1();
			number2 = exercise.getNumber2();
			operation = exercise.getOperation();
			result = exercise.getResult();
			
			exerciseType = exercise.getExerciseType();
			
			
			String listEntry = new String();
			Number solution = 0;
			
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
			
			listOfExercises.add(listEntry);
			listOfSolutions.add(solution.toString());
			listOfSpaces.add(" ");
			
		}
		String solutions = String.join(" ", listOfSolutions);
		
		listOfExercises.addAll(listOfSpaces);
		listOfExercises.add("Lösungen:");
		listOfExercises.add(solutions);
		
		new HandlingExercises(listOfExercises);
	}

	
}
