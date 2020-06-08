//链表中倒数第K个结点
//输入一个链表，输出该链表中倒数第k个结点。
public class TheKTHToTheLastNodeInTheList {

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
        public static ListNode FindKthToTail(ListNode head,int k) {
            if(head==null){
                return head;
            }
            ListNode p1=head;
            ListNode p2=head;
            int count=0;
            while(p1!=null){
                if(count>=k){
                    p2=p2.next;
                }
                count++;
                p1=p1.next;
            }
            if(count<k){
                return null;
            }
            return p2;
        }

    public static void main(String[] args) {
        ListNode n1=new ListNode(3);
        ListNode n2=new ListNode(4);
        ListNode n3=new ListNode(8);
        n1.next=n2;
        n2.next=n3;
        System.out.println(FindKthToTail(n1,1));
    }
}
