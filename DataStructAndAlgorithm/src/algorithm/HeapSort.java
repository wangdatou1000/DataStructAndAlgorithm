/**
 * 
 */
package algorithm;

import tools.tools;

/**
 * 功能描述：
 * 
 * @author 王世杰
 * @version 1.0, 2015年12月15日 上午11:41:56
 */
public class HeapSort implements SortAlgorithm {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ALgorithm.SortAlgorithm#sort(int[])
	 */
	@Override
	public void sort(int[] a) {
		int n = a.length - 1;
		bulidMaxHeap(a);
		tools.swap(0, n, a);
		for (int m = 0; m < n; m++) {
			maxHeapify(0, n - m - 1, a);
			tools.swap(0, n - m - 1, a);
		}
	}

	public void bulidMaxHeap(int[] a) {
		int n = a.length;
		for (int m = n / 2 - 1; m >= 0; m--) {
			maxHeapify(m, n - 1, a);
		}
	}

	public void maxHeapify(int idx, int max, int[] a) {
		// 根节点下标是0，left为1，right为2;
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;
		if (left > max)
			return;

		int largest = 0;
		largest = a[left] > a[idx] ? left : idx;
		if (right <= max && a[right] > a[largest]) {
			largest = right;
		}
		if (largest != idx) {
			tools.swap(idx, largest, a);
			maxHeapify(largest, max, a);
		}
	}

}
