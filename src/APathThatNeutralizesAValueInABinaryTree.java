import java.util.ArrayList;

//二叉树中和为某一值的路径
//输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
public class APathThatNeutralizesAValueInABinaryTree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null){
            return result;
        }
        list.add(root.val);
        target=target-root.val;
        if(target==0&&root.left==null&&root.right==null){
            result.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return result;
    }
}
