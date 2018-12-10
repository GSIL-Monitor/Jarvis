package com.mrliuxia.heiheihei.d0174_used_car_system;

/**
 * Created by Poker on 2016/12/7.
 */
public class Vechile implements Comparable {

    private String id;          //车辆id
    private String color;       //车辆颜色
    private String kind;        //车辆种类 car motor van truck
    private String state;       //车辆状态 new used crashed damaged
    private String inDate;      //车辆加入车库（买入）时间
    private double inPrice;     //车辆买入价格
    private String outDate;     //车辆卖出时间
    private double outPrice;    //车辆卖出价格

    private double space;       //车辆占用空间
    private int date;           //用于比较时间先后

    public Vechile(String id, String color, String kind, String state
            , String inDate, double inPrice, String outDate, double outPrice) {
        this.id = id;
        this.color = color;
        this.kind = kind;
        this.state = state;
        this.inDate = inDate;
        this.inPrice = inPrice;
        this.outDate = outDate;
        this.outPrice = outPrice;
        switch (kind) {
            case "motor":
                this.space = 0.5;
                break;
            case "car":
                this.space = 1;
                break;
            case "van":
                this.space = 2;
                break;
            case "truck":
                this.space = 4;
                break;
        }
        this.date = Integer.parseInt(inDate.split("/")[0]) * 10000 +
                Integer.parseInt(inDate.split("/")[1]) * 100 +
                Integer.parseInt(inDate.split("/")[2]);
    }

    @Override
    public String toString() {
        return id + "," + color + "," + kind + "," + state + ","
                + inDate + "," + inPrice + "," + outDate + "," + outPrice;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Vechile)) {
            return -1;
        }
        return this.date - ((Vechile) o).date;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vechile)) {
            return false;
        }
        if (((Vechile) obj).getId() == this.getId()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public double getInPrice() {
        return inPrice;
    }

    public void setInPrice(double inPrice) {
        this.inPrice = inPrice;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(double outPrice) {
        this.outPrice = outPrice;
    }

    public double getSpace() {
        return space;
    }

    public void setSpace(double space) {
        this.space = space;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
