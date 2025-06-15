package Charactor;

public class WildCat extends Monster{

    public WildCat(Hero hero){
        this.name="살쾡이";
        this.power=100+10*(hero.level-1);
        this.defense=20+3*(hero.level-1);
        this.hp=1000+50*(hero.level-1);
        this.money=50+3*(hero.level-1);
        this.experience=50+3*(hero.level-1);
        this.mp=3+(hero.level-1);
    }
    @Override
    public void attacked(int sum,Hero hero) {
        if (sum == 0) {
            System.out.println("mp가 부족하여 해당 기술을 사용할수 없습니다! 턴은 넘어갑니다");
        } else {
            super.attacked(sum,hero);
        }
    }
}


