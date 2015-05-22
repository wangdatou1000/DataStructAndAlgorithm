package string;

public class KMPForSubString {
	private int[] next;

	public int[] getNext(String s) {
		char[] p = s.toCharArray();
		int[] next = new int[s.length()];
		int j = -1, i = 0;
		next[i] = j;
		while (i < s.length() - 1) {
			// 这个递归是关键
			while (j >= 0 && p[i] != p[j]) {
				j = next[j];
			}
			i++;
			j++;
			next[i] = j;
		}
		return next;
	}

	public int indexOf(String text, String pattern) {
		if (text == null || pattern == null)
			return -1;
		final int n = text.length();
		final int m = pattern.length();
		if (m > n || m == 0)
			return -1;

		char[] t = text.toCharArray();
		char[] p = pattern.toCharArray();

		int i = 0, j = 0;
		final int[] next = getNext(pattern);
		while (i < n && j < m) {
			while (j >= 0 && t[i] != p[j])
				j = next[j];
			i++;
			j++;
		}

		return j == m ? (i - j) : -1;

	}

	public int myindexOf(String text, String pattern) {
		if (text == null || pattern == null)
			return -1;
		final int n = text.length();
		final int m = pattern.length();
		if (m > n || m == 0)
			return -1;
		char[] source = text.toCharArray();
		char[] target = pattern.toCharArray();
		int sourceOffset = 0, sourceCount = source.length, targetOffset = 0, targetCount = target.length;
		int fromIndex = 0;
		if (fromIndex >= sourceCount) {
			return (targetCount == 0 ? sourceCount : -1);
		}
		if (fromIndex < 0) {
			fromIndex = 0;
		}
		if (targetCount == 0) {
			return fromIndex;
		}

		char first = target[targetOffset];
		int max = sourceOffset + (sourceCount - targetCount);

		for (int i = sourceOffset + fromIndex; i <= max; i++) {
			/* Look for first character. */
			if (source[i] != first) {
				while (++i <= max && source[i] != first)
					;
			}

			/* Found first character, now look at the rest of v2 */
			if (i <= max) {
				int j = i + 1;
				int end = j + targetCount - 1;
				for (int k = targetOffset + 1; j < end && source[j] == target[k]; j++, k++)
					;

				if (j == end) {
					/* Found whole string. */
					return i - sourceOffset;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String text = "dabcdrwngwangdatouwangdatoudatrw,,,"
				+ "sdfsdfsfsfswewoiiioiiiieuuwiasfsaaskfwioewrwrwrwangatouskfwandotulkwan"
				+ "gdkasskfwangdatouaaxcvxvzxvxzvxcvxvzxvcxzcvxzvcxzvxzvcxzcvxzvcxcvxzcvxzcvzxvxcvxcvxcvxcvxcvxcvxvcxvcxcvxcvxzcvxzvzxvxzvvxzcvxzvcxzcvxzcv"
				+ "xvcxcvxvcxzvxcvxvcxvcsdfdfdgsdfgdfgdfgdgdgfbfgggferewewet";
		String pattern = "wangqs";
		KMPForSubString sub = new KMPForSubString();

		SundayForSubString sd = new SundayForSubString();
		BMForSubString bm = new BMForSubString();
		int bmindex = 0, sunday = 0, kmp = 0, index = 0, myindex = 0;
		int max = 10000000;

		Long a = System.currentTimeMillis();
		for (int i = 0; i < max; i++) {
			bmindex = bm.indexOf(text, pattern);
		}
		Long b = System.currentTimeMillis();
		System.out.println("bm:" + (b - a));

		a = System.currentTimeMillis();
		for (int i = 0; i < max; i++) {
			myindex = sub.myindexOf(text, pattern);
		}
		b = System.currentTimeMillis();
		System.out.println("myindexof:" + (b - a));

		a = System.currentTimeMillis();
		for (int i = 0; i < max; i++) {
			sunday = sd.indexOf(text, pattern);
		}
		b = System.currentTimeMillis();
		System.out.println("sunday:" + (b - a));

		a = System.currentTimeMillis();
		for (int i = 0; i < max; i++) {
			kmp = sub.indexOf(text, pattern);
		}
		b = System.currentTimeMillis();
		System.out.println("KMP:" + (b - a));

		a = System.currentTimeMillis();
		for (int i = 0; i < max; i++) {
			index = text.indexOf(pattern);
		}
		b = System.currentTimeMillis();
		System.out.println("index:" + (b - a));

		System.out.println(kmp + "\t" + sunday + "\t" + bmindex + "\t" + index + "\t" + myindex);
	}

}
