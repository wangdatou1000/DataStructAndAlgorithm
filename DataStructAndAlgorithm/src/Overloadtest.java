
public class Overloadtest {
    public  int a=0;
    public   int getA(){
    	return a;    }
	public static void main(String[] args) {
		Overloadtest f=new b();
		System.out.println(f.getA()+"---"+f.a);
		b cf=(b)f;
		System.out.println(cf.getA()+"---"+cf.a);
		b c=new b();
		System.out.println(c.getA()+"---"+c.a);

	}

}
class b extends Overloadtest{
	public  int a=1;
	public  int getA(){
		return a;
	}
}