package com.mrliuxia.factory;

/**
 * Created by pokerface_lx on 16/6/20.
 */
public class MapFactory {

    private static int[][] map;

    public static int[][] getMapForDijkstra() {
        map = new int[6][6];
        map[0] = new int[]{0, -1, -1, -1, -1, -1};
        map[1] = new int[]{5, 1, -1, -1, -1, -1};
        map[2] = new int[]{-1, 15, 0, 5, -1, -1};
        map[3] = new int[]{-1, -1, -1, 0, -1, -1};
        map[4] = new int[]{10, 9, -1, -1, 0, -1};
        map[5] = new int[]{-1, -1, 6, 8, 7, 0};
        return map;
    }

    public static int[][] getMapForPK() {
        map = new int[6][6];
        map[0] = new int[]{0, 6, -1, -1, 10, 12};
        map[1] = new int[]{6, 0, 3, 5, -1, 8};
        map[2] = new int[]{-1, 3, 0, 7, -1, -1};
        map[3] = new int[]{-1, 5, 7, 0, 9, 11};
        map[4] = new int[]{10, -1, -1, 9, 0, 16};
        map[5] = new int[]{12, 8, -1, 11, 16, 0};
        return map;
    }

}
