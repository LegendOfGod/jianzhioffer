package q_32;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lqb
 * @date 2021/10/19 11:19
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        //利用队列层序遍历
        if (root != null){
            Queue<TreeNode> queue  = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode now = queue.poll();
                list.add(now.val);
                if (now.left != null) {
                    queue.offer(now.left);
                }
                if (now.right != null) {
                    queue.offer(now.right);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }
}
