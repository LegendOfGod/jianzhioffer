package q_34;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lqb
 * @date 2021/10/27 11:33
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * <p>
 * 走到某个节点如果和大于目标值name直接返回
 * <p>
 * 提示：
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        preOrder(root,target);
        return res;
    }

    private void preOrder(TreeNode root,int tar) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        tar = tar - root.val;
        if (root.left == null && root.right == null && tar == 0) {
            res.add(new ArrayList<>(temp));
        }
        preOrder(root.left,tar);
        preOrder(root.right,tar);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        List<List<Integer>> list = solution.pathSum(treeNode1, 4);
        System.out.println(list);
    }
}
