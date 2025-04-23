package com.seyo.q3;

public class Calculator {
	
	//두 수의 합을 리턴하는 메서드
	public int add(int a, int b) {
		return a + b;
	}
	
	// 두 수의 차를 리턴하는 메서드
	public int sub(int a, int b) {
		return a - b;
	}
	
	// 두 수의 곱을 리턴하는 메서드
	public int mul(int a, int b) {
		return a * b;
	}
	
	//두 수의 나눗셈을 리턴하는 메서드
	 double div(int a, int b) {
	        if (b == 0) {
	            System.out.println("0으로 나눌 수 없습니다.");
	            return 0;
	        }
	        return (double) a / b;
	    }

	}


//계산기 클래스 만들기
//Calculator 클래스를 만들고, 다음 기능을 메서드로 구현해라.
//add(int a, int b) -> 합 리턴
//sub(int a, int b) -> 차 리턴
//mul(int a, int b) -> 곱 리턴
//div(int a, int b) -> 나눗셈 리턴 (단, b가 0일 경우 "0으로 나눌 수 없습니다" 출력)


//반환값: return 0;은 메서드가 0을 반환하도록함. 이는 나눗셈이 실패했음을 나타냄.
//return 0;  -->0으로 나누게 되면 큰 오류가 뜨기때문에 0이라는 숫자를 내보냄.
//return(double) a / b;
//*double(실수) : 반환 타입 ---> 정수인 a를 넣으면 실수로 변하게 함
//기능:
//먼저, b가 0인지 확인한다. 만약 0이라면 "0으로 나눌 수 있다."라는 메세지를 출력하고 0을 반환한다.
//그렇지 않으면, a를 b로 나눈 결과를 반환한다.
//이때 (double) a를 사용하여 정수 나눗셈이 아닌 실수 나눗셈을 수행함.
//정수 나눗셈 vs 실수 나눗셈: Java에서 두 개의 정수를 나누면 결과도 정수로 반환됩니다. 
//예를 들어, 5 / 2는 2가 됩니다. 이는 소수점 이하를 버리기 때문입니다. 따라서 실수 결과를 얻기 위해서는 적어도 하나의 피연산자가 실수형이어야 합니다.
//형 변환: (double) a는 a를 실수형으로 변환합니다. 이렇게 하면 나눗셈이 실수 나눗셈으로 수행되어 소수점 이하의 값도 포함된 결과를 얻을 수 있습니다.
//결과 반환: return (double) a / b;는 a를 b로 나눈 결과를 반환합니다. 예를 들어, div(8, 2)를 호출하면 8 / 2는 4.0이 됩니다.

	
