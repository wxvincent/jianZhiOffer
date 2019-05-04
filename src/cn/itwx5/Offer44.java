package cn.itwx5;

/**
 * 数字序列中某一位的数字
 * 
 * @author wang
 *
 */
public class Offer44 {

	public static int digitAtIndex(int index) {
		if (index < 0)
			return -1;

		int digits = 1;
		while (true) {
			int digitNumbers = countOfNumbersFor(digits);
			int countOfNumbers = digitNumbers * digits;
			if (index < countOfNumbers) {
				return digitAtIndex(index, digits);
			} else {
				index = index - countOfNumbers;
				digits++;
			}
		}
	}

	private static int digitAtIndex(int index, int digits) {
		//对应的数值
        int number = beginNumberFor(digits) + index / digits;
        //从数值右边开始算的位置
        int indexFromRight = digits - index % digits;
        //去除右边的indexFromRight-1个数字
        for (int i = 1; i < indexFromRight; i++)
            number /= 10;
        //求个位数字
        return number % 10;

	}

	private static int beginNumberFor(int digits) {
		if (digits == 1)
			return 0;

		return (int) Math.pow(10, digits - 1);
	}

	/**
	 * digits位数的数字个数
	 * 
	 * @param digits
	 * @return
	 */
	private static int countOfNumbersFor(int digits) {
		if (digits == 1)
			return 10;
		int count = (int) Math.pow(10, digits - 1);
		return 9 * count;
	}

}
