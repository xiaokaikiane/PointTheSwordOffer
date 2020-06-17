//重建二叉树
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
// 则重建二叉树并返回
import java.util.Arrays;

public class ReconstructABinaryTree {
    static class TreeNode {
      int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0){
            return null;
        }
        int rootval=pre[0];
        if (pre.length==1){
            return new TreeNode(rootval);
        }
        TreeNode root=new TreeNode(rootval);
        int rootindex=0;
        for(int i=0;i<in.length;i++){
            if(rootval==in[i]){
                rootindex=i;
                break;
            }
        }
        //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left=reConstructBinaryTree(
                Arrays.copyOfRange(pre,1,rootindex+1),Arrays.copyOfRange(in,0,rootindex));
        root.right=reConstructBinaryTree(
                Arrays.copyOfRange(pre,rootindex+1,pre.length),Arrays.copyOfRange(in,rootindex+1,in.length));
return root;
    }
}
