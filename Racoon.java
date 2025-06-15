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
    public boolean attacked(int sum,Hero hero){
        if (sum==0){
            if(hero.name.equals("전사")&&hero.attack_num==4){
                int val=5+2*(hero.level-1);
                System.out.printf("%s의 방어력이 %d만큼 약해졌다!",val);
                this.defense-=val;
                return false;
            }
            else if((hero.name.equals("마법사") || hero.name.equals("궁수"))&&hero.attack_num==4){
                System.out.printf("%s의 기술로 인해 %s은 1턴 공격을 못한다!",hero.name,this.name);
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
