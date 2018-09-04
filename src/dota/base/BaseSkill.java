package dota.base;

import java.util.Arrays;

/**
 * Author: liuxiao
 * Created: 2018/8/18 23:50
 * Description:
 */
public class BaseSkill implements ISkill {

    private String name;
    private float[] damangeList;

    public BaseSkill(String name, float... damangeList) {
        this.name = name;
        this.damangeList = damangeList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getDamage(int level) {
        return damangeList[level];
    }

    @Override
    public String toString() {
        return String.format("Skill: [name=%s, damangeList=%s]", name, Arrays.asList(damangeList));
    }

    public BaseSkill name(String name) {
        this.name = name;
        return this;
    }

    public BaseSkill damage(float... damageList) {
        this.damangeList = damageList;
        return this;
    }
}
