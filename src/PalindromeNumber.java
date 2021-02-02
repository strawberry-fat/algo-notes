/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0 ){
           return false;
        }
        String str = Integer.toString(x);
        String str1 = new StringBuffer(str).reverse().toString();
        if (str.equals(str1)){
            return true;
        }
        return false;
    }

    public boolean isPalindrome0(int x) {
        int num=x;
        int temp=0;

        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        //反转数字，对10取余数，获取num的最低位数字，然后tem*10,使得最低位的数字进一位。
        while(num!=0){
            temp=temp*10+num%10;
            num/=10;
        }
        return x==temp;


    }
}
