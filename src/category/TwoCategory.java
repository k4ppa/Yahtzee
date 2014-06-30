package category;

import rules.TwoRule;
import rules.YahtzeeRule;
import yahtzee.Yahtzee;

public class TwoCategory implements Category {

	@Override
	public Integer applyCategory(Yahtzee yahtzee) {
		for (YahtzeeRule rule : yahtzee.getRules()) {
			if (rule instanceof TwoRule)
				return rule.ruleScore(yahtzee.getDiceMap());
		}
		return 0;
	}

}
