package category;

import rules.SixRule;
import rules.YahtzeeRule;
import yahtzee.Yahtzee;

public class SixCategory implements Category {

	@Override
	public Integer applyCategory(Yahtzee yahtzee) {
		for (YahtzeeRule rule : yahtzee.getRules()) {
			if (rule instanceof SixRule)
				return rule.ruleScore(yahtzee.getDiceMap());
		}
		return 0;
	}

}
