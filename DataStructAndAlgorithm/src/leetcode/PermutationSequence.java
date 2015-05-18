package leetcode;

import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		String permutation=PermutationSequence.solution(3, 2);
        System.out.println(permutation);
	}
	/*The set [1,2,3,…,n] contains a total of n! unique permutations. 
	By listing and labeling all of the permutations in order,
	We get the following sequence (ie, for n = 3):
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"

	Given n and k, return the kth permutation sequence. 
	Note: Given n will be between 1 and 9 inclusive. 
	1. 首先构造出来一个1 - n 的字符序列 p
	2. 算出k的阶乘是多shao div
	3. 如果k >= div ，那就是返回整个反转的p
	4. 开始以下循环：
	   div /= i; 
	    pos = (k - 1) / div;
	   这两行代码计算得到了pos，可以想一下，这时pos的含义是(k - 1)是div的多shao倍， 只有经历一次完整的div变换，才能使得最高位换上一个新数， 现在经历了pos次，那么就是说第pos的字符被换到了当前最高位。
	   k -= (pos * div) 
	   得到还剩下多shao个计数没有被chǔ理
	   p.erase(p.begin() + pos);
	   因为地pos的元素已经知道会被放到当前最高位（ret当前的末尾），再下个循环chǔ理k的时候这个元素已经不存在了，所以要剔除它。 
	在纸上画一遍1，2，3，4 第10个序列的过程会对这个过程有直观的理解。 
	1，2，3，4  （n = 4, k = 10) 
	第一次循环 
	div /= 4   -> div = 6
	pos = (k - 1) / 6  -> pos = 1
	k -= (pos * div) -> k = 4
	把2 放入 ret，从p剔除2 
	1，3，4     （ret = "2"） 
	第二次循环：
	div /= 3   -> div = 2
	pos = (k - 1) / 2  -> pos = 1
	k -= (pos * div) -> k = 2
	把3 放入 ret，从p剔除3 
	1，4     （ret = "2 3"） 
	第三次循环：
	div /= 2   -> div = 1
	pos = (k - 1) / 2  -> pos = 1
	k -= (pos * div) -> k = 1
	把4 放入 ret，从p剔除1 
	1 （ret= "2 3 4") 
	第四次循环：
	div /= 1  -> div = 1
	pos = (k - 1) / 1  -> pos = 0
	k -= (pos * div) -> k = 1
	把1 放入 ret，从p剔除1 
	ret = "2341" 
	从 “1234” 到 “2341“ ，k = 10 
	1234 -〉2134 ，消耗6次变换
	2134 -> 2314， 消耗2次变换
	2314-> 2341, 消耗1次变换 
	共消耗9次变换，位置从第一个变成第10个，这正是k= 10的要求。 */
    public static String solution(int n,int k){
    	 if(k<1)return null;
    	 int div=1;
    	 char[] pm=new char[n];
    	 List<Character> p=new LinkedList<Character>();
    	 for (int i = 1; i <= n; i++) {
             p.add((char) (i+48));
             pm[i-1]=(char)(i+48);
             div *= i;
         }
    	 int pos;
    	 if(k>div) return new StringBuffer(new String(pm)).reverse().toString();
    	 for(int i=n,j=0;i>0;i--,j++){
    		 div/=i;
    		 pos=(k-1)/div;
    		 k-=pos*div;
    		 pm[j]=p.get(pos);
    		 p.remove(pos);
    	 }
    	return new String(pm);
    }

}
