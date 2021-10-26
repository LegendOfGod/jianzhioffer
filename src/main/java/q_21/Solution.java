package q_21;

import java.util.Arrays;

/**
 * @author lqb
 * @date 2021/10/26 9:59
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 *
 *
 * 提示：
 *
 *     0 <= nums.length <= 50000
 *     0 <= nums[i] <= 10000
 *
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail){
            //左偶右奇直接交换
            if (nums[head]%2 == 0 && nums[tail]%2 == 1){
                int temp = nums[tail];
                nums[tail] = nums[head];
                nums[head] = temp;
                head++;
                tail--;
            }
            //左奇右偶
            if (nums[head]%2 == 1 && nums[tail]%2 == 0){
                head++;
                tail--;
            }
            //左偶右偶
            if (nums[head]%2 == 0 && nums[tail]%2 == 0){
                tail--;
            }
            //左奇右奇
            if (nums[head]%2 == 1 && nums[tail]%2 == 1){
                head++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.exchange(a)));
    }
}
