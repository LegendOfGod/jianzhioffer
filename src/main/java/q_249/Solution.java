package q_249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lqb
 * @date 2022/1/13 10:09
 * 给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。
 *
 *  
 *
 * 示例：
 *
 * 输入：["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
 * 输出：
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 * 解释：可以认为字母表首尾相接，所以 'z' 的后续为 'a'，所以 ["az","ba"] 也满足 “移位” 操作规律。。
 *
 * 题目的意思是每个组里面的字符串 每个字符移动相同的位数都可以变成组内其他的字符串  也就是说每个字符传首字符都移动到z后 整体字符串相同的就是同一组 所以可以将这个字符串当做key 做hash分组
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> group = new HashMap<>();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            //首字符要移动到z要移动的位数
            int num = 'z' - chars[0];
            //对字符串循环移位
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] + num > 'z'){
                    chars[i] = (char) ('a' + ((num - ('z' - chars[i]) - 1)));
                }else {
                    chars[i] = (char) (chars[i] + num);
                }
            }
            String s = new String(chars);
            group.computeIfAbsent(s,list -> new ArrayList<>()).add(string);
        }
        List<List<String>> result = new ArrayList<>(group.values());
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        Solution solution = new Solution();
        System.out.println(solution.groupStrings(strings));
    }

}
