package rules;

import java.util.Map;

public class OneRule implements GameRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		return new Integer(1) * diceMap.get(1);
	}

}
