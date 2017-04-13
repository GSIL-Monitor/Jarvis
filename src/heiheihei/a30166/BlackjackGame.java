package heiheihei.a30166;

import java.util.Scanner;

/**
 * @Description Blackjack Game
 * @Author
 * @Date 2017/4/2
 */
public class BlackjackGame {

	public static final int WINNING_RANK = 21; //获胜目标

	/**
	 * 程序入口
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		BlackjackGame game = new BlackjackGame();
		game.showInfo();
		game.start();
	}

	/**
	 * 游戏开始
	 */
	private void start() {
		Scanner scan = new Scanner(System.in);
		int startMoney = getStartMoney(scan);
		CardSet cardSet = new CardSet(1);
		Player player = new Player(cardSet, scan, startMoney);
		Dealer dealer = new Dealer(cardSet, scan);
		while (true) {
			player.clearCards();
			dealer.clearCards();

			int betMoney = getBetMoney(scan, player);
			if (!player.onStart(betMoney) && ifContinue(scan, player, null, betMoney)) continue;
			if (!player.onPlay(betMoney) && ifContinue(scan, player, null, betMoney)) continue;

			if (!dealer.onStart(betMoney) && ifContinue(scan, player, dealer, betMoney)) continue;
			if (!dealer.onPlay(betMoney) && ifContinue(scan, player, dealer, betMoney)) continue;

			if (ifContinue(scan, player, dealer, betMoney)) continue;
		}
	}

	/**
	 * 显示简介
	 */
	private void showInfo() {
		System.out.println("========================\n   Black Jack Game\n========================\n" +
				"Default setting:\n" +
				" Player number: 1\n Card amount: 1 deck\n H-HEART\n S-SPADE\n D-DIAMOND\n C-CLUB\n" +
				"========================");

	}

	/**
	 * 从控制台获取player初始金钱数
	 *
	 * @param scan
	 * @return 初始金钱数
	 */
	private int getStartMoney(Scanner scan) {
		System.out.print("Input the money player is provided: ");
		while (true) {
			String s = scan.next();
			try {
				int money = Integer.parseInt(s);
				return money;
			} catch (NumberFormatException e) {
				System.out.print("Input is invalid, input again: ");
				continue;
			}
		}
	}

	/**
	 * 从控制台获取player压的钱数
	 *
	 * @param scan
	 * @param player
	 * @return
	 */
	private int getBetMoney(Scanner scan, Player player) {
		System.out.println("-------------------");
		System.out.println("Player's left money: " + player.getMoney());
		System.out.print("Input the money to bet: ");
		while (true) {
			String s = scan.next();
			try {
				int money = Integer.parseInt(s);
				if (money > player.getMoney()) {
					System.out.println("You do not have so much money, bet again.");
					continue;
				}
				return money;
			} catch (NumberFormatException e) {
				System.out.print("Input is invalid, input again: ");
				continue;
			}
		}
	}

	/**
	 * 从控制台获取是否开始新的一轮继续游戏
	 *
	 * @param scan
	 * @param player
	 * @param dealer
	 * @param betMoney 压的钱数
	 * @return
	 */
	private boolean ifContinue(Scanner scan, Player player, Dealer dealer, int betMoney) {
		printResult(player, dealer, betMoney);
		System.out.println("\n\n-------------------");
		System.out.print("Start new turn? y/n ");
		while (true) {
			String s = scan.next();
			switch (s.toLowerCase()) {
				case "y":
					return true;
				case "n":
					System.exit(1);
					return false;
				default:
					System.out.print("Input is invalid, input again: ");
			}
		}
	}

	/**
	 * 打印当前轮结果
	 *
	 * @param player
	 * @param dealer
	 * @param betMoney 压的钱数
	 */
	private void printResult(Player player, Dealer dealer, int betMoney) {
		System.out.println("\n- Result:");
		if (dealer == null) {
			if (player.getResultRank() == WINNING_RANK) {
				player.win(betMoney);
				System.out.println(" Player's rank: " + WINNING_RANK + ", player win.");
			}
			if (player.getResultRank() == -1) {
				player.lose(betMoney);
				System.out.println(" Player's rank goes over 21, player lose.");
			}
		} else {
			switch (dealer.getResultRank()) {
				case WINNING_RANK:
					player.lose(betMoney);
					System.out.println(" Dealer's rank: " + WINNING_RANK + ", player lose.");
					break;
				case -1:
					player.win(betMoney);
					System.out.println(" Dealer's rank goes over 21, player win.");
					break;
				default:
					int playerRank = player.getResultRank();
					int dealerRank = dealer.getResultRank();
					System.out.print(String.format(" Player's rank: %s, Dealer's rank: %s, ", playerRank, dealerRank));
					if (playerRank == dealerRank) {
						System.out.println("tie.");
					}
					if (playerRank > dealerRank) {
						player.win(betMoney);
						System.out.println("player win.");
					}
					if (playerRank < dealerRank) {
						player.lose(betMoney);
						System.out.println("player lose.");
					}
					break;
			}
		}
		System.out.println(" Player current money: " + player.getMoney());
	}


}
