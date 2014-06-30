package rules;

import java.util.Map;

public class TwoRule implements YahtzeeRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		return new Integer(2) * diceMap.get(2);
	}

}
