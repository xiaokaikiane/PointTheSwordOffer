import java.util.LinkedList;
import java.util.Queue;

//树的子结构
//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class TheSubstructureOfATree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
        if(root1==null||root2==null){
            return false;
        }
        if(root1.val==root2.val){
            result=func(root1,root2);
        }
        if(!result){
            result=HasSubtree(root1.left,root2);
        }
        if(!result){
            result=HasSubtree(root1.right,root2);
        }
        return result;
    }
    public static boolean func(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }else{
            return  func(root1.left,root2.left)&&
                    func(root1.right,root2.right);
        }
    }
}
