
/*
 * Exercise 1:
Write a function to calculate change for a given number (number represents cents)
The function will return list, vector or collection of numbers representing the number of
quarters(25), dimes(10), nickels (5), pennies (1) that would yield the correct change.
# Example:
# For 83¢, the function will return 3 quarters, 0 dimes, 1 nickel, and 3 pennies.
 * */

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
     * 
     * @param amount : Amount
     * @return Map<String, Integer>: Map with key as change(coin) name and value as number of those coins  
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
