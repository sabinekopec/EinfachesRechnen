package exercises;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class ExercisesTest extends TestCase {

	private Exercise exercise;
	
	protected void setUp() throws Exception {
		exercise = new Exercise();
	}
	
	public void testRandomNumbers () {
		assertTrue(exercise.getRandomNumber(0,5)>0 && exercise.getRandomNumber(0,5)<5);
	}
	
	public void testRandomOperation() {
		List<String> list = new ArrayList<String>();
		list.add("+");
		assertEquals(exercise.getRandomOperation(list),"+");
		
		list.add("+");
		assertTrue(exercise.getRandomOperation(list).equals("+") || exercise.getRandomOperation(list).equals("-"));
	}
	
	public void testCalculation () {
		int result = exercise.calculation(1,2,"+");
		assertEquals(result,3);
		
		result = exercise.calculation(2,1,"-");
		assertEquals(result,1);
		
		result = exercise.calculation(2,2,"*");
		assertEquals(result,4);
		
		result = exercise.calculation(12,2,"+");
		assertEquals(result,14);
		
		result = exercise.calculation(14,4,"-");
		assertEquals(result,10);
		
		result = exercise.calculation(6,3,"*");
		assertEquals(result,18);
		
//		result = exercise.calculation(4,2,"/");
//		assertEquals(result,2);
		
	}
	
}
