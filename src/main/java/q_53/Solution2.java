package q_53;

/**
 * @author lqb
 * @date 2021/10/18 16:52
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == mid){
                //如果mid下标值和下标相等  那么出现问题的数肯定在mid右侧区间
                left = mid + 1;
            }else if (nums[mid] != mid ){
                right = mid -1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] ints = {0, 2, 3,4,5};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.missingNumber(ints));
    }
}
