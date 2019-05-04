package cn.itwx1;

/**
 * 替换空格
 * 
 * @author wang
 *
 */
public class Offer5 {

	public static String replaceSpace(String s) {
		if (s == null)
			return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!String.valueOf(s.charAt(i)).equals(" ")) {
				sb.append(s.charAt(i));
			} else {
				sb.append("%20");
			}

		}

		return sb.toString();
	}

}
