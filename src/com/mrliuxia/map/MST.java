package com.mrliuxia.map;

import java.util.*;

/**
 * Created by apple on 16/6/18.
 */
public class MST {

    public static void Prim(MapForPK map) {
        List<Integer> openList = new ArrayList<>();
        List<Integer> closeList = new ArrayList<>();
        for (int i = 0; i < map.getPaths().length; i++) {
            if (i == 0) {
                closeList.add(i);
                System.out.println("下一个节点是:" + i + ",距离为:0");
            } else {
                openList.add(i);
            }
        }
        while (openList.size() > 0) {
            int minDis = -1;
            int minPos = -1;
            int curPos = -1;
            for (int nextPos: openList) {
                int pos = closeList.get(0);
                int dis = map.getPaths()[pos][nextPos];
                if (dis != -1 && dis != 0) {
                    minDis = dis;
                    minPos = nextPos;
                    curPos = pos;
                    break;
                }
            }
            for (Integer pos : closeList) {
                for (int nextPos: openList) {
                    int dis = map.getPaths()[pos][nextPos];
                    if (dis != -1 && dis != 0 && dis <= minDis) {
                        minDis = dis;
                        minPos = nextPos;
                        curPos = pos;
                    }
                }
            }
            for (Integer pos : openList) {
                if (pos == minPos) {
                    openList.remove(pos);
                    break;
                }
            }
            closeList.add(minPos);
            System.out.println("下一个节点是:" + minPos + ",与节点" + curPos + "距离为:" + minDis);
        }
    }

    public static void Kruskal(MapForPK map) {
        List<Path> paths = new ArrayList<>();
        for (int i = 0; i < map.getPaths().length; i++) {
            for (int j = i+1; j < map.getPaths()[i].length; j++) {
                if (map.getPaths()[i][j]!=-1) {
                    paths.add(new Path(i, j, map.getPaths()[i][j]));
                }
            }
        }
        Collections.sort(paths, new Comparator<Path>() {
            @Override
            public int compare(Path p1, Path p2) {
                return p1.getDistance().compareTo(p2.getDistance());
            }
        });
        List<Integer> openList = new ArrayList<>();
        List<Integer> closeList = new ArrayList<>();
        closeList.add(paths.get(0).fromNode);
        closeList.add(paths.get(0).toNode);
        System.out.println("添加路径从"+paths.get(0).getFromNode()+"到"+paths.get(0).getToNode()
                +"距离"+paths.get(0).getDistance());
        paths.remove(0);
        for (int i = 0; i < map.getPaths().length; i++) {
            if (!closeList.contains(i)) {
                openList.add(i);
            }
        }
        while(openList.size() > 0) {
            for (Path path: paths) {
                if (openList.contains(path.getFromNode()) && closeList.contains(path.getToNode())) {
                    openList.remove(path.getFromNode());
                    closeList.add(path.getFromNode());
                    System.out.println("添加路径从"+path.getFromNode()+"到"+path.getToNode()
                            +"距离"+path.getDistance());
                    paths.remove(path);
                    break;
                }
                if (closeList.contains(path.getFromNode()) && openList.contains(path.getToNode())) {
                    openList.remove(path.getToNode());
                    closeList.add(path.getToNode());
                    System.out.println("添加路径从"+path.getFromNode()+"到"+path.getToNode()
                            +"距离"+path.getDistance());
                    paths.remove(path);
                    break;
                }
            }
        }
    }

    private static class Path {
        private Integer distance;
        private Integer fromNode;
        private Integer toNode;
        public Path(Integer fromNode, Integer toNode, Integer distance) {
            this.fromNode = fromNode;
            this.toNode = toNode;
            this.distance = distance;
        }

        public Integer getDistance() {
            return distance;
        }

        public Integer getFromNode() {
            return fromNode;
        }

        public Integer getToNode() {
            return toNode;
        }
    }


}
