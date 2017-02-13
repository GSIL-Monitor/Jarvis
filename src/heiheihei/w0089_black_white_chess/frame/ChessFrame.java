package heiheihei.w0089_black_white_chess.frame;

import heiheihei.w0089_black_white_chess.model.Chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

/**
 * Created by Poker on 2016/12/25.
 */
public class ChessFrame extends JFrame {

    private JPanel board, scoreBoard;
    private Chess[][] chesses;
    private JButton doublePlayerMode, computerMode;
    private JLabel modeLabel;
    private JLabel scoreTitleLabel, scoreLabel, player1ScoreLabel, player2ScoreLabel;

    private Map<Object, Integer> chessStates;
    private int currPlayer;   //1-white 2-black
    private boolean isWhite;
    private int currMode;   //1-doubleplayer 2-computer
    private int score1, score2, scorePlayer, scoreComputer;

    private static final int CHESS_NUM = 8;
    private static final int CHESS_SIZE = 30;
    private static final Color BOARD_BACKGROUND = new Color(160, 82, 45);
    private static final Color WHITE = Color.WHITE;
    private static final Color BLACK = Color.BLACK;
    private static final String BOARD_PLAYER1 = "player1(black): ";
    private static final String BOARD_PLAYER2 = "player2(white): ";
    private static final String BOARD_PLAYER = "player(black): ";
    private static final String BOARD_COMPUTER = "computer(white): ";


    public ChessFrame() throws Exception {
        this.setSize(600, 400);
        this.setTitle("Maze");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        initField();
        initLayout();
        this.setVisible(true);
    }


    private void initField() {
        chesses = new Chess[CHESS_NUM][CHESS_NUM];
        chessStates = new HashMap<Object, Integer>();
        currPlayer = 1;
        currMode = 0;
        score1 = 0;
        score2 = 0;
    }


    private void initLayout() {
        board = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                for (int i = 1; i < CHESS_NUM; i++) {
                    g.drawLine(0, CHESS_SIZE * i, getWidth(), CHESS_SIZE * i);
                    g.drawLine(CHESS_SIZE * i, 0, CHESS_SIZE * i, getHeight());

                }
            }
        };
        board.setBackground(BOARD_BACKGROUND);
        board.setBounds(50, 50, 240, 240);
        board.setLayout(null);
        this.add(board);

        modeLabel = new JLabel("当前模式：");
        modeLabel.setBounds(330, 100, 200, 30);
        this.add(modeLabel);

        doublePlayerMode = new JButton("双人模式");
        doublePlayerMode.setBounds(330, 50, 100, 30);
        this.add(doublePlayerMode);
        doublePlayerMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeLabel.setText("当前模式：双人模式");
                currPlayer = 2;
                currMode = 1;
                score1 = 0;
                score2 = 0;
                initDoublePlayerMode();
            }
        });

        computerMode = new JButton("人机模式");
        computerMode.setBounds(450, 50, 100, 30);
        this.add(computerMode);
        computerMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeLabel.setText("当前模式：人机模式");
                currPlayer = 2;
                currMode = 2;
                score1 = 0;
                score2 = 0;
                initComputerMode();
            }
        });

        scoreBoard = new JPanel();
        scoreBoard.setLayout(null);
        scoreBoard.setBounds(330, 150, 220, 130);
        scoreBoard.setBackground(Color.LIGHT_GRAY);
        this.add(scoreBoard);

        scoreTitleLabel = new JLabel("记分板");
        scoreTitleLabel.setBounds(20, 10, 100, 30);
        scoreBoard.add(scoreTitleLabel);

        scoreLabel = new JLabel();
        scoreLabel.setBounds(100, 10, 100, 30);
        scoreBoard.add(scoreLabel);

        player1ScoreLabel = new JLabel();
        player1ScoreLabel.setBounds(20, 50, 200, 30);
        player1ScoreLabel.setVisible(false);
        scoreBoard.add(player1ScoreLabel);

        player2ScoreLabel = new JLabel();
        player2ScoreLabel.setBounds(20, 80, 200, 30);
        player2ScoreLabel.setVisible(false);
        scoreBoard.add(player2ScoreLabel);

        chessStates = new HashMap<Object, Integer>();
        for (int i = 0; i < CHESS_NUM; i++) {
            for (int j = 0; j < CHESS_NUM; j++) {
                chesses[i][j] = new Chess(null);
                chessStates.put(chesses[i][j], 0);
                chesses[i][j].setBounds(CHESS_SIZE * i, CHESS_SIZE * j, CHESS_SIZE, CHESS_SIZE);
                chesses[i][j].setVisible(false);
                board.add(chesses[i][j]);
            }
        }

        board.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (currMode) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "请先选择模式", "错误", JOptionPane.ERROR_MESSAGE);
                        return;
                    case 1:
                        int i = e.getX() / CHESS_SIZE;
                        int j = e.getY() / CHESS_SIZE;
                        if (getEatNums(new Position(i, j), currPlayer) == 0) {
                            JOptionPane.showMessageDialog(null, "不能在此处落子", "错误", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (chessStates.get(chesses[i][j]) == 0) {
                            chesses[i][j].setVisible(true);
                            chesses[i][j].setColor(currPlayer == 1 ? WHITE : BLACK);
                            chessStates.put(chesses[i][j], currPlayer);
                            eatChesses(i, j, currPlayer);
                            currPlayer = 1 ^ 2 ^ currPlayer;
//                            System.out.println("if finished:" + ifFinished());
                            if (ifFinished()) {
                                if (player1ScoreLabel.getText().charAt(player1ScoreLabel.getText().length() - 1) == '0') {
                                    JOptionPane.showMessageDialog(null, "player 2 wins", "", JOptionPane.INFORMATION_MESSAGE);
                                    score2++;
                                } else {
                                    JOptionPane.showMessageDialog(null, "player 1 wins", "", JOptionPane.INFORMATION_MESSAGE);
                                    score1++;
                                }
                                initDoublePlayerMode();
                            }
                        }
                        return;
                    case 2:
                        int x = e.getX() / CHESS_SIZE;
                        int y = e.getY() / CHESS_SIZE;
                        if (getEatNums(new Position(x, y), currPlayer) == 0) {
                            JOptionPane.showMessageDialog(null, "不能在此处落子", "错误", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (chessStates.get(chesses[x][y]) == 0) {
                            chesses[x][y].setVisible(true);
                            chesses[x][y].setColor(BLACK);
                            chessStates.put(chesses[x][y], currPlayer);
                            eatChesses(x, y, currPlayer);
//                            System.out.println("if finished:" + ifFinished());
                            if (ifFinished()) {
                                if (player1ScoreLabel.getText().charAt(player1ScoreLabel.getText().length() - 1) == '0') {
                                    JOptionPane.showMessageDialog(null, "computer wins", "", JOptionPane.INFORMATION_MESSAGE);
                                    score2++;
                                } else {
                                    JOptionPane.showMessageDialog(null, "player  wins", "", JOptionPane.INFORMATION_MESSAGE);
                                    score1++;
                                }
                                initDoublePlayerMode();
                            }
                            Position best = getBestPosition(getRelativePositions(), 1);
                            int a = -1;
                            try {
                                Thread.currentThread().sleep(300);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                            chesses[best.x][best.y].setVisible(true);
                            chesses[best.x][best.y].setColor(WHITE);
                            chessStates.put(chesses[best.x][best.y], 1);
                            eatChesses(best.x, best.y, 1);
//                            System.out.println("if finished:" + ifFinished());
                            if (ifFinished()) {
                                if (player1ScoreLabel.getText().charAt(player1ScoreLabel.getText().length() - 1) == '0') {
                                    JOptionPane.showMessageDialog(null, "computer wins", "", JOptionPane.INFORMATION_MESSAGE);
                                    score2++;
                                } else {
                                    JOptionPane.showMessageDialog(null, "player  wins", "", JOptionPane.INFORMATION_MESSAGE);
                                    score1++;
                                }
                                initDoublePlayerMode();
                            }
                        }
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    private void initDoublePlayerMode() {
        player1ScoreLabel.setText(BOARD_PLAYER1 + 2);
        player1ScoreLabel.setVisible(true);
        player2ScoreLabel.setText(BOARD_PLAYER2 + 2);
        player2ScoreLabel.setVisible(true);
        scoreLabel.setText(score1 + " : " + score2);

        for (int i = 0; i < CHESS_NUM; i++) {
            for (int j = 0; j < CHESS_NUM; j++) {
                chesses[i][j].setVisible(false);
                chessStates.put(chesses[i][j], 0);
            }
        }
        chesses[3][3].setColor(WHITE);
        chesses[3][3].setVisible(true);
        chessStates.put(chesses[3][3], 1);
        chesses[3][4].setColor(BLACK);
        chesses[3][4].setVisible(true);
        chessStates.put(chesses[3][4], 2);
        chesses[4][3].setVisible(true);
        chesses[4][3].setColor(BLACK);
        chessStates.put(chesses[4][3], 2);
        chesses[4][4].setColor(WHITE);
        chesses[4][4].setVisible(true);
        chessStates.put(chesses[4][4], 1);
    }


    private void initComputerMode() {
        player1ScoreLabel.setText(BOARD_PLAYER + 2);
        player1ScoreLabel.setVisible(true);
        player2ScoreLabel.setText(BOARD_COMPUTER + 2);
        player2ScoreLabel.setVisible(true);
        scoreLabel.setText(score1 + " : " + score2);

        for (int i = 0; i < CHESS_NUM; i++) {
            for (int j = 0; j < CHESS_NUM; j++) {
                chesses[i][j].setVisible(false);
                chessStates.put(chesses[i][j], 0);
            }
        }
        chesses[3][3].setColor(WHITE);
        chesses[3][3].setVisible(true);
        chessStates.put(chesses[3][3], 1);
        chesses[3][4].setColor(BLACK);
        chesses[3][4].setVisible(true);
        chessStates.put(chesses[3][4], 2);
        chesses[4][3].setVisible(true);
        chesses[4][3].setColor(BLACK);
        chessStates.put(chesses[4][3], 2);
        chesses[4][4].setColor(WHITE);
        chesses[4][4].setVisible(true);
        chessStates.put(chesses[4][4], 1);
    }


    private void eatChesses(int curX, int curY, int curPlayer) {
        // hengxian
        int leftX = -1, rightX = -1;
        for (int i = curX; i >= 0; i--) {
            if (chessStates.get(chesses[i][curY]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][curY]) == curPlayer) {
                leftX = i;
            }
        }
        for (int i = curX; i < CHESS_NUM; i++) {
            if (chessStates.get(chesses[i][curY]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][curY]) == curPlayer) {
                rightX = i;
            }
        }
        for (int i = leftX; i <= rightX; i++) {
            chesses[i][curY].setColor(curPlayer == 1 ? WHITE : BLACK);
            chessStates.put(chesses[i][curY], curPlayer);
        }

        // shuxian
        int topY = -1, buttomY = -1;
        for (int j = curY; j >= 0; j--) {
            if (chessStates.get(chesses[curX][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[curX][j]) == curPlayer) {
                topY = j;
            }
        }
        for (int j = curY; j < CHESS_NUM; j++) {
            if (chessStates.get(chesses[curX][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[curX][j]) == curPlayer) {
                buttomY = j;
            }
        }
        for (int j = topY; j <= buttomY; j++) {
            chesses[curX][j].setColor(curPlayer == 1 ? WHITE : BLACK);
            chessStates.put(chesses[curX][j], curPlayer);
        }

        // you xiexian
        for (int i = curX, j = curY; i >= 0 && j >= 0; i--, j--) {
            if (chessStates.get(chesses[i][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][j]) == curPlayer) {
                leftX = i;
                topY = j;
            }
        }
        for (int i = curX, j = curY; i < CHESS_NUM && j < CHESS_NUM; i++, j++) {
            if (chessStates.get(chesses[i][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][j]) == curPlayer) {
                rightX = i;
                buttomY = j;
            }
        }
        for (int i = leftX, j = topY; i <= rightX && j <= buttomY; i++, j++) {
            chesses[i][j].setColor(curPlayer == 1 ? WHITE : BLACK);
            chessStates.put(chesses[i][j], curPlayer);
        }

        // zuo xiexian
        for (int i = curX, j = curY; i >= 0 && j < CHESS_NUM; i--, j++) {
            if (chessStates.get(chesses[i][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][j]) == curPlayer) {
                leftX = i;
                buttomY = j;
            }
        }
        for (int i = curX, j = curY; i < CHESS_NUM && j >= 0; i++, j--) {
            if (chessStates.get(chesses[i][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][j]) == curPlayer) {
                rightX = i;
                topY = j;
            }
        }
        for (int i = leftX, j = buttomY; i <= rightX && j >= topY; i++, j--) {
            chesses[i][j].setColor(curPlayer == 1 ? WHITE : BLACK);
            chessStates.put(chesses[i][j], curPlayer);
        }
    }


    private Set<Position> getRelativePositions() {
        Set<Position> relPositions = new TreeSet<Position>();
        for (int i = 0; i < CHESS_NUM; i++) {
            for (int j = 0; j < CHESS_NUM; j++) {
                if (chessStates.get(chesses[i][j]) == 0) {
                    continue;
                }
                if (isVaild(i - 1, j) && chessStates.get(chesses[i - 1][j]) == 0) {
                    relPositions.add(new Position(i - 1, j));
                }
                if (isVaild(i + 1, j) && chessStates.get(chesses[i + 1][j]) == 0) {
                    relPositions.add(new Position(i + 1, j));
                }
                if (isVaild(i, j - 1) && chessStates.get(chesses[i][j - 1]) == 0) {
                    relPositions.add(new Position(i, j - 1));
                }
                if (isVaild(i, j + 1) && chessStates.get(chesses[i][j + 1]) == 0) {
                    relPositions.add(new Position(i, j + 1));
                }
                if (isVaild(i - 1, j - 1) && chessStates.get(chesses[i - 1][j - 1]) == 0) {
                    relPositions.add(new Position(i - 1, j - 1));
                }
                if (isVaild(i - 1, j + 1) && chessStates.get(chesses[i - 1][j + 1]) == 0) {
                    relPositions.add(new Position(i - 1, j + 1));
                }
                if (isVaild(i + 1, j - 1) && chessStates.get(chesses[i + 1][j - 1]) == 0) {
                    relPositions.add(new Position(i + 1, j - 1));
                }
                if (isVaild(i + 1, j + 1) && chessStates.get(chesses[i + 1][j + 1]) == 0) {
                    relPositions.add(new Position(i + 1, j + 1));
                }
            }
        }
//        System.out.println(" --- get relatives ---");
//        System.out.println("counts:" + relPositions.size());
        for (Position pos : relPositions) {
//            System.out.println(pos);
        }
//        System.out.println("finish");
        return relPositions;
    }


    private Position getBestPosition(Set<Position> candidates, int curPlayer) {
//        System.out.println(" --- get best candidate ---");
        Position bestPosition = new Position(-1, -1);
        int maxCount = 0;
        for (Position curPosition : candidates) {
            if (!isVaild(curPosition.x, curPosition.y)) {
                continue;
            }
            int curCount = 0;
            // hengxian
            int leftX = -1, rightX = -1;
            for (int i = curPosition.getX() - 1; i >= 0; i--) {
                if (chessStates.get(chesses[i][curPosition.getY()]) == 0) {
                    break;
                }
                if (chessStates.get(chesses[i][curPosition.getY()]) == curPlayer) {
                    leftX = i;
                }
            }
            for (int i = curPosition.getX() + 1; i < CHESS_NUM; i++) {
                if (chessStates.get(chesses[i][curPosition.getY()]) == 0) {
                    break;
                }
                if (chessStates.get(chesses[i][curPosition.getY()]) == curPlayer) {
                    rightX = i;
                }
            }
            if (leftX != -1) {
                for (int i = curPosition.getX() - 1; i >= leftX; i--) {
                    if (chessStates.get(chesses[i][curPosition.getY()]) != curPlayer) {
                        curCount++;
                    }
                }
            }
            if (rightX != -1) {
                for (int i = curPosition.getX() + 1; i < rightX; i++) {
                    if (chessStates.get(chesses[i][curPosition.getY()]) != curPlayer) {
                        curCount++;
                    }
                }
            }

            // shuxian
            int topY = -1, buttomY = -1;
            for (int j = curPosition.getY() - 1; j >= 0; j--) {
                if (chessStates.get(chesses[curPosition.getX()][j]) == 0) {
                    break;
                }
                if (chessStates.get(chesses[curPosition.getX()][j]) == curPlayer) {
                    topY = j;
                }
            }
            for (int j = curPosition.getY() + 1; j < CHESS_NUM; j++) {
                if (chessStates.get(chesses[curPosition.getX()][j]) == 0) {
                    break;
                }
                if (chessStates.get(chesses[curPosition.getX()][j]) == curPlayer) {
                    buttomY = j;
                }
            }
            if (topY != -1) {
                for (int j = curPosition.getY() - 1; j >= topY; j--) {
                    if (chessStates.get(chesses[curPosition.getX()][j]) != curPlayer) {
                        curCount++;
                    }
                }
            }
            if (buttomY != -1) {
                for (int j = curPosition.getY() + 1; j <= buttomY; j++) {
                    if (chessStates.get(chesses[curPosition.getX()][j]) != curPlayer) {
                        curCount++;
                    }
                }
            }

            // you xiexian
            leftX = -1;
            rightX = -1;
            topY = -1;
            buttomY = -1;
            for (int i = curPosition.getX() - 1, j = curPosition.getY() - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessStates.get(chesses[i][j]) == 0) {
                    break;
                }
                if (chessStates.get(chesses[i][j]) == curPlayer) {
                    leftX = i;
                    topY = j;
                }
            }
            for (int i = curPosition.getX() + 1, j = curPosition.getY() + 1; i < CHESS_NUM && j < CHESS_NUM; i++, j++) {
                if (chessStates.get(chesses[i][j]) == 0) {
                    break;
                }
                if (chessStates.get(chesses[i][j]) == curPlayer) {
                    rightX = i;
                    buttomY = j;
                }
            }
            if (leftX != -1 && topY != -1) {
                for (int i = curPosition.getX() - 1, j = curPosition.getY() - 1; i >= leftX && j >= topY; i--, j--) {
                    if (chessStates.get(chesses[i][j]) != curPlayer) {
                        curCount++;
                    }
                }
            }
            if (rightX != -1 && buttomY != -1) {
                for (int i = curPosition.getX() + 1, j = curPosition.getY() + 1; i <= rightX && j <= buttomY; i++, j++) {
                    if (chessStates.get(chesses[i][j]) != curPlayer) {
                        curCount++;
                    }
                }
            }

            // zuo xiexian
            leftX = -1;
            rightX = -1;
            topY = -1;
            buttomY = -1;
            for (int i = curPosition.getX() - 1, j = curPosition.getY() + 1; i >= 0 && j < CHESS_NUM; i--, j++) {
                if (chessStates.get(chesses[i][j]) == 0) {
                    break;
                }
                if (chessStates.get(chesses[i][j]) == curPlayer) {
                    leftX = i;
                    buttomY = j;
                }
            }
            for (int i = curPosition.getX() + 1, j = curPosition.getY() - 1; i < CHESS_NUM && j >= 0; i++, j--) {
                if (chessStates.get(chesses[i][j]) == 0) {
                    break;
                }
                if (chessStates.get(chesses[i][j]) == curPlayer) {
                    rightX = i;
                    topY = j;
                }
            }
            if (leftX != -1 && buttomY != -1) {
                for (int i = curPosition.getX() - 1, j = curPosition.getY() + 1; i >= leftX && j <= buttomY; i--, j++) {
                    if (chessStates.get(chesses[i][j]) != curPlayer) {
                        curCount++;
                    }
                }
            }
            if (rightX != -1 && topY != -1) {
                for (int i = curPosition.getX() + 1, j = curPosition.getY() - 1; i <= rightX && j >= topY; i++, j--) {
                    if (chessStates.get(chesses[i][j]) != curPlayer) {
                        curCount++;
                    }
                }
            }
//            System.out.println(curPosition + " " + curCount);
            if (curCount > maxCount) {
                maxCount = curCount;
                bestPosition = curPosition;
            }
        }
//        System.out.println("best:" + bestPosition + " " + maxCount);
        return bestPosition;
    }

    private int getEatNums(Position curPosition, int curPlayer) {
        if (!isVaild(curPosition.x, curPosition.y)) {
            return 0;
        }
        int curCount = 0;
        // hengxian
        int leftX = -1, rightX = -1;
        for (int i = curPosition.getX() - 1; i >= 0; i--) {
            if (chessStates.get(chesses[i][curPosition.getY()]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][curPosition.getY()]) == curPlayer) {
                leftX = i;
            }
        }
        for (int i = curPosition.getX() + 1; i < CHESS_NUM; i++) {
            if (chessStates.get(chesses[i][curPosition.getY()]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][curPosition.getY()]) == curPlayer) {
                rightX = i;
            }
        }
        if (leftX != -1) {
            for (int i = curPosition.getX() - 1; i >= leftX; i--) {
                if (chessStates.get(chesses[i][curPosition.getY()]) != curPlayer) {
                    curCount++;
                }
            }
        }
        if (rightX != -1) {
            for (int i = curPosition.getX() + 1; i < rightX; i++) {
                if (chessStates.get(chesses[i][curPosition.getY()]) != curPlayer) {
                    curCount++;
                }
            }
        }

        // shuxian
        int topY = -1, buttomY = -1;
        for (int j = curPosition.getY() - 1; j >= 0; j--) {
            if (chessStates.get(chesses[curPosition.getX()][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[curPosition.getX()][j]) == curPlayer) {
                topY = j;
            }
        }
        for (int j = curPosition.getY() + 1; j < CHESS_NUM; j++) {
            if (chessStates.get(chesses[curPosition.getX()][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[curPosition.getX()][j]) == curPlayer) {
                buttomY = j;
            }
        }
        if (topY != -1) {
            for (int j = curPosition.getY() - 1; j >= topY; j--) {
                if (chessStates.get(chesses[curPosition.getX()][j]) != curPlayer) {
                    curCount++;
                }
            }
        }
        if (buttomY != -1) {
            for (int j = curPosition.getY() + 1; j <= buttomY; j++) {
                if (chessStates.get(chesses[curPosition.getX()][j]) != curPlayer) {
                    curCount++;
                }
            }
        }

        // you xiexian
        leftX = -1;
        rightX = -1;
        topY = -1;
        buttomY = -1;
        for (int i = curPosition.getX() - 1, j = curPosition.getY() - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessStates.get(chesses[i][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][j]) == curPlayer) {
                leftX = i;
                topY = j;
            }
        }
        for (int i = curPosition.getX() + 1, j = curPosition.getY() + 1; i < CHESS_NUM && j < CHESS_NUM; i++, j++) {
            if (chessStates.get(chesses[i][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][j]) == curPlayer) {
                rightX = i;
                buttomY = j;
            }
        }
        if (leftX != -1 && topY != -1) {
            for (int i = curPosition.getX() - 1, j = curPosition.getY() - 1; i >= leftX && j >= topY; i--, j--) {
                if (chessStates.get(chesses[i][j]) != curPlayer) {
                    curCount++;
                }
            }
        }
        if (rightX != -1 && buttomY != -1) {
            for (int i = curPosition.getX() + 1, j = curPosition.getY() + 1; i <= rightX && j <= buttomY; i++, j++) {
                if (chessStates.get(chesses[i][j]) != curPlayer) {
                    curCount++;
                }
            }
        }

        // zuo xiexian
        leftX = -1;
        rightX = -1;
        topY = -1;
        buttomY = -1;
        for (int i = curPosition.getX() - 1, j = curPosition.getY() + 1; i >= 0 && j < CHESS_NUM; i--, j++) {
            if (chessStates.get(chesses[i][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][j]) == curPlayer) {
                leftX = i;
                buttomY = j;
            }
        }
        for (int i = curPosition.getX() + 1, j = curPosition.getY() - 1; i < CHESS_NUM && j >= 0; i++, j--) {
            if (chessStates.get(chesses[i][j]) == 0) {
                break;
            }
            if (chessStates.get(chesses[i][j]) == curPlayer) {
                rightX = i;
                topY = j;
            }
        }
        if (leftX != -1 && buttomY != -1) {
            for (int i = curPosition.getX() - 1, j = curPosition.getY() + 1; i >= leftX && j <= buttomY; i--, j++) {
                if (chessStates.get(chesses[i][j]) != curPlayer) {
                    curCount++;
                }
            }
        }
        if (rightX != -1 && topY != -1) {
            for (int i = curPosition.getX() + 1, j = curPosition.getY() - 1; i <= rightX && j >= topY; i++, j--) {
                if (chessStates.get(chesses[i][j]) != curPlayer) {
                    curCount++;
                }
            }
        }
        return curCount;
    }


    private boolean isVaild(int x, int y) {
        if (x < 0 || x > CHESS_NUM - 1 || y < 0 || y > CHESS_NUM - 1) {
            return false;
        } else {
            return true;
        }
    }


    private boolean ifFinished() {
        int defaultCount = 0, whiteCount = 0, blackCount = 0;
        for (int i = 0; i < CHESS_NUM; i++) {
            for (int j = 0; j < CHESS_NUM; j++) {
                switch (chessStates.get(chesses[i][j])) {
                    case 0:
                        defaultCount++;
                        break;
                    case 1:
                        whiteCount++;
                        break;
                    case 2:
                        blackCount++;
                        break;
                    default:
                        break;
                }
            }
        }
        player1ScoreLabel.setText(player1ScoreLabel.getText().split(" ")[0] + " " + blackCount);
        player2ScoreLabel.setText(player2ScoreLabel.getText().split(" ")[0] + " " + whiteCount);
//        System.out.println("blank:" + defaultCount + ", white:" + whiteCount + ", black:" + blackCount);
        if (defaultCount == 0) {
            return true;
        }
        if (defaultCount != 0 && (whiteCount == 0 || blackCount == 0)) {
            return true;
        }
        return false;
    }


    private int getWinner() {
        int defaultCount = 0, whiteCount = 0, blackCount = 0;
        for (int i = 0; i < CHESS_NUM; i++) {
            for (int j = 0; j < CHESS_NUM; j++) {
                switch (chessStates.get(chesses[i][j])) {
                    case 0:
                        defaultCount++;
                        break;
                    case 1:
                        whiteCount++;
                        break;
                    case 2:
                        blackCount++;
                        break;
                    default:
                        break;
                }
            }
        }
        if (whiteCount == blackCount) {
            return 0;
        }
        return whiteCount > blackCount ? 1 : 2;
    }


    private class Position implements Comparable {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x=" + x + ", y=" + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Position)) {
                return false;
            }
            return ((Position) obj).getX() == x && ((Position) obj).getY() == y;
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Position)) {
                return -1;
            }
            return (x - ((Position) o).getX()) * 100 + (y - ((Position) o).getY());
        }

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
    }

}
