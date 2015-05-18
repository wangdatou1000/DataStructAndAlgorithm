package leetcode;

import tools.tools;

/**
 * @ClassName: RemoveDuplicatesFromSortedArray
 * @Description:<h3>一句话功能简述:</h3><br>
 *	<h3>功能详细描述:<h3><br>
 *	<p>
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array A = [1,1,2] ,
 * Your function should return length = 2, and A is now [1,2] . 
 *  </p>
 * @author 		14061734
 * @date 		2014年12月1日 上午9:33:53 
 * @see 		[相关类/方法]（可选）
 * @since 		[产品/模块版本] （可选）
 *  
*/
public class RemoveDuplicatesFromSortedArray {
	
    /**
    * <p>Title: solution</p>
    * <p>Description: 设置两个指针一个遍历一个标记，该方法同样适用于链表的快速排序中</p>
    * @param a
    * @return
    */
    public static int solution (int[] a){
    	/*记得一定要检测边界*/
    	if(a==null||a.length==0)return 0;
    	int length=0;
    	for(int i=1,L=a.length;i<L;i++){
    		if(a[length]!=a[i]){
    			a[++length]=a[i];	
    		}
    	}
    	return length+1;
    }
	public static void main(String[] args) {
		int[] a={1,2,3,3};
		int l=RemoveDuplicatesFromSortedArray.solution(a);
		System.out.println("the length of ok array:"+l);
		tools.printArray(a);
	}
     
}
