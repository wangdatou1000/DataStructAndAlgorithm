package leetcode;

import tools.tools;

/**
 * @ClassName: MedianofTwoSortedArrays
 * @Description:<h3>一句话功能简述:</h3><br>
 *	<h3>功能详细描述:<h3><br>
 *	<p> There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted
 *	arrays. The overall run time complexity should be O (log ( m + n )).            </p>
 * @author 		14061734
 * @date 		2014年12月1日 下午6:02:28 
 * @see 		[相关类/方法]（可选）
 * @since 		[产品/模块版本] （可选）
 *  
*/
public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		int[] a={1};
		int[] b={};
		double median=MedianofTwoSortedArrays.solution2(a, b);
        System.out.println("the median is :"+median);
        double median2=MedianofTwoSortedArrays.solution(a, b);
        System.out.println("the median is :"+median2);
        double median3=MedianofTwoSortedArrays.solution3(a, b);
        System.out.println("the median is :"+median3);
	}
	/*查找元素不需要排序，该解法时间复杂度为O( m + n )，还有刚快的解法时间复杂度可以达到O(log(m+n))*/
    public static double solution(int[] a,int[] b){
    	double median=0;
    	final int length=a.length+b.length;
    	int[] all=new int[length];
    	int i=0,j=0,g=0;
    	while(g<length){
    		if(i<a.length&&j<b.length){
    			all[g++]=a[i]<=b[j]?a[i++]:b[j++];
    		}else if(i<a.length){
    			all[g++]=a[i++];
    		}else if (j<b.length){
    			all[g++]=b[j++];
    		}
    	}
    	int index=length/2;
    	median=(length%2)!=0?all[index]:(all[index-1]+all[index])/2.0;
    	tools.printArray(all);
    	
    	return median;
    }
    /*查找元素不需要排序，该解法时间复杂度为O((m + n)/2)，还有刚快的解法时间复杂度可以达到O(log(m+n))*/
    public static double solution2(int[] a,int[] b){
    	final int length=a.length+b.length;
    	final int index=length/2;
    	int f=0,s=0;
    	int i=0,j=0,g=0,ra=0,rb=0;
    	while(g<length){	
    		if(i<a.length&&j<b.length){
    			if(a[i]<=b[j])
    				{ra=i++;rb=-1;}
    			else 
    				{rb=j++;ra=-1;}
    		}else if(i<a.length){
    		    ra=i++;
    		    rb=-1;
    		}else if (j<b.length){
    			rb=j++;
    			ra=-1;
    		}
    		g++;
    		if(g==index){
    			f=ra!=-1?a[ra]:b[rb];
    			}
    		if(g==index+1){
    			s=ra!=-1?a[ra]:b[rb];
    			break;
    		}
    	}
    	return (length%2)!=0?s:(f+s)/2.0;
    }
    
	/*    这是一道非常经典的题。这题更通用的形式是，给定两个已经排序好的数组，找到两者所有元
	    素中第 k 大的元素。
	    O ( m + n ) 的解法比较直观，直接 merge 两个数组，然后求第 k 大的元素。
	    不过我们仅仅需要第 k 大的元素，是不需要“排序”这么复杂的操作的。可以用一个计数器，
	    记录当前已经找到第 m 大的元素了。同时我们使用两个指针 pA 和 pB，分别指向 A 和 B 数组的第
	    一个元素，使用类似于 merge sort 的原理，如果数组 A 当前元素小，那么 pA++，同时 m++；如果数
	    组 B 当前元素小，那么 pB++，同时 m++。最终当 m 等于 k 的时候，就得到了我们的答案， O ( k ) 时
	    间， O (1) 空间。但是，当 k 很接近 m + n 的时候，这个方法还是 O ( m + n ) 的。
	    有没有更好的方案呢？我们可以考虑从 k 入手。如果我们每次都能够删除一个一定在第 k 大元
	    素之前的元素，那么我们需要进行 k 次。但是如果每次我们都删除一半呢？由于 A 和 B 都是有序
	    的，我们应该充分利用这里面的信息，类似于二分查找，也是充分利用了“有序”。
	    假设 A 和 B 的元素个数都大于 k /2，我们将 A 的第 k /2 个元素（即 A[k/2-1] ）和 B 的第 k /2
	    个元素（即 B[k/2-1] ）进行比较，有以下三种情况（为了简化这里先假设 k 为偶数，所得到的结论
	    对于 k 是奇数也是成立的）：
	    • A[k/2-1] == B[k/2-1]
	    • A[k/2-1] > B[k/2-1]
	    • A[k/2-1] < B[k/2-1]
	    如果 A[k/2-1] < B[k/2-1] ，意味着 A[0] 到 A[k/2-1 的肯定在 A ∪ B 的 top k 元素的范围
	    内，换句话说， A[k/2-1 不可能大于 A ∪ B 的第 k 大元素。留给读者证明。
	    因此，我们可以放心的删除 A 数组的这 k /2 个元素。同理，当 A[k/2-1] > B[k/2-1] 时，可
	    以删除 B 数组的 k /2 个元素。
	    当 A[k/2-1] == B[k/2-1] 时，说明找到了第 k 大的元素，直接返回 A[k/2-1] 或 B[k/2-1]
	    即可。
	    因此，我们可以写一个递归函数。那么函数什么时候应该终止呢？
	    • 当 A 或 B 是空时，直接返回 B[k-1] 或 A[k-1] ；
	    • 当 k=1 是，返回 min(A[0], B[0]) ；
	    • 当 A[k/2-1] == B[k/2-1] 时，返回 A[k/2-1] 或 B[k/2-1]*/
    public static double solution3(int[] a ,int[] b){
    	int total=a.length+b.length;
    	if((total&0x1)==1){
    		return findKth(a,a.length,b,b.length,total/2+1);
    	}else {
    		return (findKth(a,a.length,b,b.length,total/2)+findKth(a,a.length,b,b.length,total/2+1))/2.0;
    	}
    }
    public static double findKth(int[] a,int m ,int[] b,int n,int k){
    	if(m>n) return findKth(b,n,a,m,k);
    	if(m==0) return b[b.length-n+k-1];
    	if(k==1) return a[a.length-m]<b[b.length-n]?a[a.length-m]:b[b.length-n];
    	
    	int ia=k/2<m?k/2:m;int ib=k-ia;
    	if(a[a.length-m+ia-1]<b[b.length-n+ib-1])
    		return findKth(a,m-ia,b,n,k-ia);
    	else if(a[a.length-m+ia-1]>b[b.length-n+ib-1]){
    		return findKth(a,m,b,n-ib,k-ib);
    	}else {
    		return a[a.length-m+ia-1];
    	}
    }
}
