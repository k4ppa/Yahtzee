package rules;

import java.util.Map;

public class FiveRule implements GameRule {

	private Integer score;
	
	@Override
	public Integer ruleScore(Map<Integer, Integer> diceMap) { 
//		score = new Integer(5) * diceMap.get(5); 
		return score = new Integer(5) * diceMap.get(5);
	}
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
