package ALgorithm;

import java.util.LinkedList;

/**
 * 功能描述：快速排序，合并排序，堆排序
 * 
 * @author 王世杰
 * @version 1.0, 2015年5月22日 上午8:43:24
 */

public class Sortv2 {

	public static void main(String[] args) {
		int a[] = { 3, 2, 1, 9, 4, 8, 99, 33, 25, 22, 10, 9, 100, 44, 11 };
		Sortv2 st = new Sortv2();
		// st.sortByFastSortV2(0, a.length-1, a);
		// st.heapSort(a);
		st.mergeSort(0, a.length - 1, a);
		st.print(a);
	}

	public void sortByFastSort(LinkedList<Integer> a) {

	}

	public void print(int[] a) {
		for (int n = 0, m = a.length; n < m; n++) {
			System.out.print(a[n] + " ");
		}
		System.out.print("\n");
	}

	/**
	 * 功能描述： 快速排序方法2,双指针从头开始比较。
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public void sortByFastSortV2(int left, int right, int[] a) {
		int q, i;
		if (right > left) {
			i = left - 1;
			for (int j = left; j < right; j++) {
				if (a[j] <= a[right]) {
					i++;
					swap(i, j, a);
				}
			}
			swap(i + 1, right, a);

			q = i + 1;
			sortByFastSortV2(left, q - 1, a);
			sortByFastSortV2(q + 1, right, a);
		}

	}

	/**
	 * 
	 * 功能描述：快速排序的方法1,从两头开始，以右边元素为比较对象。
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public void sortByFastSort(int left, int right, int[] a) {
		if (left > right)
			return;

		int temp = a[left];
		int i = left;
		int j = right;

		while (i != j) {
			while (a[j] >= temp && i < j) {
				j--;
			}
			while (a[i] <= temp && i < j) {
				i++;
			}
			if (i < j) {
				swap(i, j, a);
			}

		}
		swap(left, i, a);
		sortByFastSort(i + 1, right, a);
		sortByFastSort(left, i - 1, a);

	}

	/**
	 * 
	 * 功能描述：合并排序
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public void mergeSort(int left, int right, int[] a) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		mergeSort(left, mid, a);
		mergeSort(mid + 1, right, a);
		merge(left, right, mid, a);
		// print(a);
	}

	public void merge(int left, int right, int mid, int[] a) {
		int[] temp = new int[right - left + 1];
		int i = left, j = mid + 1, n = 0;
		while (i <= mid && j <= right) {
			temp[n++] = a[i] <= a[j] ? a[i++] : a[j++];
		}
		for (; i <= mid; temp[n++] = a[i++])
			;
		for (; j <= right; temp[n++] = a[j++])
			;
		for (int off = 0, w = temp.length; off < w; off++) {
			a[left + off] = temp[off];
		}
	}

	/**
	 * 
	 * 功能描述：堆排序
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public void heapSort(int[] a) {
		int n = a.length - 1;
		bulidHeap(a);
		swap(0, n, a);
		for (int m = 0; m < n; m++) {
			heapify(0, n - m - 1, a);
			swap(0, n - m - 1, a);
		}
	}

	public void bulidHeap(int[] a) {
		int n = a.length;
		for (int m = n / 2 - 1; m >= 0; m--) {
			heapify(m, n - 1, a);
		}
	}

	public void heapify(int idx, int max, int[] a) {
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
			swap(idx, largest, a);
			heapify(largest, max, a);
		}
	}

	/**
	 * <p>
	 * Title: swap
	 * </p>
	 * <p>
	 * Description:�������м�����������������Ľ�����ͨ���Ӽ���ʵ��
	 * ע�⣺��a=b��ʱ����н�����������0��������ʼ���ab��ȷ����ж�
	 * </p>
	 * 
	 * @param a
	 * @param b
	 */
	public void swap(int a, int b, int[] array) {
		if (a == b)
			return;
		array[a] = array[a] + array[b];
		array[b] = array[a] - array[b];
		array[a] = array[a] - array[b];
	}

	/**
	 * <p>
	 * Title: swap
	 * </p>
	 * <p>
	 * Description:�������м�����������������Ľ�����ͨ���Ӽ���ʵ��
	 * ע�⣺��a=b��ʱ����н�����������0��������ʼ���ab��ȷ����ж�
	 * </p>
	 * 
	 * @param a
	 * @param b
	 */
	public void swapV2(int a, int b, int[] array) {
		if (a == b)
			return;
		array[a] = array[a] ^ array[b];
		array[b] = array[a] ^ array[b];
		array[a] = array[a] ^ array[b];
	}

}
