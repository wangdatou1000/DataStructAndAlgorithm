package proxy;

public class MyworkImpl implements Mywork,Mywork2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSomething() {
		System.out.println("hello! this is something");
	}

	@Override
	public void sayhello(String hello) {
		System.out.println("hello "+hello);
		
	}

	@Override
	public void saybye() {
		System.out.println("bye ,have a nice day!");
		
	}

	@Override
	public void doSomething2() {
		System.out.println("do something2 of mywork2!");
		
	}

}
