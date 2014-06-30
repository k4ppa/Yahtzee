package category;

import java.util.List;
import java.util.Map;

import rules.FourRule;
import rules.YahtzeeRule;

public class FourCategory implements Category {

	@Override
	public Integer applyCategory(List<YahtzeeRule> rules, Map<Integer, Integer> diceMap) {
		for (YahtzeeRule rule : rules) {
			if (rule instanceof FourRule)
				return rule.ruleScore(diceMap);
		}
		return 0;
	}

}
