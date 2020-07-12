import java.util.HashMap;
import java.util.Map;

//数字在排序数组中出现的次数
//统计一个数字在排序数组中出现的次数。
public class TheNumberOfTimesANumberAppearsInASortedArray {
    public int GetNumberOfK(int [] array , int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int a:array){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
        }
        for(Integer a:map.keySet()){
            if(a==k){
                return map.get(a);
            }
        }
        return 0;
    }
}
