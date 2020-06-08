//合并两个排序的链表
//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
public class MergeTwoRowsOfLinkedLists {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){return list2;}
        if(list2==null){return list1;}
        ListNode cur1=list1;
        ListNode cur2=list2;
        ListNode result=null;
        ListNode last=null;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
                ListNode next=cur1.next;
                if(result==null){
                    result=cur1;
                }else{
                    cur1.next=null;
                    last.next=cur1;
                }
                last=cur1;
                cur1=next;
            } else{
                ListNode next=cur2.next;
                if(result==null){
                    result=cur2;
                }else{
                    cur2.next=null;
                    last.next=cur2;
                }
                last=cur2;
                cur2=next;
            }
        }
        if(cur1==null){
            last.next=cur2;
        }else{
            last.next=cur1;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(3);
        ListNode n3=new ListNode(5);
        ListNode n4=new ListNode(7);
        ListNode n5=new ListNode(2);
        ListNode n6=new ListNode(4);
        ListNode n7=new ListNode(6);
        ListNode n8=new ListNode(8);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        System.out.println(Merge(n1,n5));
    }
}
