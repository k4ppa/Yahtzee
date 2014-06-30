package rules;

import java.util.Map;

public class BonusRule implements GameRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		return new Integer(35);
	}

}
