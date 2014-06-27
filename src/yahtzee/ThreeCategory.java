package yahtzee;

import java.util.List;
import java.util.Map;

import rules.YahtzeeRule;
import category.Category;

public class ThreeCategory implements Category {

	@Override
	public Integer applyCategory(List<YahtzeeRule> rules, Map<Integer, Integer> diceMap) {
		return rules.get(2).ruleScore(diceMap);
	}

}
