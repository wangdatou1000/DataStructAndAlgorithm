package leetcode;


/**
 * @ClassName: SearchinRotatedSortedArray
 * @Description:<h3>一句话功能简述:</h3><br>
 *	<h3>功能详细描述:<h3><br>
 *	<p>  Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *	You are given a target value to search. If found in the array return its index, otherwise return -1.
 *	You may assume no duplicate exists in the array.
 *   for solution2:
 *          Follow up for ”Search in Rotated Sorted Array”: What if duplicates are allowed?
			Would this affect the run-time complexity? How and why?
			Write a function to determine if a given target is in the array.</p>
 * @author 		14061734
 * @date 		2014年12月1日 下午3:03:52 
 * @see 		[相关类/方法]（可选）
 * @since 		[产品/模块版本] （可选）
 *  
*/
public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		int target=1;
		int[] a = {2,2,2,2,3,1 };
		int l = SearchinRotatedSortedArray.solution2(a,target);
		System.out.println("the index of target:" + l);
		if(l!=-1){
			System.out.println(a[l]+"---"+target);
		}

	}

	public static int solution(int[] a, int target) {
		if (a == null || a.length == 0)
			return -1;
		int first = 0, last = a.length;
		while (first != last) {
			final int mid = (first + last) / 2;
			if (a[mid] == target)
				return mid;
			if (a[first] < a[mid]) {
				if (a[first] <= target && target < a[mid]) {
					last = mid;
				} else {
					first = mid + 1;
				}
			}else {
				
				if(a[mid]<target&&target<=a[last-1]){
					first=mid+1;
				}else {
					last=mid;
				}
			}

		}
		return -1;
	}
	
	
	/**
	* <p>Title: solution2</p>
	* <p>Description: 
	* 当array中的元素重复时，由该方法解决
	* </p>
	* @param a
	* @param target
	* @return
	*/
	public static int solution2(int[] a, int target) {
		if (a == null || a.length == 0)
			return -1;
		int first = 0, last = a.length;
		while (first != last) {
			final int mid = (first + last) / 2;
			if (a[mid] == target)
				return mid;
			if (a[first] < a[mid]) {
				if (a[first] <= target && target < a[mid]) {
					last = mid;
				} else {
					first = mid + 1;
				}
			} else if(a[first]>a[mid]){

				if (a[mid] < target && target <= a[last - 1]) {
					first = mid + 1;
				} else {
					last = mid;
				}
			}else {
				first++;
			}

		}
		return -1;
	}

}
