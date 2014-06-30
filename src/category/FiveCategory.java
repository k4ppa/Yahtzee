package category;

import java.util.List;
import java.util.Map;

import rules.FiveRule;
import rules.YahtzeeRule;

public class FiveCategory implements Category {

	@Override
	public Integer applyCategory(List<YahtzeeRule> rules, Map<Integer, Integer> diceMap) {
		for (YahtzeeRule rule : rules) {
			if (rule instanceof FiveRule)
				return rule.ruleScore(diceMap);
		}
		return 0;
	}

}
