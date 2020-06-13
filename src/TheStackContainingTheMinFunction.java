import java.util.Stack;
//包含min函数的栈
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
//注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
public class TheStackContainingTheMinFunction {
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> min=new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
        if(min==null||node <min.peek()){
            min.push(node);
        }else{
            min.push(min.peek());
        }
    }
    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
