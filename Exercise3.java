/*
 * Exercise 3:
	This is a 2 part exercise. If you can do part A or Part B or Both.
	Write a function to find out the best Buying and Selling day for maximum gain from daily stock
	prices of the last 10 days. Following are 2 rules.
	Part A:
	1. Buy first
	2. You can only buy once and sell once
	Part B:
	1. You buy first and then sell
	2. Buy and sell as many times as possible. Goal is to maximize profit.
 * */
import java.util.List;
import java.util.ArrayList;

public class Exercise3 {

	public static void main(String[] args) {
		
		int[] prices = {3, 8, 8, 55, 38, 1, 7, 42, 54, 53};
		
		
		int[] prices1 = {7, 1, 5, 3, 6, 8, 12, 4, 23, 5};
		
		//Expected Maximum Gain 0
		int[] prices2 = {100, 97, 80, 70, 60, 45, 40, 34, 30, 12, 1};
		
		int[][] testcases = {prices, prices1, prices2};
		
		for(int i = 0; i <  testcases.length; i++) {
			System.out.println("For Testcase " + (i+1));
			TradeDays tradeDays = findMaximumGainA(testcases[i]);
			
			System.out.println("Part A : Buying day : " + tradeDays.buyingDay + " Selling day : " + tradeDays.sellingDay);
			
			List<TradeDays> tradDaysList = findMaximumGainB(testcases[i]);
			
			System.out.println("Part B :");
			for(TradeDays tempTradeDays : tradDaysList) {
				System.out.println("Buying day : " + tempTradeDays.buyingDay + " Selling day : " + tempTradeDays.sellingDay);
			}
			
			System.out.println();
		}

	}
	
    /**
     * 
     * @param prices
     * @return TradeDays
     */
	private static TradeDays findMaximumGainA(int[] prices) {
		
		TradeDays tradeDays = new TradeDays();
		
		//Check edge cases if prices array is null or less than 2
		if(prices == null || prices.length < 2) {
			return tradeDays;
		}
		
		int minimumPrice = Integer.MAX_VALUE;
		int maximumGain = 0;
		
		int buyingDay = 0, sellingDay = 0;
		
		for(int day = 0;  day < prices.length; day++) {
			if(prices[day] < minimumPrice) {
				buyingDay = day+1;
				minimumPrice = prices[day];
			}
			if(prices[day] - minimumPrice > maximumGain) {
				sellingDay = day+1;
				maximumGain = prices[day] - minimumPrice;
			}
		}
		tradeDays.buyingDay = buyingDay;
		tradeDays.sellingDay = sellingDay;
		
		return tradeDays;
	}
	
    /**
     * 
     * @param prices
     * @return list of tradeDays
     */
	private static List<TradeDays> findMaximumGainB(int[] prices) {
		
		List<TradeDays> tradeDaysList = new ArrayList<TradeDays>();
		//Check edge cases if prices array is null or less than 2
		if(prices == null || prices.length < 2) {
			return tradeDaysList;
		}
		
		int buyingDay = 0, sellingDay = 0;
		
		int day = 0;
		while(day < prices.length-1) {
            while(day < prices.length-1 && prices[day] >= prices[day+1]) {
                day++;
            }
            buyingDay = day+1;
            while(day < prices.length-1 && prices[day] <= prices[day+1]) {
                day++;
            }
            sellingDay = day+1;
            if(sellingDay > buyingDay) {
            	TradeDays tradeDays = new TradeDays();
				tradeDays.buyingDay = buyingDay;
				tradeDays.sellingDay = sellingDay;
				tradeDaysList.add(tradeDays);
            }
        }

		
		return tradeDaysList;
	}
	
    /**
     * Class to maintaind buing day and selling day
     */
	static class TradeDays{
		int buyingDay = 0;
		int sellingDay = 0; 
	}

}
