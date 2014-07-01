package yahtzee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rules.FiveRule;
import rules.FourRule;
import rules.GameRule;
import rules.BonusRule;
import rules.OneRule;
import rules.SixRule;
import rules.ThreeRule;
import rules.TwoRule;

public class Yahtzee {
	
	private Map<Integer, Integer> diceMap;
	private List<GameRule> usedRules;
	private Integer totalScore;
	
	public Yahtzee() {
		diceMap = new HashMap<Integer, Integer>();
		usedRules = new ArrayList<>();
		totalScore = new Integer(0);
	}
	
	public void rollDice(int[] rolledDice) {
		diceMap.clear();
		for (int dieIndex = 0; dieIndex < rolledDice.length; dieIndex++) 
			chooseNumberOfDiceToInsert(rolledDice[dieIndex]);
	}

	private void chooseNumberOfDiceToInsert(int die) {
		Integer numberOfDie = extractNumberOfDieFromMap(die);
		if (numberOfDie != null)
			insertNumberOfDieInMap(die, ++numberOfDie);
		else
			insertNumberOfDieInMap(die, 1);
	}

	private void insertNumberOfDieInMap(int die, Integer numberOfDie) {
		diceMap.put(die, numberOfDie);
	}

	private Integer extractNumberOfDieFromMap(int die) {
		return diceMap.get(die);
	}

	public Integer totalScore() {
		totalScore += addBonusScore();
		return totalScore;
	}

	private Integer addBonusScore() {
		Integer numRuleScore = new Integer(0);
		for (GameRule rule : usedRules) {
			if (rule instanceof OneRule)
				numRuleScore += ((OneRule) rule).getScore();
			if (rule instanceof TwoRule)
				numRuleScore += ((TwoRule) rule).getScore();
			if (rule instanceof ThreeRule)
				numRuleScore += ((ThreeRule) rule).getScore();
			if (rule instanceof FourRule)
				numRuleScore += ((FourRule) rule).getScore();
			if (rule instanceof FiveRule)
				numRuleScore += ((FiveRule) rule).getScore();
			if (rule instanceof SixRule)
				numRuleScore += ((SixRule) rule).getScore();
		}
		return numRuleScore >= 63? new Integer(35) : new Integer(0);
	}

	public String toStringRolledDice() {
		return diceMap.toString();
	}

	public void chooseRule(GameRule choosenRule) {
		addUsedRule(choosenRule);
		sumUsedRuleScore(choosenRule);
	}

	private void addUsedRule(GameRule newRule) {
		usedRules.add(newRule);
	}
	
	private void sumUsedRuleScore(GameRule rule) {
		totalScore += rule.ruleScore(diceMap);
	}
}
