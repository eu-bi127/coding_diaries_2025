//중복 코드 제거 : if문이 반복되어 있는데, 이걸 배열과 반복문을 사용해서 중복을 줄일 수 있다. 

var userNumbers = [p1, p2, p3, p4, p5, p6];
var randomNumbers = [r1, r2, r3, r4, r5, r6]; 

for (var i = 0; i < userNumbers. length; i++) {
    for (var k = 0; j < randomNumbers. length; j++) {
        if (userNumbers[i] == randomNumbers[j]) {
            win++;
        }
    }
}

