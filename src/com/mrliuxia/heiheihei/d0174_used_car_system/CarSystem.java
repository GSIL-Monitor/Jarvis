package com.mrliuxia.heiheihei.d0174_used_car_system;

import java.io.*;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Poker on 2016/12/7.
 */
public class CarSystem {

    private static Scanner cin;
    private static Garage garage;   //车库
    private static File dataFile;   //存储车库信息的文件

    public CarSystem() {
        this.cin = new Scanner(System.in);
        this.dataFile = new File("data.txt");
        this.garage = new Garage();
        init();
        menu();
        while (cin.hasNext()) {
            operate(cin.next());
        }
    }

    /**
     * 从文本中读取车库信息
     */
    private void init() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataFile));
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
                garage.getOnsale().add(v);
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
                garage.getSold().add(v);
            }
        } catch (IOException e) {
            System.out.println("file doesn't exist");
            e.printStackTrace();
        }
    }

    /**
     * 显示主菜单
     */
    private void menu() {
        System.out.println("Operation Table:");
        System.out.println(" P --- print current vechiles ");
        System.out.println(" A --- add a new one");
        System.out.println(" S --- sell one");
        System.out.println(" C --- check & update one");
        System.out.println(" U --- query vechiles");
        System.out.println(" R --- record of sold vechiles");
        System.out.println(" Q --- quit");
    }

    /**
     * 操作
     * @param s 操作符
     */
    private void operate(String s) {
        switch (s) {
            case "A":
                add();
                menu();
                break;
            case "S":
                sell();
                menu();
                break;
            case "C":
                update();
                menu();
                break;
            case "P":
                showVechiles();
                menu();
                break;
            case "U":
                printQuery();
                menu();
                break;
            case "R":
                report();
                menu();
                break;
            case "Q":
                System.out.println("thanks");
                save();
                break;
            default:
                error();
        }
    }

    /**
     * 向车库中添加车辆的逻辑
     */
    private void add() {
        String id, color, kind, state, inDate, outDate;
        double inPrice, outPrice;
        System.out.println("Add a new vechile:");
        System.out.print(" id: ");
        id = cin.next();
        System.out.print(" color: ");
        color = cin.next();
        System.out.print(" kind(car/motor/van/truck): ");
        kind = cin.next();
        if (!checkKind(kind)) return;
        System.out.print(" state(new/used/damaged/crashed): ");
        state = cin.next();
        if (!checkState(state)) return;
        System.out.print(" in date(eg:2016/12/01): ");
        inDate = cin.next();
        if (!checkDate(inDate)) return;
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
            System.out.println("Success!");
        } else {
            System.out.println("Failed! reason: garage has no more space.");
        }
    }

    /**
     * 从车库出售车辆的逻辑
     */
    private void sell() {
        System.out.print("id: ");
        String id = cin.next();
        System.out.print("date: ");
        String outDate = cin.next();
        if (!checkDate(outDate)) return;
        System.out.print("price: ");
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
    private void update() {
        System.out.print("id: ");
        String id = cin.next();
        System.out.print("new state(new/used/damaged/crashed):");
        String state = cin.next();
        if (!checkState(state)) return;
        if (garage.checkVechile(id, state)) {
            System.out.println("Success!");
        } else {
            error();
            return;
        }

    }

    /**
     * 显示车库中现有车辆列表信息的逻辑
     */
    private void showVechiles() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("State:");
        System.out.println(" left space:" + garage.getLeftSpace());
        System.out.println(" vechiles:");
        System.out.println("|"+String.format("%-8s", "ID") +"|"+ String.format("%-8s", "Color") +"|"+
                String.format("%-8s", "Kind") +"|"+ String.format("%-12s", "State") +"|"+
                String.format("%-16s", "In Date") + "|"+String.format("%-14s", "In Price") +"|"+
                String.format("%-10s", "Out Price")+"|");
        for (Vechile v : garage.getOnsale()) {
            System.out.print("|"+String.format("%-8s", v.getId()) +"|"+
                    String.format("%-8s", v.getColor()) + "|"+
                    String.format("%-8s", v.getKind()) + "|"+
                    String.format("%-12s", v.getState()) + "|"+
                    String.format("%-16s", v.getInDate()) + "|"+
                    String.format("%-14s", v.getInPrice()) + "|"+
                    String.format("%-10s", v.getOutPrice()) + "|\n");
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    /**
     * 根据color和state查询符合条件的车辆的逻辑
     */
    private void printQuery() {
        System.out.println("conditions(skip->\"skip\"):");
        System.out.print(" color:");
        String color = cin.next();
        color = (color.equals("skip")) ? null : color;
        System.out.print(" state(new/used/damaged/crashed):");
        String state = cin.next();
        state = (state.equals("skip")) ? null : state;
        Set<Vechile> set = garage.query(color, state);
        showVechiles(set);
    }

    /**
     * 将set中车辆打印出
     * @param set
     */
    private void showVechiles(Set<Vechile> set) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Result:");
        System.out.println("|"+String.format("%-8s", "ID") +"|"+ String.format("%-8s", "Color") +"|"+
                String.format("%-8s", "Kind") +"|"+ String.format("%-12s", "State") +"|"+
                String.format("%-16s", "In Date") + "|"+String.format("%-14s", "In Price") +"|"+
                String.format("%-10s", "Out Price")+"|");
        for (Vechile v : set) {
            System.out.print("|"+String.format("%-8s", v.getId()) +"|"+
                    String.format("%-8s", v.getColor()) + "|"+
                    String.format("%-8s", v.getKind()) + "|"+
                    String.format("%-12s", v.getState()) + "|"+
                    String.format("%-16s", v.getInDate()) + "|"+
                    String.format("%-14s", v.getInPrice()) + "|"+
                    String.format("%-10s", v.getOutPrice()) + "|\n");
        }
        System.out.println("-----------------------------------------------------------------------------------------");

    }

    /**
     * 打印已经售出车辆的信息
     */
    private void report() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Report:");
        System.out.println("|"+String.format("%-8s", "ID") +"|"+ String.format("%-8s", "Color") +"|"+
                String.format("%-8s", "Kind") +"|"+ String.format("%-12s", "State") +"|"+
                String.format("%-16s", "In Date") + "|"+String.format("%-14s", "In Price") +"|"+
                String.format("%-10s", "Out Price")+"|");
        for (Vechile v : garage.getSold()) {
            System.out.print("|"+String.format("%-8s", v.getId()) +"|"+
                    String.format("%-8s", v.getColor()) + "|"+
                    String.format("%-8s", v.getKind()) + "|"+
                    String.format("%-12s", v.getState()) + "|"+
                    String.format("%-16s", v.getInDate()) + "|"+
                    String.format("%-14s", v.getInPrice()) + "|"+
                    String.format("%-10s", v.getOutPrice()) + "|\n");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    /**
     * 报错
     */
    private void error() {
        System.out.println("input invalid!");
    }

    /**
     * 将现有信息保存到文本中
     */
    private void save() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(dataFile));
            writer.println(garage.getLeftSpace());
            for (Vechile v : garage.getOnsale()) {
                writer.println(v);
            }
            writer.println();
            for (Vechile v : garage.getSold()) {
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
     * @param s
     * @return
     */
    private boolean checkKind(String s) {
        if (s.equals("car") || s.equals("motor") || s.equals("van") || s.equals("truck")) {
            return true;
        } else {
            error();
            return false;
        }
    }

    /**
     * 检查s作为车辆状态是否合法
     * @param s
     * @return
     */
    private boolean checkState(String s) {
        if (s.equals("new") || s.equals("used") || s.equals("damaged") || s.equals("crashed")) {
            return true;
        } else {
            error();
            return false;
        }
    }

    /**
     * 检查s作为日期是否合法
     * @param s
     * @return
     */
    private boolean checkDate(String s) {
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
