public class XiXueGui {   
    /**  
     * 吸血鬼数字算法  
     * 如：12*60=1260  
     * YangL.  
     */ 
	public void findXiXueGui(){
		 String[] ar_str1 = null, ar_str2;   
	        int sum = 0;   
	        int count=0;
	        int ws=2;
	        int number=(int) Math.pow(10, 2);
	        for (int i = number,maxi=number*10,minNumber=number*maxi,maxNumber=maxi*maxi-1; i <maxi ; i++) {   
	            for (int j = i ; j < maxi; j++) {   
	                int i_val = i * j;   
	                if (i_val < minNumber || i_val >maxNumber)   
	                    continue; // 积小于1000或大于9999排除,继续下一轮环   
	                count++;
	                ar_str1 = String.valueOf(i_val).split("");   
	                ar_str2 = (String.valueOf(i) + String.valueOf(j)).split("");   
	                java.util.Arrays.sort(ar_str1);   
	                java.util.Arrays.sort(ar_str2);   
	                if (java.util.Arrays.equals(ar_str1, ar_str2)) {   
	                    // 排序后比较,为真则找到一组   
	                    sum++;   
	                    System.out.println("第" + sum + "组: " + i + "*" + j + "="   
	                            + i_val);   
	                }   
	            }   
	        }   
	        System.out.println("共找到" + sum + "组吸血鬼数"+"\ncount"+count);
	       
	}
    public static void main(String[] args) {   
       XiXueGui x=new XiXueGui();
       Long begin=System.currentTimeMillis();
       x.findXiXueGui();
       Long end=System.currentTimeMillis();
       System.out.println("总共耗时："+(end-begin)+"ms");

       
    }   
}