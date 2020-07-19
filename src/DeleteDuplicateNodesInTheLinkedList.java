

//删除链表中重复的节点
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
// 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class DeleteDuplicateNodesInTheLinkedList {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode point = new ListNode(0);
        point.next = pHead;
        ListNode first = point;
        ListNode last = point.next;
        while (last != null) {
            if (last.next != null && (last.val == last.next.val)) {
                while(last.next!=null&&(last.val==last.next.val)) {
                    last = last.next;
                }
                first.next = last.next;
                last=last.next;
            } else {
                first = first.next;
                last = last.next;
            }
        }
        return point.next;
    }
}
