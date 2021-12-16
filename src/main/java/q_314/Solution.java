package q_314;

import java.util.*;

/**
 * @author lqb
 * @date 2021/12/16 10:07
 * 给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。
 *
 * 如果两个结点在同一行和列，那么顺序则为 从左到右。
 * 同一行和同一列
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        //结果集
        Map<Integer, List<Integer>> res = new TreeMap<>();
        //记录当前节点的位置弹出的出列的时候才能将其放进对应的结果集
        Map<TreeNode, Integer> pos = new HashMap<>();
        pos.put(root, 0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            res.computeIfAbsent(pos.get(head), i -> new ArrayList<>()).add(head.val);
            if (head.left != null) {
                pos.put(head.left, pos.get(head) - 1);
                queue.offer(head.left);
            }

            if (head.right != null) {
                pos.put(head.right, pos.get(head) + 1);
                queue.offer(head.right);
            }
        }
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {

    }
}
