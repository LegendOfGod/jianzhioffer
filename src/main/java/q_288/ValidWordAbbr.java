package q_288;

import java.util.*;

/**
 * @author lqb
 * @date 2021/12/16 9:02
 * 单词的 缩写 需要遵循 <起始字母><中间字母数><结尾字母> 这样的格式。如果单词只有两个字符，那么它就是它自身的 缩写 。
 * <p>
 * 以下是一些单词缩写的范例：
 * <p>
 * dog --> d1g 因为第一个字母 'd' 和最后一个字母 'g' 之间有 1 个字母
 * internationalization --> i18n 因为第一个字母 'i' 和最后一个字母 'n' 之间有 18 个字母
 * it --> it 单词只有两个字符，它就是它自身的 缩写
 *  
 * <p>
 * 实现 ValidWordAbbr 类：
 * <p>
 * ValidWordAbbr(String[] dictionary) 使用单词字典 dictionary 初始化对象
 * boolean isUnique(string word) 如果满足下述任意一个条件，返回 true ；否则，返回 false ：
 * 字典 dictionary 中没有任何其他单词的 缩写 与该单词 word 的 缩写 相同。
 * 字典 dictionary 中的所有 缩写 与该单词 word 的 缩写 相同的单词都与 word 相同 。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique", "isUnique"]
 * [[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"], ["cake"]]
 * 输出
 * [null, false, true, false, true, true]
 * <p>
 * 解释
 * ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", "card"]);
 * validWordAbbr.isUnique("dear"); // 返回 false，字典中的 "deer" 与输入 "dear" 的缩写都是 "d2r"，但这两个单词不相同
 * validWordAbbr.isUnique("cart"); // 返回 true，字典中不存在缩写为 "c2t" 的单词
 * validWordAbbr.isUnique("cane"); // 返回 false，字典中的 "cake" 与输入 "cane" 的缩写都是 "c2e"，但这两个单词不相同
 * validWordAbbr.isUnique("make"); // 返回 true，字典中不存在缩写为 "m2e" 的单词
 * validWordAbbr.isUnique("cake"); // 返回 true，因为 "cake" 已经存在于字典中，并且字典中没有其他缩写为 "c2e" 的单词
 */
public class ValidWordAbbr {

    Map<String, Set<String>> dic = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) {
            if (s.length() > 1) {
                String firstLetter = s.substring(0,1);
                String lastLetter = s.substring(s.length() -1);
                int length = s.length() - 2;
                String key = firstLetter + length + lastLetter;
                if (dic.containsKey(key)) {
                    dic.get(key).add(s);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(s);
                    dic.put(key, set);
                }
            } else {
                Set<String> set = new HashSet<>();
                set.add(s);
                dic.put(s, set);
            }
        }
    }

    public boolean isUnique(String word) {
        if (word.length() > 1) {
            String firstLetter = word.substring(0,1);
            String lastLetter = word.substring(word.length() - 1);
            int length = word.length() - 2;
            String key = firstLetter + length + lastLetter;
            Set<String> dicSet = dic.get(key);

            if (dicSet == null) {
                //字典中没这个缩写
                return true;
            } else if (dicSet.contains(word) && dicSet.size() == 1) {
                //字典有这个缩写 并且 只含这个词
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(validWordAbbr.isUnique("dear"));
        System.out.println(validWordAbbr.isUnique("cart"));
        System.out.println(validWordAbbr.isUnique("cane"));
        System.out.println(validWordAbbr.isUnique("make"));
        System.out.println(validWordAbbr.isUnique("cake"));
    }
}
