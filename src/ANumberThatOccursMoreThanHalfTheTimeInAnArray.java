import java.util.HashMap;
import java.util.Map;

//数组中出现次数超过一半的数字
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
//超过数组长度的一半，因此输出2。如果不存在则输出0
public class ANumberThatOccursMoreThanHalfTheTimeInAnArray {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map=new HashMap<>();
        for(Integer a:array){
            if(!map.containsKey(a)){
                map.put(a,1);
                continue;
            }
            map.put(a,map.get(a)+1);
        }
        for(Integer a:map.keySet()){
            if(map.get(a)>array.length/2){
                return a;
            }
        }
        return 0;
}
}
