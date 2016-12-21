package heiheihei.d0251_maze.model;

import heiheihei.d0251_maze.Maze;

/**
 * position model
 *
 * Created by Poker on 2016/12/18.
 */
public class Position {

    private int x;
    private int y;
    private Position prevPosition;
    private int distance;

    /**
     * constructor of position
     * default x,y,distance = -1
     */
    public Position() {
        this.x = -1;
        this.y = -1;
        this.prevPosition = null;
        this.distance = -1;
    }

    /**
     * constructor of position
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.prevPosition = null;
        this.distance = -1;
    }

    /**
     * position to string
     *
     * @return
     */
    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    /**
     * if positions are equal
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) {
            return false;
        }
        return ((Position) obj).x == this.x && ((Position) obj).y == this.y;
    }

    /**
     * move the position
     * @param dir
     * @return
     *   true - move success
     *   false - move failed
     */
    public boolean move(Dir dir) {
        switch (dir) {
            case DIR_UP:
                if (x - 1 < 0) {
                    return false;
                } else {
                    return true;
                }
            case DIR_DOWN:
                if (x + 1 >= Maze.SIZE) {
                    return false;
                } else {
                    return true;
                }
            case DIR_LEFT:
                if (y - 1 < 0) {
                    return false;
                } else {
                    return true;
                }
            case DIR_RIGHT:
                if (y + 1 >= Maze.SIZE) {
                    return false;
                } else {
                    return true;
                }
        }
        return false;
    }

    /**
     * get direction position of the position
     *
     * @param dir
     * @return facing position
     */
    public Position get(Dir dir) {
        switch (dir) {
            case DIR_UP:
                if (x - 1 < 0) {
                    return null;
                } else {
                    return new Position(x - 1, y);
                }
            case DIR_DOWN:
                if (x + 1 >= Maze.SIZE) {
                    return null;
                } else {
                    return new Position(x + 1, y);
                }
            case DIR_LEFT:
                if (y - 1 < 0) {
                    return null;
                } else {
                    return new Position(x, y - 1);
                }
            case DIR_RIGHT:
                if (y + 1 >= Maze.SIZE) {
                    return null;
                } else {
                    return new Position(x, y + 1);
                }
        }
        return null;
    }

    /**
     * hashcode of the position
     * @return
     */
    @Override
    public int hashCode() {
        return x * 100 + y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position getPrevPosition() {
        return prevPosition;
    }

    public void setPrevPosition(Position prevPosition) {
        this.prevPosition = prevPosition;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
