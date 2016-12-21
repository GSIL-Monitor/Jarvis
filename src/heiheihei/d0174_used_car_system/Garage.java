package heiheihei.d0174_used_car_system;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Poker on 2016/12/7.
 */
public class Garage {

    private double leftSpace;
    private Set<Vechile> onsale;
    private Set<Vechile> sold;

    public Garage() {
        this.leftSpace = 20;
        this.onsale = new TreeSet<>();
        this.sold = new TreeSet<>();
    }

    /**
     * 向车库中添加车辆
     * @param v 车辆
     * @return
     */
    public boolean addVechile(Vechile v) {
        this.onsale.add(v);
        if (v.getKind().equals("car")) {
            if (leftSpace < 1) {
                return false;
            } else {
                leftSpace = leftSpace - 1;
                return true;
            }
        }
        if (v.getKind().equals("motor")) {
            if (leftSpace < 0.5) {
                return false;
            } else {
                leftSpace = leftSpace - 0.5;
                return true;
            }
        }
        if (v.getKind().equals("van")) {
            if (leftSpace < 2) {
                return false;
            } else {
                leftSpace = leftSpace - 2;
                return true;
            }
        }
        if (v.getKind().equals("truck")) {
            if (leftSpace < 4) {
                return false;
            } else {
                leftSpace = leftSpace - 4;
                return true;
            }
        }
        return false;
    }

    /**
     * 卖出车辆
     * @param id 车辆id
     * @param date 卖出时间
     * @param price 卖出价格
     * @return
     */
    public boolean sellVechile(String id, String date, double price) {
        Vechile v = null;
        for (Vechile v1 : onsale) {
            if (v1.getId().equals(id)) {
                v = v1;
                onsale.remove(v);
                break;
            }
        }
        if (v == null) {
            return false;
        }
        v.setState("sold");
        v.setOutDate(date);
        v.setOutPrice(price);
        sold.add(v);
        if (v.getKind().equals("car")) {
            leftSpace += 1;
            return true;
        }
        if (v.getKind().equals("motor")) {
            leftSpace += 0.5;
            return true;
        }
        if (v.getKind().equals("van")) {
            leftSpace += 2;
            return true;
        }
        if (v.getKind().equals("truck")) {
            leftSpace += 4;
            return true;
        }
        return false;
    }

    /**
     * 检查车辆，更新状态
     * @param id 车辆id
     * @param newState 车辆更新后状态
     * @return
     */
    public boolean checkVechile(String id, String newState) {
        for (Vechile v : onsale) {
            if (v.getId().equals(id)) {
                v.setState(newState);
                return true;
            }
        }
        return false;
    }

    /**
     * 根据颜色和状态查询车辆
     * @param color 颜色
     * @param state 状态
     * @return
     */
    public Set<Vechile> query(String color, String state) {
        Set<Vechile> set = new TreeSet<>();
        for (Vechile v : onsale) {
            if ((color == null || v.getColor().equals(color))
                    && (state == null || v.getState().equals(state))){
                set.add(v);
            }
        }
        return set;
    }

    public double getLeftSpace() {
        return leftSpace;
    }

    public void setLeftSpace(double leftSpace) {
        this.leftSpace = leftSpace;
    }

    public Set<Vechile> getOnsale() {
        return onsale;
    }

    public void setOnsale(Set<Vechile> onsale) {
        this.onsale = onsale;
    }

    public Set<Vechile> getSold() {
        return sold;
    }

    public void setSold(Set<Vechile> sold) {
        this.sold = sold;
    }
}
