package heiheihei.d0206_count_words;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Poker on 2016/12/11.
 */
public class CountWords {

    private static Map<String, LinkedHashMap<String, Integer>> totalMap;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        welcome();
        showMenu();
//        totalMap.put("data1.txt", readFile(new File("data1.txt")));
//        totalMap.put("data2.txt", readFile(new File("data2.txt")));
        while (scan.hasNextLine()) {
            String s = scan.nextLine().toUpperCase();
            switch (s) {
                case "A":
                    addFile();
                    break;
                case "P":
                    printCounts();
                    break;
                case "I":
                    try {
                        inquire();
                    } catch (Exception e) {
                        System.out.println("your input is invalid");
                    }
                    break;
                case "Q":
                    return;
                case "":
                    break;
                default:
                    System.out.println("your input is invalid");
                    showMenu();
                    break;
            }
        }
    }

    private static void welcome() {
        System.out.println("================================");
        System.out.println("          Count Words");
        System.out.println("================================");
        totalMap = new HashMap<>();
    }

    private static void showMenu() {
        System.out.println(" A: add a new file");
        System.out.println(" P: print word counts");
        System.out.println(" I: inquire");
        System.out.println(" Q: quit");
    }

    private static void addFile() {
        System.out.print("please input file path: ");
        String path = scan.next();
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("the file doesn't exist");
            showMenu();
            return;
        }
        totalMap.put(path, readFile(file));
        System.out.println("add succeed\n");
        showMenu();
    }

    private static LinkedHashMap<String, Integer> readFile(File file) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        try {
            StringBuilder sb = new StringBuilder();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    private static void printCounts() {
        for (String path : totalMap.keySet()) {
            System.out.println("File " + path + ": ");
            System.out.println(String.format("%-10s", "Word") + String.format("%-10s", "Count"));
            HashMap<String, Integer> map = totalMap.get(path);
            for (String s : map.keySet()) {
                System.out.println(String.format("%-10s", s) + String.format("%-10s", map.get(s)));
            }
        }
        System.out.println();
        showMenu();
    }

    private static void inquire() {
        System.out.print("please input your query:");
        inquire(scan.nextLine());
    }

    private static void inquire(String s) {
        Set<String> keywordSet = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        String[] ss = s.split(" ");
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
                        Iterator<String> it = resultSet.iterator();
                        while (it.hasNext()) {
                            String path = it.next();
                            if (!totalMap.get(path).containsKey(key2)) {
                                it.remove();
                            }
                        }
                    } else {
                        i++;
                        String key2 = ss[i].substring(1, ss[i].length() - 1);
                        if (keywordSet.contains(key2)) keywordSet.remove(key2);
                        Iterator<String> it = resultSet.iterator();
                        while (it.hasNext()) {
                            String path = it.next();
                            if (totalMap.get(path).containsKey(key2)) {
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
        System.out.println("There are " + resultSet.size() + " files fulfilling the condition:");
        for (String path : resultSet) {
            System.out.print(path + "  ");
        }
        System.out.println("\nShow them?  Y/N");
        if (scan.next().equals("Y")) {
            for (String path :resultSet) {
                System.out.println("File "+path+":");
                try {
                    StringBuilder sb = new StringBuilder();
                    FileReader reader = new FileReader(new File(path));
                    int a;
                    while ((a = reader.read()) != -1) {
                        if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
                            sb.append((char) a);
                        } else {
                            if (keywordSet.contains(sb.toString())) {
                                sb.insert(0,"\"").append("\"");
                            }
                            System.out.print(sb.toString()+(char)a);
                            sb = new StringBuilder();
                        }
                    }
                    if (sb.length() > 0) {
                        if (keywordSet.contains(sb.toString())) {
                            sb.insert(0,"\"").append("\"");
                        }
                        System.out.print(sb.toString()+(char)a);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print('\n');
            }
        }
        System.out.println();
        showMenu();
    }

    private static Set<String> query(String keyword, boolean flag) {
        Set<String> set = new HashSet<>();
        if (flag) {
            for (String path : totalMap.keySet()) {
                if (totalMap.get(path).containsKey(keyword)) {
                    set.add(path);
                }
            }
        } else {
            for (String path : totalMap.keySet()) {
                if (!totalMap.get(path).containsKey(keyword)) {
                    set.add(path);
                }
            }
        }
        return set;
    }

}
