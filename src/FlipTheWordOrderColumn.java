import java.util.Arrays;

//翻转单词顺序列
//牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
//同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
//例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
// 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，
// 你能帮助他么？
public class FlipTheWordOrderColumn {
    public String ReverseSentence(String str) {
        String[] arr=str.split(" ");
        String[] array=new String[arr.length];
        int j=0;
        String s="";
        if(str.trim().equals("")){
            return str;
        }
        if(str==null||str.length()==0){
            return s;
        }
        for(int i=arr.length-1;i>=0;i--){
            array[j]=arr[i];
            j++;
        }
        for(int i=0;i<array.length;i++){
            s+=array[i];
            if(i!=array.length-1){
                s+=" ";
            }
        }
        return s;
    }
}
