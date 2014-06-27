package yahtzee;

import java.util.List;
import java.util.Map;

import rules.YahtzeeRule;
import category.Category;

public class TwoCategory implements Category {

	@Override
	public Integer applyCategory(List<YahtzeeRule> rules, Map<Integer, Integer> diceMap) {
		return rules.get(1).ruleScore(diceMap);
	}

}
