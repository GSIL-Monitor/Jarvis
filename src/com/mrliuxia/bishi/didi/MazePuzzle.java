package com.mrliuxia.bishi.didi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by pokerface_lx on 16/9/18.
 */
public class MazePuzzle {

    private static Stack<Position> openStack;
    private static Stack<Position> closeStack;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int p = scan.nextInt();
            int[][] maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = scan.nextInt();
                }
            }
            findPath(maze, p);
        }
    }

    private static void findPath(int[][] maze, int life) {
        openStack = new Stack<>();
        closeStack = new Stack<>();
        Position currPosition = new Position(0, 0, life);
        openStack.push(currPosition);
        while (openStack.size() > 0
                || (currPosition.xPosition != 0 && currPosition.xPosition != maze[0].length - 1)) {
            if (openStack.size() == 0) {
                System.out.println("Can not escape!");
                return;
            }
            currPosition = openStack.pop();
            int x = currPosition.xPosition;
            int y = currPosition.yPosition;
            int currLife = currPosition.life;
            closeStack.push(currPosition);
            maze[x][y] = 2;
            if ((x == 0) && (y == maze[0].length - 1)) {
                break;
            }
            boolean isDeadEnd = true;
            if (isValid(maze, x + 1, y) && maze[x + 1][y] == 1) {
                currPosition = new Position(x + 1, y, currLife);
                openStack.push(currPosition);
                isDeadEnd = false;
            }
            if (isValid(maze, x, y - 1) && maze[x][y - 1] == 1 && (currLife - 1 >= 0)) {
                currPosition = new Position(x, y - 1, currLife - 1);
                openStack.push(currPosition);
                isDeadEnd = false;
            }
            if (isValid(maze, x - 1, y) && maze[x - 1][y] == 1 && (currLife - 3 >= 0)) {
                currPosition = new Position(x - 1, y, currLife - 3);
                openStack.push(currPosition);
                isDeadEnd = false;
            }
            if (isValid(maze, x, y + 1) && maze[x][y + 1] == 1 && (currLife - 1 >= 0)) {
                currPosition = new Position(x, y + 1, currLife - 1);
                openStack.push(currPosition);
                isDeadEnd = false;
            }
            if (isDeadEnd) {
                closeStack.pop();
            }
        }
        if (closeStack.peek().xPosition != 0 || closeStack.peek().yPosition != maze[0].length - 1) {
            System.out.println("Can not escape!");
            return;
        }
        Stack<Position> outputStack = new Stack<>();
        while (closeStack.size() > 0) {
            outputStack.push(closeStack.pop());
        }
        while (outputStack.size() > 0) {
            if (outputStack.size() == 1) {
                System.out.print(outputStack.pop());
            } else {
                System.out.print(outputStack.pop() + ",");
            }
        }
    }

    private static boolean isValid(int[][] maze, int x, int y) {
        if (x >= 0 && y >= 0 && x < maze.length && y < maze[x].length) {
            return true;
        } else {
            return false;
        }
    }

    private static class Position {
        private int xPosition;
        private int yPosition;
        private int life;

        public Position(int xPosition, int yPosition, int life) {
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.life = life;
        }

        @Override
        public String toString() {
            return "[" + xPosition + "," + yPosition + "]";
        }
    }

}
