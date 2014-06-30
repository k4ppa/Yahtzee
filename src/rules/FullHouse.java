package rules;

import java.util.Map;

public class FullHouse implements YahtzeeRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		if (diceMap.containsValue(3) && diceMap.containsValue(2)) 
			return new Integer(25);
		
		return new Integer(0);
	}

}
