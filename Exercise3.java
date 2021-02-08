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
			
			System.out.println("Part A : ");
            if(tradeDays.buyingDay == 0 && tradeDays.sellingDay == 0){
                System.out.println("Maximum gain can not be obtained");
            }
            else{
                System.out.println("Buying Day = " + tradeDays.buyingDay + " and Selling Day = " + tradeDays.sellingDay);
            }
            
			List<TradeDays> tradDaysList = findMaximumGainB(testcases[i]);
			
			System.out.println("Part B :");
            if(tradDaysList.size() == 0){
                System.out.println("Maximum gain can not be obtained");
            }
            else{
                for(TradeDays tempTradeDays : tradDaysList) {
                    System.out.println("Buying Day = " + tempTradeDays.buyingDay + " and Selling Day = " + tempTradeDays.sellingDay);
                }
            }
			
			System.out.println();
		}

	}
	
    /**
     * Returns TradeDays object with buying and selling day to obtain maximum gain
     * from daily stock prices of last 10 days.
     * This method considers only single transaction i.e. stock can only be bought
     * once and sold once.
     * 
     * @param prices An array of daily stock prices of last 10 days 
     * @return       TradeDays object with buying and selling dat
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
        if(buyingDay > 0 && sellingDay > 0){
            tradeDays.buyingDay = buyingDay;
            tradeDays.sellingDay = sellingDay;
        }
		
		return tradeDays;
	}
	
    /**
     * Returns a list of TradeDays objects to obtain maximum gain
     * from daily stock prices of last 10 days.
     * This method considers multiple transactions i.e. stocks can be bought and sold
     * multiple time. But, stock can be bought only after previous stock is sold.
     * 
     * @param prices An array of daily stock prices of last 10 days
     * @return       List of TradeDays objects
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
     * Class to maintaine buying day and selling day
     */
	static class TradeDays{
		int buyingDay = 0;
		int sellingDay = 0; 
	}

}
