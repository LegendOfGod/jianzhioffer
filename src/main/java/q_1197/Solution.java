package q_1197;

import javax.swing.text.StyledEditorKit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author lqb
 * @date 2021/12/16 11:19
 * 一个坐标可以从 -infinity 延伸到 +infinity 的 无限大的 棋盘上，你的 骑士 驻扎在坐标为 [0, 0] 的方格里。
 *
 * 骑士的走法和中国象棋中的马相似，走 “日” 字：即先向左（或右）走 1 格，再向上（或下）走 2 格；或先向左（或右）走 2 格，再向上（或下）走 1 格。
 *
 * 每次移动，他都可以按图示八个方向之一前进。
 *
 *
 *
 * 现在，骑士需要前去征服坐标为 [x, y] 的部落，请你为他规划路线。
 *
 * 最后返回所需的最小移动次数即可。本题确保答案是一定存在的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2, y = 1
 * 输出：1
 * 解释：[0, 0] → [2, 1]
 * 示例 2：
 *
 * 输入：x = 5, y = 5
 * 输出：4
 * 解释：[0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 *
 * 题目分析出当前位置是（x,y）
 * 那么移动方法有八种
 * （x+1,y+2） (x+1,y-2) (x-1,y+2) (x-1,y-2)
 * (x+2,y+1) (x+2,y-1) (x-2,y+1) （x-2,y-1）
 * (1,2) (1,-2) (-1,2) (-1,-2)
 * (2,1) (2,-1) (-2 ,1) (-2,-1)
 * //层序遍历每次走八个方向（排除已经走过的点）记录层级根节点为0 这样当到达目标位置时就是最短步数
 * |x| + |y| <= 300
 * bfs会超时 必须进行合理的剪枝 灵活的缩小BFS范围
s */
public class Solution {

    public int minKnightMoves(int x, int y) {
        if (x ==0 && y==0) {
            return 0;
        }
        int[][] direct = new int[][]{
                {1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}
        };
        x = Math.abs(x);
        y = Math.abs(y);
        Map<String, Boolean> step = new HashMap<>();
        Map<String, Integer> stepCount = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        stepCount.put("0-0",0);
        step.put("0-0",true);
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for (int[] singleDirect : direct) {
                int[] newPoint = new int[]{current[0] + singleDirect[0],current[1]+singleDirect[1]};
                if (step.get(newPoint[0] + "-" + newPoint[1]) == null){
                    if (newPoint[0] >= -2 && newPoint[0] <= x + 2 && newPoint[1] >= -2 && newPoint[1] <= y + 2) {
                        queue.add(newPoint);
                        step.put(newPoint[0] + "-" + newPoint[1],true);
                        stepCount.put(newPoint[0] + "-" + newPoint[1],stepCount.get(current[0] +"-"+current[1]) + 1);
                        if (newPoint[0] == x && newPoint[1] == y){
                            return stepCount.get(newPoint[0] + "-" + newPoint[1]);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minKnightMoves(1, 1));
    }
}
