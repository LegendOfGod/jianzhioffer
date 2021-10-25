package q_63;

/**
 * @author lqb
 * @date 2021/10/22 10:13
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 最后一天买入的利润
 * profile(1) = priceMax(2,n) - price(1)
 * profile(2) = priceMax(3,n) - price(2)
 * priceMax(2,n) = Max(price(2),price(3,n)) - price(1)
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 10^5
 *
 */
public class Solution {
    int[] maxPrice = new int[100010];
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfile = 0;
        maxPrice[prices.length - 1] = prices[prices.length-1];
        for (int i = 0; i < prices.length - 1; i++) {
            int rightMaxPrice = rightMaxPrice(i+1,prices);
            int profile = rightMaxPrice - prices[i];
            if (profile > maxProfile){
                maxProfile = profile;
            }
        }
        return maxProfile;
    }

    private int rightMaxPrice(int i,int[] prices) {
        if (maxPrice[i] != 0 || i == prices.length - 1){
            return maxPrice[i];
        }else {
            int max = Math.max(prices[i], rightMaxPrice(i + 1, prices));
            maxPrice[i] = max;
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1,1,0};
        System.out.println(solution.maxProfit(input));
    }
}
