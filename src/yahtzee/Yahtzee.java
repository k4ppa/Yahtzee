package yahtzee;

import java.util.HashMap;
import java.util.Map;

public class Yahtzee {
	
	private Map<Integer, Integer> diceMap;
	private Integer totalScore;
	private Category category;
	
	public Yahtzee() {
		diceMap = new HashMap<Integer, Integer>();
		totalScore = new Integer(0);
		category = new Category();
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
			return ruleScore(1);
		if (isRuleTwoSelected()) 
			return ruleScore(2);
		if (isRuleThreeSelected()) 
			return ruleScore(3);
			
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
