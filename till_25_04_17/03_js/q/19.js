for(var i=1; i<=10; i=i+1){
    for(var j=10; j>=i; j=j-1){
        document.write("*");
    }
    document.write("<br>");
}

//역수로 표시하기
// I포문 먼저해서 J포문 시작
// i포문이 1-10까지 돌림
// j값이 10부터 시작하는게 다름
// j>=1 로 
// j=j-1 증감식 --> 10이었는데 9로 바뀜
// 9>=1 트루
// i 2회차에 j포문에서 j>=2 로 바뀜
