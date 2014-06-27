package yahtzee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rules.OneRule;
import rules.ThreeRule;
import rules.TwoRule;
import rules.YahtzeeRule;

public class Yahtzee {
	
	private Map<Integer, Integer> diceMap;
	private List<YahtzeeRule> rules;
	private Integer totalScore;
	private Category category;
	
	public Yahtzee() {
		diceMap = new HashMap<Integer, Integer>();
		rules = new ArrayList<>();
		totalScore = new Integer(0);
		category = new Category();
		
		rules.add(new OneRule());
		rules.add(new TwoRule());
		rules.add(new ThreeRule());
	}
	
	public void rollDiceTest(int[] rolledDice) {
		for (int dieNumber = 0; dieNumber < rolledDice.length; dieNumber++) {
			Integer value = diceMap.get(rolledDice[dieNumber]);
			if (value != null)
				diceMap.put(rolledDice[dieNumber], ++value);
			else
				diceMap.put(rolledDice[dieNumber], 1);
		}
		
	}

	public Integer totalScore() {
		if (isRuleOneSelected())
			return rules.get(0).ruleScore(diceMap);
		if (isRuleTwoSelected()) 
			return rules.get(1).ruleScore(diceMap);
		if (isRuleThreeSelected()) 
			return rules.get(2).ruleScore(diceMap);
			
		return totalScore;
	}

	private int ruleScore(int ruleNumber) {
		return new Integer(ruleNumber) * diceMap.get(ruleNumber);
	}

	private boolean isRuleOneSelected() {
		return category.getCategory().equals("One") && diceMap.containsKey(new Integer(1));
	}

	private boolean isRuleTwoSelected() {
		return category.getCategory().equals("Two") && diceMap.containsKey(new Integer(2));
	}

	private boolean isRuleThreeSelected() {
		return category.getCategory().equals("Three") && diceMap.containsKey(new Integer(3));
	}

	public String toStringRolledDice() {
		return diceMap.toString();
	}

	public void chooseCategory(String choosenCategory) {
		category.setCategory(choosenCategory);
	}

}
