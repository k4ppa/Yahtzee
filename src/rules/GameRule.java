package rules;

import java.util.Map;

public interface GameRule {

	public Integer ruleScore(Map<Integer, Integer> diceMap);
}
