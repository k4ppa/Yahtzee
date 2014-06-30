package category;

import java.util.List;
import java.util.Map;

import rules.SixRule;
import rules.YahtzeeRule;

public class SixCategory implements Category {

	@Override
	public Integer applyCategory(List<YahtzeeRule> rules, Map<Integer, Integer> diceMap) {
		for (YahtzeeRule rule : rules) {
			if (rule instanceof SixRule)
				return rule.ruleScore(diceMap);
		}
		return 0;
	}

}
