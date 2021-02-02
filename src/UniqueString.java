import java.util.HashMap;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * https://leetcode-cn.com/problems/is-unique-lcci/
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 *
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 */
public class UniqueString {
    public boolean isUnique(String astr) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0 ; i< astr.length() ; i++){
            if(map.containsKey(astr.charAt(i))){
                return false;
            }else {
                map.put(astr.charAt(i),1);
            }
        }
        return true;
    }
}
