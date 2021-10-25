package q_58;

/**
 * @author lqb
 * @date 2021/10/15 10:44
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n));
        sb.append(s, 0, 2);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords(s, 2));
    }
}
