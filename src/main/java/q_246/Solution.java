package q_246;

import com.sun.deploy.util.StringUtils;

/**
 * @author lqb
 * @date 2021/12/16 18:53
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 *
 * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num = "69"
 * 输出: true
 * 示例 2:
 *
 * 输入: num = "88"
 * 输出: true
 * 示例 3:
 *
 * 输入: num = "962"
 * 输出: false
 * 示例 4：
 *
 * 输入：num = "1"
 * 输出：true
 *
 */
public class Solution {

    public boolean isStrobogrammatic(String num) {
        if ("1".equals(num) || "8".equals(num)){
            return true;
        }
        char[] chars = num.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while(left <= chars.length/2){
            if (chars[left] == chars[right] && ((chars[left] == '8' && chars[right] == '8') || (chars[left] == '1' && chars[right] == '1') || (chars[left] == '0' && chars[right] == '0'))){
                left++;
                right--;
            } else if ((chars[left] == '6' && chars[right] == '9') || (chars[left] == '9' && chars[right] == '6')|| (chars[left] == '1' && chars[right] == '1')|| (chars[left] == '0' && chars[right] == '0')){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isStrobogrammatic("101"));
        System.out.println(solution.isStrobogrammatic("88"));
        System.out.println(solution.isStrobogrammatic("962"));
        System.out.println(solution.isStrobogrammatic("1"));
    }
}
