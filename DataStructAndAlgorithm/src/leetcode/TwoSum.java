package leetcode;

import java.util.HashMap;
import java.util.Map;

import tools.tools;

public class TwoSum {

	public static void main(String[] args) {
		int[] a={1,4,3,10};
		int target=11;
		int[] l=TwoSum.solution(a,target);
		System.out.println("the index of target :"+target);
		tools.printArray(l);
	}
    public static int[] solution(int[] a,int target){
    	Map<Integer, Integer> map =new HashMap<Integer, Integer>();
    	int[] result=new int[2];
    	for(int i=0,m=a.length;i<m;i++){
    		map.put(a[i], i);
    	}
    	for(int i=0,m=a.length;i<m;i++){
    		int temp=target-a[i];
    		if(map.containsKey(temp)&&i<map.get(temp)){
    			result[0]=i;
    			result[1]=map.get(temp);
    			break;
    		}
    	}
    
    	return result;
    }
}
