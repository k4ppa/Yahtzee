package rules;

import java.util.Map;

public class FourRule implements YahtzeeRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		return new Integer(4) * diceMap.get(4);
	}

}
