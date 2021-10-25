package q_47;

/**
 * @author lqb
 * @date 2021/10/22 14:33
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * f(0,0) = max(f(0,1)+nums[0][0],f(1,0)+nums[0][0])
 * f(x,y) = max(f(x,y+1)+ nums[x,y],f(x+1,y)+nums[x,y])
 * 边界是
 * <p>
 * 提示：
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 */
public class Solution {
    int m = 0;
    int n = 0;
    int[][] temp;
    int[][] max = new int[210][210];

    public int maxValue(int[][] grid) {
        temp = grid;
        m = grid.length - 1;
        n = grid[0].length - 1;
        if (m == 0 && n == 0) {
            return grid[0][0];
        } else {
            return maxSubValue(0, 0);
        }
    }

    private int maxSubValue(int i, int j) {
        if (max[i][j] == 0) {
            if (i == m && j == n) {
                max[i][j] = temp[i][j];
            }
            if (i == m && j != n) {
                max[i][j] = temp[i][j] + maxSubValue(i, j + 1);
            }
            if (i != m && j == n) {
                max[i][j] = temp[i][j] + maxSubValue(i + 1, j);
            }
            if (i != m && j != n) {
                max[i][j] = temp[i][j] + Math.max(maxSubValue(i + 1, j), maxSubValue(i, j + 1));
            }
        }
        return max[i][j];
    }

    public static void main(String[] args) {
        int[][] input = {
                {9, 1, 4, 8},
        };
        Solution solution = new Solution();
        System.out.println(solution.maxValue(input));
    }
}
