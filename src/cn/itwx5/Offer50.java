package cn.itwx5;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 *
 * @author wang
 */
public class Offer50 {

    /**
     * 字符串中第一个只出现一次的字符
     *
     * @param str
     * @return
     */
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        char[] cs = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < cs.length; i++) {
            if (map.get(cs[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
