package tools;

public class tools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static void printArray(int[] a){
    	if(a==null||a.length==0)return;
    	System.out.print("[");
    	for(int i=0,m=a.length;i<m;i++){
    		System.out.print(a[i]+" ");
    	}
    	System.out.print("]");
    }
    public static void swap(int a, int b,int[] array) {
		if(a==b)return;
		array[a]=array[a]^array[b];
		array[b]=array[a]^array[b];
		array[a]=array[a]^array[b];		
	}
}
