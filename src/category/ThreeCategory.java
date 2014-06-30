package category;

import java.util.List;
import java.util.Map;

import rules.ThreeRule;
import rules.YahtzeeRule;

public class ThreeCategory implements Category {

	@Override
	public Integer applyCategory(List<YahtzeeRule> rules, Map<Integer, Integer> diceMap) {
		for (YahtzeeRule rule : rules) {
			if (rule instanceof ThreeRule)
				return rule.ruleScore(diceMap);
		}
		return 0;
	}

}
