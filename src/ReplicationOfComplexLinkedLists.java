//复杂链表的复制
//输入一个复杂链表（每个节点中有节点值，以及两个指针，
// 一个指向下一个节点，另一个特殊指针random指向一个随机节点），
// 请对此链表进行深拷贝，并返回拷贝后的头结点。
// （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
public class ReplicationOfComplexLinkedLists {
    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null){
            return null;
        }
        RandomListNode cur=pHead;
        while(cur!=null){//复制
            RandomListNode clone=new RandomListNode(cur.label);
            RandomListNode node=cur.next;
            cur.next=clone;
            clone.next=node;
            cur=node;
        }
        cur=pHead;
        while(cur!=null){//复制random
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }else{
                cur.next.random=null;
            }
            cur=cur.next.next;
        }
        cur=pHead;
        RandomListNode Nhead=pHead.next;
        while(cur!=null){
            RandomListNode clone=cur.next;
            cur.next=clone.next;
            if(clone.next!=null){
                clone.next=clone.next.next;
            }else{
                clone.next=null;
            }
            cur=cur.next;
        }
        return Nhead;
    }
}
