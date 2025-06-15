package Map;
import java.util.Random;
import Charactor.Monster;
import Charactor.Hero;

public class Mission {
    Random r= new Random();
    String name;
    int count;
    int hunted;
    public boolean complete;
    static String [] monster={"너구리","살쾡이","들개","멧돼지"};
    public Mission(Hero hero){

        this.name=monster[hero.level<=2? r.nextInt(1):r.nextInt(4)];
        this.count=r.nextInt(1,11);
        this.hunted=0;
        this.complete=false;
        System.out.println();
        System.out.printf("<<미션>> %s 몬스터를 %d 마리 잡기\n",name,count);
        System.out.println();
    }
    public void hunt(Monster monster){
        if (monster.name.equals(name)){
            hunted++;
            System.out.printf("[미션 진행도] %s 잡음 %.1f%% 진행\n",name,(hunted/(float)count)*100);
            if (hunted>=count){
                complete=true;
            }
        }
    }
    public void reward(Hero hero){
        System.out.println("미션 성공으로 보상을 수여합니다.");
        hero.level++;
        hero.exp = 0;
        hero.power += 3;
        hero.hp += 50;
        System.out.println(hero.name + "의 레벨이" + hero.level + "이 되었습니다.");
        System.out.println("레벨업 기념으로 돈이 100원 증가하여");
        hero.money += 100;
        System.out.println(hero.money + "원이 되었습니다.");
    }
}
