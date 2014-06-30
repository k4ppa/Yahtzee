package category;

import rules.OneRule;
import rules.YahtzeeRule;
import yahtzee.Yahtzee;

public class OneCategory implements Category {
	
	@Override
	public Integer applyCategory(Yahtzee yahtzee) {
		for (YahtzeeRule rule : yahtzee.getRules()) {
			if (rule instanceof OneRule)
				return rule.ruleScore(yahtzee.getDiceMap());
		}
		return 0;
	}
}
