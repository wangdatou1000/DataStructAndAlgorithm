
/**
 * @ClassName: Equals_Hashcode
 * @Description:<h3>一句话功能简述:</h3><br>
 *	<h3>功能详细描述:<h3><br>
 *	<p>说明==、equals、hashcode的区别   
 *	c++运算符是可以重载的          </p>
 * @author 		14061734
 * @date 		2014年11月27日 上午9:48:02 
 * @see 		[相关类/方法]（可选）
 * @since 		[产品/模块版本] （可选）
 *  
*/
public class Equals_Hashcode {

	public static void main(String[] args) {
		
		Equals_Hashcode.test3();
		
		String a=new String("a");
		String b=new String(a);
		char[] ac=getchar();
		char[] bc=ac;
		ac[0]=40;
		System.out.println(bc[0]+"--"+ac[0]);
		
	}
	public static char[] getchar(){
		char[] a=new char[1];
		a[0]=48;
		return a;
	}
	public static String getA(){return "a";}
    public static void test(){
    	String a="a";
    	final String c="a";
    	String b=a+"b";
    	String d=c+"b";
    	String e=getA()+"b";  
    	String compare="ab";
    	b.equals(compare);
    	System.out.println((b==compare)+"- -"+b.equals(compare));
    	System.out.println(d==compare);
    	System.out.println(e==compare);
    	
    }
    public static void test2(){
    	String a="a";
    	String b=a+"b";
    	String d="ab";
    	String e=new String(b);
    	String f=new String(d);
    	final String  fn="a";
    	String m=fn+"b";
    	String compare="ab";
    	System.out.println(b==compare);
    	System.out.println(e==compare);
    	System.out.println(f==compare);
    	System.out.println(b.intern()==compare);
    	System.out.println(e.intern()==compare);
    	System.out.println(f.intern()==compare.intern());
    	System.out.println(d==compare);
    	
    }
    
    public static void test3(){
    	 System.out.println("integer test");
    	Integer i1=new Integer(1);
    	   Integer i2=new Integer(1);
    	//i1,i2分别位于堆中不同的内存空间

    	   System.out.println(i1==i2);//输出false


    	   Integer i3=1;
    	   Integer i4=1;
    	//i3,i4指向常量池中同一个内存空间

    	   System.out.println(i3==i4);//输出true

    	//很显然，i1,i3位于不同的内存空间

    	System.out.println(i1==i3);//输出false

    	}
}
