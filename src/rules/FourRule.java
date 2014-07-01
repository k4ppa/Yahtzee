package rules;

import java.util.Map;

public class FourRule implements GameRule {

	private Integer score;
	
	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
//		score = new Integer(4) * diceMap.get(4);
		return score = new Integer(4) * diceMap.get(4);
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
