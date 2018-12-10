package com.mrliuxia.heiheihei.d0251_maze.frame;

import com.mrliuxia.heiheihei.d0251_maze.model.Cell;
import com.mrliuxia.heiheihei.d0251_maze.model.Dir;
import com.mrliuxia.heiheihei.d0251_maze.util.FileUtil;
import com.mrliuxia.heiheihei.d0251_maze.Maze;
import com.mrliuxia.heiheihei.d0251_maze.model.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * frame of the com.mrliuxia.jarvis.maze
 * <p>
 * Created by Poker on 2016/12/18.
 *
 * @version 1.0
 */
public class MazeFrame extends JFrame implements ActionListener, MouseListener {

    //    private JPanel buttonPanel;
    private JButton[][] buttons;
    private Cell[][] cells;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu, helpMenu;
    private JMenuItem openItem, saveItem, findPathItem, exitItem;
    private JMenuItem openEditableItem, closeEditableItem;
    private JMenuItem aboutItem;
    private boolean editable;
    private Map<Position, Cell> cellMap;
    private Position telePosition, landPosition;

    /**
     * constructor
     * init frame & fields
     *
     * @throws Exception
     */
    public MazeFrame() throws Exception {
        this.setSize(600, 400);
        this.setTitle("Maze");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        layoutComponents();
        this.setVisible(true);
    }

    /**
     * set layouts & init fields
     */
    private void layoutComponents() {
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        // file menu
        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        openItem = new JMenuItem("Open com.mrliuxia.jarvis.maze");
        openItem.addActionListener(this);
        fileMenu.add(openItem);

        saveItem = new JMenuItem("Save com.mrliuxia.jarvis.maze");
        saveItem.addActionListener(this);
        fileMenu.add(saveItem);

        findPathItem = new JMenuItem("Find path");
        findPathItem.addActionListener(this);
        fileMenu.add(findPathItem);

        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        fileMenu.add(exitItem);

        // edit menu
        editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        openEditableItem = new JMenuItem("Open editable");
        openEditableItem.addActionListener(this);
        editMenu.add(openEditableItem);

        closeEditableItem = new JMenuItem("Close editable");
        closeEditableItem.addActionListener(this);
        editMenu.add(closeEditableItem);

        // help menu
        helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(this);
        helpMenu.add(aboutItem);


        // init field
        editable = false;
        cells = new Cell[Maze.SIZE][Maze.SIZE];
        cellMap = new HashMap<>();
        for (int i = 0; i < Maze.SIZE; i++) {
            for (int j = 0; j < Maze.SIZE; j++) {
                cellMap.put(new Position(i, j), Cell.CELL_E);
            }
        }
        telePosition = new Position();
        landPosition = new Position();

        // add buttons
        this.setLayout(new GridLayout(10, 10));
        buttons = new JButton[Maze.SIZE][Maze.SIZE];
        for (int i = 0; i < Maze.SIZE; i++) {
            for (int j = 0; j < Maze.SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setEnabled(false);
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].addActionListener(this);
                buttons[i][j].addMouseListener(this);
                cells[i][j] = Cell.CELL_E;
                this.add(buttons[i][j]);
            }
        }


    }

    /**
     * events when menu item is clicked
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openItem) {
            JFileChooser jsc = new JFileChooser();
            jsc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            jsc.showDialog(new JLabel(), "Choose file");
            File file = jsc.getSelectedFile();
            try {
                cellMap = FileUtil.getCellMap(file);
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return;
            }
            clearResult();
            for (int i = 0; i < Maze.SIZE; i++) {
                for (int j = 0; j < Maze.SIZE; j++) {
                    Position curPosition = new Position(i, j);
                    switch (cellMap.get(curPosition)) {
                        case CELL_E:
                            buttons[i][j].setBackground(Color.WHITE);
                            cells[i][j] = Cell.CELL_E;
                            break;
                        case CELL_W:
                            buttons[i][j].setBackground(Color.BLACK);
                            cells[i][j] = Cell.CELL_W;
                            break;
                        case CELL_T:
                            buttons[i][j].setBackground(Color.RED);
                            cells[i][j] = Cell.CELL_T;
                            telePosition = new Position(i, j);
                            break;
                        case CELL_L:
                            buttons[i][j].setBackground(Color.GREEN);
                            cells[i][j] = Cell.CELL_L;
                            landPosition = new Position(i, j);
                            break;
                    }
                }
            }
            return;
        }
        if (e.getSource() == saveItem) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(null);
//            if(option == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileUtil.saveMap(cellMap, file);
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.out.println("error");
            }


        }
        if (e.getSource() == findPathItem) {
            clearResult();
            readMaze();
            Position targetPosition;
            try {
                targetPosition = getSolution();
            } catch (Exception e1) {
                e1.printStackTrace();
                return;
            }
            Position currPosition = targetPosition;
            while (currPosition != null) {
                int x = currPosition.getX();
                int y = currPosition.getY();
                buttons[x][y].setText(String.valueOf(currPosition.getDistance()));
                currPosition = currPosition.getPrevPosition();
            }
            return;
        }
        if (e.getSource() == exitItem) {
            System.exit(0);
        }
        if (e.getSource() == openEditableItem) {
//            for (int i = 0; i < Maze.SIZE; i++) {
//                for (int j = 0; j < Maze.SIZE; j++) {
//                    buttons[i][j].setEnabled(true);
//                }
//            }
            editable = true;
            return;
        }
        if (e.getSource() == closeEditableItem) {
//            for (int i = 0; i < Maze.SIZE; i++) {
//                for (int j = 0; j < Maze.SIZE; j++) {
//                    buttons[i][j].setEnabled(false);
//                }
//            }
            editable = false;
            return;
        }
//        ( (JButton)e.getSource()).setBackground(Color.blue);
//        for (int i = 0; i < Maze.SIZE; i++) {
//            for (int j = 0; j < Maze.SIZE; j++) {
//                if (e.getSource() == buttons[i][j]) {
//                    System.out.println(i+" "+j);
//                }
//            }
//        }
    }

    /**
     * events when com.mrliuxia.jarvis.maze cell is clicked
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (!editable) {
            return;
        }
        int x = -1, y = -1;
        JButton clickedButton = (JButton) e.getSource();
        for (int i = 0; i < Maze.SIZE; i++) {
            for (int j = 0; j < Maze.SIZE; j++) {
                if (e.getSource().equals(buttons[i][j])) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        if (e.isShiftDown()) {
            if (!telePosition.equals(new Position(-1, -1))) {
                cells[telePosition.getX()][telePosition.getY()] = Cell.CELL_E;
                cellMap.put(telePosition, Cell.CELL_E);
                buttons[telePosition.getX()][telePosition.getY()].setBackground(Color.WHITE);
            }
            cells[x][y] = Cell.CELL_T;
            telePosition = new Position(x, y);
            cellMap.put(telePosition, Cell.CELL_T);
            buttons[x][y].setBackground(Color.RED);
        }
        if (e.isControlDown()) {
            if (!landPosition.equals(new Position(-1, -1))) {
                cells[landPosition.getX()][landPosition.getY()] = Cell.CELL_L;
                cellMap.put(landPosition, Cell.CELL_E);
                buttons[landPosition.getX()][landPosition.getY()].setBackground(Color.white);
            }
            cells[x][y] = Cell.CELL_L;
            landPosition = new Position(x, y);
            cellMap.put(landPosition, Cell.CELL_L);
            buttons[x][y].setBackground(Color.GREEN);
        }
        switch (cells[x][y]) {
            case CELL_E:
                cells[x][y] = Cell.CELL_W;
                cellMap.put(new Position(x, y), Cell.CELL_W);
                clickedButton.setBackground(Color.BLACK);
                break;
            case CELL_W:
                cells[x][y] = Cell.CELL_E;
                clickedButton.setBackground(Color.WHITE);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * read com.mrliuxia.jarvis.maze from current frame
     */
    private void readMaze() {
        cellMap = new HashMap<>();
        for (int i = 0; i < Maze.SIZE; i++) {
            for (int j = 0; j < Maze.SIZE; j++) {
                cellMap.put(new Position(i, j), cells[i][j]);
                if (cells[i][j].equals(Cell.CELL_T)) {
                    telePosition = new Position(i, j);
                }
                if (cells[i][j].equals(Cell.CELL_L)) {
                    landPosition = new Position(i, j);
                }
            }
        }
    }

    /**
     * clear result path (1,2,...,n)
     */
    private void clearResult() {
        for (int i = 0; i < Maze.SIZE; i++) {
            for (int j = 0; j < Maze.SIZE; j++) {
                buttons[i][j].setText(null);
                telePosition = new Position();
                landPosition = new Position();
            }
        }
    }

    /**
     * com.mrliuxia.jarvis.algorithm of finding shorest path of the com.mrliuxia.jarvis.maze
     *
     * @return
     * @throws IOException
     */
    public Position getSolution() throws IOException {
//        Map<Position, Cell> cellMap = FileUtil.getCellMap(new File("map1.csv"));
        Map<Integer, Set<Position>> resultMap = new HashMap<>();
        Set<Position> close = new HashSet<>();
        Queue<Position> open = new LinkedList<>();

//        Position landPosition = new Position();
//        for (Position p : cellMap.keySet()) {
//            if (cellMap.get(p) == Cell.CELL_L) {
//                landPosition = p;
//            }
//        }

        Position currPosition = new Position(0, 0);
        Position targetPosition = new Position(9, 9);
        int currDistance = 0;
        currPosition.setDistance(currDistance);
        open.add(currPosition);
        while (open.size() > 0) {
            currPosition = open.poll();
            close.add(currPosition);
            currDistance = currPosition.getDistance() + 1;
            if (!resultMap.containsKey(currDistance)) {
                resultMap.put(currDistance, new HashSet<>());
            }
            // jump
            if (cellMap.get(currPosition) == Cell.CELL_T) {
                Position nextPosition = landPosition;
                nextPosition.setDistance(currDistance);
                nextPosition.setPrevPosition(currPosition);
                if (nextPosition.equals(targetPosition)) {
                    targetPosition = nextPosition;
                    break;
                }
                resultMap.get(currDistance).add(nextPosition);
                open.add(nextPosition);
                continue;
            }

            // up
            Position upPosition = currPosition.get(Dir.DIR_UP);
            if (upPosition != null && cellMap.get(upPosition) != Cell.CELL_W && !close.contains(upPosition)) {
                upPosition.setDistance(currDistance);
                upPosition.setPrevPosition(currPosition);
                if (upPosition.equals(targetPosition)) {
                    targetPosition = upPosition;
                    break;
                }
                resultMap.get(currDistance).add(upPosition);
                open.add(upPosition);
            }
            // down
            Position downPosition = currPosition.get(Dir.DIR_DOWN);
            if (downPosition != null && cellMap.get(downPosition) != Cell.CELL_W && !close.contains(downPosition)) {
                downPosition.setDistance(currDistance);
                downPosition.setPrevPosition(currPosition);
                if (downPosition.equals(targetPosition)) {
                    targetPosition = downPosition;
                    break;
                }
                resultMap.get(currDistance).add(downPosition);
                open.add(downPosition);
            }
            // left
            Position leftPosition = currPosition.get(Dir.DIR_LEFT);
            if (leftPosition != null && cellMap.get(leftPosition) != Cell.CELL_W && !close.contains(leftPosition)) {
                leftPosition.setDistance(currDistance);
                leftPosition.setPrevPosition(currPosition);
                if (leftPosition.equals(targetPosition)) {
                    targetPosition = leftPosition;
                    break;
                }
                resultMap.get(currDistance).add(leftPosition);
                open.add(leftPosition);
            }
            // right
            Position rightPosition = currPosition.get(Dir.DIR_RIGHT);
            if (rightPosition != null && cellMap.get(rightPosition) != Cell.CELL_W && !close.contains(rightPosition)) {
                rightPosition.setDistance(currDistance);
                rightPosition.setPrevPosition(currPosition);
                if (rightPosition.equals(targetPosition)) {
                    targetPosition = rightPosition;
                    break;
                }
                resultMap.get(currDistance).add(rightPosition);
                open.add(rightPosition);
            }
        }
//        System.out.println();
//        currPosition = targetPosition;
//        System.out.println(currPosition.getDistance());
//        while (currPosition!= null) {
//            System.out.println(currPosition.getX() + "," + currPosition.getY());
//            currPosition = currPosition.getPrevPosition();
//        }
        return targetPosition;
    }
}
