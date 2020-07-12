//平衡二叉树
//输入一棵二叉树，判断该二叉树是否是平衡二叉树。
//
//在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
public class BalancedBinaryTree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        Boolean left=IsBalanced_Solution(root.left);
        if(!left){
            return false;
        }
        Boolean right=IsBalanced_Solution(root.right);
        if(!right){
            return false;
        }
        int leftcount=TreeDepth(root.left);
        int rightcount=TreeDepth(root.right);
        if(Math.abs(leftcount-rightcount)>1){
            return false;
        }
        return true;
    }
    public int TreeDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=TreeDepth(node.left);
        int  right=TreeDepth(node.right);
        int height=Math.max(left,right)+1;
        return height;
    }
}
