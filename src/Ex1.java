
public class Ex1 {

	public static void main(String[] args) {
		
		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1 == str2);
		String str3 = new String("abc");
		String str4 = new String("abc");
		
		// String은 + 연산자를 만나면 상수풀이 아닌 
		// Heap 영역에 새로운 인스턴스가 생성됨
		str1 = str1 + "def";
		String str5 = "abcdef";
		
		System.out.println(str2 == str3);
		System.out.println(str3 == str4);
		System.out.println(str1 == str5);
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str1.equals(str5));
		System.out.println("---------------------------------------");
	
		A a = new A();
		a.name = "홍길동";
		System.out.println(a);
		System.out.println(a.toString());
		
		System.out.println("----------------------");
		C c = new C();
		c.method();
		
	}

}

class A {
	String name;

	@Override
	public String toString() {
		return name;
	}
	
}

class B {
	public void method() {
		System.out.println("B");
	}
}

class C extends B {
	@Override
	public void method() {
		System.out.println("C");
	}
}

















