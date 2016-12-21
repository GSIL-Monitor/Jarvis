package map;

import factory.MapFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pokerface_lx on 16/6/20.
 * 使用迪杰斯特拉算法计算某节点到图中所有节点的最短距离
 */
public class Dijkstra {

    private static List<Integer> openList;
    private static List<Integer> closeList;
    private static int[] results;
    private static int choose;

    public static void solve(int[][] map) {
        openList = new ArrayList<>();
        closeList = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            openList.add(i);
        }
        results = new int[map.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = -1;
        }
        int startIndex = map.length - 1;
        openList.remove(startIndex);
        closeList.add(startIndex);
        results[startIndex] = 0;
        System.out.println("CLOSE RESULTS CHOOSE");
        showStatus();
        while (openList.size() > 0) {
            int lastChoose = closeList.get(closeList.size() - 1);
            for (int i = 0; i < map.length; i++) {
                if (results[i] == -1 && map[lastChoose][i] != -1) {
                    results[i] = map[lastChoose][i] + results[lastChoose];
                }
                if (results[i] != -1 && map[lastChoose][i] != -1 &&
                        (map[lastChoose][i] + results[lastChoose] < results[i])) {
                    results[i] = map[lastChoose][i] + results[lastChoose];
                }
            }
            choose = -1;
            int minDis = Integer.MAX_VALUE;
            for (int i : openList) {
                if (results[i] != -1 && results[i] != 0 && results[i] < minDis) {
                    minDis = results[i];
                    choose = i;
                }
            }
            openList.remove(new Integer(choose));
            closeList.add(choose);
            showStatus();
        }
    }

    private static void showStatus() {
        System.out.println(closeList.toString() + " " + Arrays.toString(results) + " " + choose);
    }

    public static void main(String[] args) {
        Dijkstra.solve(MapFactory.getMapForDijkstra());
    }

}
