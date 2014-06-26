package yahtzee;

import java.util.HashMap;
import java.util.Map;

public class Yahtzee {
	
	private Map<Integer, Integer> diceMap;
	private Integer totalScore;
	
	public Yahtzee() {
		diceMap = new HashMap<Integer, Integer>();
		totalScore = new Integer(0);
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
		if (diceMap.containsKey(new Integer(1)))
			return new Integer(1) * diceMap.get(1);
		if (diceMap.containsKey(new Integer(2))) 
			return new Integer(2) * diceMap.get(2);
		if (diceMap.containsKey(new Integer(3))) 
			return new Integer(3) * diceMap.get(3);
			
		return totalScore;
	}

	public String toStringRolledDice() {
		return diceMap.toString();
	}

}
