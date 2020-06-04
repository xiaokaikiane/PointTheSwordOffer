//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
// 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
public class AdjustTheArrayOrderSoThatOddNumbersPrecedeEvenNumbers {
    public void reOrderArray(int [] array) {
        int[] arr=new int[array.length];
        int k=0;
        for(int j=0;j<array.length;j++){
            if(array[j]%2==1){
                arr[k]=array[j];
                k++;
            }
        }
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                arr[k]=array[i];
                k++;
            }
        }
      for(int i=0;i<arr.length;i++){
          array[i]=arr[i];
      }
    }
}
