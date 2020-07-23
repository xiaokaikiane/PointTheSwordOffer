//剪绳子
//给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
// 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？例如，
// 当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
public class CutTheRope {
    //当n大于等于5时，我们尽可能多的剪长度为3的绳子；当剩下的绳子长度为4时，
    // 把绳子剪成两段长度为2的绳子。 为什么选2，3为最小的子问题？因为2，3包含于各个问题中，
    // 如果再往下剪得话，乘积就会变小。 为什么选长度为3？因为当n≥5时，3(n−3)≥2(n−2)
    public int cutRope(int target) {
        int sum=1;
        if(target>0&&target<=3){
            return target-1;
        }
        while(target>4){
            target-=3;
            sum*=3;
        }
        return sum*target;
    }
}
