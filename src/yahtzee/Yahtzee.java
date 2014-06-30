package yahtzee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rules.YahtzeeRule;
import rules.BonusRule;

public class Yahtzee {
	
	private Map<Integer, Integer> diceMap;
	private List<YahtzeeRule> usedRules;
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
		if (totalScore >= 63) {
			YahtzeeRule rule = new BonusRule();
			this.addUsedRule(rule);
			totalScore += rule.ruleScore(diceMap);
		}
		return totalScore;
	}

	public String toStringRolledDice() {
		return diceMap.toString();
	}

	public void chooseRule(YahtzeeRule choosenRule) {
		this.addUsedRule(choosenRule);
		sumRuleScore(choosenRule);
	}

	private void sumRuleScore(YahtzeeRule rule) {
		totalScore += rule.ruleScore(diceMap);
	}
	

	public void addUsedRule(YahtzeeRule newRule) {
		usedRules.add(newRule);
	}

	public boolean isRulePresent(YahtzeeRule ruleToBeSearched) {
		for (YahtzeeRule rule : usedRules) {
			if (rule instanceof BonusRule) 
				return true;
		}
		return false;
	}
	
	public List<YahtzeeRule> getRules() {
		return usedRules;
	}
	
	public Map<Integer, Integer> getDiceMap() {
		return diceMap;
	}
}
