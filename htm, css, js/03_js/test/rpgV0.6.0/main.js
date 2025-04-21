// - 전투 무한 루프 처리 : 전투 시 플레이어나 적의 현재 체력이 0 이하로 될 때까지(죽을때 까지) 전투 반복 처리

var dragon = new Monster("드래곤",100,10);

var elf = new Character();
elf.name = "성모";
elf.hp = 200;
elf.max_hp = 200;
elf.attack = 20;

elf.info();
dragon.info();

hr();
dw("전투시작");
hr();


function proc_battle(){
	var elf_attack = r(elf.attack);
	var dragon_attack = r(dragon.attack);
	
	hr();
	dw("플레이어 데미지:"+elf_attack);
	hr();
	dw("몬스터 데미지:"+dragon_attack);      //누구한테 데미지를 입었는지 까지 나옴옴
	hr();
	
	elf.hp = elf.hp - dragon_attack;		// 1~10 랜덤 뎀
	dragon.hp = dragon.hp - elf_attack;	
	
	elf.info();       //info라는 함수를 넣으면 데이터 출력력
	dragon.info();
}



while(true){
	proc_battle();

	if(elf.hp <= 0 || dragon.hp <= 0){
		break;
	}
}

// while 로 무한루트 걸어줌
// 생명력이 많이 떨어져서 0을 지나 -마이너스로 됬을경우, break를 건다.
