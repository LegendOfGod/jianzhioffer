package q_35;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lqb
 * @date 2021/10/14 11:34
 */
public class Solution {
    public Node copyRandomList(Node head) {
        //先复制单项链表
        Node newHead = null;
        Node pre = null;
        Node curOld = head;
        Map<Node,Node> random = new HashMap<Node,Node>();
        while (curOld != null){
            Node newNode;
            //该节点还没有复制过 创造新的节点
            if (!random.containsKey(curOld)){

                //创建新的节点
                newNode = new Node(curOld.val);
                random.put(curOld, newNode);
                if (pre != null){
                    pre.next = newNode;
                }
                pre = newNode;
                if (newHead == null){
                    newHead = newNode;
                }

                //random节点 没有则复制 有则直接使用
                Node nextOldRandom = curOld.random;

                if (nextOldRandom == null){
                    newNode.random = null;
                }else {
                    //如果这个节点已经被复制过了
                    if (random.containsKey(nextOldRandom)){
                        newNode.random = random.get(nextOldRandom);
                    }else{
                        //如果这个节点没有被使用
                        Node newRandom = new Node(nextOldRandom.val);
                        newNode.random = newRandom;
                        random.put(nextOldRandom, newRandom);
                    }
                }
            }else {
                Node node = random.get(curOld);
                if (pre != null){
                    pre.next = node;
                }
                pre = node;

                //random节点 没有则复制 有则直接使用
                Node nextOldRandom = curOld.random;

                if (nextOldRandom == null){
                    node.random = null;
                }else {
                    //如果这个节点已经被复制过了
                    if (random.containsKey(nextOldRandom)){
                        node.random = random.get(nextOldRandom);
                    }else{
                        //如果这个节点没有被使用
                        Node newRandom = new Node(nextOldRandom.val);
                        node.random = newRandom;
                        random.put(nextOldRandom, newRandom);
                    }
                }
            }
            curOld = curOld.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node node03 = new Node(3);
        Node node13 = new Node(3);
        Node node33 = new Node(3);
        node03.next = node13;
        node13.next = node33;
        node13.random = node03;
        Solution solution = new Solution();
        Node node = solution.copyRandomList(node03);
        System.out.println(node);
    }
}
