package q_06;

/**
 * @author lqb
 * @date 2021/10/14 9:58
 */

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] out = new int[stack.size()];
        while (!stack.isEmpty()){
            out[i++] = stack.pop();
        }
        return out;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(2);
        Solution solution = new Solution();
        System.out.println(solution.reversePrint(listNode1).toString());
    }
}
