package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LongestConsecutiveSequence
 * @Description:<h3>一句话功能简述:</h3><br>
 *	<h3>功能详细描述:<h3><br>
 *	<p> Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *	For example, Given [100, 4, 200, 1, 3, 2] , The longest consecutive elements sequence is [1,
 *	2, 3, 4] . Return its length: 4.
 *	Your algorithm should run in O ( n ) complexity.            </p>
 * @author 		14061734
 * @date 		2014年12月1日 下午9:07:05 
 * @see 		[相关类/方法]（可选）
 * @since 		[产品/模块版本] （可选）
 *  
*/
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] a={10,9,8,11,12,200,1,3,4,6,55,2,7};
		int median=LongestConsecutiveSequence.solution(a);
        System.out.println("the Longest Consecutive Sequence is :"+median);

	}
    public static int solution(int[] a){
    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    	int max=0;
    	for(int i : a) {
			if(map.containsKey(i))continue;
			map.put(i, 1);
			if(map.containsKey(i-1)){
               max=mergeCluster(map,i,-1,max);
			}
			if(map.containsKey(i+1)){
				max=mergeCluster(map,i,1,max);
			}
		}
    	return max;
    }
    private static int  mergeCluster(Map<Integer,Integer> map,int i,int lr,int max){	
    	int m=map.get(i+1*lr);
		int n=map.get(i);
		int length=m+n;
		map.put(i-n+1, length);
		map.put(i+m*lr, length);
    	return max>length?max:length;
    }
}
