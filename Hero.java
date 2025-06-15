package Charactor;
import Map.Mission;
import Map.WeaponStore;

import javax.management.remote.rmi.RMIServerImpl;
import java.util.Scanner;
public class Hero extends Character{
    Scanner in =new Scanner(System.in);
    public int power;
    public int defense;
    public String lagacy;
    public int money=0;
    public int exp=0;
    public int weapon;
    public int attack_num;
    public Mission mission;
    public boolean ismission;
    public Hero(){
        this.level=1;
    }

    public void setName(String name){
        this.name=name;
    }
    public int attack(Monster monster){
        int damage=this.level*10+this.power*30;
        return damage;
    }
    public void attacked(int sum){
        if (this.defense>=sum){
            this.hp=this.hp-0;
        }
        else{
            this.hp=this.hp+this.defense-sum;
        }
    }
    //히어로의 상태창 표시
    public void showInfo(){
        System.out.println("==================================");
        System.out.printf("현재 %s의 이름 : %s\n",this.name,this.name);
        System.out.printf("현재 %s의 레벨 : %d\n",this.name,this.level);
        System.out.printf("현재 %s의 힘 : %d\n",this.name,this.power);
        System.out.printf("현재 %s의 방어력 : %d\n",this.name,this.defense);
        System.out.printf("현재 %s의 HP : %d\n",this.name,this.hp);
        System.out.printf("현재 %s의 MP : %d\n",this.name,this.mp);
        System.out.printf("현재 %s의 경험치 : %d\n",this.name,this.exp);
        System.out.printf("현재 %s의 돈 : %d\n",this.name,this.money);
        System.out.println("===================================");
    }
}
