//两个链表的第一个公共结点
//输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，
// 所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
public class TheFirstCommonNodeOfTwoLinkedLists {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1=pHead1;
        ListNode cur2=pHead2;
        int l1=getlength(cur1);
        int l2=getlength(cur2);
        if(l1>l2){
            int k=l1-l2;
            while (k>0){
                cur1=cur1.next;
                k--;
            }
        }
        if (l2>l1){
            int k=l2-l1;
            while(k>0){
                cur2=cur2.next;
                k--;
            }
        }
        while(cur1.val!=cur2.val){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }

    private int getlength(ListNode node) {
        int length=0;ListNode cur=node;
        while(cur.next!=null){
            length++;
            cur=cur.next;
        }
        return length;
    }
}
