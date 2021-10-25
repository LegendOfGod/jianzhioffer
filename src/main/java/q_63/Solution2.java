package q_63;

/**
 * @author lqb
 * @date 2021/10/22 11:33
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i <prices.length ; i++) {
            int tempProfit = prices[i] - minPrice;
            if (tempProfit > maxProfit){
                maxProfit = tempProfit;
            }
            if (minPrice > prices[i]){
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

}
