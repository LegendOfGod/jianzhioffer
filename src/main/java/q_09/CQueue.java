package q_09;

/**
 * @author lqb
 * @date 2021/10/13 16:32
 *
 */

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：
 * [null,null,3,-1]
 *
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 *
 *     1 <= values <= 10000
 *     最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class CQueue {

    private final Stack<Integer> stackIn = new Stack<Integer>();
    private final Stack<Integer> stackOut = new Stack<Integer>();

    public CQueue() {
    }

    public void appendTail(int value) {
        //追加元素到stackIn
        stackIn.push(value);
    }

    public int deleteHead() {
        //stackOut不为空则直接弹出
        if (!stackOut.isEmpty()){
            return stackOut.pop();
        }else {
            //stackIn也为空
            if (stackIn.isEmpty()){
                return -1;
            }else {
                while (!stackIn.isEmpty()){
                    Integer pop = stackIn.pop();
                    stackOut.push(pop);
                }
                return stackOut.pop();
            }
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
