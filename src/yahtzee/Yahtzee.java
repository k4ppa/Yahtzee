package yahtzee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import category.Category;
import category.OneCategory;
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
		
		addDefaultRules();
	}

	private void addDefaultRules() {
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
		return category.applyCategory(rules, diceMap);
	}

	public String toStringRolledDice() {
		return diceMap.toString();
	}

	public void chooseCategory(String choosenCategory) {
		if (choosenCategory.equals("One")) 
			this.setCategory(new OneCategory());
		if (choosenCategory.equals("Two")) 
			this.setCategory(new TwoCategory());
		if (choosenCategory.equals("Three")) 
			this.setCategory(new ThreeCategory());
		
	}
	
	public void setCategory(Category choosenCategory) {
		category = choosenCategory;
	}

}
