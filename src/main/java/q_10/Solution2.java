package q_10;

/**
 * @author lqb
 * @date 2021/10/22 9:25
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 *
 * 提示：
 *
 *     0 <= n <= 100
 * step(2) = step(1) + step(0) = 2
 * step(3) = step(2) + step(1) = 2 + 1 = 3
 * step(4) = step(3) + step(2) = 3 + 2 = 5
 * 递推公式为
 * step(n) = step(n-1) +step(n-2)
 */
public class Solution2 {
    public int numWays(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        int step1 = 1;
        int step0 = 1;
        int sum = 0;
        for (int i = 2; i <= n ; i++) {
            sum = (step0 + step1)%1000000007;
            int temp = step1;
            step1 = sum;
            step0 = temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.numWays(7));
    }
}
