package q_35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lqb
 * @date 2021/10/14 16:22
 */
public class Solution2 {
    //回溯
    Map<Node,Node> random = new HashMap<Node,Node>();
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        if (!random.containsKey(head)){
            Node newNode = new Node(head.val);
            random.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return random.get(head);
    }
}
