package heiheihei.a2591_time_table;

import heiheihei.a2591_time_table.model.Course;
import heiheihei.a2591_time_table.widget.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Poker on 2016/12/27.
 */
public class Table extends JFrame {

    private List<Course> courseList;

    private JPanel tablePanel;
    private MyPanel titlePanel, subTitlePanel;

    private static final int CELL_HEIGHT = 30;
    private static final int CELL_WIDTH = 150;
    private static final int NO_WIDTH = 50;
    private static final int TABLE_WIDTH = 500;
    private static final int TABLE_HEIGHT = CELL_HEIGHT * 16;

    public Table() throws Exception {
            this.setSize(600, 600);
            this.setTitle("Time Table");
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
        courseList = new ArrayList<>();
        courseList.add(new Course("16-17-2", 2016, 9, 27, 2016, 11, 30,
                2, 2, 4, "高数", "J7-1", "陈华"));
        courseList.add(new Course("16-17-2", 2016, 9, 27, 2016, 11, 30,
                2, 7, 8, "英语", "J7-2", "陈华"));
        Collections.sort(courseList);
    }

    private void initLayout() {
        // table
        tablePanel = new JPanel() {
        };
        tablePanel.setBackground(Color.PINK);
        tablePanel.setBounds(50, 30, TABLE_WIDTH, TABLE_HEIGHT);
        tablePanel.setLayout(null);
        this.add(tablePanel);

        // title
        titlePanel = new MyPanel(true, false, true, true);
        titlePanel.setBounds(0, 0, TABLE_WIDTH, CELL_HEIGHT);
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(new JLabel("当日课表"));
        tablePanel.add(titlePanel);

        // subtitle
        subTitlePanel = new MyPanel(false, false, false, false);
        subTitlePanel.setBounds(0, CELL_HEIGHT, TABLE_WIDTH, CELL_HEIGHT);
        subTitlePanel.setBackground(Color.WHITE);
        subTitlePanel.setLayout(null);
        tablePanel.add(subTitlePanel);

        MyPanel subTitleNoPanel = new MyPanel(false, false, true, false);
        subTitleNoPanel.setBounds(0, 0, NO_WIDTH, CELL_HEIGHT);
        subTitlePanel.add(subTitleNoPanel);

        MyPanel subTitleSubPanel = new MyPanel(false, false, false, false);
        subTitleSubPanel.setBounds(NO_WIDTH, 0, CELL_WIDTH, CELL_HEIGHT);
        subTitleSubPanel.add(new JLabel("科目"));
        subTitlePanel.add(subTitleSubPanel);

        MyPanel subTitleTeaPanel = new MyPanel(false, false, false, false);
        subTitleTeaPanel.setBounds(NO_WIDTH + CELL_WIDTH, 0, CELL_WIDTH, CELL_HEIGHT);
        subTitleTeaPanel.add(new JLabel("教师"));
        subTitlePanel.add(subTitleTeaPanel);

        MyPanel subTitleCrPanel = new MyPanel(false, false, false, true);
        subTitleCrPanel.setBounds(NO_WIDTH + CELL_WIDTH * 2, 0, CELL_WIDTH, CELL_HEIGHT);
        subTitleCrPanel.add(new JLabel("教室"));
        subTitlePanel.add(subTitleCrPanel);

        int currCourseIndex = 0;
        for (int i = 1; i <= 13; i++) {
            MyPanel noPanel = new MyPanel(false, false, true, false);
            noPanel.setBounds(0, CELL_HEIGHT * (i + 1), NO_WIDTH, CELL_HEIGHT);
            noPanel.add(new JLabel(i + ""));
            tablePanel.add(noPanel);
        }

        MyPanel psTitlePanel = new MyPanel(false, true, true, false);
        psTitlePanel.setBounds(0, CELL_HEIGHT * 15, NO_WIDTH, CELL_HEIGHT);
        psTitlePanel.add(new JLabel("备注"));
        tablePanel.add(psTitlePanel);

        MyPanel psContentPanel = new MyPanel(false, true, false, true);
        psContentPanel.setBounds(NO_WIDTH, CELL_HEIGHT * 15, CELL_WIDTH * 3, CELL_HEIGHT);
        tablePanel.add(psContentPanel);

        Course lastCourse = null;

        for (Course c : courseList) {
            int startIndex = 1;
            if (lastCourse != null) {
                startIndex = lastCourse.getEc() + 1;
            }
            System.out.println();
            for (int i = startIndex; i < c.getSc(); i++) {
                MyPanel subPanel = new MyPanel(false, false, false, false);
                subPanel.setBounds(NO_WIDTH, CELL_HEIGHT * (i + 1), CELL_WIDTH, CELL_HEIGHT);
                tablePanel.add(subPanel);

                MyPanel teaPanel = new MyPanel(false, false, false, false);
                teaPanel.setBounds(NO_WIDTH + CELL_WIDTH, CELL_HEIGHT * (i + 1), CELL_WIDTH, CELL_HEIGHT);
                tablePanel.add(teaPanel);

                MyPanel crPanel = new MyPanel(false, false, false, true);
                crPanel.setBounds(NO_WIDTH + CELL_WIDTH * 2, CELL_HEIGHT * (i + 1), CELL_WIDTH, CELL_HEIGHT);
                tablePanel.add(crPanel);
            }
            MyPanel subPanel = new MyPanel(false, false, false, false);
            subPanel.setBounds(NO_WIDTH, CELL_HEIGHT * (c.getSc() + 1), CELL_WIDTH, CELL_HEIGHT * (c.getEc() - c.getSc() + 1));
            subPanel.setBackground(Color.LIGHT_GRAY);
            subPanel.add(new JLabel(c.getSub()));
            tablePanel.add(subPanel);

            MyPanel teaPanel = new MyPanel(false, false, false, false);
            teaPanel.setBounds(NO_WIDTH + CELL_WIDTH, CELL_HEIGHT * (c.getSc() + 1), CELL_WIDTH, CELL_HEIGHT * (c.getEc() - c.getSc() + 1));
            subPanel.setBackground(Color.LIGHT_GRAY);
            teaPanel.add(new JLabel(c.getTea(), JLabel.CENTER));
            tablePanel.add(teaPanel);

            MyPanel crPanel = new MyPanel(false, false, false, true);
            crPanel.setBounds(NO_WIDTH + CELL_WIDTH * 2, CELL_HEIGHT * (c.getSc() + 1), CELL_WIDTH, CELL_HEIGHT * (c.getEc() - c.getSc() + 1));
            subPanel.setBackground(Color.LIGHT_GRAY);
            crPanel.add(new JLabel(c.getCr()));
            tablePanel.add(crPanel);

            lastCourse = c;
        }
        for (int i = lastCourse.getEc() + 1; i <= 13; i++) {
            MyPanel subPanel = new MyPanel(false, false, false, false);
            subPanel.setBounds(NO_WIDTH, CELL_HEIGHT * (i + 1), CELL_WIDTH, CELL_HEIGHT);
            tablePanel.add(subPanel);

            MyPanel teaPanel = new MyPanel(false, false, false, false);
            teaPanel.setBounds(NO_WIDTH + CELL_WIDTH, CELL_HEIGHT * (i + 1), CELL_WIDTH, CELL_HEIGHT);
            tablePanel.add(teaPanel);

            MyPanel crPanel = new MyPanel(false, false, false, true);
            crPanel.setBounds(NO_WIDTH + CELL_WIDTH * 2, CELL_HEIGHT * (i + 1), CELL_WIDTH, CELL_HEIGHT);
            tablePanel.add(crPanel);
        }


    }

    public static void main(String[] args) throws Exception {
        new Table();
    }

}
