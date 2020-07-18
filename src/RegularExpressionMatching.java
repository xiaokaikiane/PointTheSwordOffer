//正则表达式匹配
//请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
// 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
// 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
public class RegularExpressionMatching {
    public boolean match(char[] str, char[] pattern){
        if(pattern==null||str==null){
            return false;
        }
        return match(str,0,pattern,0);
    }

 /* 前提：当pattern遍历完，return取决于str是否遍历完，str恰好遍历完才返回true，再接下来讨论
  *  *  1.若当前字符存在下一个字符，看下一个字符是否是 '*'，如果是，有2种情况
  *  *      一：当前匹配
  *  *      1.1match(str,i + 1,pattern,j)//跳过str
  *  *      1.2match(str,i,pattern,j + 2)//跳过pattern
  *  *      1.3match(str,i + 1,pattern,j + 2)//这一种可以省略，相当于 1.1 + 1.2
  *  *      二：当前不匹配
  *  *      match(str,i,pattern,j + 2)//跳过pattern
  *  * 2.下一个不是 *
  *  *     当前匹配 return match(str,i + 1,pattern,j + 1)
   *  */
    private  boolean match(char[] str, int i, char[] pattern, int j) {
        if(j == pattern.length) {//pattern遍历完了
            return str.length == i;
        }//如果str也完了，返回true，不然false
        // 注意数组越界问题，一下情况都保证数组不越界
        if(j < pattern.length - 1 && pattern[j + 1] == '*') {//下一个是*
            if(str.length != i && //当前匹配
                    (str[i] == pattern[j] || pattern[j] == '.')) { //匹配
                return match(str, i, pattern, j + 2)
                        || match(str, i + 1, pattern, j);
            } else {//当前不匹配
                return match(str, i, pattern, j + 2);
            }
        }       //下一个不是“*”，当前匹配
        if(str.length != i && (str[i] == pattern[j] || pattern[j] == '.')) {
            return match(str, i + 1, pattern, j + 1);
        }
        return false;
    }
}
