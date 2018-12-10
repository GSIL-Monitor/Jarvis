package com.mrliuxia.heiheihei.w0068_count_words;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Poker on 2016/12/12.
 */
public class CountWordsFrame extends JFrame implements ActionListener {

    private JPanel top;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu;
    private JMenuItem addFileItem, quitItem;
    private JMenuItem showCountsItem, inquireItem;
    private JPanel filePanel;
    private JScrollPane contentPanel, countPanel;
    private ArrayList<JButton> fileButtons;
    private JTextArea contentTxt, countTxt;
    private Set<File> files;
    private Map<File, Map<String, Integer>> totalMap;
    private Set<String> keywordSet;

    public static void main(String[] args) {
        new CountWordsFrame();
    }

    @SuppressWarnings("unchecked")
    public CountWordsFrame() {
        this.setSize(600, 400);
        this.setTitle("Count Words 1.0");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        layoutComponents();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void layoutComponents() {
        // menu bar
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        addFileItem = new JMenuItem("Add file");
        addFileItem.addActionListener(this);
        fileMenu.add(addFileItem);

        quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);
        fileMenu.add(quitItem);

        editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        showCountsItem = new JMenuItem("Show counts");
        showCountsItem.addActionListener(this);
        editMenu.add(showCountsItem);

        inquireItem = new JMenuItem("Query");
        inquireItem.addActionListener(this);
        editMenu.add(inquireItem);

        // init field
        fileButtons = new ArrayList<>();
        files = new HashSet<>();
        totalMap = new HashMap<>();

        this.setLayout(new GridLayout(1, 3));
        filePanel = new JPanel();
        filePanel.setBackground(Color.LIGHT_GRAY);
        this.add(filePanel);

        contentTxt = new JTextArea();
        contentTxt.setLineWrap(true);
        contentPanel = new JScrollPane(contentTxt);
        contentPanel.setBackground(Color.GRAY);
        this.add(contentPanel);

        countTxt = new JTextArea();
        countTxt.setLineWrap(true);
        countPanel = new JScrollPane(countTxt);
        countPanel.setBackground(Color.GRAY);
        this.add(countPanel);


    }

    @SuppressWarnings("unchecked")
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFileItem) {
            JFileChooser jsc = new JFileChooser();
            jsc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            jsc.showDialog(new JLabel(), "Choose file");
            File file = jsc.getSelectedFile();
            JButton fBtn;
            if (file == null) {
                return;
            }
            if (files.contains(file)) {
                return;
            }
            files.add(file);
            fBtn = new JButton(file.getName());
            fileButtons.add(fBtn);
            filePanel.add(fBtn);
            try {
                LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
                FileReader reader = new FileReader(file);
                int a = -1;
                StringBuilder sb1 = new StringBuilder("File Content:\n");
                StringBuilder sb2 = new StringBuilder();
                while ((a = reader.read()) != -1) {
                    sb1.append((char) a);
                    if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
                        sb2.append((char) a);
                    } else {
                        int value = map.containsKey(sb2.toString()) ? map.get(sb2.toString()) + 1 : 1;
                        map.put(sb2.toString(), value);
                        sb2 = new StringBuilder();
                    }
                }
                if (sb2.length() > 0) {
                    int value = map.containsKey(sb2.toString()) ? map.get(sb2.toString()) + 1 : 1;
                    map.put(sb2.toString(), value);
                }
                totalMap.put(file, map);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            fBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
                        FileReader reader = new FileReader(file);
                        int a = -1;
                        StringBuilder sb1 = new StringBuilder("File Content:\n");
                        StringBuilder sb2 = new StringBuilder();
                        while ((a = reader.read()) != -1) {
                            if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
                                sb2.append((char) a);
                            } else {
                                if (keywordSet != null && keywordSet.size() > 0 && keywordSet.contains(sb2.toString())) {
                                    sb1.append("\"").append(sb2.toString() + "\" ");
                                }else {
                                    sb1.append(sb2.toString()+" ");
                                }
                                int value = map.containsKey(sb2.toString()) ? map.get(sb2.toString()) + 1 : 1;
                                map.put(sb2.toString(), value);
                                sb2 = new StringBuilder();
                            }
                        }
                        if (sb2.length() > 0) {
                            int value = map.containsKey(sb2.toString()) ? map.get(sb2.toString()) + 1 : 1;
                            map.put(sb2.toString(), value);
                        }
                        totalMap.put(file, map);
                        contentTxt.setText(sb1.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Keyword  ---  Count\n");
                        for (String keyword : map.keySet()) {
                            if (keyword == null || keyword.length() == 0) {
                                continue;
                            }
                            sb3.append(keyword).append("  ---  ").append(map.get(keyword)).append("\n");
                        }
                        countTxt.setText(sb3.toString());
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            });
            filePanel.revalidate();
        }
        if (e.getSource() == quitItem) {
            System.exit(0);
        }
        if (e.getSource() == showCountsItem) {
            StringBuilder sb = new StringBuilder();
            Map<String, Integer> map = new HashMap<>();
            try {
                for (File file : files) {
                    FileReader reader = new FileReader(file);
                    int a;
                    while ((a = reader.read()) != -1) {
                        if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
                            sb.append((char) a);
                        } else {
                            int value = map.containsKey(sb.toString()) ? map.get(sb.toString()) + 1 : 1;
                            map.put(sb.toString(), value);
                            sb = new StringBuilder();
                        }
                    }
                    if (sb.length() > 0) {
                        int value = map.containsKey(sb.toString()) ? map.get(sb.toString()) + 1 : 1;
                        map.put(sb.toString(), value);
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            sb = new StringBuilder();
            sb.append("Total counts:\nWord  ---  Count\n");
            for (String word : map.keySet()) {
                if (word == null || word.length() == 0) {
                    continue;
                }
                sb.append(word + "  ---  " + map.get(word) + "\n");
            }
            countTxt.setText(sb.toString());
        }
        if (e.getSource() == inquireItem) {
            String query = JOptionPane.showInputDialog(this, "Enter your query");
            if (query == null) return;
            Set[] res = query(query);
            Set<File> resultSet = res[0];
            keywordSet = res[1];
            StringBuilder sb = new StringBuilder();
            sb.append("There are ").append(resultSet.size()).append(" files fulfilling the condition:\n");
            for (File file : resultSet) {
                sb.append(file.getName()).append("\n");
            }
            countTxt.setText(sb.toString());
        }
    }

    @SuppressWarnings("unchecked")
    private Set<File> query(String keyword, boolean flag) {
        Set<File> set = new HashSet<>();
        if (flag) {
            for (File file : totalMap.keySet()) {
                if (totalMap.get(file).containsKey(keyword)) {
                    set.add(file);
                }
            }
        } else {
            for (File file : totalMap.keySet()) {
                if (!totalMap.get(file).containsKey(keyword)) {
                    set.add(file);
                }
            }
        }
        return set;
    }

    @SuppressWarnings("unchecked")
    private Set<File>[] query(String query) {
        Set<String> keywordSet = new HashSet<>();
        Set<File> resultSet = new HashSet<>();
        String[] ss = query.split(" ");
        for (int i = 0; i < ss.length; i++) {
            switch (ss[i]) {
                case "NOT":
                    i++;
                    String key1 = ss[i].substring(1, ss[i].length() - 1);
                    resultSet.addAll(query(key1, false));
                    break;
                case "AND":
                    i++;
                    if (!ss[i].equals("NOT")) {
                        String key2 = ss[i].substring(1, ss[i].length() - 1);
                        keywordSet.add(key2);
                        Iterator<File> it = resultSet.iterator();
                        while (it.hasNext()) {
                            File file = it.next();
                            if (!totalMap.get(file).containsKey(key2)) {
                                it.remove();
                            }
                        }
                    } else {
                        i++;
                        String key2 = ss[i].substring(1, ss[i].length() - 1);
                        if (keywordSet.contains(key2)) keywordSet.remove(key2);
                        Iterator<File> it = resultSet.iterator();
                        while (it.hasNext()) {
                            File file = it.next();
                            if (totalMap.get(file).containsKey(key2)) {
                                it.remove();
                            }
                        }
                    }
                    break;
                case "OR":
                    i++;
                    if (!ss[i].equals("NOT")) {
                        String key3 = ss[i].substring(1, ss[i].length() - 1);
                        keywordSet.add(key3);
                        resultSet.addAll(query(key3, true));
                    } else {
                        i++;
                        String key3 = ss[i].substring(1, ss[i].length() - 1);
                        if (keywordSet.contains(key3)) keywordSet.remove(key3);
                        resultSet.addAll(query(key3, false));
                    }
                    break;
                default:
                    String key = ss[i].substring(1, ss[i].length() - 1);
                    keywordSet.add(key);
                    resultSet.addAll(query(key, true));
                    break;
            }
        }
        return new Set[]{resultSet, keywordSet};
    }

}
