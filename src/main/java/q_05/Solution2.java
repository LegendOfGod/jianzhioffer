package q_05;

/**
 * @author lqb
 * @date 2021/10/15 10:31
 */
public class Solution2 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < s.length();i++){
            sb.append(" ".equals(String.valueOf(s.charAt(i)))?"%20":s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy";
        Solution2 solution = new Solution2();
        System.out.println(solution.replaceSpace(s));
    }
}

