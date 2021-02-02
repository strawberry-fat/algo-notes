/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs ==null || strs.length < 1){
            return "";
        }
        String prefix = strs[0];
        for (int i = 0 ; i < strs.length ; i++){
            prefix = commonPrefix(prefix,strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private static String commonPrefix(String prefix, String str) {
        int minlen = Math.min(prefix.length(),str.length());
        int index = 0 ;
        while(index < minlen && prefix.charAt(index) == str.charAt(index)){
            index ++;
        }
        return prefix.substring(0,index);
    }
}
