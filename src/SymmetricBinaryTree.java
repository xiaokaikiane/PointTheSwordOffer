import java.util.LinkedList;
import java.util.Queue;

//对称的二叉树
//请实现一个函数，用来判断一棵二叉树是不是对称的。注意，
// 如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
public class SymmetricBinaryTree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    //    boolean isSymmetrical(TreeNode pRoot){
//        TreeNode Mir=Mirror(pRoot);
//        Queue<TreeNode> q1=new LinkedList<>();
//        Queue<TreeNode> q2=new LinkedList<>();
//        q1.add(pRoot);
//        q2.add(Mir);
//        while(!q1.isEmpty()){
//            TreeNode front1=q1.poll();
//            TreeNode front2=q2.poll();
//            if(front1!=front2){
//                return false;
//            }
//            if((front1.left==null&&front2.left!=null)||(front1.left!=null&&front2.left==null)||
//                    (front1.right==null&&front2.right!=null)||(front1.right!=null&&front2.right==null)){
//                return false;
//            }
//            if(front1.left!=null){
//                q1.add(front1.left);
//                q2.add(front2.left);
//            }
//            if(front1.right!=null){
//                q1.add(front1.right);
//                q2.add(front2.right);
//            }
//        }
//        return true;
//    }
//    public TreeNode Mirror(TreeNode root) {
//        if(root==null){
//            return null;
//        }
//        TreeNode temp=root.left;
//        root.left=root.right;
//        root.right=temp;
//        Mirror(root.left);
//        Mirror(root.right);
//        return root;
//    }
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return func(pRoot.left,pRoot.right);
    }

    boolean func(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return func(left.right,right.left) && func(left.left,right.right);
    }
}
