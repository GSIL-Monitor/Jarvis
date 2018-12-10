package com.mrliuxia.heiheihei.i0007_1;

import java.util.Scanner;

public class Game {

    private static ThreeDiceScorer s;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("rounds:");
        int rounds;
        while ((rounds = scan.nextInt()) <= 0) {
            System.out.println("your input is invalid");
        }
        int playerNum = 2;
        play(playerNum, rounds);
    }

    /**
     * 掷骰子游戏的逻辑，按照要求输出
     *
     * @param playerNum 参与人数
     * @param rounds    游戏轮数
     */
    private static void play(int playerNum, int rounds) {
        int[] totalWins = new int[playerNum];
        int[] totalPoints = new int[playerNum];
        int winner = 0, winnerPoint = 0;
        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + i + "   ");
            int maxPlayer = 0, maxPoint = 0;
            for (int j = 0; j < playerNum; j++) {
                ThreeDiceScorer ds = ThreeDiceScorer.getDiceScorer();
                int point = ds.getPoints();
                totalPoints[j] += point;
                if (ds.getPoints() > maxPoint) {
                    maxPlayer = j;
                    maxPoint = point;
                }
                System.out.print("Player " + (j + 1) + ": " + ds + " points: " + point + "    ");
            }
            totalWins[maxPlayer]++;
            System.out.println("Round winner is player " + (maxPlayer + 1));
        }
        System.out.println("\nTotal wins:");
        for (int i = 0; i < playerNum; i++) {
            System.out.print("\tPlayer " + (i + 1) + ": " + totalWins[i]);
        }
        System.out.println("\nTotal points:");
        for (int i = 0; i < playerNum; i++) {
            if (totalPoints[i] > winnerPoint) {
                winner = i;
                winnerPoint = totalPoints[i];
            }
            System.out.print("\tPlayer " + (i + 1) + ": " + totalPoints[i]);
        }
        System.out.println("\nAverage points per round:");
        for (int i = 0; i < playerNum; i++) {
            System.out.print("\tPlayer " + (i + 1) + ": "
                    + Double.parseDouble(String.valueOf(totalPoints[i])) / rounds);
        }
        System.out.println("\n\nOverall points winner is player " + (winner + 1) + ".\n\n");
    }

}
