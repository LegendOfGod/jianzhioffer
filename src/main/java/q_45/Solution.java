package q_45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lqb
 * @date 2021/10/28 9:17
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 *
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 *
 *
 * 提示:
 *
 *     0 < nums.length <= 100
 *
 * 说明:
 *
 *     输出结果可能非常大，所以你需要返回一个字符串而不是整数
 *     拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 */
public class Solution {
    public String minNumber(int[] nums) {
        //贪心 局部最优到全局最优
        //如果 x + y < y + x 那么x 在 y前面
        //如果 x + y > y + x 那么y在 x前面
        StringBuilder sb = new StringBuilder();
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2+s1));
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
