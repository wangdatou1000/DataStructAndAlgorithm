
public  class NewObject extends NewFather{
    public NewObject(){
    	System.out.println("newobject was born");
    }
	
    public static void main(String[] args) {
    	NewObject a=new NewObject();

	}
}
class NewFather extends NewGrandpa{
	public NewFather(){
		System.out.println("Father was born");
	}
    
}
class NewGrandpa{
	public NewGrandpa(){
		System.out.println("grandpa was born");
	}
}