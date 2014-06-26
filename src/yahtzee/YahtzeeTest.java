package yahtzee;

import static org.junit.Assert.*;

import org.junit.Test;

public class YahtzeeTest {

	@Test
	public void testRuleOneWithOneDie() {
		Yahtzee yahtzee = new Yahtzee();
		int[] rolledDice = {1, 2, 4, 6, 5};
		
		yahtzee.rollDiceTest(rolledDice);
		assertEquals(new Integer(1), yahtzee.totalScore());
	}

	@Test
	public void testRuleOneWithTwoDice() throws Exception {
		Yahtzee yahtzee = new Yahtzee();
		int[] rolledDice = {1, 1, 4, 6, 5};
		
		yahtzee.rollDiceTest(rolledDice);
		assertEquals(new Integer(2), yahtzee.totalScore());
	}
}
