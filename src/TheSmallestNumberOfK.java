import java.util.ArrayList;

//最小的K个数
//输入n个整数，找出其中最小的K个数。
//例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
public class TheSmallestNumberOfK {
    public static void swap(int[] array,int i,int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        if(input.length==0||k>0||k>input.length){
            return list;
        }
     int size=input.length;
     creatHeap(input,size);
     for(int i=0;i<k;i++){
         list.add(input[0]);
         swap(input,0,size-1);
         size--;
         creatHeap(input,size);
     }
     return list;
    }
    public static void creatHeap(int[] arr,int size){
        for(int i=(size-2)/2;i>=0;i--){
            heapity(arr,size,i);
        }
    }

    private static void heapity(int[] arr, int size,int index) {
        while(true){
            int left=2*index+1;
            int right=2*index+2;
            if(left>=size){
                return;
            }
            int min=left;
            if(right<size){
                if(arr[right]<arr[left]){
                    min=right;
                }
            }
            if(arr[index]<=arr[min]){
                return;
            }
            swap(arr,index,min);
            index=min;
        }
    }

    public static void main(String[] args) {
        int[]  arr={3,4,2,5,8,9,1};
        System.out.println(GetLeastNumbers_Solution(arr,4));
    }
}
