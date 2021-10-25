package q_05;

/**
 * @author lqb
 * @date 2021/10/15 10:27
 */
public class Solution {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        String s = "We are happy";
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace(s));
    }
}
