package q_48;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lqb
 * @date 2021/10/22 16:43
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 *
 * 提示：
 *
 *     s.length <= 40000
 *
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int max = 1;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))){
                right = i;
                map.put(s.charAt(i),i);
            }else {
                right = i;
                if (map.get(s.charAt(i)) >= left){
                    left = map.get(s.charAt(i)) + 1;
                }
                map.put(s.charAt(i),i);
            }
            if ((right - left + 1) >= max){
                max = right - left + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
