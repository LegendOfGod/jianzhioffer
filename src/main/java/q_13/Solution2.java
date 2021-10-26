package q_13;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lqb
 * @date 2021/10/26 20:04
 * bfs解法
 */
public class Solution2 {
    public int movingCount(int m, int n, int k) {
        Boolean[][] record = new Boolean[m][n];
        int res = 0;
        Deque<int[]> queue = new LinkedList<int[]>();
        queue.push(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            if ((pop[2] + pop[3]) <= k) {
                res++;
                record[pop[0]][pop[1]] = true;
                //下边
                if (pop[0] != (m - 1) && record[pop[0]+1][pop[1]] == null){
                    queue.push(new int[]{pop[0] + 1,pop[1],(pop[0] + 1)/10 + (pop[0] + 1)%10,pop[1]/10 + pop[1]%10});
                }
                //右边
                if (pop[1] != (n - 1) && record[pop[0]][pop[1]+1] ==null){
                    queue.push(new int[]{pop[0],pop[1]+1,pop[0]/10 + pop[0]%10,(pop[1]+1)/10 + (pop[1]+1)%10});
                }
            }else {
                record[pop[0]][pop[1]] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.movingCount(16, 8, 4));
    }
}
