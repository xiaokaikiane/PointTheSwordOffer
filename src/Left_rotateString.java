import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//左旋转字符串
//汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
// 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后
// 的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
// 即“XYZdefabc”。是不是很简单？OK，搞定它！
public class Left_rotateString {
    public static String LeftRotateString(String str,int n) {
        LinkedList<String> list1=new LinkedList<>();
        LinkedList<String> list2=new LinkedList<>();
        String s="";
        if(str==null||str.length()==0){
            return s;
        }
        int len=str.length();
        int len1=n%len;
        String[] arr=str.split("");
        for(int i=0;i<arr.length;i++){
            if(i<len1){
                list1.add(arr[i]);
            }else{
                list2.add(arr[i]);
            }
        }
        System.out.println(list1);
        System.out.println(list2);
        for(int i=0;i<len1;i++) {
            list2.add(list1.get(i));
        }
        System.out.println(list1);
        System.out.println(list2);
        for(int i=0;i<len;i++){
            s+=list2.get(i);
        }
        return s;
    }

    public static void main(String[] args) {
        String s="abcdefg";
        System.out.println(LeftRotateString(s,2));
    }
}
