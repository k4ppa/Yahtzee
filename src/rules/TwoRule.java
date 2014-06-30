package rules;

import java.util.Map;

public class TwoRule implements GameRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		return new Integer(2) * diceMap.get(2);
	}

}
