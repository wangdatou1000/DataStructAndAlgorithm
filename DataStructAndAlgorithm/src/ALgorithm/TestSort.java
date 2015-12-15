/**
 * 
 */
package ALgorithm;

import java.util.HashMap;

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
		int a[] = { 3, 2, 1, 9, 4, 8, 99, 33, 9, 22, 10, 9, 100, 44, 11 };
		// tools.getRandomArray(2000);
		HashMap<String, SortAlgorithm> sortMap = new HashMap();
		sortMap.put("insertionSort", new InsertionSort());
		sortMap.put("mergeSort", new MergeSort());
		sortMap.put("heapSort", new HeapSort());
		sortMap.put("quickSort", new QuickSort());
		tools.printArray(a);
		// sortMap.get("insertionSort").sort(a);
		// sortMap.get("mergeSort").sort(a);
		sortMap.get("quickSort").sort(a);
		tools.printArray(a);
	}

}
