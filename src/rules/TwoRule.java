package rules;

import java.util.Map;

public class TwoRule implements GameRule {
	
	private Integer score;

	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
//		score = new Integer(2) * diceMap.get(2);
		return score = new Integer(2) * diceMap.get(2);
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
