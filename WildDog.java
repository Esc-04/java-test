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
    public boolean attacked(int sum, Hero hero) {
        if (sum == 0) {
            if (hero.name.equals("전사")&&hero.attack_num==4) {
                System.out.println("이런..!! 들개는 해당 기술이 통하지않는것 같다!");
            } else if((hero.name.equals("마법사")||hero.name.equals("궁수"))&&hero.attack_num==4) {
                System.out.printf("%s의 기술로인해 1턴 공격을 못한다!", hero.name);
                return true;
            }
            else{
                System.out.println("mp가 부족하여 해당 공격을 사용할 수 없습니다. 턴은 넘어갑니다!");
            }
        } else {
            super.attacked(sum, hero);
        }
        return false;
    }
}