package Charactor;

public class Warrior extends Hero{
    public Warrior(){
        this.hp=85;
        this.mp=0;
        this.power=15;
        this.defense=25;
        this.lagacy="전사";
        System.out.println("[System] 전사가 선택되었습니다");
    }
    @Override
    public int attack(Monster monster){
        System.out.println("1.쓰러스트");
        if(this.level>=2){
            System.out.println("2.삼단베기(MP공격)");
        }
        if (this.level > 3) {
            System.out.println("3.정의의 심판(MP공격)");
        }
        if(this.level>5){
            System.out.println("4.용맹한 기세");
        }
        System.out.printf("%s의 차례입니다! 공격을 선택하세요 : ",this.name);
        int n,damage;
        attack_num=in.nextInt();
        if(attack_num==1){
            if(monster.name.equals("너구리")||this.weapon==1){
                System.out.println("[System] 크리티컬 공격! 효과는 굉장했다!");
                damage=(this.level*5+this.power*20);
            }
            else{damage=this.level*5+this.power*10;}
        }
        else if(attack_num==2){
            if(mp<5){
                return 0;
            }
            if(monster.name.equals("들개")){
                System.out.println("[삼단베기] 공격은 들개에게 효과적이었다!");
                damage=2*((this.level * 5) + (this.power * 40));
            }
            else{
            damage=(this.level * 10) + (this.power * 20);}
            this.mp-=5;
        }
        else if(attack_num==3){
            if(mp<15){
                return 0;
            }
            if(monster.name.equals("살쾡이")||(this.weapon==4 && monster.name.equals("멧돼지"))){
                System.out.println("[정의의 심판] 공격은 "+monster.name+"에게 효과적이었다!");
                damage=100+((this.level*10)+(this.power*60));
                this.mp-=15;
            }
            else{damage=(this.level*10)+ (this.power*30);
            this.mp-=15;}
        }
        else{
            System.out.println("[System] 용맹한 기세를 사용했다");
            damage=0;
        }
        if (weapon==7){
            damage=damage+200+10*level;
        }
        return damage;
    }

}
