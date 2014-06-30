package category;

import java.util.List;
import java.util.Map;

import rules.TwoRule;
import rules.YahtzeeRule;

public class TwoCategory implements Category {

	@Override
	public Integer applyCategory(List<YahtzeeRule> rules, Map<Integer, Integer> diceMap) {
		for (YahtzeeRule rule : rules) {
			if (rule instanceof TwoRule)
				return rule.ruleScore(diceMap);
		}
		return 0;
	}

}
