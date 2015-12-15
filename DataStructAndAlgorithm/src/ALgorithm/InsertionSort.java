/**
 * 
 */
package ALgorithm;

/**
 * 功能描述：
 * 
 * @author 王世杰
 * @version 1.0, 2015年12月15日 上午10:09:06
 */
public class InsertionSort implements SortAlgorithm {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ALgorithm.SortAlgorithm#sort(int[])
	 */
	@Override
	public void sort(int[] a) {
		int key = 0;
		//
		for (int j = 1, size = a.length; j < size; j++) {
			key = a[j];
			int i = j - 1;
			while (i >= 0 && a[i] > key) {
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = key;
		}
	}

}
