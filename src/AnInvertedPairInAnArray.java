//数组中的逆序对
//在数组中的两个数字，如果前面一个数字大于后面的数字，
// 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
// 并将P对1000000007取模的结果输出。 即输出P%1000000007
public class AnInvertedPairInAnArray {
    public int InversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int[] arr=new int[array.length];
        int count=0;
        mersort(array,0,array.length-1,arr,count);
        return count;
    }

    private int mersort(int[] array, int left, int right, int[] arr) {
        int leftcount=0;
        int rightcount=0;
        if(left<right){
            int mid=(left+right)/2;
            leftcount=mersort(array,left,mid,arr);//归并左边
            rightcount=mersort(array,mid+1,right,arr);//归并右边
            func(array,left,mid,right,arr);
        }
        return leftcount+rightcount;
    }

    private int func(int[] array, int left, int mid, int right, int[] arr) {
        int low=left;//左边序列指针
        int high=mid+1;//右边序列指针
        int t=0;//新建数组的下标
        int count=0;
        while(low<=mid&&high<=right){
            if(array[low]>array[high]){
                count++;
                arr[t]=array[high];
                t++;high++;
            }else{
                arr[t]=array[low];
                t++;
                low++;
            }
        }
        while(low<=mid){//右边的元素全部进入新数组
            arr[t]=array[low];
            t++;
            low++;
        }
        while(high<=right){//左边的元素全部进入数组
            arr[t]=array[high];
            t++;
            high++;
        }
    }
}
