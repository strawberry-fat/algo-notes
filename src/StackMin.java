import java.util.Stack;

/**
 * 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 示例
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.

 *
 */
public class StackMin {
    Stack<Integer> totalStack = new Stack<>();
    Stack<Integer> littleStack = new Stack<>();

    public void push(int node) {
        totalStack.push(node);
        if (littleStack.empty()) littleStack.push(node);
        else littleStack.push(Math.min(littleStack.peek(), node));
    }

    public void pop() {
        totalStack.pop();
        littleStack.pop();
    }

    public int top() {
        return totalStack.peek();
    }

    public int min() {
        return littleStack.peek();
    }
}
