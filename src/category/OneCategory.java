package category;

import java.util.List;
import java.util.Map;

import rules.OneRule;
import rules.YahtzeeRule;

public class OneCategory implements Category {
	public Integer applyCategory(List<YahtzeeRule> rules, Map<Integer, Integer> diceMap) {
		for (YahtzeeRule rule : rules) {
			if (rule instanceof OneRule)
				return rule.ruleScore(diceMap);
		}
		return 0;
	}
}
