package category;

import rules.FiveRule;
import rules.YahtzeeRule;
import yahtzee.Yahtzee;

public class FiveCategory implements Category {

	@Override
	public Integer applyCategory(Yahtzee yahtzee) {
		for (YahtzeeRule rule : yahtzee.getRules()) {
			if (rule instanceof FiveRule)
				return rule.ruleScore(yahtzee.getDiceMap());
		}
		return 0;
	}

}
