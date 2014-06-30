package rules;

import java.util.Map;

public class NoRule implements GameRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		return new Integer(0);
	}

}
