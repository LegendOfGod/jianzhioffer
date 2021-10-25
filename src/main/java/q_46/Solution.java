package q_46;

/**
 * @author lqb
 * @date 2021/10/22 15:44
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * f(0) = 0
 * f(1) = 1;
 * f(2) = f(1) + exist(f(0))
 * f(3) = f(2) + exist(f(1))
 *
 *
 * 提示：
 *
 *     0 <= num < 231
 *
 */
public class Solution {
    public int translateNum(int num) {
        if (num < 10){
            return 1;
        }
        String s = Integer.toString(num);
        int first = 1;
        int second = 1;
        int sum = 1;
        for (int i = 1; i < s.length() ; i++) {
            int temp = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
            if (temp >= 10 && temp <= 25 ){
                sum = first  + second;
                int temp1 = first;
                first = sum;
                second = temp1;
            }else {
                sum = first;
                int temp1 = first;
                first = sum;
                second = temp1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(12258));
    }
}
