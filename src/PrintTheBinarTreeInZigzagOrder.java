import java.util.ArrayList;
import java.util.Stack;

//按之字形顺序打印二叉树
//请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
// 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
public class PrintTheBinarTreeInZigzagOrder {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(pRoot==null){
            return result;
        }
        int index=1;
        Stack<TreeNode> s1=new Stack<>();
        s1.push(pRoot);
        Stack<TreeNode> s2=new Stack<>();
        while(!s1.isEmpty()||!s2.isEmpty()){
            if(index%2!=0) {
                ArrayList<Integer> temp=new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode pre= s1.pop();
                    if (pre!=null){
                        temp.add(pre.val);
                        s2.push(pre.left);
                        s2.push(pre.right);
                    }
                }
                if(!temp.isEmpty()){
                    result.add(temp);
                    index++;
                }
            }
            if(index%2==0){
                ArrayList<Integer> temp=new ArrayList<>();
                while(!s2.isEmpty()){
                    TreeNode pre=s2.pop();
                    if(pre!=null){
                        temp.add(pre.val);
                        s1.push(pre.right);
                        s1.push(pre.left);
                    }
                }
                if(!temp.isEmpty()){
                    result.add(temp);
                    index++;
                }
            }
        }
        return result;
    }
}
