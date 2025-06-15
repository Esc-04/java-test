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
    public boolean attacked(int sum,Hero hero) {
        if (sum == 0) {
            if(hero.name.equals("전사")&&hero.attack_num==4){
                System.out.println("%s의 방어력이 약해졌다!");
                this.defense-=10*5*(hero.level-1);
                if(this.defense<0){
                    this.defense=0;
                }
            }
            else if((hero.name.equals("마법사") || hero.name.equals("궁수"))&&hero.attack_num==4){
                System.out.println("이런..!! 살쾡이는 해당 기술이 통하지않는것 같다!");}
            else{
                System.out.println("mp가 부족하여 해당 기술을 사용할수 없습니다! 턴은 넘어갑니다");
            }
        } else {
            super.attacked(sum,hero);
        }
        return false;
    }
}


