package rules;

import java.util.Map;

public class FullHouse implements GameRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		if (isFullHouse(diceMap)) 
			return new Integer(25);
		
		return new Integer(0);
	}

	private boolean isFullHouse(Map<Integer, Integer> diceMap) {
		return diceMap.containsValue(3) && diceMap.containsValue(2);
	}

}
