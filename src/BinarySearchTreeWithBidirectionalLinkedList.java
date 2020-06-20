//二叉搜索树与双向链表
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class BinarySearchTreeWithBidirectionalLinkedList {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    TreeNode point=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        Convert(pRootOfTree.right);
        if(point==null){
            point=pRootOfTree;
        }else{
            point.left=pRootOfTree;
            pRootOfTree.right=point;
            point=pRootOfTree;
        }
        Convert(pRootOfTree.left);
        return point;
    }

}
