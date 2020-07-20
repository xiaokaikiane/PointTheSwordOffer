import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//从上往下打印二叉树
//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class PrintBinaryTreesFromTopToBottom {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new  ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode front=queue.poll();
            list.add(front.val);
            if(front.left!=null){
                queue.add(front.left);
            }
            if(front.right!=null){
                queue.add(front.right);
            }
        }
        return list;
    }
}
