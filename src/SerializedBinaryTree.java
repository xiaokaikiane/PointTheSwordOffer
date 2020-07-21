import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//序列化二叉树
//请实现两个函数，分别用来序列化和反序列化二叉树
//
//二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
// 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式
// 来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！
// 表示一个结点值的结束（value!）。
//
//二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
//
//例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
public class SerializedBinaryTree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
     static String Serialize(TreeNode root) {
        String str="";
        if(root==null){
            return str;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode front=queue.poll();
            if (front!=null){
//                System.out.println(front.val);
                str+=front.val;
                str+=",";
                queue.add(front.left);
                queue.add(front.right);
            }else{
                str+="#,";
            }
        }
        return str.substring(0,str.length()-1);
    }
     static TreeNode Deserialize(String str) {
        TreeNode head=null;
        if(str==null||str.length()==0){
            return null;
        }
        String[] arr=str.split(",");
        TreeNode[] nodes=new TreeNode[arr.length];
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("#")){
                nodes[i]=new TreeNode(Integer.valueOf(arr[i]));
            }
        }
        int j=1;
        for (int i=0;i<nodes.length;i++){
            if (nodes[i]!=null){
                nodes[i].left=nodes[j];
                j++;
                nodes[i].right=nodes[j];
                j++;
            }
        }
        return nodes[0];
    }

    static String Serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
            queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val + ",");
          } else{
                sb.append("#" + ",");
            }
        }
        if(sb.length() != 0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    static TreeNode Deserialize1(String str) {
        TreeNode head = null;
        if(str == null || str.length() == 0)
            return head;
        String[] nodes = str.split(",");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for(int i=0; i<nodes.length; i++){
            if(!nodes[i].equals("#"))
                treeNodes[i] = new TreeNode(Integer.valueOf(nodes[i]));
        }
        for(int i=0, j=1; j<treeNodes.length; i++){
            if(treeNodes[i] != null){
                treeNodes[i].left = treeNodes[j++];
                treeNodes[i].right = treeNodes[j++];
            }
        }
        return treeNodes[0];
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

        System.out.println(Serialize(root));
    }
}
