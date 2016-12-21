package heiheihei.d0251_maze.util;

import heiheihei.d0251_maze.Maze;
import heiheihei.d0251_maze.model.Cell;
import heiheihei.d0251_maze.model.Position;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * file util
 * <p>
 * Created by Poker on 2016/12/18.
 */
public class FileUtil {

    /**
     * read map data from file
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static Map<Position, Cell> getCellMap(File file) throws IOException {
        Map<Position, Cell> cellMap = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "";
        int x = 0;
        while ((line = reader.readLine()) != null) {
            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    count++;
                }
            }
            if (count + 1 != Maze.SIZE) {
                throw new RuntimeException("file data error.");
            }
            int j = 0;
            for (int y = 0; y < Maze.SIZE - 1; y++) {
                if (line.charAt(j) == ',') {
                    cellMap.put(new Position(x, y), Cell.getCell(' '));
                } else {
                    cellMap.put(new Position(x, y), Cell.getCell(line.charAt(j++)));
                }
                j++;
            }
            if (line.charAt(line.length() - 1) == ',') {
                cellMap.put(new Position(x, Maze.SIZE - 1), Cell.getCell(' '));
            } else {
                cellMap.put(new Position(x, Maze.SIZE - 1), Cell.getCell(line.charAt(line.length() - 1)));
            }
            x++;
        }
        return cellMap;
    }

    /**
     * save map data into file
     *
     * @param cellMap
     * @param file
     * @return
     */
    public static boolean saveMap(Map<Position, Cell> cellMap, File file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (int i = 0; i < Maze.SIZE; i++) {
                for (int j = 0; j < Maze.SIZE; j++) {
                    switch (cellMap.get(new Position(i, j))) {
                        case CELL_W:
                            writer.print('W');
                            break;
                        case CELL_T:
                            writer.print('T');
                            break;
                        case CELL_L:
                            writer.print('L');
                            break;
                    }
                    if (j == Maze.SIZE - 1) {
                        continue;
                    }
                    writer.print(',');
                }
                writer.print('\n');
            }
            writer.flush();
            writer.close();
            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }

}
