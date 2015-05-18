package leetcode;

import tools.tools;

/**
 * @ClassName: RemoveDuplicatesFromSortedArrayII
 * @Description:<h3>一句话功能简述:</h3><br> <h3>功能详细描述:<h3><br>
 *                                    <p>
 *                                    Follow up for ”Remove Duplicates”: What if
 *                                    duplicates are allowed at most twice? For
 *                                    example, Given sorted array A =
 *                                    [1,1,1,2,2,3] , Your function should
 *                                    return length = 5, and A is now
 *                                    [1,1,2,2,3]
 *                                    </p>
 * @author 14061734
 * @date 2014年12月1日 上午9:52:34
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 * 
 */
public class RemoveDuplicatesFromSortedArrayII {
	/**
	 * <p>
	 * Title: solution
	 * </p>
	 * <p>
	 * Description: 设置两个指针一个遍历一个标记，该方法同样适用于链表的快速排序中
	 * 需要设置一个变量来标记是否达到重复的个数如果达到不做处理往前走，如果没有达到则执行 去重处理
	 * </p>
	 * 
	 * @param a
	 * @return
	 */
	public static int solution(int[] a) {
		/* 记得一定要检测边界 */
		if (a == null || a.length == 0)
			return 0;
		int length = 0;
		final int MAX = 2;
		int count = 1;
		for (int i = 1, L = a.length; i < L; i++) {
			if (a[length] != a[i]) {
				a[++length] = a[i];
				count = 1;
			} else if (count < MAX) {
				length++;
				count++;
				if (length < i)
					a[length] = a[i];
			}
		}
		return length + 1;
	}

	/**
	 * <p>
	 * Title: solution
	 * </p>
	 * <p>
	 * Description: 设置两个指针一个遍历一个标记，该方法同样适用于链表的快速排序中
	 * 需要设置一个变量来标记是否达到重复的个数如果达到不做处理往前走，如果没有达到则执行 去重处理
	 * </p>
	 * 
	 * @param a
	 * @return
	 */
	public static int solution2(int[] a) {
		/* 记得一定要检测边界 */
		if (a == null) 
			return 0;
		if(a.length <= 2)
			return a.length;
		int index = 2;
		for (int i = 2; i < a.length; i++) {
			if (a[i] != a[index - 2])
				a[index++] = a[i];
		}
		return index;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5, 9 };
		int l = RemoveDuplicatesFromSortedArrayII.solution2(a);
		System.out.println("the length of ok array:s" + l);
		tools.printArray(a);
	}

}
