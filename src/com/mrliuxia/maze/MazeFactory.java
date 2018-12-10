package com.mrliuxia.maze;

/**
 * Created by pokerface_lx on 16/6/19.
 */
public class MazeFactory {

    private static int[][] maze;

    public MazeFactory() {

    }

    public static int[][] getDefaultMaze() {
        maze = new int[6][6];
        maze[0] = new int[]{1, 1, 0, 1, 1, 0};
        maze[1] = new int[]{0, 1, 1, 0, 0, 1};
        maze[2] = new int[]{0, 1, 0, 1, 1, 1};
        maze[3] = new int[]{1, 1, 0, 1, 0, 1};
        maze[4] = new int[]{0, 1, 1, 1, 0, 1};
        maze[5] = new int[]{1, 1, 0, 0, 1, 1};
        return maze;
    }

    public static int[][] getMaze(int length, int width) {
        maze = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (Math.random() < 0.5) {
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = 1;
                }
            }
        }
        return maze;
    }


}
