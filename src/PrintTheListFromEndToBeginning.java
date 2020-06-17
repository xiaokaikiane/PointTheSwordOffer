import java.util.ArrayList;
import java.util.Stack;

//从尾到头打印链表
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class PrintTheListFromEndToBeginning {
   static class ListNode {
       int val;
       ListNode next = null;

       ListNode(int val) {
           this.val = val;
       }
   }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack=new Stack<Integer>();
        ArrayList<Integer> list=new ArrayList<Integer>();
       if (listNode==null) {
           return list;
       }
        for(ListNode cur=listNode;cur!=null;cur=cur.next){
            stack.push(cur.val);
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
