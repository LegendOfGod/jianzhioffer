package q_06;

/**
 * @author lqb
 * @date 2021/10/14 9:58
 */

import java.util.List;
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
public class Solution2 {
    //反转链表
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        int i = 0;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            if (cur != null){
                head = cur;
            }
            i++;
        }

        int[] out = new int[i];
        int j = 0;
        while (head != null){
            out[j++] = head.val;
            head = head.next;
        }
        return out;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(2);
        Solution2 solution = new Solution2();
        System.out.println(solution.reversePrint(listNode1).toString());
    }
}
