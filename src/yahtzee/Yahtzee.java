package yahtzee;

import java.util.HashMap;
import java.util.Map;

public class Yahtzee {
	
	private Map<Integer, Integer> diceMap;
	private Integer totalScore;
	
	public Yahtzee() {
		diceMap = new HashMap<Integer, Integer>();
		totalScore = 0;
	}
	
	public void rollDiceTest(int[] rolledDice) {
		for (int dieNumber = 0; dieNumber < rolledDice.length; dieNumber++) {
			Integer value = diceMap.get(rolledDice[dieNumber]);
			if (value != null)
				diceMap.put(rolledDice[dieNumber], ++value);
			else
				diceMap.put(rolledDice[dieNumber], 1);
		}
		
	}

	public Integer totalScore() {
		if (diceMap.containsValue(new Integer(1)))
			return diceMap.get(new Integer(1));
		else if (diceMap.containsValue(new Integer(2))) 
			return diceMap.get(new Integer(2));
			
		return totalScore;
	}

	public String toStringRolledDice() {
		return diceMap.toString();
	}

}
