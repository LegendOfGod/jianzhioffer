package q_54;

/**
 * @author lqb
 * @date 2021/10/27 15:32
 *  * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *  * <p>
 *  * <p>
 *  * <p>
 *  * 示例 1:
 *  * <p>
 *  * 输入: root = [3,1,4,null,2], k = 1
 *  * 3
 *  * / \
 *  * 1   4
 *  * \
 *  * 2
 *  * 输出: 4
 *  * <p>
 *  * 示例 2:
 *  * <p>
 *  * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *  * 5
 *  * / \
 *  * 3   6
 *  * / \
 *  * 2   4
 *  * /
 *  * 1
 *  * 输出: 4
 *  * <p>
 *  * <p>
 *  * <p>
 *  * 限制：
 *  * <p>
 *  * 1 ≤ k ≤ 二叉搜索树元素个数
 *  * <p>
 */
public class Solution {
    int k;
    int num;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrderReverse(root);
        return num;
    }

    private void inOrderReverse(TreeNode root) {
        if (root == null){
            return;
        }
        inOrderReverse(root.right);
        k--;
        if (k == 0){
            num = root.val;
        }
        inOrderReverse(root.left);
    }
}
