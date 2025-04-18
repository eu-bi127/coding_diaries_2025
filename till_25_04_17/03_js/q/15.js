// 문15	반복문	while	참고탭 참고	prompt 함수를 이용하여 숫자 값을 하나 입력 받기	
// 				숫자가 100이 아니면 숫자를 화면에 (팝업말고) 출력	
// 				숫자가 100이면 while 반복문을 끝내도록 처리	
// "" --> 빈문자의 개념도 있다.
// while에 의도적으로 true를 넣으면 안에있는 것들이 무한루프 돈다. 의도적으로 무한루프 만든다. 
// break;를 만들면 무한루프에서 퇴로를 만들어주는 것이다. 

window.onload = function(){


    var t = document.getElementById("a");

    var s ="";
    
    
    while(true){
    
        s = prompt("값을 입력하세요 :");
        if(s==100){
            break;
        }else{
            t.innerHTML = "마지막 입력값:"+s+"<br>";
        }
    }

}
