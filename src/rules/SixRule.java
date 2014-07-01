package rules;

import java.util.Map;

public class SixRule implements GameRule {

	private Integer score;
	
	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
//		score = new Integer(6) * diceMap.get(6);
		return score = new Integer(6) * diceMap.get(6);
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
