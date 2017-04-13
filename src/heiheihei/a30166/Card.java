package heiheihei.a30166;

/**
 * @Description 牌
 * 默认排序：红桃-黑桃-方块-草花，分别1-13
 * @Author
 * @Date 2017/4/2
 */
public class Card implements Comparable {

	public static final int MIN_RANK = 1;
	public static final int MAX_RANK = 13;
	public static final int TOTAL_SIZE = 52;
	public static final Suit[] SUITS = {Suit.HEART, Suit.SPADE, Suit.DIAMOND, Suit.CLUB}; //花色集合

	private Suit suit; //花色
	private int rank; //牌面数字

	public Card(Suit suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * 返回牌面数字
	 *
	 * @return
	 */
	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return suit.toString() + rank;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Card)) {
			return false;
		}
		return ((Card) obj).suit.equals(this.suit) && ((Card) obj).rank == this.rank;
	}

	@Override
	public int hashCode() {
		return (suit.getHashCode() << 4) + rank;
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Card)) {
			return -1;
		}
		return this.hashCode() - o.hashCode();
	}

	/**
	 * 牌的花色
	 */
	public enum Suit {
		HEART, //红桃
		SPADE, //黑桃
		DIAMOND, //方块
		CLUB; //梅花

		@Override
		public String toString() {
			return super.toString().substring(0, 1);
		}

		public int getHashCode() {
			switch (this) {
				case HEART:
					return 1;
				case SPADE:
					return 2;
				case DIAMOND:
					return 3;
				case CLUB:
					return 4;
			}
			return 0;
		}

	}
}
