function Character(){
	this.name;	// 이름
	this.hp;	// 체력. 생명력
	this.max_hp;	// 체력. 생명력
	this.attack;	// 공격력

	this.exp;	// 경험치
	this.next_exp;	// 필요 경험치

	this.gold;	// 보유금

	this.info = function(){
		dw("["+this.name+"(💖"+this.hp+ " / "+this.max_hp+")]"+"(exp: "+this.exp+"/"+this.next_exp+")"
			+"🍁:"+this.gold
		);
	}
}


