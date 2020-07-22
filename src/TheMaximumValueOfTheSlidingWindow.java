import java.util.ArrayList;
import java.util.Collections;

//滑动窗口的最大值
//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，
// 如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
// 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
// {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
// {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
public class TheMaximumValueOfTheSlidingWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> result=new ArrayList<>();
        if(size>num.length||num==null||size<=0){
            return result;
        }
        int begin=0;
        int end=size-1;
        while(true){
            if(end==num.length){
                break;
            }
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=begin;i<=end;i++){
                list.add(num[i]);
            }
            Collections.sort(list);
            result.add(list.get(size-1));
            begin++;
            end++;
        }
        return result;
    }
}
