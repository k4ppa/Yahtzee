package yahtzee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import category.BonusCategory;
import category.Category;
import rules.FiveRule;
import rules.FourRule;
import rules.OneRule;
import rules.SixRule;
import rules.ThreeRule;
import rules.TwoRule;
import rules.YahtzeeRule;
import rules.BonusRule;

public class Yahtzee {
	
	private Map<Integer, Integer> diceMap;
	private List<YahtzeeRule> rules;
	private Integer totalScore;
	private Category category;
	
	public Yahtzee() {
		diceMap = new HashMap<Integer, Integer>();
		rules = new ArrayList<>();
		totalScore = new Integer(0);
		
		addDefaultRules();
	}

	private void addDefaultRules() {
		rules.add(new OneRule());
		rules.add(new TwoRule());
		rules.add(new ThreeRule());
		rules.add(new FourRule());
		rules.add(new FiveRule());
		rules.add(new SixRule());
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
			this.setCategory(new BonusCategory());
			return totalScore += category.applyCategory(this);
		}
		return totalScore;
	}

	public String toStringRolledDice() {
		return diceMap.toString();
	}

	public void chooseCategory(Category choosenCategory) {
		this.setCategory(choosenCategory);
		sumCategoryScore();
	}

	private void sumCategoryScore() {
		totalScore += category.applyCategory(this);
	}
	

	public void addNewRule(YahtzeeRule bonusRule) {
		rules.add(bonusRule);
	}

	public boolean isRulePresent(YahtzeeRule ruleToBeSearched) {
		for (YahtzeeRule rule : rules) {
			if (rule instanceof BonusRule) 
				return true;
		}
		return false;
	}
	
	public void setCategory(Category choosenCategory) {
		category = choosenCategory;
	}
	
	public List<YahtzeeRule> getRules() {
		return rules;
	}
	
	public Map<Integer, Integer> getDiceMap() {
		return diceMap;
	}
}
