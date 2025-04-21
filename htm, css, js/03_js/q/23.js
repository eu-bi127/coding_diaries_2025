// 문23	for - break	참고탭 참고	
// 1 ~ 10 랜덤값 준비		
// 반복문 1~10 돌면서 1~10 출력		
// 반복 도중 반복용 변수 값( var i ) 이 랜덤값과 일치하는 경우 반복문을 중지	

var r = Math.floor(Math.random() * 10) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
for(var i=1;i<=10;i=i+1){
    
    document.write(i);
    
    if(i == r){
        break;
    }
}

// break는 회차를 중지시키고 빠져나게 하는 개념
// 만얀에 var i 값이 5라면, i == r 변수값과 랜덤값이 5로 일치하는 경우에
// 1~5까지 document로 가서 찍히고 6~10까지는 break당해서 나오지 않음