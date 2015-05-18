import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import tools.tools;

public class RandomArray {
	public void processArray(int[] a) {
		if (a == null || a.length == 0)
			return;
		Random r = new Random(System.currentTimeMillis());
		final int L = a.length;
		for (int n = 0; n < L; n++) {
			tools.swap(r.nextInt(L - n), L - n - 1, a);
		}
	}

	public static void main(String[] args) {
		int a[] = { 3, 2, 1, 9, 4, 8, 99, 33, 25, 22, 10, 9, 100, 44, 11 };
		Sort st = new Sort();
		// st.sortByFastSortV2(0, a.length-1, a);
		// st.heapSort(a);
		st.mergeSort(0, a.length - 1, a);
		st.print(a);
		RandomArray r = new RandomArray();
		r.processArray(a);
		tools.printArray(a);
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "value1");
		map.put("2", "value2");
		map.put("3", "value3");

		// //第一种：普遍使用，二次取值
		// System.out.println("通过Map.keySet遍历key和value：");
		// for (String key : map.keySet()) {
		// System.out.println("key= "+ key + " and value= " + map.get(key));
		// }
		// Iterator it2=map.keySet().iterator();
		// while(it2.hasNext()){
		// String sa=(String) it2.next();
		// System.out.println("key="+sa+"value="+map.get(sa));
		// }
		// //第二种
		// System.out.println("通过Map.entrySet使用iterator遍历key和value：");
		// Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		// while (it.hasNext()) {
		// Map.Entry<String, String> entry = it.next();
		// System.out.println("key= " + entry.getKey() + " and value= " +
		// entry.getValue());
		// }
		//
		// //第三种：推荐，尤其是容量大时
		// System.out.println("通过Map.entrySet遍历key和value");
		// for (Map.Entry<String, String> entry : map.entrySet()) {
		// System.out.println("key= " + entry.getKey() + " and value= " +
		// entry.getValue());
		// }
		//
		// //第四种
		// System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
		// for (String v : map.values()) {
		// System.out.println("value= " + v);
		// }
	}

}
