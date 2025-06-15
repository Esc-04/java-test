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
    public void attacked(int sum,Hero hero){
        if(sum==0){
            System.out.println("mp가 부족하여 해당 기술을 사용할수 없습니다! 턴은 넘어갑니다");
        }
        else {
            super.attacked(sum, hero);
        }
    }

}
