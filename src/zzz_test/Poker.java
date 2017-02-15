package zzz_test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pokerface_lx on 16/8/16.
 */
public class Poker extends JFrame {

    public static void main(String[] args) throws Exception {
        System.out.println(2.0f-1.9f);
    }

    private static long createPalindrom(long num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }

    public Poker() throws Exception{
        this.setSize(600, 400);
        this.setTitle("Pk");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());


        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());


        JButton jb1 = new JButton();
        jb1.setBackground(Color.black);
        this.add(jb1);


        this.setVisible(true);
    }
}
