import java.util.Arrays;

//数组中的逆序对
//在数组中的两个数字，如果前面一个数字大于后面的数字，
// 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
// 并将P对1000000007取模的结果输出。 即输出P%1000000007
public class AnInvertedPairInAnArray {
    public static int InversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int[] arr=new int[array.length];
        int count=mersort(array,0,array.length-1,arr);
        System.out.println(count);
        return count;
    }

    private static int mersort(int[] array, int left, int right, int[] arr) {
        int leftcount=0;
        int rightcount=0;
        int count=0;
        if(left<right){
            int mid=(left+right)/2;
            leftcount=mersort(array,left,mid,arr)%1000000007;//归并左边
            rightcount=mersort(array,mid+1,right,arr)%1000000007;//归并右边
            count=func(array,left,mid,right,arr);
        }
        return (rightcount+leftcount+count)%1000000007;
    }

    private static int func(int[] array, int left, int mid, int right, int[] arr) {
        int low=left;//左边序列指针
        int high=mid+1;//右边序列指针
        int t=0;//新建数组的下标
        int count=0;
        while(low<=mid&&high<=right){
            if(array[low]>array[high]){
                count+=mid-low+1;
                arr[t]=array[high];
                t++;
                high++;
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
        t=0;
        while(left<=right){
            array[left]=arr[t];
            left++;
            t++;
        }
        System.out.println(count);
        return count;
    }
    /*归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，合并数组，
    合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面数组array[i]~array[mid]
    都是大于array[j]的，count += mid+1 - i参考剑指Offer，但是感觉剑指Offer归并过程少了一步拷贝过程
    。还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余*/

    public int InversePairs1(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++){
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);//数值过大求余
        return count;
    }
    private int InversePairsCore(int[] array,int[] copy,int low,int high) {
        if(low==high)
        {
            return 0;
        }
        int mid = (low+high)>>1;
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;
        int count = 0;
        int i=mid;
        int j=high;
        int locCopy = high;
        while(i>=low&&j>mid)
        {
            if(array[i]>array[j])
            {
                count += j-mid;
                copy[locCopy--] = array[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else
            {
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }
    public static void main(String[] args) {
        int[] arr={2,5,1,4,7,10,0};
        InversePairs(arr);
        System.out.println(Arrays.toString(arr));
//        int mid=2;
//        int[] str=new int[arr.length];
//        func(arr,0,mid,arr.length-1,str);
//        System.out.println(Arrays.toString(arr));
    }
}
