package rules;

import java.util.Map;

public interface YahtzeeRule {

	public Integer ruleScore(Map<Integer, Integer> diceMap);
}
