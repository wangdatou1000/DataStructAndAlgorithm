package string;
public class BMForSubString {

	public static void main(String[] args) {
		String text = "abcdef";
		String pattern = "bcdf";
		BMForSubString bm = new BMForSubString();
		int index = bm.indexOf(text, pattern);
		System.out.println(index);

	}

	public int indexOf(String text, String pattern) {
		if (text == null || pattern == null)
			return -1;
		final int n = text.length();
		final int m = pattern.length();
		if (m > n||m==0)
			return -1;
		int i = m - 1;
		int j = m - 1;
		final char[] t = text.toCharArray();
		final char[] p = pattern.toCharArray();
		while (j >= 0 && i < n) {
			if (t[i] == p[j]) {
				if (j == 0)
					return i;
				i--;
				j--;
			} else {
				j--;
				if(j<0||t[i] == p[j]){
					i+=m-1-j;
					j=m-1;
				}
			}
		}
		return -1;
	}
}
