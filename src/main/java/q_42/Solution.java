package q_42;

/**
 * @author lqb
 * @date 2021/10/22 13:49
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 *
 * 提示：
 *
 *     1 <= arr.length <= 10^5
 *     -100 <= arr[i] <= 100
 *
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre+nums[i],nums[i]);
            maxSum = Math.max(maxSum,pre);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(input));
    }
}
