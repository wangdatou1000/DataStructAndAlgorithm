/**
 * 
 */
package ALgorithm;

import tools.tools;

/**
 * 功能描述：
 * 
 * @author 王世杰
 * @version 1.0, 2015年12月15日 上午10:30:10
 */
public class TestSort {

	/**
	 * 功能描述：
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public static void main(String[] args) {
		int a[] = tools.getRandomArray(10);
		SortAlgorithm insertionSort = new InsertionSort();
		tools.printArray(a);
		insertionSort.sort(a);
		tools.printArray(a);
	}

}
