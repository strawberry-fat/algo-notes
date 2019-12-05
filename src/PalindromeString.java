/**
 * 验证回文字符串---未解决
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class PalindromeString {
    public static void main(String[] args) {
        String str = "1a2";
        isPalindrome(str);
    }
    public static  boolean isPalindrome(String s) {
        s = s.toUpperCase();
        char[] chars = s.toCharArray();
        String str="";
        for(int i = 0 ; i < chars.length ; i++){
            if((chars[i] == '0')||
                    (chars[i] - '0' > 0 && chars[i] - 9 <= 0)||
                    (chars[i] - 'a' >= 0 && chars[i] - 'z' <= 0 )||
                    (chars[i] - 'A' >= 0 && chars[i] -'Z' <= 0)){
                str = str+chars[i];
            }
        }

        //java库方法，判读某个字符是字母或数字。
        //Character.isLetterOrDigit(chars[1]);
        char[] chars1 = str.toCharArray();
        for(int i = 0 , j = chars1.length -1 ; i < chars1.length/2 ; i++,j--){
            if(chars1[i] != chars1[j]){
                return false;
            }
        }
        return true;
    }
}
