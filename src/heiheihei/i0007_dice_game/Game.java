package heiheihei.i0007_dice_game;

import java.util.Scanner;

/**
 * Created by Poker on 2016/12/13.
 */
public class Game {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("rounds:");
            int rounds = parseRound(scan.next());
            if (rounds == 0) {
                System.out.println("your input is invalid");
                continue;
            }
            int playerNum = 2;
            play(playerNum, rounds);
            System.out.print("\ncontinue? Y/N  ");
            if (scan.next().equals("N")) return;
        }
    }

    private static int parseRound(String s) {
        try {
            int rounds = Integer.parseInt(s);
            if (rounds < 1) {
                return 0;
            } else {
                return rounds;
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

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
        System.out.println("\n\nOverall points winner is player " + (winner + 1) + ".");
    }

}
