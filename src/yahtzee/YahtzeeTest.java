package yahtzee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class YahtzeeTest {

	private Yahtzee yahtzee;

	@Before
	public void setUp() {
		yahtzee = new Yahtzee();
	}
	
	@Test
	public void testRuleOneWithOneDieTotalResultIsOne() {
		int[] rolledDice = {1, 2, 4, 5, 6};
		
		yahtzee.rollDiceTest(rolledDice);
		yahtzee.chooseCategory("One");
		assertEquals(new Integer(1), yahtzee.totalScore());
	}

	@Test
	public void testRuleOneWithTwoDiceTotalResultIsTwo() throws Exception {
		int[] rolledDice = {1, 1, 4, 5, 6};
		
		yahtzee.rollDiceTest(rolledDice);
		yahtzee.chooseCategory("One");
		assertEquals(new Integer(2), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleTwoWithOneDiceTotalResultIsTwo() throws Exception {
		int[] rolledDice = {2, 3, 4, 5, 6};
		
		yahtzee.rollDiceTest(rolledDice);
		yahtzee.chooseCategory("Two");
		assertEquals("{2=1, 3=1, 4=1, 5=1, 6=1}",  yahtzee.toStringRolledDice());
		assertEquals(new Integer(2), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleThreeWithThreeDiceTotalResultIsNine() throws Exception {
		int[] rolledDice = {3, 3, 3, 5, 6};
		
		yahtzee.rollDiceTest(rolledDice);
		yahtzee.chooseCategory("Three");
		assertEquals(new Integer(9), yahtzee.totalScore());
	}
	
	@Test
	public void testChooseThreeRuleCategoryOverTwoRuleCategory() throws Exception {
		int[] rolledDice = {2, 2, 1, 3, 3};
		
		yahtzee.rollDiceTest(rolledDice);
		yahtzee.chooseCategory("Three");
		assertEquals(new Integer(6), yahtzee.totalScore());
	}
	
	@Test
	public void testChooseTwoRuleCategoryOverThreeRuleCategory() throws Exception {
		int[] rolledDice = {2, 2, 1, 3, 3};
		
		yahtzee.rollDiceTest(rolledDice);
		yahtzee.chooseCategory("Two");
		assertEquals(new Integer(4), yahtzee.totalScore());
	}
	
	@Test
	public void testToStringForRolledDice() throws Exception {
		int[] rolledDice = {1, 1, 4, 6, 6};
		
		yahtzee.rollDiceTest(rolledDice);
		assertEquals("{1=2, 4=1, 6=2}",  yahtzee.toStringRolledDice());
	}
}
