for(var i=1;i<=10;i=i+1){

    document.write(i);
    if(i%2 == 1){
        document.write("홀수입니다.");
    } else {
        document.write("짝수입니다.");
    }
    hr();
}

//i%2 == 1 는 몫이 0이고, 나머지는 1이다.
// 나머지가 1인것을 봐야한다
// 1 == 1 ---> 홀수 
// 2%2 인 경우 짝수 
