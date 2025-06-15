package Charactor;

public class Archer extends Hero{
    public Archer(){
        this.hp=80;
        this.mp=0;
        this.power=25;
        this.defense=15;
        this.lagacy="궁수";
        System.out.println("[System] 궁수가 선택되었습니다");
    }
    @Override
    public int attack(Monster monster) {
        System.out.println("1.화살 공격");
        if(this.level>=2){
            System.out.println("2.불화살 공격 (MP공격)");
        }
        if(this.level>3){
            System.out.println("3.화살폭풍 (MP공격)");
        }
        if(this.level>5){
            System.out.println("4.용의 일격");
        }
        int damage;
        System.out.printf("%s의 차례입니다! 공격을 선택하세요 : ", this.name);
        attack_num=in.nextInt();
        if (attack_num== 1) {
            if (monster.name.equals("너구리")||weapon==3) {
                System.out.println("[System] 크리티컬 공격! 효과는 굉장했다!");
                damage = (this.level * 10 + this.power * 40);
            } else {
                damage = this.level * 10 + this.power * 20;
            }
        }
        else if(attack_num==2){
            if(mp<5){
                return 0;
            }
            if(monster.name.equals("멧돼지")){
                System.out.println("[불화살] 공격은 멧돼지에게 효과적이었다!");
                damage=2*((this.level * 10) + (this.power * 40));
            }
            else{
            damage=(this.level * 10) + (this.power * 40);}
            this.mp-=5;
        }
        else if(attack_num==3){
            if(mp<10){
                return 0;
            }
            if(monster.name.equals("살쾡이")||(weapon==6&&monster.name.equals("들개"))){
                System.out.println("[화살폭풍] 공격은"+monster.name+"에게 효과적이었다!");
                damage=2*(level*10+power*50);
            }
            else{damage=(this.level*10)+ (this.power*50);}
            this.mp-=10;
        }
        else{
            if(mp<10){
                return 0;
            }
            System.out.println("<용의 일격>");
            damage=level*30+power*50;
            this.mp-=20;
        }
        if (weapon==9){
            damage+=230;
        };
        return damage;
    }
}
