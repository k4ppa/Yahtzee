package rules;

import java.util.Map;

public class bonusRule implements YahtzeeRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		return new Integer(35);
	}

}
