package rules;

import java.util.Map;

public class SmallStraightRule implements GameRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		
		if (firstStraightFormed(diceMap) || secondStraightFormed(diceMap) || thirdStraightFormed(diceMap)) 
			return new Integer(30);
		
		return new Integer(0);
	}

	private boolean thirdStraightFormed(Map<Integer, Integer> diceMap) {
		return diceMap.containsKey(3) && diceMap.containsKey(4) && diceMap.containsKey(5) && diceMap.containsKey(6);
	}

	private boolean secondStraightFormed(Map<Integer, Integer> diceMap) {
		return diceMap.containsKey(2) && diceMap.containsKey(3) && diceMap.containsKey(4) && diceMap.containsKey(5);
	}

	private boolean firstStraightFormed(Map<Integer, Integer> diceMap) {
		return diceMap.containsKey(1) && diceMap.containsKey(2) && diceMap.containsKey(3) && diceMap.containsKey(4);
	}

}
