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
	 * (non-Javadoc) 最坏复杂度为O（n^2）
	 * 
	 * @see ALgorithm.SortAlgorithm#sort(int[])
	 */
	@Override
	public void sort(int[] a) {
		int key = 0;
		// 从第二个元素开始比较，一直到最后一个元素。
		for (int j = 1, size = a.length; j < size; j++) {
			key = a[j];
			int i = j - 1;
			// 将指定元素与之前的所有元素比较，在适合的位置插入。
			while (i >= 0 && a[i] > key) {
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = key;// 因为while循环中已将i减一，故这里要加一。
		}
	}

}
