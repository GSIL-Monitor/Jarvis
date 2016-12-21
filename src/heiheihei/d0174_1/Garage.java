package heiheihei.d0174_1;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Poker on 2016/12/7.
 */
public class Garage {

    private double leftSpace;
    private Set<Vechile> vechiles;
    private Set<Vechile> soldVechiles;

    public Garage() {
        this.leftSpace = 20;
        this.vechiles = new TreeSet<>();
        this.soldVechiles = new TreeSet<>();
    }

    /**
     * 向车库中添加车辆
     * @param v 车辆
     * @return
     */
    public boolean addVechile(Vechile v) {
        this.vechiles.add(v);
        switch (v.getKind()) {
            case "car":
                if (leftSpace < 1) {
                    return false;
                } else {
                    leftSpace = leftSpace - 1;
                    return true;
                }
            case "motor":
                if (leftSpace < 0.5) {
                    return false;
                } else {
                    leftSpace = leftSpace - 0.5;
                    return true;
                }
            case "van":
                if (leftSpace < 2) {
                    return false;
                } else {
                    leftSpace = leftSpace - 2;
                    return true;
                }
            case "truck":
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
        for (Vechile v1 : vechiles) {
            if (v1.getId().equals(id)) {
                v = v1;
                vechiles.remove(v);
                break;
            }
        }
        if (v == null) {
            return false;
        }
        v.setState("sold");
        v.setOutDate(date);
        v.setOutPrice(price);
        soldVechiles.add(v);
        switch (v.getKind()) {
            case "car":
                leftSpace += 1;
                return true;
            case "motor":
                leftSpace += 0.5;
                return true;
            case "van":
                leftSpace += 2;
                return true;
            case "truck":
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
        for (Vechile v : vechiles) {
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
        for (Vechile v : vechiles) {
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

    public Set<Vechile> getVechiles() {
        return vechiles;
    }

    public void setVechiles(Set<Vechile> vechiles) {
        this.vechiles = vechiles;
    }

    public Set<Vechile> getSoldVechiles() {
        return soldVechiles;
    }

    public void setSoldVechiles(Set<Vechile> soldVechiles) {
        this.soldVechiles = soldVechiles;
    }
}
