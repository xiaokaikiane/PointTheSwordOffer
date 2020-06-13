import java.util.Stack;

//栈的压入弹出序列
//输入两个整数序列，第一个序列表示栈的压入顺序，
// 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
// 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
// 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
public class StackPush_InPopSequence {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if(pushA.length==0||popA.length==0){
            return false;
        }
        Stack<Integer> stack = new Stack();
        int indexPu = 0;
        int indexPo = 0;
        while(indexPu<pushA.length){
            stack.push(pushA[indexPu]);
            indexPu++;
            while(!stack.isEmpty()&&stack.peek()==popA[indexPo]){
                stack.pop();
                indexPo++;
            }
            if (indexPo>=popA.length){
                return true;
            }
        }
        return false;
    }
//    public boolean IsPopOrder(int [] pushA,int [] popA) {
//        if(pushA.length == 0 || popA.length == 0)
//            return false;
//        Stack<Integer> s = new Stack<Integer>();
//        //用于标识弹出序列的位置
//         int popIndex = 0;
//         for(int i = 0; i< pushA.length;i++){
//             s.push(pushA[i]);
//             //如果栈不为空，且栈顶元素等于弹出序列
//             while(!s.empty() &&s.peek() == popA[popIndex]){
//                 //出栈
//                s.pop();
//                 // 弹出序列向后一位
//                 popIndex++;
//                }
//                 }
//                 return s.empty();
//                 }
}
