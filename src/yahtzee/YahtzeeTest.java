package yahtzee;

import static org.junit.Assert.*;

import org.junit.Test;

public class YahtzeeTest {

	@Test
	public void testRuleOneWithOneDie() {
		Yahtzee yahtzee = new Yahtzee();
		int[] rolledDice = {1, 2, 4, 6, 5};
		
		yahtzee.rollDiceTest(rolledDice);
		assertEquals(1, yahtzee.totalScore());
	}

}
