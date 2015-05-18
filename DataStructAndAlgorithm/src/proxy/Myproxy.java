package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.regex.Pattern;

public class Myproxy implements InvocationHandler {
	private Object proxied;
    private String regx;
    Pattern pattern; 
	public Myproxy(Object proxied,String regx) {
		this.proxied = proxied;
		this.regx=regx;
		pattern=Pattern.compile(regx);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		boolean matcher = pattern.matcher(methodName).matches();
		if (matcher) {
			System.out.println("\n------the method " + method.getName()+" is good ;begin");
		}
		method.invoke(proxied, args);
		if (matcher) {
			System.out.println("------the method is " + method.getName()+"\n");
		}
		return null;
	}

	/**
	 * 获取目标对象的代理对象
	 * 
	 * @return 代理对象
	 */
	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread()
				.getContextClassLoader(), proxied.getClass().getInterfaces(),
				this);
	}

	public static void main(String[] args) {
		MyworkImpl real = new MyworkImpl();
		String regx="^say.*";
		String regx2="^do.*";
		Myproxy proxy = new Myproxy(real,regx2);
		Mywork2 proxySubject = (Mywork2) proxy.getProxy();
		Mywork proxySubject2 = (Mywork) proxy.getProxy();
		proxySubject.doSomething2();
		proxySubject2.sayhello("datou");
		proxySubject2.doSomething();
		proxySubject2.saybye();

	}

}
