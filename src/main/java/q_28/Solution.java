package q_28;

import java.util.*;

/**
 * @author lqb
 * @date 2021/10/21 11:32
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode first = queue.poll();
                if (first != null){
                    temp.add(first.val);
                    queue.offer(first.left);
                    queue.offer(first.right);
                }else {
                    temp.add(null);
                }
            }
            List<Integer> temp1 = new ArrayList<>(temp);
            Collections.reverse(temp);
            if (!temp1.equals(temp)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        treeNode.left = left;
        treeNode.right = right;
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(treeNode));

    }
}
