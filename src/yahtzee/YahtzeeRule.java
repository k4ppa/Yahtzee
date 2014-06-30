package yahtzee;

import java.util.Map;

import rules.GameRule;

public class YahtzeeRule implements GameRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		if (diceMap.containsValue(5)) 
			return new Integer(50);
		
		return new Integer(0);
	}

}
