package q_26;

/**
 * @author lqb
 * @date 2021/10/21 9:03
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        //如果节点相等 直接判断树结构
        if (A.val == B.val && help(A.left,B.left) && help(A.right,B.right) ){
            return true;
        }
        //否则遍历树
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public Boolean help(TreeNode A,TreeNode B){
        //A节点为空 但是B节点有值 不等
        if (A == null && B != null){
            return false;
        }
        //B节点为空 等
        if (B == null){
            return true;
        }
        //值相等的情况下继续判断左右子树
        if (A.val == B.val){
            return help(A.left,B.left) && help(A.right,B.right);
        }else {
            return false;
        }
    }
}
