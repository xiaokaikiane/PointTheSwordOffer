

//链表中的环入口节点
//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
public class LoopEntryNodeInALinkedList {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null||pHead.next==null){//构成环最少要三个结点
            return null;
        }
        ListNode p1=pHead;
        ListNode p2=pHead;
        while(true){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){
                p2=pHead;
                while(p1!=p2){
                    p1=p1.next;
                    p2=p2.next;
                }
                if(p1==p2){
                    return p1;
                }
            }
        }
    }
}
