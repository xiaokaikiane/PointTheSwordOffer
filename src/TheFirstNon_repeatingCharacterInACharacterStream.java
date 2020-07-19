
import java.util.LinkedHashMap;
import java.util.Map;


//字符流中第一个不重复的字符
//请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
// 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
public class TheFirstNon_repeatingCharacterInACharacterStream {
    Map<Character,Integer> map=new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
       int k=map.getOrDefault(ch,0);
       map.put(ch,k+1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for(char c:map.keySet()){
            if(map.get(c)==1){
                    return c;
            }
        }
        return '#';
    }
}
