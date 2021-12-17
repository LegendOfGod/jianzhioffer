package q_360;

import java.util.Arrays;

/**
 * @author lqb
 * @date 2021/12/16 19:38
 * 给你一个已经 排好序 的整数数组 nums 和整数 a、b、c。对于数组中的每一个数 x，计算函数值 f(x) = ax2 + bx + c，请将函数值产生的数组返回。
 * <p>
 * 要注意，返回的这个数组必须按照 升序排列，并且我们所期望的解法时间复杂度为 O(n)。
 * <p>
 * 示例 1：
 * <p>
 * 输入: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
 * 输出: [3,9,15,33]
 * 示例 2：
 * <p>
 * 输入: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
 * 输出: [-23,-5,1,7]
 * <p>
 * a大于0函数开口朝上 否则朝下
 * -b/2a 是顶点坐标
 * 总的来说 里订单越近的函数值越大 或者越小  这取决于开口方向
 */
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int head = 0;
        int tail = nums.length - 1;
        if (a == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (b > 0) {
                    res[head++] = b * nums[i] + c;
                } else {
                    res[tail--] = b * nums[i] + c;
                }
            }
        }else {
            double mid = -b / (2.0 * a);
            int i = 0;
            int j = nums.length-1;
            while(i <= j){
                //离中心越远的函数值越大或者越小
                if (Math.abs(nums[i] - mid) >= Math.abs(nums[j]  - mid)){
                    if (a > 0){
                        res[tail--] = a*nums[i]*nums[i] + b*nums[i] + c;
                        i++;
                    }else {
                        res[head++] = a*nums[i]*nums[i] + b*nums[i] + c;
                        i++;
                    }
                }else {
                    if (a > 0){
                        res[tail--] = a*nums[j]*nums[j] + b*nums[j] + c;
                        j--;
                    }else {
                        res[head++] = a*nums[j]*nums[j] + b*nums[j] + c;
                        j--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortTransformedArray(new int[]{-4, -2, 2, 4}, 1, 3, 5)));
    }
}
