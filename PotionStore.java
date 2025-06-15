package Map;

import Charactor.Hero;

public class PotionStore {
            public int item;
            public int value;
            public PotionStore(){
                System.out.println("포션 상점에 입장하셨습니다");
                System.out.println("1.힘 증강 포션 (30원)");
				System.out.println("2.방어력 증강 포션 (30원)");
				System.out.println("3.경험치 증강 포션 (100원)");
				System.out.println("4.HP 증강 포션 (10원)");
				System.out.println("5.MP 증강 포션 (10원)");
                System.out.println("원하시는 물건을 입력하세요.");
            }
            public void buy(int item, Hero hero){
                switch (item) {
                    case 1:
                        if (hero.money >= 30) {
                            hero.power += 3;
                            hero.money -= 30;
                            System.out.println("구입이 완료되었습니다.");
                        } else
                            System.out.println("머니가 부족합니다.");
                        break;
                    case 2:
                        if (hero.money >= 30) {
                            hero.defense += 3;
                            hero.money -= 30;
                            System.out.println("구입이 완료되었습니다.");
                        } else
                            System.out.println("머니가 부족합니다.");
                        break;
                    case 3:
                        if (hero.money>= 100) {
                            hero.exp+= 50;
                            if ((hero.exp) >= hero.level * 80 && !hero.ismission) {
                                hero.mission=new Mission(hero);
                                hero.ismission=true;
                            }
                            hero.money -= 100;
                            System.out.println("구입이 완료되었습니다.");
                        } else
                            System.out.println("머니가 부족합니다.");
                        break;
                    case 4:
                        if (hero.money >= 10) {
                            hero.hp += 50;
                            hero.money -= 10;
                            System.out.println("구입이 완료되었습니다.");
                        } else
                            System.out.println("머니가 부족합니다.");
                        break;
                    case 5:
                        if (hero.money >= 10) {
                            hero.mp += 50;
                            hero.money -= 10;
                            System.out.println("구입이 완료되었습니다.");
                        } else
                            System.out.println("머니가 부족합니다.");
                        break;
                    default:
                        System.out.println("잘못 입력하셨습니다.");

                }
                hero.showInfo();
            }
            }
