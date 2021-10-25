package q_27;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lqb
 * @date 2021/10/21 10:32
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        int i = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = root;
        queue.offer(head);
        while (!queue.isEmpty()){
            TreeNode peak = queue.poll();
            TreeNode temp = peak.right;
            peak.right = peak.left;
            peak.left = temp;
            if (peak.left != null){
                queue.offer(peak.left);
            }
            if (peak.right != null){
                queue.offer(peak.right);
            }
        }
        return head;
    }
}
