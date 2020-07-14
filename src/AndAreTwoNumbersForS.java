import java.util.ArrayList;

//和为s的两个数字
//输入一个递增排序的数组和一个数字S，在数组中查找两个数，
//使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
public class AndAreTwoNumbersForS {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list=new ArrayList<>();
        if(array==null||array.length<2){
            return list;
        }
        int i=0;
        int j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;//第一对肯定乘积最小
            }else if(array[i]+array[j]<sum){
                i++;
            }else{
                j--;
            }
        }
        return list;
    }
}
