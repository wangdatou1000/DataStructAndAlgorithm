/**
 * 
 */
package ALgorithm;

import tools.tools;

/**
 * 功能描述：
 * 
 * @author 王世杰
 * @version 1.0, 2015年12月15日 下午3:03:29
 */
public class QuickSort implements SortAlgorithm {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ALgorithm.SortAlgorithm#sort(int[])
	 */
	@Override
	public void sort(int[] a) {
		sortByQuickSort(0, a.length - 1, a);
	}

	/**
	 * 
	 * 功能描述：快速排序的方法1,从两头开始，以右边元素为比较对象。
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public void sortByQuickSort(int left, int right, int[] a) {
		if (left > right)
			return;

		int temp = a[left];
		int i = left;
		int j = right;

		while (i != j) {
			while (a[j] > temp && i < j) {
				j--;
			}
			while (a[i] <= temp && i < j) {
				i++;
			}
			if (i < j) {
				tools.swap(i, j, a);
			}

		}
		tools.swap(left, i, a);
		sortByQuickSort(i + 1, right, a);
		sortByQuickSort(left, i - 1, a);

	}

	/**
	 * 功能描述： 快速排序方法2,双指针从头开始比较。
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public void sortByQuickSortV2(int left, int right, int[] a) {
		int q, i;
		if (right > left) {
			i = left - 1;
			// 双指针模式分别为i与j，i指向较小元素的最后一个，j指向较大元素的最后一个的后面一个，即待比较元素；
			// 以最后一个元素right为比较基准，
			for (int j = left; j < right; j++) {
				if (a[j] <= a[right]) {
					i++;// 原本i指向较小元素的最后一个，++后指向较大元素的第一个，
					tools.swap(i, j, a);// 由于j指向的当前元素较小，故交换后，较小元素区间增大1.
				}
			}
			tools.swap(i + 1, right, a);// 将基准元素，插入到两个区间中间，也就是把第一个较大元素和最后一个元素交换

			q = i + 1;
			sortByQuickSortV2(left, q - 1, a);
			sortByQuickSortV2(q + 1, right, a);
		}

	}
}
