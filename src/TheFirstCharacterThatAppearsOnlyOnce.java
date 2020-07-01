import java.util.HashMap;
import java.util.Map;

//第一个只出现一次的字符
//在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只
// 出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
// （从0开始计数）
public class TheFirstCharacterThatAppearsOnlyOnce {
    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map=new HashMap<>();
        char[] arr=str.toCharArray();
        for(int i=0;i<arr.length;i++){
            int n=map.getOrDefault(arr[i],0);
            map.put(arr[i],n+1);
        }
       int i=0;
        for(;i<arr.length;i++){
            char c=arr[i];
            if(map.get(c)==1){
                return i;
            }
        }
        return -1;
    }
}
