package rules;

import java.util.Map;

public class ThreeRule implements GameRule {

	private Integer score;
	
	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
//		score = new Integer(3) * diceMap.get(3);
		return score = new Integer(3) * diceMap.get(3);
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
