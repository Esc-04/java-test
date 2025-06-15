package Main;
import Charactor.*;
import Map.Mission;
import Map.PotionStore;
import Map.WeaponStore;

import java.util.Scanner;
//ppt에 넣어야할것
//조건1 추상화하기/클래스 선언
//조건2 Hero클래스 직업 3개 + 직업에 따른 스탯을 다르게 하기 (각각 캡쳐해서 보여드리기 3종류)
//조건3 몬스터 4개 추가하기, 단계별로 높아지는 스탯 구성, (몬스터 선택에 따라 게임이 진행되는 과정을 캡쳐하기)
//조건4 공격 선택 추가하기 //레벨에 따라 공격 선택할수있도록 처리 각각 적합한 공격 매칭
//조건5 클래스 상속 구조
//조건 무기 클래스 /표 설명
//미션 부여과정 추가
public class gameMain {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("*********RPG GAME*********");
        System.out.println("직업을 선택하세요");
        System.out.println("1.전사");
        System.out.println("2.마법사");
        System.out.println("3.궁수");
        int c1;
        Hero h;
        while(0>(c1=in.nextInt()) || (c1>4)){
            System.out.println("올바른 입력이 아닙니다!\n영웅을 다시 선택해주세요 >>");
        }

        if (c1==1){
            h=new Warrior();
        }
        else if(c1==2){
            h=new Magicion();
        }
        else{
            h=new Archer();
        }
        System.out.print("영웅의 이름을 입력하세요 : ");
        h.setName(in.next());
        System.out.println("이름이 입력되었습니다.");
        h.showInfo();
        System.out.println("게임에 입장하였습니다.");
        while(true){
            System.out.println("1.사냥터");
            System.out.println("2.포션상점");
            System.out.println("3.무기상점");
            System.out.println("4.현재 상태보기");
            System.out.print("입장할 장소를 선택하세요.:");
            int place = in.nextInt();
            if(place==1){
                System.out.println("사냥터에 입장하였습니다.");
                Monster m;
                System.out.println("1. 너구리");
                System.out.println("2. 살쾡이");
                System.out.println("3. 들개");
                System.out.println("4. 맷돼지");
                System.out.print("전투할 상대를 입력하세요. :");
                int c2;
                while(0>(c2=in.nextInt()) || (c2>4)){
                    System.out.println("올바른 입력이 아닙니다!\n몬스터를 다시 선택해주세요 >>");
                }
                m = switch (c2) {
                    case 1 -> new Racoon(h);
                    case 2 -> new WildCat(h);
                    case 3 -> new WildDog(h);
                    case 4 -> new WildBoar(h);
                    default -> new Racoon(h);
                };
                while (h.hp > 0 && m.hp > 0) {
                    int damage=h.attack(m);
                    System.out.println("데미지는 "+damage+"이다.");
                    m.attacked(damage,h);
                     // 몬스터의 죽음 (조건문)
                    if (m.hp<= 0) {
                        System.out.println(m.name + "가 죽었습니다.");
                        h.exp += m.experience;
                        h.money += m.money;
                        if (h.ismission){
                            h.mission.hunt(m);
                            if (h.mission.complete){
                                h.mission.reward(h);
                                h.ismission=false;
                            }
                        }
                        if ((h.exp) >= h.level * 80 && !h.ismission) {
                            h.mission=new Mission(h);
                            h.ismission=true;
                        }
                        break;
                    }
                    System.out.println("몬스터의 공격차례입니다."); // 몬스터의 공격
                    damage=m.attack(h);
                    h.attacked(damage);

                    if (h.hp<= 0) {
                        System.out.println("이런..!!" + h.name+ "가 죽었습니다.");
                        h.hp = 1;
                        h.exp= 0;
                        System.out.println(h.name + "가 부활했습니다.");
                        h.showInfo();
                        break;
                    }

                }
            }
            else if(place==2){
                PotionStore p=new PotionStore();
                p.buy(in.nextInt(),h);
            }
            else if(place==3){
                WeaponStore w=new WeaponStore();
                w.open();
                w.buy(in.nextInt(),h);
            }
            else if (place==4){
                h.showInfo();
            }
            }

    }
}
