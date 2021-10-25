package q_50;

import java.util.*;

/**
 * @author lqb
 * @date 2021/10/19 9:58
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 *
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)){
                map.put(ch,i);
                queue.offer(new Pair(ch,i));
                while(!queue.isEmpty() && map.get(queue.peek().getCh()) == -1){
                    queue.poll();
                }
            }else {
                map.put(ch,-1);
                while(!queue.isEmpty() && map.get(queue.peek().getCh()) == -1){
                    queue.poll();
                }
            }
        }
        return queue.isEmpty()?' ':queue.poll().ch;
    }




    class Pair{
        private char ch;
        private int value;

        public Pair(char ch, int value) {
            this.ch = ch;
            this.value = value;
        }

        public char getCh() {
            return ch;
        }

        public void setCh(char ch) {
            this.ch = ch;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }





    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb"));
    }
}
