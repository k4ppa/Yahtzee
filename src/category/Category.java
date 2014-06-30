package category;

import java.util.List;
import java.util.Map;

import rules.YahtzeeRule;

public interface Category {
	public Integer applyCategory(List<YahtzeeRule> rules, Map<Integer, Integer> diceMap);
}
