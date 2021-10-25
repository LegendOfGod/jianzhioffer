package q_30;

/**
 * @author lqb
 * @date 2021/10/13 17:50
 */
public class MinStack2 {
    private int[] stack;
    private int top_cur;
    private int min;

    public MinStack2(){
        this.stack = new int[1000];
        this.top_cur = -1;
        this.min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min){
            stack[++top_cur] = min;
            min = x;
        }
        stack[++top_cur] = x;
    }

    public void pop() {
        if (min == stack[top_cur]){
            top_cur--;
            min = stack[top_cur];
        }
        top_cur--;
    }

    public int top() {
        return stack[top_cur];
    }

    public int min() {
        return min;
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

}
