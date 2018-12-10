package com.mrliuxia.heiheihei.a30166;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description 纸牌，几副牌通过构造函数设置，发牌调用next()方法
 * @Author
 * @Date 2017/4/2
 */
public class CardSet {

	private Map<Card, Integer> cardMap;
	private Random random;
	private int originSize;
	private int leftSize;

	/**
	 * 构造函数，通过num设置一共有几副牌
	 *
	 * @param num
	 */
	public CardSet(int num) {
		originSize = num * Card.TOTAL_SIZE;
		leftSize = num * Card.TOTAL_SIZE;
		random = new Random();
		cardMap = new HashMap<>(Card.TOTAL_SIZE);
		for (int i = Card.MIN_RANK; i <= Card.MAX_RANK; i++) {
			for (Card.Suit suit : Card.SUITS) {
				cardMap.put(new Card(suit, i), num);
			}
		}
	}

	/**
	 * 发下一张牌，当牌堆没有牌的时候，抛出异常
	 *
	 * @return Card 下一张牌
	 */
	public Card next() {
		if (cardMap.size() == 0) {
			throw new RuntimeException("No card left!");
		}
		Card card = null;
		while (card == null || !cardMap.containsKey(card)) {
			int suitRand = random.nextInt(4);
			int rankRand = random.nextInt(Card.MAX_RANK) + card.MIN_RANK;
			card = new Card(Card.SUITS[suitRand], rankRand);
		}
		int currNum = cardMap.get(card);
		if (currNum == 1) {
			cardMap.remove(card);
		} else {
			cardMap.put(card, currNum - 1);
		}
		leftSize--;
		return card;
	}

	/**
	 * 返回当前牌堆剩余牌数
	 *
	 * @return
	 */
	public int getLeftSize() {
		return leftSize;
	}

	/**
	 * 返回初始牌堆牌数
	 *
	 * @return
	 */
	public int getOriginSize() {
		return originSize;
	}

}
