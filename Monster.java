package Charactor;

import java.util.Random;
import java.util.Scanner;

public class Monster extends Character{
    Scanner in =new Scanner(System.in);
    public int power;
    public int defense;
    public int money;
    public int experience;

    public int attack(Hero hero){
        int sum;
        if (hero.level<4){
            sum=this.power;
        }
        else{Random r=new Random();
            int n=r.nextInt(3);
            if (n==0){
                System.out.println("몬스터의 맹렬한 공격!");
                sum=this.power*this.mp;
            }
            else{
                sum=this.power;
            }
        }
        System.out.println("데미지 "+sum+"입니다");
        return sum;
    }
    public boolean attacked(int sum,Hero hero){

            if (this.defense >= sum) {
                System.out.printf("%s의 공격이 통하지않는듯 했다..",hero.name);
            } else {
                this.hp =this.hp+this.defense-sum;
            }
            return false;
        }

}
