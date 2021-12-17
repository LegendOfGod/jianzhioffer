package q_325;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lqb
 * @date 2021/12/16 16:01
 * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,-1,5,-2,3], k = 3
 * 输出: 4
 * 解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
 * 示例 2:
 *
 * 输入: nums = [-2,-1,2,1], k = 1
 * 输出: 2
 * 解释: 子数组 [-1, 2] 和等于 1，且长度最长。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 105
 * -104 <= nums[i] <= 104
 * -109 <= k <= 109
 *
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int curLength = 0;
        int j = 0;
        int sum = 0;
        for (int i = 0; i < nums.length;i++) {
            if ((nums.length - i) < curLength){
                break;
            }
            j = i;
            sum = 0;
            for (int l = j; l < nums.length; l++) {
                sum += nums[l];
                if (sum == k && (l - i + 1) > curLength){
                    curLength = l - i + 1;
                }
            }
        }
        return curLength;



    }

    public int maxSubArrayLen2(int[] nums, int k) {
        //哈希表存储值和下标
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int[]pre=new int[n+1];
        for(int i=1;i<=n;i++){
            pre[i]=pre[i-1]+nums[i-1];
        }
        map.put(0,0);
        int max=0;
        for(int i=1;i<=n;i++){
            if(map.containsKey(pre[i]-k)){
                max=Math.max(max,i-map.get(pre[i]-k));
            }
            if(!map.containsKey(pre[i])){
                map.put(pre[i],i);
            }
        }
        return max;
    }
    //用前缀和 preSum 来记录截止到 i 位置时，得到的 nums[0:i] 之和。
    //使用哈希表来记录第一次 preSum 出现的位置 i，之所以仅仅需要记录第一个出现的位置，是因为要保证整个子数组最长，因此只需要记录最前面的位置就好了。
    //需要注意的是，对于前缀和 0 ，其出现的位置在数组开始前，也就是 -1。
    //那么在接下来的遍历过程中，如果在前缀和 preSum 记录到 i 位置时，哈希表中找到了 preSum - k 的值为 j ，那么说明 preSum[i] - preSum[j] == k 成立，此时检查是不是更长，来更新返回值 ans
    public int maxSubArrayLen3(int[] nums, int k) {
        int n = nums.length;
        // 哈希表，映射前缀和值到第一次出现的下标位置
        Map<Integer, Integer> preSumIndex = new HashMap<>();
        int ans = 0;
        // 前缀和
        int preSum = 0;
        // 0 出现的位置在 -1 位置处
        preSumIndex.put(0, -1);
        for (int i = 0; i < n; ++i) {
            // 累加前缀和
            preSum += nums[i];
            // 确保记录的是第一次出现的位置
            if (!preSumIndex.containsKey(preSum)) {
                preSumIndex.put(preSum, i);
            }
            // 检查一下是否需要更新答案
            if (preSumIndex.containsKey(preSum - k)) {
                ans = Math.max(ans, i - preSumIndex.get(preSum - k));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArrayLen2(new int[]{1,1,1}, 2));
    }
}
