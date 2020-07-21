import java.util.*;

//二叉搜索树的第K个节点
//给定一棵二叉搜索树，请找出其中的第k小的结点。
// 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
public class TheKTHNodeOfTheBinarSearchTree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    static TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null){
            return null;
        }
        ArrayList<TreeNode> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            TreeNode front=queue.poll();
            if(front!=null){
                list.add(front);
                queue.add(front.left);
                queue.add(front.right);
            }
        }
        Collections.sort(list, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val-o2.val;
            }
        });
        if(k>list.size()||k==0){
            return null;
        }
        System.out.println(list);
        return list.get(k-1);
    }

    //思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
    //     所以，按照中序遍历顺序找到第k个结点就是结果。
    public class Solution {
        int index = 0; //计数器
        TreeNode KthNode(TreeNode root, int k)    {
            if(root != null){ //中序遍历寻找第k个
                TreeNode node = KthNode(root.left,k);
                if(node != null) {
                    return node;
                }
                index ++;
                if(index == k) {
                    return root;
                }
                node = KthNode(root.right,k);
                if(node != null) {
                    return node;
                }
            }
            return null;
        }
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(8);
        TreeNode roo1=new TreeNode(6);
        TreeNode roo2=new TreeNode(10);
        TreeNode roo3=new TreeNode(5);
        TreeNode roo4=null;
        TreeNode roo5=null;
        TreeNode roo6=new TreeNode(7);
        TreeNode roo7=null;
        TreeNode roo8=new TreeNode(9);
        TreeNode roo9=null;
        TreeNode roo10=null;
        TreeNode roo11=new TreeNode(11);

        root.left=roo1;
        root.right=roo2;
        roo1.left=roo3;
        roo1.right=roo4;
        roo2.left=roo5;
        roo2.right=roo6;
        roo3.left=roo7;
        roo3.right=roo8;
        roo6.left=roo9;
        roo6.right=roo10;
        roo8.left=roo11;
        System.out.println(KthNode(root,4));
    }
}
