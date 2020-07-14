import java.util.ArrayList;

//和为S的连续正数序列
//小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是
// 100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
// 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
// 你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
public class AndIsASequenceOfConsecutivePositiveNumbersForS {

//1）由于我们要找的是和为S的连续正数序列，因此这个序列是个公差为1的等差数列，而这个序列的
//    中间值代表了平均值的大小。假设序列长度为n，那么这个序列的中间值可以通过（S / n）
//    得到，知道序列的中间值和长度，也就不难求出这段序列了。
//2）满足条件的n分两种情况n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n & 1) == 1 &&
//    sum % n == 0；    n为偶数时，序列中间两个数的平均值是序列的平均值，而这个平均值
//    的小数部分为0.5，所以条件为：(sum % n) * 2 == n.
// 3）由题可知n >= 2，那么n的最大值是多少呢？我们完全可以将n从2到S全部遍历一次，但是
//    大部分遍历是不必要的。为了让n尽可能大，我们让序列从1开始，
//    根据等差数列的求和公式：S = (1 + n) * n / 2，得到.n<根号下2*sum;
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int n=(int)Math.sqrt(2*sum);n>=2;n--){
            if((n&1)==1&&sum%n==0||(sum%n)*2==n){
                ArrayList<Integer> list=new ArrayList<>();
                for(int i=0,k=sum/n-(n-1)/2;i<n;i++,k++){
                    list.add(k);
                }
                result.add(list);
            }
        }
        return result;
    }
}
