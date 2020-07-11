import java.util.ArrayList;

//丑数
//把只包含质因子2、3和5的数称作丑数（Ugly Number）。
// 例如6、8都是丑数，但14不是，因为它包含质因子7。
// 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
public class NumberOfUgly {
    /*
    首先从丑数的定义我们知道，一个丑数的因子只有2,3,5，
    那么丑数p = 2 ^ x * 3 ^ y * 5 ^ z，换句话说一个丑数一定由另一个丑
    数乘以2或者乘以3或者乘以5得到，那么我们从1开始乘以2,3,5，就得到2,3,5三个丑数，
    在从这三个丑数出发乘以2,3,5就得到4，6,10,6，9,15,10,15,25九个丑数，
    我们发现这种方***得到重复的丑数，而且我们题目要求第N个丑数，这样的方法得到的丑数也是无
    序的。那么我们可以维护三个队列：
    （1）丑数数组： 1
    乘以2的队列：2       乘以3的队列：3       乘以5的队列：5
    选择三个队列头最小的数2加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
    （2）丑数数组：1,2
     乘以2的队列：4      乘以3的队列：3，6    乘以5的队列：5，10
     选择三个队列头最小的数3加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
    （3）丑数数组：1,2,3
    乘以2的队列：4,6      乘以3的队列：6,9    乘以5的队列：5,10,15
    选择三个队列头里最小的数4加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
     （4）丑数数组：1,2,3,4
     乘以2的队列：6，8   乘以3的队列：6,9,12   乘以5的队列：5,10,15,20
      选择三个队列头里最小的数5加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
     （5）丑数数组：1,2,3,4,5
     乘以2的队列：6,8,10， 乘以3的队列：6,9,12,15   乘以5的队列：10,15,20,25
     选择三个队列头里最小的数6加入丑数数组，但我们发现，有两个队列头都为6，
     所以我们弹出两个队列头，同时将12,18,30放入三个队列；
     ……………………
     疑问：              1.为什么分三个队列？
     丑数数组里的数一定是有序的，因为我们是从丑数数组里的数乘以2,3,5选出的最小数，一
     定比以前未乘以2,3,5大，同时对于三个队列内部，按先后顺序乘以2,3,5分别放入，
     所以同一个队列内部也是有序的；
      2.为什么比较三个队列头部最小的数放入丑数数组？
       因为三个队列是有序的，所以取出三个头中最小的，等同于找到了三个队列所有数中最小的。
      */
    public int GetUglyNumber_Solution(int index) {
        if(index<7){return index;}
        ArrayList<Integer> list=new ArrayList<>();
        int a2=0,a3=0,a5=0;
        int result=1;
        list.add(result);
        while(list.size()<index){
            int l1=list.get(a2)*2;
            int l2=list.get(a3)*3;
            int l3=list.get(a5)*5;
            int min=Math.min(Math.min(l1,l2),l3);
            list.add(min);
            if(min==l1){a2++;}
            if(min==l2){a3++;}
            if(min==l3){a5++;}
        }
        return list.get(list.size()-1);
    }
}
