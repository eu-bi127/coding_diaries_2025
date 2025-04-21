var goblin = new Monster("고블린", 100, 10);
var elf = new Character("엘프", 200, 30);

displayCharactersInfo();

hr();
dw("전투 시작")
hr();

var loop = ture;
while (loop) {
    loop = procBattleTurn();
}


function procBattleTurn() {
    var monsterDamage = getRandomAttackValue(goblin.attack);
    var playerDamage = getRandomAttackValue(elf.attack);

    goblin.currentHp = goblin.currentHp - playerDamage;
    dw(elf.name + "가" + goblin.name + "에게 데미지를" + playerDamage + "입혔습니다.<br>");
    elf.currentHp = elf.currentHp - monsterDamage;
    dw(goblin.name + "가" + elf.name + "에게 데미지를" + monsterDamage + "입혔습니다.<br>");



    if(elf.currentHp <= 0 || goblin.currentHp <= 0){
        endBattle();
        displayCharactersInfo();
        return false;
    } else {
        displayCharactersInfo();
        return true;
    }

}

function getRandomAttackValue(attack){
    attack = attack + 1;
    var random = Math.floor(Math.random()*attack);
    return random;
}

function endBattle(){
    dw("전투 종료");
    br();
    elf.exp = elf.exp + goblin.exp;
}

function displayCharactersInfo(){
    hr();
    elf.info();
    goblin.info();
    hr();
}