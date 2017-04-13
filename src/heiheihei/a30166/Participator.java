package heiheihei.a30166;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 参与者的抽象类，实例化的类为Player和Dealer
 * @Author
 * @Date 2017/4/2
 */
public abstract class Participator {

	private List<Card> openCards;
	private List<Card> closeCards;
	private int baseRank;
	private int resultRank;
	private CardSet cardSet;
	public String name;

	public Participator(CardSet cardSet) {
		this.openCards = new ArrayList<>();
		this.closeCards = new ArrayList<>();
		this.cardSet = cardSet;
		this.name = getClass().getSimpleName();
	}

	/**
	 * 开始游戏，发牌
	 *
	 * @param bet 押金数
	 * @return true-继续游戏 false-游戏结束
	 */
	public abstract boolean onStart(int bet);

	/**
	 * 进行游戏的hit部分
	 *
	 * @param bet 押金数
	 * @return true-继续游戏 false-游戏结束
	 */
	public abstract boolean onPlay(int bet);

	/**
	 * 发牌面向上的牌
	 *
	 * @param num 牌数
	 */
	public void addOpenCard(int num) {
		for (int i = 0; i < num; i++) {
			openCards.add(cardSet.next());
		}
	}

	/**
	 * 发牌面向下的牌
	 *
	 * @param num 牌数
	 */
	public void addCloseCard(int num) {
		for (int i = 0; i < num; i++) {
			closeCards.add(cardSet.next());
		}
	}

	/**
	 * 游戏定义中的hit
	 */
	public void hit() {
		Card card = cardSet.next();
		System.out.println(String.format("\n Current card: %s", card.toString()));
		openCards.add(card);
	}

	/**
	 * 游戏定义中的stay
	 */
	public void stay() {
		int maxRank = 0;
		List<Integer> rankList = getCardSumValue();
		for (int i = 0; i < rankList.size(); i++) {
			maxRank = rankList.get(i) > maxRank ? rankList.get(i) : maxRank;
		}
		resultRank = maxRank;
	}

	/**
	 * 清空参与者手中的牌和记录信息
	 */
	public void clearCards() {
		openCards = new ArrayList<>();
		closeCards = new ArrayList<>();
		baseRank = 0;
		resultRank = 0;
	}

	/**
	 * 返回当前牌面数值总数
	 *
	 * @return
	 */
	public int getResultRank() {
		return resultRank;
	}

	/**
	 * 返回当前牌面总数可能值的集合
	 *
	 * @return
	 */
	public List<Integer> getCardSumValue() {
		List<Card> cards = new ArrayList<>(openCards.size() + closeCards.size());
		cards.addAll(openCards);
		cards.addAll(closeCards);
		int rank1Num = 0;
		baseRank = 0;
		for (int i = 0; i < cards.size(); i++) {
			Card currCard = cards.get(i);
			if (currCard.getRank() == 1) {
				rank1Num++;
			}
			if (currCard.getRank() > 10) {
				baseRank += 10;
			} else {
				baseRank += currCard.getRank();
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i <= rank1Num; i++) {
			if (baseRank > 21) {
				return result;
			}
			result.add(baseRank);
			baseRank += 10;
		}
		return result;
	}

	/**
	 * 打印当前参与者所有牌面向上的牌的信息和向下的牌的数量
	 */
	public void printCards() {
		System.out.println(" Open cards: " + openCards);
		System.out.println(" Close cards count: " + closeCards.size());
		if (getCardSumValue().size() > 0) {
			System.out.println(String.format(" Possible total rank: %s\n", getCardSumValue()));
		}
	}

	/**
	 * 是否立即输掉游戏（总和超过21）
	 *
	 * @return true-输 false-没输
	 */
	public boolean ifLose() {
		if (getCardSumValue().size() == 0) {
			resultRank = -1;
			System.out.println(String.format("Current total rank: %s, %s lose.", baseRank, name));
			return true;
		}
		return false;
	}

	/**
	 * 是否立即赢得游戏（总和为21）
	 *
	 * @return true-赢 false-没赢
	 */
	public boolean ifWin() {
		if (getCardSumValue().size() > 0 && getCardSumValue().contains(BlackjackGame.WINNING_RANK)) {
			resultRank = BlackjackGame.WINNING_RANK;
			System.out.println(String.format("Current total rank: %s, %s win!", BlackjackGame.WINNING_RANK, name));
			return true;
		}
		return false;
	}

}
