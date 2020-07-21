import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//把二叉树打印成多行
//从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
public class PrintTheBinarTreeToMultipleLines {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(pRoot==null){
            return result;
        }
        Queue<TreeNode> q1=new LinkedList<>();
        q1.add(pRoot);
        Queue<TreeNode> q2=new LinkedList<>();
        int index=1;
        while(!q1.isEmpty()||!q2.isEmpty()){
            if (index%2!=0) {
                ArrayList<Integer> temp = new ArrayList<>();
                while(!q1.isEmpty()) {
                    TreeNode node = q1.poll();
                    if (node!=null){
                        temp.add(node.val);
                        q2.add(node.left);
                        q2.add(node.right);
                    }
                }
                if (!temp.isEmpty()){
                    result.add(temp);
                    index++;
                }
            }
            if (index%2==0){
                ArrayList<Integer> temp=new ArrayList<>();
                while(!q2.isEmpty()){
                    TreeNode node=q2.poll();
                    if(node!=null){
                        temp.add(node.val);
                        q1.add(node.left);
                        q1.add(node.right);
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
