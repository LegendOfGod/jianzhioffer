package q_12;

/**
 * @author lqb
 * @date 2021/10/26 11:33
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 'ABCCED'（单词中的字母已标出）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board =
 * [['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']], word = 'ABCCED'
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：board = [['a','b'],['c','d']], word = 'abcd'
 * 输出：false
 * <p>
 * dp[i][j] = dp[i + 1][j] && dp[i][j+1]
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int row = board.length;
        int column = board[0].length;
        //对每一个节点进行判断
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (existHead(board, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean existHead(char[][] board, char[] chars, int i, int j, int k) {
        //出现了数组越界的情况或者不等的情况false
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != chars[k]) {
            return false;
        }
        //找到最后一个字符且相等true
        if (k == chars.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        //其他情况还需要继续递归  递归的方向是上下左右四个方向
        boolean res = existHead(board, chars, i - 1, j, k + 1) || existHead(board, chars, i + 1, j, k + 1)
                || existHead(board, chars, i, j - 1, k + 1) || existHead(board, chars, i, j + 1, k + 1);
        board[i][j] = chars[k];
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] input = {
                {'A', 'A'},
        };
        System.out.println(solution.exist(input, "AAA"));
    }

}
