import java.util.ArrayList;
import java.util.List;

//顺时针打印矩阵
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
// 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
public class PrintTheMatrixClockwise {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        int circle=(matrix.length+1)/2;
        int row1=0;
        int row2=matrix.length-1;
        int col1=0;
        int col2=matrix[0].length-1;
        for(int i=0;i<circle;i++){
            for (int j=row1;j<=row2;j++){
                list.add(matrix[j][col1]);
                System.out.println(matrix[j][col1]);
            }
            if (row1!=row2) {
                for (int k = col1 + 1; k < col2; k++) {
                    list.add(matrix[row2][k]);
                    System.out.println(matrix[row2][k]);
                }
                for (int g = row2; g >= row1; g--) {
                    list.add(matrix[g][col2]);
                    System.out.println(matrix[g][col2]);
                }
                for (int z = col2 - 1; z > col1; z--) {
                    list.add(matrix[row1][z]);
                    System.out.println(matrix[row1][z]);
                }
            }
            row1++;
            row2--;
            col1++;
            col2--;
        }
        System.out.println(list);
        return list;
    }
    public static ArrayList<Integer> printMatrix2(int [][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        int circle=(matrix.length+1)/2;
        int row1=0;
        int row2=matrix.length-1;
        int col1=0;
        int col2=matrix[0].length-1;
        for(int i=0;i<circle;i++){
            for (int j=row1;j<=row2;j++){
                list.add(matrix[j][col1]);
                System.out.println(matrix[j][col1]);
            }
            if (row1!=row2) {
                for (int k = col1 + 1; k < col2; k++) {
                    list.add(matrix[row2][k]);
                    System.out.println(matrix[row2][k]);
                }
                for (int g = row2; g >= row1; g--) {
                    list.add(matrix[g][col2]);
                    System.out.println(matrix[g][col2]);
                }
                for (int z = col2 - 1; z > col1; z--) {
                    list.add(matrix[row1][z]);
                    System.out.println(matrix[row1][z]);
                }
            }
            row1++;
            row2--;
            col1++;
            col2--;
        }
        System.out.println(list);
        return list;
    }
//    public static ArrayList<Integer> printMatrix2(int [][] array) {
//        ArrayList<Integer> result = new ArrayList<Integer> ();
//        if(array.length==0) return result;
//        int n = array.length,m = array[0].length;
//        if(m==0) return result;
//        int layers = (Math.min(n,m)-1)/2+1;//这个是层数
//        for(int i=0;i<layers;i++){
//            for(int k = i;k<m-i;k++) result.add(array[i][k]);//左至右
//            for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
//            for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
//            for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
//        }
//        System.out.println(result);
//        return result;
//    }
    public static void main(String[] args) {
        int[][] A={{1,3},{2,4}};
        printMatrix2(A);
    }
}
