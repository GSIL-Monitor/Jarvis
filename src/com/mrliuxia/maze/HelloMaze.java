package com.mrliuxia.maze;

/**
 * Created by pokerface_lx on 16/6/19.
 */
public class HelloMaze {

    public static void main(String[] args) {
        MazePuzzle puzzle = new MazePuzzle();
        puzzle.findPath(MazeFactory.getMaze(10,10));
    }

}
