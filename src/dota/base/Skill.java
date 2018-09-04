package dota.base;

import base.IGsonBean;

/**
 * Author: liuxiao
 * Created: 2018/8/18 23:48
 * Description:
 */
public class Skill implements IGsonBean {

    private String name;
    private float[] values;

    public String getName() {
        return name;
    }

    public Skill setName(String name) {
        this.name = name;
        return this;
    }

    public float[] getValues() {
        return values;
    }

    public Skill setValues(float[] values) {
        this.values = values;
        return this;
    }
}
