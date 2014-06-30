package rules;

import java.util.Iterator;
import java.util.Map;

public class ThreeAndFourOfAKindRule implements GameRule {

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		Integer score = new Integer(0);
		
		for (Iterator<?> nextDie = diceMap.keySet().iterator(); nextDie.hasNext();) {
			Integer die = (Integer) nextDie.next();
			score += die * diceMap.get(die);
		}
		return score;
	}

}
