package rules;

import java.util.Map;

public class YahtzeeRule implements GameRule {

	private static int numberOfYahtzee = 0;
	
	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		if (numberOfYahtzee >= 1)
			return new Integer(100);
		
		numberOfYahtzee++;
		return new Integer(50);
	}

}
