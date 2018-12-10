package com.mrliuxia.map;

/**
 * Created by apple on 16/6/18.
 * 使用邻接表的形式来表示图
 */
public class MapForPK {

    private int[][] paths;

    public MapForPK() {
        paths = new int[6][6];
        paths[0] = new int[]{0, 6, -1, -1, 10, 12};
        paths[1] = new int[]{6, 0, 3, 5, -1, 8};
        paths[2] = new int[]{-1, 3, 0, 7, -1, -1};
        paths[3] = new int[]{-1, 5, 7, 0, 9, 11};
        paths[4] = new int[]{10, -1, -1, 9, 0, 16};
        paths[5] = new int[]{12, 8, -1, 11, 16, 0};
    }

    public int[][] getPaths() {
        return paths;
    }
}
