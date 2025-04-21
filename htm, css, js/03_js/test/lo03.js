// 2. 내가 한 게임을 구매했다고 가정하고		

// 컴퓨터의 6개의 숫자랑 내꺼랑 비교해서 몇개가 일치하는 지 세어 출력하기					 ex. 3개 일치	


// 내 번호들
var p1 = 1;
var p2 = 2;
var p3 = 3;
var p4 = 4;
var p5 = 5;
var p6 = 6;

// 랜덤 번호들
var r1 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r1);
document.write("<br>");

var r2 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r2);
document.write("<br>");

var r3 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r3);
document.write("<br>");

var r4 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r4);
document.write("<br>");

var r5 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r5);
document.write("<br>");

var r6 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r6);
document.write("<br>");



//todo:
// 컴퓨터의 6개의 숫자랑 내꺼랑 비교해서 몇개가 일치하는 지 세어 출력하기					 ex. 3개 일치	
// p1 ~ p6


var win = 0;    //내가 맞춘 수 // win변수는 일치하는 숫자의 개수를 세기 위해 초기화합니다. 처음에는 0으로 설정되어 있다.

if(p1 == r1){               // p1이 r1과 같으면 win의 값을 1증가 시킴. 이와 같은 방식으로 p1은 r1~r6까지 각각 비교됨.
    win = win + 1;
}
if(p1 == r2){
    win = win + 1;
}
if(p1 == r3){
    win = win + 1;
}
if(p1 == r4){
    win = win + 1;
}
if(p1 == r5){
    win = win + 1;
}
if(p1 == r6){
    win = win + 1;
}


if(p2 == r1){
    win = win + 1;
}
if(p2 == r2){
    win = win + 1;
}
if(p2 == r3){
    win = win + 1;
}
if(p2 == r4){
    win = win + 1;
}
if(p2 == r5){
    win = win + 1;
}
if(p2 == r6){
    win = win + 1;
}

//3

if(p3 == r1){
    win = win + 1;
}
if(p3 == r2){
    win = win + 1;
}
if(p3 == r3){
    win = win + 1;
}
if(p3 == r4){
    win = win + 1;
}
if(p3 == r5){
    win = win + 1;
}
if(p3 == r6){
    win = win + 1;
}

//4

if(p4 == r1){
    win = win + 1;
}
if(p4 == r2){
    win = win + 1;
}
if(p4 == r3){
    win = win + 1;
}
if(p4 == r4){
    win = win + 1;
}
if(p4 == r5){
    win = win + 1;
}
if(p4 == r6){
    win = win + 1;
}

//5

if(p5 == r1){
    win = win + 1;
}
if(p5 == r2){
    win = win + 1;
}
if(p5 == r3){
    win = win + 1;
}
if(p5 == r4){
    win = win + 1;
}
if(p5 == r5){
    win = win + 1;
}
if(p5 == r6){
    win = win + 1;
}

//6

if(p6 == r1){
    win = win + 1;
}
if(p6 == r2){
    win = win + 1;
}
if(p6 == r3){
    win = win + 1;
}
if(p6 == r4){
    win = win + 1;
}
if(p6 == r5){
    win = win + 1;
}
if(p6 == r6){
    win = win + 1;
}

document.write("win:"+win); 
// 모든 비교가 끝난 후, 일치하는 숫자의 개수를 win변수에 저장하고, 이를 웹 페이지에 출력함.
// 예를 들어, 사용자가 선택한 숫자 중 3개가 랜덤 숫자와 일치하면 "win3"이 출력됨.



