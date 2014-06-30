package rules;

import java.util.Map;

public class SixRule implements YahtzeeRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		return new Integer(6) * diceMap.get(6);
	}

}
