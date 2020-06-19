//二叉搜索树的后序遍历序列
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class BinaryTreeSearchTreePost_OrderedTraversalSequence {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }
        return func(sequence,0,sequence.length-1);
    }
    public boolean func(int[] sequence,int start,int end){
        if(start>=end){
            return true;
        }
        int i=start;
        int root=sequence[end];
        for(;i<=end-1;i++){
            if(sequence[i]>root){
                break;
            }
        }
        int j=i;
        for(;j<=end-1;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        boolean left=func(sequence,start,i-1);
        boolean right=func(sequence,i,end-1);
        return (left&&right);
    }
}
