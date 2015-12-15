/**
 * 
 */
package ALgorithm;

/**
 * 功能描述：
 * 
 * @author 王世杰
 * @version 1.0, 2015年12月15日 上午10:57:33
 */
public class MergeSort implements SortAlgorithm {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ALgorithm.SortAlgorithm#sort(int[])
	 */
	@Override
	public void sort(int[] a) {
		// mergeSort方法是作为起动点。
		mergeSort(0, a.length - 1, a);
	}

	/**
	 * 
	 * 功能描述：合并排序
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	private void mergeSort(int left, int right, int[] a) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		mergeSort(left, mid, a);
		mergeSort(mid + 1, right, a);
		merge(left, right, mid, a);
		// print(a);
	}

	private void merge(int left, int right, int mid, int[] a) {
		int[] temp = new int[right - left + 1];
		int i = left, j = mid + 1, n = 0;
		while (i <= mid && j <= right) {
			temp[n++] = a[i] <= a[j] ? a[i++] : a[j++];
		}
		// 下面两个for循环是为了处理剩余的待处理项；
		for (; i <= mid; temp[n++] = a[i++])
			;
		for (; j <= right; temp[n++] = a[j++])
			;
		for (int off = 0, w = temp.length; off < w; off++) {
			a[left + off] = temp[off];
		}
	}
}
