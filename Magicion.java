package Charactor;

public class Magicion extends Hero{
    public Magicion(){
        this.hp=60;
        this.mp=60;
        this.power=10;
        this.defense=10;
        this.lagacy="마법사";
        System.out.println("[System] 마법사가 선택되었습니다");
    }

    public int attack(Monster monster){
        System.out.println("1.지팡이 공격(물리)");
        if(this.level>=2){
            System.out.println("2.번개 마법(MP 공격)");
        }
        if(this.level>3){
            System.out.println("3.화염 마법(MP 공격)");
        }
        if(this.level>5){
            System.out.println("4.침묵 마법걸기");
        }
        int damage;
        System.out.printf("%s의 차례입니다! 공격을 선택하세요 : ",this.name);
        attack_num=in.nextInt();
        if(attack_num==1){
            if(monster.name.equals("너구리")||weapon==2){
                System.out.println("[System] 크리티컬 공격! 효과는 굉장했다!");
                damage=this.level*10+this.power*30;
            }
            else{
            damage=this.level*10+this.power*20;}
        }
        else if(attack_num==2){
            if(mp<5){
                return 0;
            }
            if(monster.name.equals("멧돼지")){
                System.out.println("[화염 마법] 공격은 멧돼지에게 효과적이었다! !");
                damage=100 + (this.level * 20) + (this.power * 60);
            }
            else{
            damage=(this.level * 10) + (this.power * 50);}
            //항상 마나 5감소
            this.mp-=5;
        }
        else if(attack_num==3){
            if(mp<5){
                return 0;
            }
            if(monster.name.equals("살쾡이")||(this.weapon==5&&monster.name.equals("들개"))){
                System.out.println("[번개 마법] 공격은 "+monster.name+"에게 효과적이었다!");
                damage=2 * ((this.level * 10) + (this.power * 50));
            }
            else{
                damage=(this.level * 10) + (this.power * 50);
            }
            this.mp-=5;
        }
        else{
            System.out.println("[System] 침묵 마법을 사용했다!");
            damage=0;
        }
        if(weapon==8){
            damage+=230;
        }
        return damage;
    }
}
