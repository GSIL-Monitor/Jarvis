package heiheihei.a2591_time_table.model;

import java.util.Comparator;

/**
 * Created by Poker on 2016/12/28.
 */
public class Course implements Comparable{

    private String t;
    private Integer sy;
    private Integer sm;
    private Integer sd;
    private Integer ey;
    private Integer em;
    private Integer ed;
    private Integer week;
    private Integer sc;
    private Integer ec;
    private String sub;
    private String cr;
    private String tea;

    public Course(String t, Integer sy, Integer sm, Integer sd, Integer ey, Integer em, Integer ed,
                  Integer week, Integer sc, Integer ec, String sub, String cr, String tea) {
        this.t = t;
        this.sy = sy;
        this.sm = sm;
        this.sd = sd;
        this.ey = ey;
        this.em = em;
        this.ed = ed;
        this.week = week;
        this.sc = sc;
        this.ec = ec;
        this.sub = sub;
        this.cr = cr;
        this.tea = tea;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Course)) {
            return -1;
        }
//        return ((Course) o).getSc().compareTo(this.sc);
        return sc.compareTo(((Course) o).getSc());
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public Integer getSy() {
        return sy;
    }

    public void setSy(Integer sy) {
        this.sy = sy;
    }

    public Integer getSm() {
        return sm;
    }

    public void setSm(Integer sm) {
        this.sm = sm;
    }

    public Integer getSd() {
        return sd;
    }

    public void setSd(Integer sd) {
        this.sd = sd;
    }

    public Integer getEy() {
        return ey;
    }

    public void setEy(Integer ey) {
        this.ey = ey;
    }

    public Integer getEm() {
        return em;
    }

    public void setEm(Integer em) {
        this.em = em;
    }

    public Integer getEd() {
        return ed;
    }

    public void setEd(Integer ed) {
        this.ed = ed;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getSc() {
        return sc;
    }

    public void setSc(Integer sc) {
        this.sc = sc;
    }

    public Integer getEc() {
        return ec;
    }

    public void setEc(Integer ec) {
        this.ec = ec;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }
}
