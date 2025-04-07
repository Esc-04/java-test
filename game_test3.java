package game;

import java.util.Scanner;

public class game_test3 {
	Scanner in = new Scanner(System.in);
	static int hero_level, hero_power, hero_hp, hero_defense, hero_mp, hero_experience, hero_money;
	static int monster_hp, monster_defense, monster_power, monster_mp, monster_level, monster_experience, monster_money;
	static String hero_name, monster_name;

	static void hero_statement() {
		System.out.println("*****************************");
		System.out.println("현재 " + hero_name + "의 레벨:" + hero_level);
		System.out.println("현재 " + hero_name + "의 힘:" + hero_power);
		System.out.println("현재 " + hero_name + "의 방어력:" + hero_defense);
		System.out.println("현재 " + hero_name + "의 HP:" + hero_hp);
		System.out.println("현재 " + hero_name + "의 MP:" + hero_mp);
		System.out.println("현재 " + hero_name + "의 경험치:" + hero_experience);
		System.out.println("현재 " + hero_name + "의 돈:" + hero_money);
		System.out.println("******************************");
	}

	static void hero(int a) {
		switch (a) {
		case 1: {
			hero_level = 1;
			hero_power = 15;
			hero_hp = 80;
			hero_defense = 25;
			hero_mp = 0;
			hero_experience = 0;
			break; // break가 꼭 필요한가?
		}
		case 2: {
			hero_level = 1;
			hero_power = 10;
			hero_hp = 70;
			hero_defense = 25;
			hero_mp = 50;
			hero_experience = 0;
			break;
		}

		}
	}

	static int potionStore_show(int money, int num) {
		System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
		switch (num) {
		case 1:
			if (hero_money > 30) {
				hero_power += 3;
				hero_money -= 30;
				break;
			}
		case 2:
			if (hero_money > 30) {
				hero_defense += 3;
				hero_money -= 30;
				break;
			}
		case 3:
			if (hero_money > 100) {
				hero_experience += 50;
				hero_money -= 100;
				break;
			}
		case 4:
			if (hero_money > 10) {
				hero_hp += 50;
				hero_money -= 10;
				break;
			}
		case 5:
			if (hero_money > 10) {
				hero_mp += 50;
				hero_money -= 10;
				break;
			}
		default:
			System.out.println("머니가 부족합니다.");
			return hero_money;

		}
		;
		System.out.println("구입이 완료되었습니다.");
		return hero_money;

	}

	static int hero_attack() {
		int sum = 0;
		sum = (hero_level * 10) + (hero_power * 30);
		return sum;
	}

	static int hero_magic_attack() {
		int sum = 0;
		sum = (hero_level * 10) + (hero_power * 50);
		hero_mp -= 5;
		return sum;
	}

	static void hero_attacked(int sum) {
		if (hero_defense >= sum) {
			hero_hp = hero_hp - 0;
		} else
			hero_hp = hero_hp + hero_defense - monster_power;
	}

	static int monster_attack() {
		int sum = 0;
		sum = monster_power;
		return sum;
	}

	static void moster_attacked(int sum) {
		if (monster_defense >= sum) {
			monster_hp = monster_hp - 0;
		} else
			monster_hp = monster_hp - sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("영웅의 이름을 입력하세요. :");
		hero_name = in.next();
		System.out.println("이름이 입력되었습니다.");
		System.out.println("1.궁수");
		System.out.println("2.마법사");
		System.out.print("영웅을 선택하세요.");
		hero(in.nextInt());
		System.out.println("게임에 입장하였습니다.");
		hero_statement();
		while (true) {
			System.out.println("1.사냥터");
			System.out.println("2.포션상점");
			System.out.print("입장할 장소를 선택하세요.:");
			int num3 = in.nextInt();
			if (num3 == 1) {
				System.out.println("사냥터에 입장하였습니다.");

				System.out.println("1. 너구리");
				if (hero_level >= 2) {
					System.out.println("2. 살쾡이");
				}
				System.out.print("전투할 상대를 입력하세요. :");
				int num = in.nextInt();
				if (num == 1) {
					monster_name = "너구리";
					monster_hp = 100;
					monster_mp = 0;
					monster_level = 1;
					monster_power = 20;
					monster_defense = 5;
					monster_money = 10;
					monster_experience = 10;
				} else if (num == 2) {
					monster_name = "살쾡이";
					monster_hp = 2000;
					monster_mp = 0;
					monster_level = 5;
					monster_power = 100;
					monster_defense = 20;
					monster_money = 30;
					monster_experience = 50;
				}
				System.out.println(monster_name + "와의 전투를 시작합니다.");
				while (hero_hp > 0 && monster_hp > 0) {
					System.out.println(hero_name + "의 공격입니다.");
					System.out.println("1.쓰러스트");
					System.out.println("2.mp 공격");
					System.out.print("공격 번호를 입력하세요.");
					int num2 = in.nextInt();
					// 유저의 공격
					if (num2 == 1) {
						moster_attacked(hero_attack());
						System.out.println("몬스터의 데미지는" + hero_attack() + "입니다.");
					} else if (num2 == 2) {
						if (hero_mp > 5) {
							int damage = hero_magic_attack(); // 한 번만 호출
							moster_attacked(damage);
							System.out.println("몬스터의 데미지는 " + damage + "입니다.");
						} else {
							System.out.println("mp가 부족하여 해당 공격을 사용할수 없습니다!");
							continue;
						}
					} // 몬스터의 죽음 (조건문)
					if (monster_hp <= 0) {
						System.out.println(monster_name + "가 죽었습니다.");
						hero_experience += monster_experience;
						hero_money += monster_money;
						if ((hero_experience) >= hero_level * 80) {
							hero_level++;
							hero_experience = 0;
							hero_power += 3;
							hero_hp += 50;
							System.out.println(hero_name + "의 레벨이" + hero_level + "이 되었습니다.");
							System.out.println("레벨업 기념으로 돈이 100원 증가하여");
							hero_money += 100;
							System.out.println(hero_money + "원이 되었습니다.");
						}
						hero_statement();
						break;
					}
					System.out.println("몬스터의 공격차례입니다."); // 몬스터의 공격
					hero_attacked(monster_attack());
					System.out.println(hero_name + "의 데미지는" + monster_attack() + "입니다.");
					if (hero_hp <= 0) {
						System.out.println("이런..!!" + hero_name + "가 죽었습니다.");
						hero_hp = 1;
						hero_experience = 0;
						System.out.println(hero_name + "가 부활했습니다.");
						hero_statement();
						break;
					}

				}
			}
			if (num3 == 2) {
				System.out.println("포션 상점에 입장하셨습니다");
				System.out.println("1.힘 증강 포션 (30원)");
				System.out.println("2.방어력 증강 포션 (30원)");
				System.out.println("3.경험치 증강 포션 (100원)");
				System.out.println("4.HP 증강 포션 (10원)");
				System.out.println("5.MP 증강 포션 (10원)");
				System.out.print("원하시는 물건을 입력하세요: ");
				int shop_num = in.nextInt();
				potionStore_show(hero_money, shop_num);
				System.out.println(hero_money + "원 남았습니다.");
				hero_statement();
			}

		}

	}

}
