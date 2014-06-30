package rules;

import java.util.Map;

public class ThreeRule implements GameRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		return new Integer(3) * diceMap.get(3);
	}

}
