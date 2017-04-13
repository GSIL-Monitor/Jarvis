package heiheihei.a30166;

import java.util.Scanner;

/**
 * @Description 玩家
 * @Author
 * @Date 2017/4/2
 */
public class Player extends Participator {

	private Scanner scan;
	private int money;

	public Player(CardSet cardSet, Scanner scan, int money) {
		super(cardSet);
		this.scan = scan;
		this.money = money;
	}

	@Override
	public boolean onStart(int bet) {
		System.out.println("-------------------");
		System.out.println(String.format("%s turn starts: ", name));
		addOpenCard(2);
		printCards();
		if (ifWin()) {
			return false;
		}
		return !ifWin();
	}

	@Override
	public boolean onPlay(int bet) {
		while (true) {
			System.out.print(" continue hit? y/n ");
			String s = scan.next();
			switch (s.toLowerCase()) {
				case "n":
					stay();
					return true;
				case "y":
					hit();
					printCards();
					if (ifWin()) {
						return false;
					}
					if (ifLose()) {
						return false;
					}
					break;
				default:
					System.out.println(" input is invalid, input again");
			}
		}
	}

	/**
	 * 返回当前玩家还有的金钱数
	 *
	 * @return
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * 玩家赢得bet数量的金钱
	 *
	 * @param bet 押金数
	 */
	public void win(int bet) {
		money += bet;
	}

	/**
	 * 玩家输掉bet数量的金钱，当现有金钱数小于等于0时游戏结束
	 *
	 * @param bet 押金数
	 */
	public void lose(int bet) {
		money -= bet;
		if (money <= 0) {
			System.out.println("Player is out of money, game over.");
			System.exit(1);
		}
	}

}

