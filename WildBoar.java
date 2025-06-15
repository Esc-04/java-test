package Charactor;

public class WildBoar extends Monster{
    public WildBoar(Hero hero){
        this.name="멧돼지";
        this.power=200+10*(hero.level-1);
        this.defense=50+3*(hero.level-1);
        this.hp=4000+100*(hero.level-1);
        this.money=100+10*(hero.level-1);
        this.experience=200+10*(hero.level-1);
        this.mp=3+(hero.level-1);
    }

    @Override
    public boolean attacked(int sum,Hero hero){
        if(sum==0){
            if(hero.name.equals("전사")&&hero.attack_num==4){
                System.out.println("멧돼지의 방어력이 약해졌다!");
                this.defense-=10+10*(hero.level-1);
                if(this.defense<0){
                    this.defense=0;
                }
            }
            else if ((hero.name.equals("마법사") || hero.name.equals("궁수"))&&hero.attack_num==4){
                System.out.printf("%s의 기술로 인해 %s는 1턴 공격을 못한다!",hero.name,this.name);
                return true;
            }
            else{
                System.out.println("mp가 부족하여 해당 기술을 사용할수 없습니다! 턴은 넘어갑니다");
            }
        }
        else{
            super.attacked(sum,hero);
        }
        return false;
    }

}
