//构建乘积数组
//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
// 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
// （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
public class BuildingAProductArray {
    public int[] multiply(int[] A) {
        int[] B=new int[A.length];
        B[0]=1;
        B[B.length-1]=1;
        for(int i=0;i<B.length;i++){
            B[0]*=A[i];
            if(i!=A.length-1){
                B[B.length-1]*=A[i];
            }
            if(i!=0&&i!=B.length-1){
                B[i]=1;
            }
        }
        for(int j=1;j<B.length-1;j++){
            for(int i=0;i<A.length;i++){
                if(i!=j){
                    B[j]*=A[i];
                }
            }
        }
        return B;
    }
}
