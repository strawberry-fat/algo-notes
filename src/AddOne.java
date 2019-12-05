/**
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class AddOne {
    public int[] plusOne(int[] digits) {
        int add = 1;
        for(int i = digits.length - 1; i >= 0; i-- ){
            int num = digits[i] + add;
            add = num / 10;
            digits[i] = num % 10;
            if(i == 0 && add == 1){
                digits = new int[digits.length+1];
                digits[0] = 1;
            }
            if(add == 0)
                break;
        }
        return digits;
    }
}
