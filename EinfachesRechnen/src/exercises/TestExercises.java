package exercises;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.fraction.*;

import junit.framework.TestCase;

public class TestExercises extends TestCase {

	private Exercise exercise;
	
	protected void setUp() throws Exception {
		exercise = new Exercise();
	}
	
	public void testRandomNumbers () {
		assertTrue(exercise.getRandomNumber(0,5)>=0 && exercise.getRandomNumber(0,5)<=5);
	}
	
	public void testRandomOperation() {
		List<String> list = new ArrayList<String>();
		list.add("+");
		assertEquals(exercise.getRandomOperation(list),"+");
		
		list.add("-");
		assertTrue(list.contains(exercise.getRandomOperation(list)));
	}
	
	public void testCalculation () {
		Fraction result = exercise.calculation(new Fraction(2), new Fraction(1),"+");
		assertEquals(result,new Fraction(3));
		
		result = exercise.calculation(new Fraction(2),new Fraction(1),"-");
		assertEquals(result,new Fraction(1));
		
		result = exercise.calculation(new Fraction(2),new Fraction(2),"*");
		assertEquals(result,new Fraction(4));
		
		result = exercise.calculation(new Fraction(12),new Fraction(2),"+");
		assertEquals(result,new Fraction(14));
		
		result = exercise.calculation(new Fraction(14),new Fraction(4),"-");
		assertEquals(result,new Fraction(10));
		
		result = exercise.calculation(new Fraction(6),new Fraction(3),"*");
		assertEquals(result,new Fraction(18));
		
		result = exercise.calculation(new Fraction(4),new Fraction(2),"/");
		assertEquals(result,new Fraction(2));
		
		result = exercise.calculation(new Fraction(15),new Fraction(3),"/");
		assertEquals(result,new Fraction(5));
		
		result = exercise.calculation(new Fraction(20),new Fraction(5),"/");
		assertEquals(result,new Fraction(4));
		
		result = exercise.calculation(new Fraction(2,5),new Fraction(1,5),"+");
		assertEquals(result,new Fraction(3,5));
		
		
	}
	
}
