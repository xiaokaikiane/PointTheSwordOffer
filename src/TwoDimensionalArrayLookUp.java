//二维数组中的查找
public class TwoDimensionalArrayLookUp {
    public static boolean Find(int target, int[][] array) {
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(array[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Find(3,arr));
    }
}
