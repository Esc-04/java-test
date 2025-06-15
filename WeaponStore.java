package Map;

import Charactor.Hero;

import java.util.ArrayList;


public class WeaponStore {
    public int item; //무기 번호
    public String name;
    public String lagacy; //각 직업의 고유한 무기
    public int requiredLevel; //구매할수있는 최소 레벨
    public int money;
    ArrayList<WeaponStore> weapon=new ArrayList<>();
    public WeaponStore(int item,String name,String lagacy,int requiredLevel,int money){
        this.item=item;
        this.name=name;
        this.lagacy=lagacy;
        this.requiredLevel=requiredLevel;
        this.money=money;
    }
    public WeaponStore(){
        System.out.println("무기상점에 입장하셨습니다.");
    }
    public void open() {
        weapon.add(new WeaponStore(1,"단검","전사",1,500));
        weapon.add(new WeaponStore(2,"기초마법서","마법사",1,500));
        weapon.add(new WeaponStore(3,"장난감 활","궁수",1,500));
        weapon.add(new WeaponStore(4,"뜨겁게 달군 도끼","전사",3,3000));
        weapon.add(new WeaponStore(5,"전공교과서","마법사",3,3000));
        weapon.add(new WeaponStore(6,"주몽의 활","궁수",3,2500));
        weapon.add(new WeaponStore(7,"아만타디움 칼","전사",5,5500));
        weapon.add(new WeaponStore(8,"전설의 지팡이","마법사",5,6000));
        weapon.add(new WeaponStore(9,"사랑의 큐피트 화살","궁수",5,6000));
        System.out.println("===================================================================");
        System.out.println("1.단검(500/전사)     2.기초마법서(500/마법사)    3.장난감 활(500/궁수)");
        System.out.println();
        System.out.println("============================lv.3이상 구매가능====================================");
        System.out.println("4.뜨겁게 달군 도끼(3000/전사)     5.전공교과서(3000/마법사)   6.주몽의 활(2500/궁수)");
        System.out.println();
        System.out.println("============================lv.5이상 구매가능====================================");
        System.out.println("7.아만타디움 칼(5500/전사)      8.전설의 지팡이(6000/마법사)   9.사랑의 큐피트 화살(6000/궁수)");
        System.out.println("구매하고싶은 무기 번호를 입력하세요");
    }
    public void buy(int num,Hero hero){
        if(num<=0 || num>weapon.size()){
            System.out.println("해당 상품은 존재하지 않습니다.");
            return;
        }
        WeaponStore selected=weapon.get(num-1);

        if(!hero.lagacy.equals(selected.lagacy)){
            System.out.printf("이 무기는 %s만 구매할 수 있다.\n",selected.lagacy);
        }
        else if(hero.level<selected.requiredLevel){
            System.out.printf("이 무기는 최소 %d 레벨이 구매할수있다.\n",selected.requiredLevel);
        }
        else if(hero.money<selected.money){
            System.out.println("돈이 부족합니다");
        }
        else{
            hero.money-=selected.money;
            hero.weapon=selected.item;
            System.out.println(selected.name+"을 구매 완료했습니다.");
        }
    }
}
