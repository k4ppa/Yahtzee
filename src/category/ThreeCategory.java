package category;

import rules.ThreeRule;
import rules.YahtzeeRule;
import yahtzee.Yahtzee;

public class ThreeCategory implements Category {

	@Override
	public Integer applyCategory(Yahtzee yahtzee) {
		for (YahtzeeRule rule : yahtzee.getRules()) {
			if (rule instanceof ThreeRule)
				return rule.ruleScore(yahtzee.getDiceMap());
		}
		return 0;
	}

}
