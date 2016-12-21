package zzz_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Poker on 2016/12/18.
 */
public class TestBackground extends JFrame {
    Color background;
    JPanel buttons = new JPanel();
    JButton red = new JButton("red");
    JButton green = new JButton("green");
    JButton yellow = new JButton("yellow");

    TestBackground() {
        ButtonGroup ni = new ButtonGroup();
        ni.add(red);
        ni.add(green);
        ni.add(yellow);
        buttons.setLayout(new FlowLayout());
        red.setOpaque(true);
        red.setBackground(Color.red);
        buttons.add(red);
        buttons.add(green);
        buttons.add(yellow);
        setLayout(new BorderLayout());
        add(buttons, BorderLayout.SOUTH);
        red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.red);
                repaint();
            }
        });
        yellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.yellow);
                repaint();
            }
        });
        green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                green.setBackground(Color.green);
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(this.getBackground());
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        red.repaint();
        yellow.repaint();
        green.repaint();
    }

    public static void main(String[] args) {
        TestBackground mine = new TestBackground();
        mine.setTitle("Test");
        mine.setSize(800, 600);
        mine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mine.setVisible(true);
    }
}
