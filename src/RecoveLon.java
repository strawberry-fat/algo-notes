/**
 *  整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 */
public class RecoveLon {
    public static void main(String[] args) {

    }
    public  static int reverse(int x) {
        int result = 0;
        int temp = x;
        String str ="";
        try{
            if(x>0){
                while(temp / 10 >=0 && temp!=0){
                    str += (temp%10);
                    temp = temp/10;
                }
                result = Integer.parseInt(str);
            }else{
                temp = Math.abs(x);
                while(temp / 10 >=0 && temp!=0){
                    str += (temp%10);
                    temp = temp/10;
                }
                result = -Integer.parseInt(str);
            }
        }catch (NumberFormatException e){
            result=0;
        }
        return result;
    }
}
