//输入一个链表，反转链表后，输出新链表的表头。
public class ReverseALinkedList {
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
    public static ListNode ReverseList(ListNode head) {
        ListNode Fhead=null;
        ListNode Hhead=null;
        while(head!=null){
            Hhead=head.next;
            head.next=Fhead;
            Fhead=head;
            head=Hhead;
        }
        //如果head为null的时候，Fhead就为最后一个节点了，但是链表已经反转完毕，Fhead就是反转后链表的第一个节点
        //直接输出Fhead就是我们想要得到的反转后的链表
        return Fhead;
    }
    public static void main(String[] args) {
        ListNode n1=new ListNode(3);
        ListNode n2=new ListNode(4);
        ListNode n3=new ListNode(8);
        n1.next=n2;
        n2.next=n3;
        System.out.println(ReverseList(n1));
    }
}
