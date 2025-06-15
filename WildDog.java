package Charactor;


public class WildDog extends Monster {
    public WildDog(Hero hero) {
        this.name = "들개";
        this.power = 150 + 10 * (hero.level - 1);
        this.defense = 40 + 3 * (hero.level - 1);
        this.hp = 3000 + 100 * (hero.level - 1);
        this.money = 50 + 10 * (hero.level - 1);
        this.experience = 100 + 10 * (hero.level - 1);
        this.mp = 3+ (hero.level - 1);
    }


    @Override
    public void attacked(int sum, Hero hero) {
        if (sum == 0) {
            System.out.println("mp가 부족하여 해당 공격을 사용할 수 없습니다. 턴은 넘어갑니다!");
        } else {
            super.attacked(sum, hero);
        }
    }
}