package q_57;

import java.util.Arrays;

/**
 * @author lqb
 * @date 2021/10/26 10:28
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 *
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 *
 *
 * 限制：
 *
 *     1 <= nums.length <= 10^5
 *     1 <= nums[i] <= 10^6
 *
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        int[] res = new int[2];
        while (head < tail){
            if ((nums[head] + nums[tail]) > target){
                tail--;
            }
            if ((nums[head] + nums[tail]) < target){
                head++;
            }
            if ((nums[head] + nums[tail]) == target){
                res[0] = nums[head];
                res[1] = nums[tail];
                return  res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, 9)));
    }
}
