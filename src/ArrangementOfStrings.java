
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//字符串的排列
//输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
//则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
public class ArrangementOfStrings {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list=new ArrayList<>();
        if(str.isEmpty()){
            return list;
        }
        Set<String> ret=new HashSet<>();
        func(0,str.toCharArray(),ret);
        for(String s:ret){
            list.add(s);
        }
        Collections.sort(list);
        return list;
    }
    public static void func(int index, char[] s, Set<String> ret){
        if(index+1==s.length){
             String s1="";
             for(int i=0;i<s.length;i++){
                 s1+=s[i];
             }
            ret.add(s1);
            return;
        }
        for(int i=index;i<s.length;i++){
            char temp=s[index];
            s[index]=s[i];
            s[i]=temp;
            func(index+1,s,ret);
            char temp1=s[index];
            s[index]=s[i];
            s[i]=temp1;
        }
    }
    public static void main(String[] args) {
        String str="abc";
        System.out.println(Permutation(str));
    }
}
