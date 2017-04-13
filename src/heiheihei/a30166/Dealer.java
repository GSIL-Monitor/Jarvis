package heiheihei.a30166;

import java.util.Scanner;

/**
 * @Description 发牌者
 * @Author
 * @Date 2017/4/2
 */
public class Dealer extends Participator {

	private Scanner scan;

	public Dealer(CardSet cardSet, Scanner scan) {
		super(cardSet);
		this.scan = scan;
	}

	@Override
	public boolean onStart(int bet) {
		System.out.println("-------------------");
		System.out.println(String.format("%s turn starts: ", name));
		addOpenCard(1);
		addCloseCard(1);
		printCards();
		return !ifWin();
	}

	@Override
	public boolean onPlay(int bet) {
		while (getCardSumValue().size() > 0 && getCardSumValue().get(0) < 17) {
			hit();
			printCards();
		}
		if (ifLose()) {
			return false;
		}
		if (ifWin()) {
			return false;
		}
		stay();
		return true;
	}
}
