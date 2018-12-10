package com.mrliuxia.heiheihei.d0207_tic_tac_toe;

import java.util.Scanner;

/**
 * Created by Poker on 2016/12/11.
 */
public class TicTacToe {

    private static int[][][] box = new int[4][4][4];
    private static int x, y, z;

    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        boolean ifPlayerFirst = true;
        System.out.println("you first? Y/N");
        if (scan1.next() != "Y") ifPlayerFirst = false;
        Scanner scan = new Scanner(System.in);
        if (ifPlayerFirst) {
            while (!isFinished()) {
                yourTurn(scan);
                print();
                if (isFinished()) {
                    System.out.println("you win!");
                    return;
                }
                computerTurn();
                print();
                if (isFinished()) {
                    System.out.println("computer win!");
                    return;
                }
            }
        } else {
            while (!isFinished()) {
                computerTurn();
                print();
                if (isFinished()) {
                    System.out.println("computer win!");
                    return;
                }
                yourTurn(scan);
                print();
                if (isFinished()) {
                    System.out.println("you win!");
                    return;
                }
            }
        }
    }

    /**
     * @return
     * false - continue
     * true  - finish
     */
    private static boolean isFinished() {
        // ij面，共4*(4+2)=24
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (box[i][j][0] != 0 && box[i][j][0] == box[i][j][1]
                        && box[i][j][1] == box[i][j][2] && box[i][j][2] == box[i][j][3]) {
                    return true;
                }
            }
            if (box[i][0][0] != 0 && box[i][0][0] == box[i][1][1]
                    && box[i][1][1] == box[i][2][2] && box[i][2][2] == box[i][3][3]) {
                return true;
            }
            if (box[i][0][3] != 0 && box[i][0][3] == box[i][1][2]
                    && box[i][1][2] == box[i][2][1] && box[i][2][1] == box[i][3][0]) {
                return true;
            }
        }
        // jk面，共4*(4+2)=24
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                if (box[0][j][k] != 0 && box[0][j][k] == box[1][j][k]
                        && box[1][j][k] == box[2][j][k] && box[2][j][k] == box[3][j][k]) {
                    return true;
                }
            }
            if (box[0][j][0] != 0 && box[0][j][0] == box[1][j][1]
                    && box[1][j][1] == box[2][j][2] && box[2][j][2] == box[3][j][3]) {
                return true;
            }
            if (box[0][j][3] != 0 && box[0][j][3] == box[1][j][2]
                    && box[1][j][2] == box[2][j][1] && box[2][j][1] == box[3][j][0]) {
                return true;
            }
        }
        // ki面，共4*(4+2)=24
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 4; i++) {
                if (box[i][0][k] != 0 && box[i][0][k] == box[i][1][k]
                        && box[i][1][k] == box[i][2][k] && box[i][2][k] == box[i][3][k]) {
                    return true;
                }
            }
            if (box[0][0][k] != 0 && box[0][0][k] == box[1][1][k]
                    && box[1][1][k] == box[2][2][k] && box[2][2][k] == box[3][3][k]) {
                return true;
            }
            if (box[0][3][k] != 0 && box[0][3][k] == box[1][2][k]
                    && box[1][2][k] == box[2][1][k] && box[2][1][k] == box[3][0][k]) {
                return true;
            }
        }
        // 4条体对角线
        if (box[0][0][0] != 0 && box[0][0][0] == box[1][1][1]
                && box[1][1][1] == box[2][2][2] && box[2][2][2] == box[3][3][3]) {
            return true;
        }
        if (box[0][0][3] != 0 && box[0][0][3] == box[1][1][2]
                && box[1][1][2] == box[2][2][1] && box[2][2][1] == box[3][3][0]) {
            return true;
        }
        if (box[3][0][0] != 0 && box[3][0][0] == box[2][1][1]
                && box[2][1][1] == box[1][2][2] && box[1][2][2] == box[0][3][3]) {
            return true;
        }
        if (box[0][3][0] != 0 && box[0][3][0] == box[1][2][1]
                && box[1][2][1] == box[2][1][2] && box[2][1][2] == box[3][0][3]) {
            return true;
        }
        return false;
    }

    private static void yourTurn(Scanner scan) {
        System.out.println("Your turn:");
        while (true) {
            System.out.print("input your position(eg:0 0 0):");
            String s = scan.nextLine();
            try {
                x = Integer.parseInt(s.split(" ")[0]);
                y = Integer.parseInt(s.split(" ")[1]);
                z = Integer.parseInt(s.split(" ")[2]);
            } catch (Exception e) {
                System.out.println("your input is invalid");
                continue;
            }
            if (x >= 0 && x < 4 && y >= 0 && y < 4 && z >= 0 && z < 4) {
//                flag = true;
            } else {
                System.out.println("your input is invalid");
                continue;
            }
            if (check()) {
                box[x][y][z] = 1;
                return;
            } else {
                System.out.println("this point has been pointed");
            }
        }
    }

    private static void computerTurn() {
        System.out.println("Computer Turn:");
//        boolean flag = true;
        while (true) {
            x = (int) (Math.random() * 4);
            y = (int) (Math.random() * 4);
            z = (int) (Math.random() * 4);
            if (check()) {
                System.out.println("x: " + x + ", y: " + y + ", z: " + z);
                box[x][y][z] = 2;
                return;
            }
        }
    }

    private static boolean check() {
        if (box[x][y][z] == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void print() {
        System.out.println("-----------------");
        for (int i = 0; i < 4; i++) {
            System.out.println("Floor " + i + ":");
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    switch (box[i][j][k]) {
                        case 0:
                            System.out.print("* ");
                            break;
                        case 1:
                            System.out.print("X ");
                            break;
                        case 2:
                            System.out.print("O ");
                            break;
                    }
                }
                System.out.println();
            }
        }
        System.out.println("-----------------");
    }

}
