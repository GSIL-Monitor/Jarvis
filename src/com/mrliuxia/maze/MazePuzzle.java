package com.mrliuxia.maze;

import java.util.Stack;

/**
 * Created by pokerface_lx on 16/6/19.
 */
public class MazePuzzle {

    private static Stack<Position> openStack;
    private static Stack<Position> closeStack;

    /**
     * 1表示此处有路,2表示是能走到此处但是不是解,3表示此路径是解
     * @param maze
     */
    public static void findPath (int[][] maze) {
        openStack = new Stack<>();
        closeStack = new Stack<>();
        openStack.push(new Position(0, 0));
        while (openStack.size()!=0) {
            Position currentPos = openStack.pop();
            int x = currentPos.getxPosition();
            int y = currentPos.getyPosition();
            closeStack.push(currentPos);
            maze[x][y]=2;
            if ((x == maze.length-1) && (y == maze[x].length-1)) {
                break;
            }
            boolean isDeadEnd = true;
            if (isValid(maze, x-1, y) && maze[x-1][y] == 1) {
                openStack.push(new Position(x-1, y));
                isDeadEnd = false;
            }
            if (isValid(maze, x+1, y) && maze[x+1][y] ==1) {
                openStack.push(new Position(x+1, y));
                isDeadEnd = false;
            }
            if (isValid(maze, x, y-1) && maze[x][y-1] == 1) {
                openStack.push(new Position(x, y-1));
                isDeadEnd = false;
            }
            if (isValid(maze, x, y+1) && maze[x][y+1]==1) {
                openStack.push(new Position(x, y+1));
                isDeadEnd = false;
            }
            if (isDeadEnd) {
                closeStack.pop();
            }
        }
        while (!closeStack.isEmpty()) {
            Position position = closeStack.pop();
            int x = position.getxPosition();
            int y = position.getyPosition();
            maze[x][y] = 3;
        }
        showMaze(maze);
    }

    private static boolean isValid(int[][] maze, int x, int y) {
        if (x >= 0 && y >= 0 && x < maze.length && y < maze[x].length) {
            return true;
        } else {
            return false;
        }
    }

    private static void showMaze (int[][] maze) {
        for (int[] a: maze) {
            for (int b: a) {
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }

    private static class Position {
        private Integer xPosition;
        private Integer yPosition;
        public Position(int xPosition, int yPosition) {
            this.xPosition = xPosition;
            this.yPosition = yPosition;
        }

        public Integer getxPosition() {
            return xPosition;
        }

        public Integer getyPosition() {
            return yPosition;
        }
    }

}
