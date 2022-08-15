
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 기본형(Primitive Type) 변수와 참조형(Reference Type) 변수의 차이
		 * - 기본형 변수는 실제값(리터럴)을 저장하며,
		 *   참조형 변수는 실제값이 저장된 인스턴스의 주소값(참조값 = 레퍼런스)을 저장
		 *   
		 * 기본형 변수와 참조형 변수의 값을 복사(전달)할 때 차이점
		 * 1. 기본형 변수의 값을 복사할 경우
		 * 		- 변수에 저장된 실제 값을 복사(전달) = Pass by value
		 * 		- 실제 값을 복사하게 되면 원본 값과 동일한 값이 별도로 생성되어 전달되므로
		 * 		  복사된 값을 변경하더라도 원본 값과 상관이 없기 때문에 원본 값은 변경되지 않는다!
		 * 
		 * 2. 참조형 변수의 값을 복사할 경우
		 * 		- 변수에 저장된 인스턴스 주소값을 복사(전달) = Pass by reference
		 * 		- 주소값을 복사하게 되면 원본값에 저장된 주소와 동일한 주소가 전달되므로
		 * 		  따라서, 한쪽에서 인스턴스에 접근하여 저장된 값을 변경할 경우
		 * 		  동일한 주소값을 참조하는 쪽에도 영향을 받게 된다.
		 * 		  => 즉, 한쪽에서 값을 변경하면 다른쪽의 값도 함께 변경된 효과를 갖는다.
		 * */
		
		int[] a = {1, 2, 3};
		int[] b = a;
		b[2] = 5;
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		
		System.out.println("--------------------------------");
		
		int x = 10;	// 기본형(정수형) 변수 x의 값을 10으로 초기화
		int y = x;	// 기본형 변수 x의 값(실제값 10)을 복사하여 변수 y에 전달
		System.out.println("x = " + x + ", y = " + y);
		
		// 기본형 변수 y의 값을 99로 변경 후 출력
		y = 99;
		System.out.println("x = " + x + ", y = " + y);
		// => 기본형 변수 y의 값을 변경하더라도
		//    원본 데이터 기본형 변수 x의 값은 변경되지 않음
		System.out.println("--------------------------------");
		
		Num n = new Num();
		n.x = 10;
		n.y = n.x;	// 인스턴스 내의 기본형 변수도 값의 복사가 일어남!
		System.out.println("n.x = " + n.x + ", n.y = " + n.y);
		
		n.y = 99;
		System.out.println("n.x = " + n.x + ", n.y = " + n.y);
		// => Num 클래스의 인스턴스 내에 있는 기본형 변수 y의 값을 변경 하더라도
		//    원본 데이터 기본형 변수 x의 값은 변경되지 않음
		System.out.println("--------------------------------");
		
		Num n2 = new Num();
		n2.x = 10;
		n2.y = 10;
		
		Num n3 = n2;	// Num 타입 참조형 변수 n3에 참조형 변수 n2의 값 복사 (=주소값 복사)
		// => 참조형변수 n2가 가리키는 인스턴스 주소값을 n3에 복사(전달) 했으므로
		//    n2와 n3가 가리키는(참조하는) 인스턴스가 동일함
		
		System.out.println("n2.x = " + n2.x + ", n2.y = " + n2.y);
		System.out.println("n3.x = " + n3.x + ", n3.y = " + n3.y);
		// 참조형 변수 n3의 인스턴스 내의 변수 y값을 99로 변경
		n3.y = 99;
		System.out.println("n2.x = " + n2.x + ", n2.y = " + n2.y);
		System.out.println("n3.x = " + n3.x + ", n3.y = " + n3.y);
		// => n2와 n3 모두 하나의 인스턴스를 참조하고 있으므로
		//    한쪽에서 인스턴스 내의 변수값을 변경하면
		//    다른쪽의 인스턴스도 동일하므로 똑같이 변경된 사항이 적용됨!
		System.out.println("====================================");
		
		System.out.println("----- 변경 전 ------");
		MyDate d1 = new MyDate(2022, 8, 9);
		System.out.println(d1);
		
		// MyDate 타입 참조변수 d2선언하고, d1에 저장된 인스턴스 주소를 복사하여 전달
		MyDate d2 = d1;	// 주소값 복사
		System.out.println(d2);
		
		System.out.println("----- 변경 후 ------");
		// 참조변수 d2가 가리키는 인스턴스의 연도를 1999년 으로 변경
		d2.year = 1999;
		// => 동일한 인스턴스를 참조하므로 d2에서 연도를 변경 시 d1의 연도도 변경됨
		System.out.println(d1);
		System.out.println(d2);
		
		System.out.println("------------------------------------");
		
		PassValue pv = new PassValue();
		int xNum = 10;
		System.out.println("changeValue() 메서드 호출 전 xNum : " + xNum);
		pv.changeValue(xNum); // 실제 값의 복사를 통해 값을 전달함
		System.out.println("changeValue() 메서드 변경 후 xNum : " + xNum);
		
		System.out.println("------------------------------------");
		
		Num num = new Num();
		num.x = 10;
		System.out.println("changeReferenceValue() 메서드 호출 전 num.x : " + num.x);
		pv.changeReferenceValue(num);
		System.out.println("changeReferenceValue() 메서드 호출 후 num.x : " + num.x);
		// => 다른 인스턴스 내의 메서드에서
		//    전달받은 참조변수가 가리키는 인스턴스 값을 변경하면
		//    동일한 인스턴스를 참조하는 나 자신도 변경된 값을 적용 받게 됨!
		
		/*
		 * 결론!
		 * 변수 값을 변경하는 경우 '누가' 바꾸는지는 중요하지 않고
		 * '무엇을' 바꾸는지가 중요하다!
		 * => 기본형 변수값을 변경하는 경우 값의 복사로 인해 원본은 영향 없음
		 * => 참조형 변수값을 변경하는 경우 주소값의 복사로 인해 원본도 영향 있음
		 * 
		 * */
		
	}
	
}

class Num {
	int x;	// 기본형 변수 x
	int y;	// 기본형 변수 y
}

class MyDate {
	int year;
	int month;
	int day;
	
	// Alt + Shift + S -> O
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	// Object 클래스에 있는 toString() 메서드 오버라이딩
	// Alt + Shift + S -> V
	@Override
	public String toString() {
		return year + "년 " + month + "월 " + day + "일";
	}
}


class PassValue {
	
	public void changeValue(int x) {
		System.out.println("changeValue() 메서드 변경 전 x : " + x);
		x = 999;
		System.out.println("changeValue() 메서드 변경 후 x : " + x);
	}
	
	public void changeReferenceValue(Num num) {
		System.out.println("changeReferenceValue() 메서드의 변경 전 num.x : " + num.x);
		num.x = 999;
		System.out.println("changeReferenceValue() 메서드의 변경 후 num.x : " + num.x);
	}
	
}







