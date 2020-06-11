import java.util.Stack;

//栈的压入弹出序列
//输入两个整数序列，第一个序列表示栈的压入顺序，
// 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
// 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
// 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
public class StackPush_InPopSequence {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack stack = new Stack();
        int idx = 0;
        int index = 0;
        while(idx<pushA.length) {
            if (pushA[idx] != popA[index]) {
                stack.push(pushA[idx]);
                idx++;
            }
        }
        if (pushA[idx] == popA[index]) {
            index++;
            while (stack.peek().equals(popA[index])) {
                stack.pop();
                index++;
            }
            if (stack != null) {
                while(idx<pushA.length) {
                    idx++;
                    if (pushA[idx] != popA[index]) {
                        stack.push(pushA[idx]);
                    }
                }
            }
            return true;
        }
    }
}
