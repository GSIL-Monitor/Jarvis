package heiheihei.w0082_simple_operator;

import sun.lwawt.macosx.CWarningWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by Poker on 2016/12/21.
 */
public class OperatorFrame extends JFrame {

    private String lastNum, lastOpr;
    private Queue<String> numQueue, oprQueue;
    private boolean flag;

    private JTextField resultTxt;
    private JButton ceBtn, addBtn, minusBtn, multiplyBtn, divideBtn, calculateBtn, pointBtn;
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    private static final int CELL_WIDTH = 80;
    private static final int CELL_HEIGHT = 50;

    public OperatorFrame() throws Exception {
        this.setSize(320, 280);
        this.setTitle("Simple Operator");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
//        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        initField();
        initLayout();
        this.setVisible(true);
    }

    private void initField() {
        flag = false;
        lastNum = "";
        lastOpr = "";
        numQueue = new LinkedList<>();
        oprQueue = new LinkedList<>();
    }

    private void initLayout() {
        resultTxt = new JTextField("0");
        resultTxt.setBackground(Color.WHITE);
        resultTxt.setBounds(0, 0, CELL_WIDTH * 3, CELL_HEIGHT);
//        resultTxt.setEnabled(false);
        resultTxt.setEditable(false);
        this.add(resultTxt);

        ceBtn = new JButton("CE");
        ceBtn.setBounds(CELL_WIDTH * 3, 0, CELL_WIDTH, CELL_HEIGHT);
        ceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initField();
                resultTxt.setText("0");
            }
        });
        this.add(ceBtn);

        btn7 = new JButton("7");
        btn7.setBounds(0, CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    oprQueue.add(resultTxt.getText());
                }
                if (resultTxt.getText().equals("0") || flag) {
                    resultTxt.setText("7");
                    flag = false;
                } else {
                    resultTxt.setText(resultTxt.getText() + "7");
                }
            }
        });
        this.add(btn7);

        btn8 = new JButton("8");
        btn8.setBounds(CELL_WIDTH, CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    oprQueue.add(resultTxt.getText());
                }
                if (resultTxt.getText().equals("0") || flag) {
                    resultTxt.setText("8");
                    flag = false;
                } else {
                    resultTxt.setText(resultTxt.getText() + "8");
                }
            }
        });
        this.add(btn8);

        btn9 = new JButton("9");
        btn9.setBounds(CELL_WIDTH * 2, CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    oprQueue.add(resultTxt.getText());
                }
                if (resultTxt.getText().equals("0") || flag) {
                    resultTxt.setText("9");
                    flag = false;
                } else {
                    resultTxt.setText(resultTxt.getText() + "9");
                }
            }
        });
        this.add(btn9);

        btn4 = new JButton("4");
        btn4.setBounds(0, CELL_HEIGHT * 2, CELL_WIDTH, CELL_HEIGHT);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    oprQueue.add(resultTxt.getText());
                }
                if (resultTxt.getText().equals("0") || flag) {
                    resultTxt.setText("4");
                    flag = false;
                } else {
                    resultTxt.setText(resultTxt.getText() + "4");
                }
            }
        });
        this.add(btn4);

        btn5 = new JButton("5");
        btn5.setBounds(CELL_WIDTH, CELL_HEIGHT * 2, CELL_WIDTH, CELL_HEIGHT);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    oprQueue.add(resultTxt.getText());
                }
                if (resultTxt.getText().equals("0") || flag) {
                    resultTxt.setText("5");
                    flag = false;
                } else {
                    resultTxt.setText(resultTxt.getText() + "5");
                }
            }
        });
        this.add(btn5);

        btn6 = new JButton("6");
        btn6.setBounds(CELL_WIDTH * 2, CELL_HEIGHT * 2, CELL_WIDTH, CELL_HEIGHT);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    oprQueue.add(resultTxt.getText());
                }
                if (resultTxt.getText().equals("0") || flag) {
                    resultTxt.setText("6");
                    flag = false;
                } else {
                    resultTxt.setText(resultTxt.getText() + "6");
                }
            }
        });
        this.add(btn6);

        btn1 = new JButton("1");
        btn1.setBounds(0, CELL_HEIGHT * 3, CELL_WIDTH, CELL_HEIGHT);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    oprQueue.add(resultTxt.getText());
                }
                if (resultTxt.getText().equals("0") || flag) {
                    resultTxt.setText("1");
                    flag = false;
                } else {
                    resultTxt.setText(resultTxt.getText() + "1");
                }
            }
        });
        this.add(btn1);

        btn2 = new JButton("2");
        btn2.setBounds(CELL_WIDTH, CELL_HEIGHT * 3, CELL_WIDTH, CELL_HEIGHT);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    oprQueue.add(resultTxt.getText());
                }
                if (resultTxt.getText().equals("0") || flag) {
                    resultTxt.setText("2");
                    flag = false;
                } else {
                    resultTxt.setText(resultTxt.getText() + "2");
                }
            }
        });
        this.add(btn2);

        btn3 = new JButton("3");
        btn3.setBounds(CELL_WIDTH * 2, CELL_HEIGHT * 3, CELL_WIDTH, CELL_HEIGHT);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    oprQueue.add(resultTxt.getText());
                }
                if (resultTxt.getText().equals("0") || flag) {
                    resultTxt.setText("3");
                    flag = false;
                } else {
                    resultTxt.setText(resultTxt.getText() + "3");
                }
            }
        });
        this.add(btn3);

        btn0 = new JButton("0");
        btn0.setBounds(0, CELL_HEIGHT * 4, CELL_WIDTH, CELL_HEIGHT);
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currResult = resultTxt.getText();
                if (flag || currResult.equals("0")) {
                    resultTxt.setText("0");
                } else {
                    resultTxt.setText(currResult + "0");
                }
                flag = false;
            }
        });
        this.add(btn0);

        pointBtn = new JButton(".");
        pointBtn.setBounds(CELL_WIDTH, CELL_HEIGHT * 4, CELL_WIDTH, CELL_HEIGHT);
        pointBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currResult = resultTxt.getText();
                if (flag) {
                    resultTxt.setText("0.");
                } else {
                    resultTxt.setText(currResult + ".");
                }
            }
        });
        this.add(pointBtn);

        divideBtn = new JButton("/");
        divideBtn.setBounds(CELL_WIDTH * 3, CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
        divideBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flag) {
                    numQueue.add(resultTxt.getText());
                }
                resultTxt.setText("/");
                flag = true;
            }
        });
        this.add(divideBtn);

        multiplyBtn = new JButton("*");
        multiplyBtn.setBounds(CELL_WIDTH * 3, CELL_HEIGHT * 2, CELL_WIDTH, CELL_HEIGHT);
        multiplyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flag) {
                    numQueue.add(resultTxt.getText());
                }
                resultTxt.setText("*");
                flag = true;
            }
        });
        this.add(multiplyBtn);

        minusBtn = new JButton("-");
        minusBtn.setBounds(CELL_WIDTH * 3, CELL_HEIGHT * 3, CELL_WIDTH, CELL_HEIGHT);
        minusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flag) {
                    numQueue.add(resultTxt.getText());
                }
                resultTxt.setText("-");
                flag = true;
            }
        });
        this.add(minusBtn);

        addBtn = new JButton("+");
        addBtn.setBounds(CELL_WIDTH * 3, CELL_HEIGHT * 4, CELL_WIDTH, CELL_HEIGHT);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flag) {
                    numQueue.add(resultTxt.getText());
                }
                resultTxt.setText("+");
                flag = true;
            }
        });
        this.add(addBtn);

        calculateBtn = new JButton("=");
        calculateBtn.setBounds(CELL_WIDTH * 2, CELL_HEIGHT * 4, CELL_WIDTH, CELL_HEIGHT);
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numQueue.add(resultTxt.getText());
                resultTxt.setText(calculate(numQueue, oprQueue));
            }
        });
        this.add(calculateBtn);
    }

    private String calculate(Queue<String> nums, Queue<String> oprs) {
        while (nums.size() > 1) {
            String num1 = nums.poll();
            String num2 = nums.poll();
            String opr = oprs.poll();
            switch (opr) {
                case "+":
                    nums.add(OperatorUtil.add(num1, num2));
                    break;
                case "-":
                    nums.add(OperatorUtil.minus(num1, num2));
                    break;
                case "*":
                    nums.add(OperatorUtil.multiply(num1, num2));
                    break;
                case "/":
                    nums.add(OperatorUtil.divide(num1, num2));
                    break;
            }
        }
        return nums.poll();
    }


    public static void main(String[] args) throws Exception {
        new OperatorFrame();
    }


}
