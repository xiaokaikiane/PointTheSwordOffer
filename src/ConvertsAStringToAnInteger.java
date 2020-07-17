//把字符串转化为整数
//将一个字符串转换成一个整数，要求不
//能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
public class ConvertsAStringToAnInteger {
    public int StrToInt(String str) {
        if (str == null)
            return 0;
        int result = 0;
        boolean negative = false;//是否负数
        int i = 0, len = str.length();
        /**  * limit 默认初始化为 负的 最大正整数 ，假如字符串表示的是正数
         * 那么result(在返回之前一直是负数形式)就必须和这个最大正数的负数来比较，
         * * 判断是否溢出
         * */
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;
        if (len > 0) {
            char firstChar = str.charAt(0);//首先看第一位
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;//在负号的情况下，判断溢出的值就变成了 整数的 最小负数了
                } else if (firstChar != '+') {//第一位不是数字和-只能是+
                    return 0;
                }
                if (len == 1) { // Cannot have lone "+" or "-"
                    return 0;
                }
                i++;
            }
            multmin = limit / 10;
            while (i < len) {      // Accumulating negatively avoids surprises near MAX_VALUE
                digit = str.charAt(i++)-'0';//char转int
                if (digit < 0 || digit > 9) {//0到9以外的数字
                    return 0;          //判断溢出
                }
                if (result < multmin) {
                    return 0;
                }
                result *= 10;
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }        //如果是正数就返回-result（result一直是负数）
        return negative ? result : -result;
    }
}