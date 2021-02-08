
import java.util.Map;
import java.util.HashMap;

public class Exercise1 {

	public static void main(String[] args) {
		
		Map<String, Integer> changeCoinsMap = calculateChange(83);
		
		String[] denominationNames = {"quarters", "dimes", "nickels", "pennies"};
		
		System.out.println("Number of coins");
		for(String denominationName : denominationNames) {
			System.out.println(changeCoinsMap.get(denominationName) + "  " + denominationName);
		}

	}
	
    /**
     * Returns a map with number of coins per each change.
     * This method returns a map with 0 coins per change if amount is less than or equal to 0
     * 
     * @param amount Amount whose change is to be calculated
     * @return       Map with key as change(coin) name and value as number of those coins  
     */
	private static Map<String, Integer> calculateChange(int amount) {
		
		Map<String, Integer> changeCoinsMap = new HashMap();
		changeCoinsMap.put("quarters", 0);
		changeCoinsMap.put("dimes", 0);
		changeCoinsMap.put("nickels", 0);
		changeCoinsMap.put("pennies", 0);
		
		int[] denominationAmount = {25, 10, 5, 1};
		String[] denominationNames = {"quarters", "dimes", "nickels", "pennies"};
		
		if(amount > 0) {
			for(int i = 0; i < denominationAmount.length; i++) {
				if(amount > denominationAmount[i]) {
					int numberofCoins = amount / denominationAmount[i];
					changeCoinsMap.put(denominationNames[i], numberofCoins);
					
					amount %= denominationAmount[i];
				}
			}
		}
		
		return changeCoinsMap;
	}

}
