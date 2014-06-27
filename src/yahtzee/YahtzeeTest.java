package yahtzee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import category.Category;
import category.FiveCategory;
import category.FourCategory;
import category.OneCategory;
import category.SixCategory;
import category.ThreeCategory;
import category.TwoCategory;

public class YahtzeeTest {

	private Yahtzee yahtzee;

	@Before
	public void setUp() {
		yahtzee = new Yahtzee();
	}
	
	private void playRound(int[] rolledDice, Category choosenCategory) {
		yahtzee.rollDice(rolledDice);
		yahtzee.chooseCategory(choosenCategory);
	}
	
	@Test
	public void testRuleOneWithOneDieTotalResultIsOne() {
		int[] rolledDice = {1, 2, 4, 5, 6};
		
		playRound(rolledDice, new OneCategory());
		assertEquals(new Integer(1), yahtzee.totalScore());
	}

	@Test
	public void testRuleOneWithTwoDiceTotalResultIsTwo() throws Exception {
		int[] rolledDice = {1, 1, 4, 5, 6};
		
		playRound(rolledDice, new OneCategory());
		assertEquals(new Integer(2), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleTwoWithOneDiceTotalResultIsTwo() throws Exception {
		int[] rolledDice = {2, 3, 4, 5, 6};
		
		playRound(rolledDice, new TwoCategory());
		assertEquals("{2=1, 3=1, 4=1, 5=1, 6=1}",  yahtzee.toStringRolledDice());
		assertEquals(new Integer(2), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleThreeWithThreeDiceTotalResultIsNine() throws Exception {
		int[] rolledDice = {3, 3, 3, 5, 6};
		
		playRound(rolledDice, new ThreeCategory());
		assertEquals(new Integer(9), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleFourWithTwoDiceTotalResultEight() throws Exception {
		int[] rolledDice = {4, 4, 3, 5, 6};
		
		playRound(rolledDice, new FourCategory());
		assertEquals(new Integer(8), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleFiveWithThreeDiceTotalResultFifteen() throws Exception {
		int[] rolledDice = {5, 5, 5, 1, 2};
		
		playRound(rolledDice, new FiveCategory());
		assertEquals(new Integer(15), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleSixWithFiveDiceTotalResultThirty() throws Exception {
		int[] rolledDice = {6, 6, 6, 6, 6};
		
		playRound(rolledDice, new SixCategory());
		assertEquals(new Integer(30), yahtzee.totalScore());
	}
	
	@Test
	public void testChooseThreeRuleCategoryOverTwoRuleCategory() throws Exception {
		int[] rolledDice = {2, 2, 1, 3, 3};
		
		playRound(rolledDice, new ThreeCategory());
		assertEquals(new Integer(6), yahtzee.totalScore());
	}
	
	@Test
	public void testChooseTwoRuleCategoryOverThreeRuleCategory() throws Exception {
		int[] rolledDice = {2, 2, 1, 3, 3};
		
		playRound(rolledDice, new TwoCategory());
		assertEquals(new Integer(4), yahtzee.totalScore());
	}
	
	@Test
	public void testToStringForRolledDice() throws Exception {
		int[] rolledDice = {1, 1, 4, 6, 6};
		
		yahtzee.rollDice(rolledDice);
		assertEquals("{1=2, 4=1, 6=2}",  yahtzee.toStringRolledDice());
	}
	
	@Test
	public void testRollTwoTimes() throws Exception {
		int[] rolledDice1 = {2, 2, 1, 3, 3};
		int[] rolledDice2 = {2, 2, 1, 1, 3};
		
		playRound(rolledDice1, new ThreeCategory());
		playRound(rolledDice2, new TwoCategory());
		
		assertEquals(new Integer(10), yahtzee.totalScore());
	}
}
