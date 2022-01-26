package jianzhi2_032;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lqb
 * @date 2022/1/25 15:26
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "a"
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t 仅包含小写字母
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character first = s.charAt(i);
            int firstValue = map.computeIfAbsent(first, f -> 0);
            map.put(first, firstValue + 1);
            if (map.get(first).equals(0)) {
                map.remove(first);
            }
            Character second = t.charAt(i);
            int secondValue = map.computeIfAbsent(second, n -> 0);
            map.put(second, secondValue -1);
            if (map.get(second).equals(0)) {
                map.remove(second);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("a", "a"));
    }

}
