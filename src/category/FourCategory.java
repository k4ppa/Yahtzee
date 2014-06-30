package category;

import rules.FourRule;
import rules.YahtzeeRule;
import yahtzee.Yahtzee;

public class FourCategory implements Category {

	@Override
	public Integer applyCategory(Yahtzee yahtzee) {
		for (YahtzeeRule rule : yahtzee.getRules()) {
			if (rule instanceof FourRule)
				return rule.ruleScore(yahtzee.getDiceMap());
		}
		return 0;
	}

}
