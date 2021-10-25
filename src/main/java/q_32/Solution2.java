package q_32;

import java.util.*;

/**
 * @author lqb
 * @date 2021/10/20 16:21
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //结果集
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        //记录层数
        Map<TreeNode,Integer> layer = new HashMap<>();
        //记录已经产生list的层
        Set<Integer> existLayers = new HashSet<>();
        //层序遍历队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //根节点为第一层
        layer.put(root,1);
        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            Integer layerInt = layer.get(head);
            if (existLayers.contains(layerInt)){
                list.get(layerInt - 1).add(head.val);
            }else {
                List<Integer> layerInt2 = new ArrayList<>();
                layerInt2.add(head.val);
                list.add(layerInt2);
                existLayers.add(layerInt);
            }
            if (head.left != null){
                queue.offer(head.left);
                layer.put(head.left,layerInt+1);
            }

            if (head.right != null){
                queue.offer(head.right);
                layer.put(head.right,layerInt+1);
            }
        }
        return list;
    }

}
