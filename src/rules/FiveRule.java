package rules;

import java.util.Map;

public class FiveRule implements GameRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		return new Integer(5) * diceMap.get(5);
	}

}
