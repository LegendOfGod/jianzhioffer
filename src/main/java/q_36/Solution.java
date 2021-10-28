package q_36;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lqb
 * @date 2021/10/27 14:19
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *
 *
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 *
 *
 *
 *
 *
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 *
 *
 *
 *
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 *
 */
public class Solution {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        //dfs 搜索树中序遍历的结果就是节点的顺序
        inOrder(root);
        head.left  = pre;
        pre.right = head;
        return head;
    }

    private void inOrder(Node root) {
        if (root == null){
            return;
        }
        inOrder(root.left);
        if (pre != null){
            pre.right = root;
        }else {
            head = root;
        }
        root.left = pre;
        pre = root;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node4.left = node2;
        node4.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        solution.treeToDoublyList(node4);
    }

}
