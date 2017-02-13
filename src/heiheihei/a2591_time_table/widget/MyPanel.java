package heiheihei.a2591_time_table.widget;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Poker on 2016/12/28.
 */
public class MyPanel extends JPanel {

    private boolean up;
    private boolean bottom;
    private boolean left;
    private boolean right;

    public MyPanel(boolean up, boolean bottom, boolean left, boolean right) {
        this.up = up;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, getWidth(), 0);
        g.drawLine(0, 0, 0, getHeight());
        g.drawLine(getWidth(), 0, getWidth(), getHeight());
        g.drawLine(0, getHeight(), getWidth(), getHeight());
        ((Graphics2D) g).setStroke(new BasicStroke(3));
        if (up) {
            g.drawLine(0, 0, getWidth(), 0);
        }
        if (bottom) {
            g.drawLine(0, getHeight(), getWidth(), getHeight());
        }
        if (left) {
            g.drawLine(0, 0, 0, getHeight());
        }
        if (right) {
            g.drawLine(getWidth(), 0, getWidth(), getHeight());
        }
        this.setBackground(Color.WHITE);
    }
}
