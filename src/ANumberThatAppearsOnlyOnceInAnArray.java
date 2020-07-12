import java.util.HashMap;
import java.util.Map;

//数组中只出现一次的数字
//一个整型数组里除了两个数字之外，
// 其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
public class ANumberThatAppearsOnlyOnceInAnArray {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : array) {
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        }
        int a = 0;
        for (int k : map.keySet()) {
            if (map.get(k) == 1) {
                if (a == 1) {
                    num2[0] = k;
                } else if (a == 0) {
                    num1[0] = k;
                    a++;
                }
            }
        }
    }
}
