package q_254;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lqb
 * @date 2021/12/17 9:06
 * 整数可以被看作是其因子的乘积。
 * <p>
 * 例如：
 * <p>
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 * <p>
 * 注意：
 * <p>
 * 你可以假定 n 为永远为正数。
 * 因子必须大于 1 并且小于 n。
 * 示例 1：
 * <p>
 * 输入: 1
 * 输出: []
 * 示例 2：
 * <p>
 * 输入: 37
 * 输出: []
 * 示例 3：
 * <p>
 * 输入: 12
 * 输出:
 * [
 * [2, 6],
 * [2, 2, 3],
 * [3, 4]
 * ]
 * 示例 4:
 * <p>
 * 输入: 32
 * 输出:
 * [
 * [2, 16],
 * [2, 2, 8],
 * [2, 2, 2, 4],
 * [2, 2, 2, 2, 2],
 * [2, 4, 4],
 * [4, 8]
 * ]
 * 质因子的范围是2 - x的开方
 * 质因子进行组合就可以所有的组合  这个可以递归
 * dfs(num)
 * 遍历数字1~num，找到能被自己整除的因子mulNum，那么[mulNum, num/mulNum]就是一种结果， 并往下继续dfs(num/mulNum)得到num/mulNum的可能情况并添加到返回结果。
 *
 * 剪枝点：
 *
 * 为了避免重复，没必要从1开始遍历，而是从上一次的mulNum开始遍历，这样保证mulNum后续dfs的过程是递增的，所以不会出现重复。
 * 遍历终点没必要为num， 而是num的开根号， 因此最大情况2^32的开根号结果为2^16次方=65536，是可接受范围。
 *
 */
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        return dfs(2,n);
    }

    private List<List<Integer>> dfs(int start, int num) {
        if (num == 1){
            return new ArrayList<>();
        }
        int max = (int) Math.sqrt(num);
        List<List<Integer>> result = new ArrayList<>();
        for (int intNum = start; intNum <= max; intNum++) {
            if (num % intNum == 0){
                List<Integer> simpleList = new ArrayList<>();
                simpleList.add(intNum);
                simpleList.add(num/intNum);
                result.add(simpleList);
                List<List<Integer>> nextList = dfs(intNum, num / intNum);
                for (List<Integer> list : nextList) {
                    list.add(intNum);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.getFactors(12);
        System.out.println(list);
    }

}
