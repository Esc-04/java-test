package Charactor;

public class Racoon extends Monster{
    public Racoon(Hero hero){
        this.name="너구리";
        this.power=20+3*(hero.level-1);
        this.defense=5+3*(hero.level-1);
        this.hp=100+50*(hero.level-1);
        this.money=30+3*(hero.level-1);
        this.experience=10+3*(hero.level-1);
        this.mp=3+(hero.level-1);
    }
    @Override
    public void attacked(int sum,Hero hero){
        if (sum==0){
            System.out.println("mp가 부족하여 해당 기술을 사용할수 없습니다! 턴은 넘어갑니다");
        }
        else{
            super.attacked(sum,hero);
        }
    }

}
