function Cat(){	
	/* 속성 또는 프로퍼티들 */
	this.name = "";  // 이름
	this.age = 0;    // 나이
	this.weight = 0; // 몸무게
	this.family = "";    // 종류 (ex. 코리안숏헤어, 페르시아고양이)
	this.color = "";     // 털색
}


// 1. Cat 클래스 객체를 생성하기.
new Cat();

// 2. 변수 kitty 를 선언하고 여기에 위의(1번문제의) Cat 클래스 객체 생성문을 넣기(대입하기).
var kitty = new Cat();



// 3.이 클래스형 변수 kitty 가 가진 name 변수에 "야옹이" 를 넣기( "야옹이" 라고 이름 지어주기)
kitty.name = "야옹이";
kitty.age = 7;
kitty.weight = 100;
kitty.family = "페르시아";
kitty.color = "삼색이";


// 4.위 고양이 이름을 출력하기
document.write(kitty.name);  br();
document.write(kitty.age); br();
document.write(kitty.weight);  br();
document.write(kitty.family);  br();
document.write(kitty.color);  br();


// 문46의 키티에 나머지 값들도 넣어주시고 각각 다 출력

