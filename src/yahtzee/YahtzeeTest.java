package yahtzee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import rules.BonusRule;
import rules.FiveRule;
import rules.FourRule;
import rules.LargeStraightRule;
import rules.OneRule;
import rules.SixRule;
import rules.SmallStraightRule;
import rules.ThreeAndFourOfAKindRule;
import rules.ThreeRule;
import rules.TwoRule;
import rules.YahtzeeRule;

public class YahtzeeTest {

	private Yahtzee yahtzee;

	@Before
	public void setUp() {
		yahtzee = new Yahtzee();
	}
	
	private void playRound(int[] rolledDice, YahtzeeRule choosenRule) {
		yahtzee.rollDice(rolledDice);
		yahtzee.chooseRule(choosenRule);
	}
	
	@Test
	public void testRuleOneWithOneDieTotalResultIsOne() {
		int[] rolledDice = {1, 2, 4, 5, 6};
		
		playRound(rolledDice, new OneRule());
		assertEquals(new Integer(1), yahtzee.totalScore());
	}

	@Test
	public void testRuleOneWithTwoDiceTotalResultIsTwo() throws Exception {
		int[] rolledDice = {1, 1, 4, 5, 6};
		
		playRound(rolledDice, new OneRule());
		assertEquals(new Integer(2), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleTwoWithOneDiceTotalResultIsTwo() throws Exception {
		int[] rolledDice = {2, 3, 4, 5, 6};
		
		playRound(rolledDice, new TwoRule());
		assertEquals("{2=1, 3=1, 4=1, 5=1, 6=1}",  yahtzee.toStringRolledDice());
		assertEquals(new Integer(2), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleThreeWithThreeDiceTotalResultIsNine() throws Exception {
		int[] rolledDice = {3, 3, 3, 5, 6};
		
		playRound(rolledDice, new ThreeRule());
		assertEquals(new Integer(9), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleFourWithTwoDiceTotalResultEight() throws Exception {
		int[] rolledDice = {4, 4, 3, 5, 6};
		
		playRound(rolledDice, new FourRule());
		assertEquals(new Integer(8), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleFiveWithThreeDiceTotalResultFifteen() throws Exception {
		int[] rolledDice = {5, 5, 5, 1, 2};
		
		playRound(rolledDice, new FiveRule());
		assertEquals(new Integer(15), yahtzee.totalScore());
	}
	
	@Test
	public void testRuleSixWithFiveDiceTotalResultThirty() throws Exception {
		int[] rolledDice = {6, 6, 6, 6, 6};
		
		playRound(rolledDice, new SixRule());
		assertEquals(new Integer(30), yahtzee.totalScore());
	}
	
	@Test
	public void testChooseThreeRuleCategoryOverTwoRuleCategory() throws Exception {
		int[] rolledDice = {2, 2, 1, 3, 3};
		
		playRound(rolledDice, new ThreeRule());
		assertEquals(new Integer(6), yahtzee.totalScore());
	}
	
	@Test
	public void testChooseTwoRuleCategoryOverThreeRuleCategory() throws Exception {
		int[] rolledDice = {2, 2, 1, 3, 3};
		
		playRound(rolledDice, new TwoRule());
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
		
		playRound(rolledDice1, new ThreeRule());
		playRound(rolledDice2, new TwoRule());
		
		assertEquals(new Integer(10), yahtzee.totalScore());
	}
	@Ignore
	@Test
	public void testAddNewRule() throws Exception {
		yahtzee.addUsedRule(new BonusRule());
		
		assertEquals(true, yahtzee.isRulePresent(new BonusRule()));
	}
	
	@Test
	public void testBonusRule() throws Exception {
		int[] rolledDice1 = {1, 1, 1, 2, 2};
		int[] rolledDice2 = {2, 2, 2, 1, 1};
		int[] rolledDice3 = {3, 3, 3, 1, 4};
		int[] rolledDice4 = {4, 4, 4, 6, 1};
		int[] rolledDice5 = {5, 5, 5, 2, 3};
		int[] rolledDice6 = {6, 6, 6, 3, 5};
		
		playRound(rolledDice1, new OneRule());
		playRound(rolledDice2, new TwoRule());
		playRound(rolledDice3, new ThreeRule());
		playRound(rolledDice4, new FourRule());
		playRound(rolledDice5, new FiveRule());
		playRound(rolledDice6, new SixRule());
		
		assertEquals(new Integer(98), yahtzee.totalScore());
	}
	
	@Test
	public void testThreeOfAKindRule() throws Exception {
		int[] rolledDice = {2, 2, 2, 3, 4};
		
		playRound(rolledDice, new ThreeAndFourOfAKindRule());
		assertEquals(new Integer(13), yahtzee.totalScore());
	}
	
	@Test
	public void testFourOfAKindRule() throws Exception {
		int[] rolledDice = {2, 2, 2, 2, 4};
		
		playRound(rolledDice, new ThreeAndFourOfAKindRule());
		assertEquals(new Integer(12), yahtzee.totalScore());
	}
	
	@Test
	public void testSmallStraight() throws Exception {
		int[] rolledDice = {2, 3, 2, 1, 4};
		
		playRound(rolledDice, new SmallStraightRule());
		assertEquals(new Integer(30), yahtzee.totalScore());
	}
	
	@Test
	public void testSLargeStraight() throws Exception {
		int[] rolledDice = {2, 3, 5, 1, 4};
		
		playRound(rolledDice, new LargeStraightRule());
		assertEquals(new Integer(40), yahtzee.totalScore());
	}
}

