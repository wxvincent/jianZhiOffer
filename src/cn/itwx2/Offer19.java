package cn.itwx2;

/**
 * 正则表达式匹配
 *
 * @author wang
 */
public class Offer19 {

    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;

        if (str.length == 1 && pattern.length == 1) {
            if (str[0] == pattern[0] || pattern[0] == '.') {
                return true;
            }
        }

        int sIndex = 0;
        int pIndex = 0;
        return matchIndex(str, sIndex, pattern, pIndex);
    }

    private static boolean matchIndex(char[] str, int sIndex, char[] pattern, int pIndex) {
        if (sIndex == str.length && pIndex == pattern.length) return true;
        if (sIndex < str.length && pIndex == pattern.length) return false;

        if (pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*') {
            if ((sIndex != str.length && str[sIndex] == pattern[pIndex]) ||
                    (sIndex != str.length && pattern[pIndex] == '.')) {
                return matchIndex(str, sIndex, pattern, pIndex + 2) ||
                        matchIndex(str, sIndex + 1, pattern, pIndex) ||
                        matchIndex(str, sIndex + 1, pattern, pIndex + 2);
            } else {
                return matchIndex(str, sIndex, pattern, pIndex + 2);
            }
        }

        if ((sIndex != str.length && str[sIndex] == pattern[pIndex]) ||
                (sIndex != str.length && pattern[pIndex] == '.')) {
            return matchIndex(str, sIndex + 1, pattern, pIndex + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        String a = "aaa";
        String pattern = "aa.a";
        boolean match = match(a.toCharArray(), pattern.toCharArray());
        System.out.println(match);
    }

}
