package yahtzee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import category.Category;
import category.OneCategory;
import category.ThreeCategory;
import category.TwoCategory;
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
		return totalScore;
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
		if (choosenCategory.equals("Four")) 
			this.setCategory(new FourCategory());
		if (choosenCategory.equals("Five")) 
			this.setCategory(new FiveCategory());
		if (choosenCategory.equals("Six")) 
			this.setCategory(new SixCategory());
		
		sumCategoryScore();
	}

	private void sumCategoryScore() {
		totalScore += category.applyCategory(rules, diceMap);
	}
	
	public void setCategory(Category choosenCategory) {
		category = choosenCategory;
	}
}
