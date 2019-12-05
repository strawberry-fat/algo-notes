import java.util.HashMap;
import java.util.Map;

/**
 *  字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 */
public class FindTheOnlyOfStr {
    public int firstUniqChar(String s) {
        int result = -1;
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i = 0 ; i<chars.length ; i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i],-1);
            }else {
                map.put(chars[i],i);
            }
        }
        for(int i = 0 ; i<chars.length ; i++){
            if(map.get(chars[i])!=-1){
                if(result == -1){
                    result = i;
                }
                result = Math.min(i,result);
            }
        }
        return result;
    }
    //leetcode上的最优解
    public int firstUniqChar1(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // 第一次遍历字符串，将字符串放入map中，字符串中只出现过一次的key对应的val为1。
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //使用map的getOrDefault()方法让只出现过一次的key对应的val为1
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // 第二次遍历，寻找第一个唯一值
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

}
