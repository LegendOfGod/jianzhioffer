package q_13;

/**
 * @author lqb
 * @date 2021/10/26 19:02
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 只往下和右走就可以达到DFS
 * 遇到处理过的点要记忆避免重复计算  最坏的情况是计
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class Solution {
    int i = 0;
    int j = 0;
    Integer res = 0;

    public int movingCount(int m, int n, int k) {
        //深度优先搜索
        i = m - 1;
        j = n - 1;
        Boolean[][] record = new Boolean[m][n];
        res = dfs(0, 0, k, record, res);
        return res;
    }

    private int dfs(int m, int n, int k, Boolean[][] record, Integer res) {
        if (m < 0 || n < 0 || m > i || n > j) {
            return res;
        } else {
            if (record[m][n] == null) {
                //如果位置没有越界
                if (sumSingle(m, n) <= k) {
                    res++;
                    record[m][n] = true;
                    //左边
                    if (n != 0) {
                        res = dfs(m, n - 1, k, record, res);
                    }
                    //右边
                    if (n != j) {
                        res = dfs(m, n + 1, k, record, res);
                    }
                    //上边
                    if (m != 0) {
                        res = dfs(m - 1, n, k, record, res);
                    }
                    //下边
                    if (m != i) {
                        res = dfs(m + 1, n, k, record, res);
                    }
                } else {
                    record[m][n] = false;
                }
                return res;
            } else {
                return res;
            }
        }
    }

    private int sumSingle(int m, int n) {
        int m1 = m / 10;
        int m2 = m % 10;
        int n1 = n / 10;
        int n2 = n % 10;
        return m1 + m2 + n1 + n2;
    }
}
