package rules;

import java.util.Map;

public class OneRule implements GameRule {

	private Integer score;
	
	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) {
		score = new Integer(1) * diceMap.get(1); 
		return score = new Integer(1) * diceMap.get(1);
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
