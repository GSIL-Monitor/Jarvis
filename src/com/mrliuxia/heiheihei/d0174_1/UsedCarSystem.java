package com.mrliuxia.heiheihei.d0174_1;

import java.io.*;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Poker on 2016/12/7.
 */
public class UsedCarSystem {

    private static Scanner cin;
    private static Garage garage;   //车库
    private static File data;   //存储车库信息的文件

    public static void main(String[] args) {
        cin = new Scanner(System.in);
        data = new File("data.txt");
        garage = new Garage();
        loadData();
        welcome();
        showMenu();
        while (cin.hasNext()) {
            operate(cin.next());
        }
    }

    /**
     * 从文本中读取车库信息
     */
    private static void loadData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(data));
            garage.setLeftSpace(Double.parseDouble(reader.readLine()));
            String s = "";
            while (!(s = reader.readLine()).equals("")) {
                String[] a = s.split(",");
                String id = s.split(",")[0];
                String color = s.split(",")[1];
                String kind = s.split(",")[2];
                String state = s.split(",")[3];
                String inDate = s.split(",")[4];
                double inPrice = Double.parseDouble(s.split(",")[5]);
                String outDate = s.split(",")[6];
                double outPrice = Double.parseDouble(s.split(",")[7]);
                Vechile v = new Vechile(id, color, kind, state, inDate, inPrice, outDate, outPrice);
                garage.getVechiles().add(v);
            }
            while ((s = reader.readLine()) != null) {
                String id = s.split(",")[0];
                String color = s.split(",")[1];
                String kind = s.split(",")[2];
                String state = s.split(",")[3];
                String inDate = s.split(",")[4];
                double inPrice = Double.parseDouble(s.split(",")[5]);
                String outDate = s.split(",")[6];
                double outPrice = Double.parseDouble(s.split(",")[7]);
                Vechile v = new Vechile(id, color, kind, state, inDate, inPrice, outDate, outPrice);
                garage.getSoldVechiles().add(v);
            }
        } catch (IOException e) {
            System.out.println("file doesn't exist");
            e.printStackTrace();
        }
    }

    /**
     * 欢迎信息
     */
    private static void welcome() {
        System.out.println("**************************");
        System.out.println("*                        *");
        System.out.println("*      Joe's Garage      *");
        System.out.println("*                        *");
        System.out.println("**************************");
    }

    /**
     * 显示主菜单
     */
    private static void showMenu() {
        System.out.println("> Operations");
        System.out.println(" 1 : add a new vechile");
        System.out.println(" 2 : sell a vechile");
        System.out.println(" 3 : check and update a vehile");
        System.out.println(" 4 : print current vechiles ");
        System.out.println(" 5 : print eligible vechiles");
        System.out.println(" 6 : record of sold vechiles");
        System.out.println(" 7 : quit");
    }

    /**
     * 操作
     *
     * @param s 操作符
     */
    private static void operate(String s) {
        switch (s) {
            case "1":
                addVechile();
                System.out.println("---------------------------------");
                showMenu();
                break;
            case "2":
                sellVechile();
                System.out.println("---------------------------------");
                showMenu();
                break;
            case "3":
                chechVechile();
                System.out.println("---------------------------------");
                showMenu();
                break;
            case "4":
                showVechiles();
                System.out.println("---------------------------------");
                showMenu();
                break;
            case "5":
                printEilVechiles();
                System.out.println("---------------------------------");
                showMenu();
                break;
            case "6":
                showReport();
                System.out.println("---------------------------------");
                showMenu();
                break;
            case "7":
                System.out.println("thanks");
                saveGarage();
                break;
            default:
                error();
        }
    }

    /**
     * 向车库中添加车辆的逻辑
     */
    private static void addVechile() {
        String id, color, kind, state, inDate, outDate;
        double inPrice, outPrice;
        System.out.println("> Add a new vechile:");
        System.out.print(" in date(eg:2016/12/01): ");
        inDate = cin.next();
        if (!checkDate(inDate)) return;
        System.out.print(" id: ");
        id = cin.next();
        System.out.print(" kind(car/motor/van/truck): ");
        kind = cin.next();
        if (!checkKind(kind)) return;
        System.out.print(" state(new/used/damaged/crashed): ");
        state = cin.next();
        if (!checkState(state)) return;
        System.out.print(" color: ");
        color = cin.next();
        System.out.print(" in price(float): ");
        try {
            inPrice = cin.nextDouble();
        } catch (Exception e) {
            error();
            return;
        }
        Vechile v;
        try {
            v = new Vechile(id, color, kind, state, inDate, inPrice, "", 0);
        } catch (Exception e) {
            error();
            return;
        }
        if (garage.addVechile(v)) {
            System.out.println("Success.");
        } else {
            System.out.println("Failed.");
        }
    }

    /**
     * 从车库出售车辆的逻辑
     */
    private static void sellVechile() {
        System.out.println("> Sell a vechile:");
        System.out.print(" id: ");
        String id = cin.next();
        System.out.print(" date: ");
        String outDate = cin.next();
        if (!checkDate(outDate)) return;
        System.out.print(" price: ");
        double outPrice;
        try {
            outPrice = cin.nextDouble();
        } catch (Exception e) {
            error();
            return;
        }
        if (garage.sellVechile(id, outDate, outPrice)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed! reason: doesn't has this vechile.");
        }
    }

    /**
     * 检查并更新车辆信息的逻辑
     */
    private static void chechVechile() {
        System.out.println("> Check and update:");
        System.out.print(" id: ");
        String id = cin.next();
        System.out.print(" updated state(new/used/damaged/crashed):");
        String state = cin.next();
        if (!checkState(state)) return;
        if (garage.checkVechile(id, state)) {
            System.out.println("Success.");
        } else {
            error();
            return;
        }

    }

    /**
     * 显示车库中现有车辆列表信息的逻辑
     */
    private static void showVechiles() {
        System.out.println("> State:");
        System.out.println(" left space:" + garage.getLeftSpace());
        System.out.println(" vechiles:");
        System.out.println(String.format("%-16s", "IN DATE") + String.format("%-8s", "ID") +
                String.format("%-8s", "KIND") + String.format("%-12s", "STATE") +
                String.format("%-8s", "COLOR") + String.format("%-14s", "IN PRICE") +
                String.format("%-10s", "OUT PRICE"));
        for (Vechile v : garage.getVechiles()) {
            System.out.print(String.format("%-12s", v.getInDate()) + '\t' +
                    String.format("%-6s", v.getId()) + '\t' +
                    String.format("%-6s", v.getKind()) + '\t' +
                    String.format("%-8s", v.getState()) + '\t' +
                    String.format("%-6s", v.getColor()) + '\t' +
                    String.format("%-8s", v.getInPrice()) + '\t' + "  " +
                    String.format("%-7s", v.getOutPrice()) + '\n');
        }
    }

    /**
     * 根据color和state查询符合条件的车辆的逻辑
     */
    private static void printEilVechiles() {
        System.out.println("> Query:");
        System.out.println(" conditions(skip->\"s\"):");
        System.out.print(" color:");
        String color = cin.next();
        color = (color.equals("s")) ? null : color;
        System.out.print(" state(new/used/damaged/crashed):");
        String state = cin.next();
        state = (state.equals("s")) ? null : state;
        Set<Vechile> set = garage.query(color, state);
        showVechiles(set);
    }

    /**
     * 将set中车辆打印出
     *
     * @param set
     */
    private static void showVechiles(Set<Vechile> set) {
        System.out.println("> Result:");
        System.out.println(String.format("%-16s", "In Date") + String.format("%-8s", "ID") +
                String.format("%-8s", "Kind") + String.format("%-12s", "State") +
                String.format("%-8s", "Color") + String.format("%-14s", "In Price") +
                String.format("%-10s", "Out Price"));
        for (Vechile v : set) {
            System.out.print(String.format("%-12s", v.getInDate()) + '\t' +
                    String.format("%-6s", v.getId()) + '\t' +
                    String.format("%-6s", v.getKind()) + '\t' +
                    String.format("%-8s", v.getState()) + '\t' +
                    String.format("%-6s", v.getColor()) + '\t' +
                    String.format("%-8s", v.getInPrice()) + '\t' + "  " +
                    String.format("%-7s", v.getOutPrice()) + '\n');
        }
    }

    /**
     * 打印已经售出车辆的信息
     */
    private static void showReport() {
        System.out.println("> Sold Report:");
        System.out.println(String.format("%-16s", "In Date") + String.format("%-8s", "ID") +
                String.format("%-8s", "Kind") + String.format("%-12s", "State") +
                String.format("%-8s", "Color") + String.format("%-14s", "In Price") +
                String.format("%-10s", "Out Price"));
        for (Vechile v : garage.getSoldVechiles()) {
            System.out.print(String.format("%-12s", v.getInDate()) + '\t' +
                    String.format("%-6s", v.getId()) + '\t' +
                    String.format("%-6s", v.getKind()) + '\t' +
                    String.format("%-8s", v.getState()) + '\t' +
                    String.format("%-6s", v.getColor()) + '\t' +
                    String.format("%-8s", v.getInPrice()) + '\t' + "  " +
                    String.format("%-7s", v.getOutPrice()) + '\n');
        }
    }

    /**
     * 报错
     */
    private static void error() {
        System.out.println("error: invalid format");
    }

    /**
     * 将现有信息保存到文本中
     */
    private static void saveGarage() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(data));
            writer.println(garage.getLeftSpace());
            for (Vechile v : garage.getVechiles()) {
                writer.println(v);
            }
            writer.println();
            for (Vechile v : garage.getSoldVechiles()) {
                writer.println(v);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("file doesn't exist");
            e.printStackTrace();
        }
    }

    /**
     * 检查s作为车辆种类是否合法
     *
     * @param s
     * @return
     */
    private static boolean checkKind(String s) {
        if (s.equals("car") || s.equals("motor") || s.equals("van") || s.equals("truck")) {
            return true;
        } else {
            error();
            return false;
        }
    }

    /**
     * 检查s作为车辆状态是否合法
     *
     * @param s
     * @return
     */
    private static boolean checkState(String s) {
        if (s.equals("new") || s.equals("used") || s.equals("damaged") || s.equals("crashed")) {
            return true;
        } else {
            error();
            return false;
        }
    }

    /**
     * 检查s作为日期是否合法
     *
     * @param s
     * @return
     */
    private static boolean checkDate(String s) {
        try {
            int a = Integer.parseInt(s.split("/")[0]);
            int b = Integer.parseInt(s.split("/")[1]);
            int c = Integer.parseInt(s.split("/")[2]);
        } catch (Exception e) {
            error();
            return false;
        }
        return true;
    }


}
