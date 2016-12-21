package heiheihei.d0251_maze.model;

/**
 * cell model
 *   CELL_W - wall
 *   CELL_E - empty
 *   CELL_T - teleporter
 *   CELL_L - lands
 *
 * Created by Poker on 2016/12/18.
 */
public enum Cell {

    CELL_W, CELL_E, CELL_T, CELL_L;

    /**
     * parse string to cell
     *
     * @param s
     * @return
     */
    public static Cell getCell(String s) {
        switch (s) {
            case "":
                return CELL_E;
            case "W":
                return CELL_W;
            case "T":
                return CELL_T;
            case "L":
                return CELL_L;
            default:
                return null;
        }
    }

    /**
     * parst char to cell
     *
     * @param c
     * @return
     */
    public static Cell getCell(char c) {
        switch (c) {
            case ' ':
                return CELL_E;
            case 'W':
                return CELL_W;
            case 'T':
                return CELL_T;
            case 'L':
                return CELL_L;
            default:
                return null;
        }
    }

}
