package yahtzee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class YahtzeeTest {

	private Yahtzee yahtzee;

	@Before
	public void setUp() {
		yahtzee = new Yahtzee();
	}
	
	@Test
	public void testRuleOneWithOneDie() {
		int[] rolledDice = {1, 2, 4, 6, 5};
		
		yahtzee.rollDiceTest(rolledDice);
		assertEquals(new Integer(1), yahtzee.totalScore());
	}

	@Test
	public void testRuleOneWithTwoDice() throws Exception {
		int[] rolledDice = {1, 1, 4, 6, 5};
		
		yahtzee.rollDiceTest(rolledDice);
		assertEquals(new Integer(2), yahtzee.totalScore());
	}
}
