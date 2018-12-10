package com.mrliuxia.dota.base;

import com.mrliuxia.base.IGsonBean;

/**
 * Author: liuxiao
 * Created: 2018/8/19 17:29
 * Description:
 */
public class HeroData implements IGsonBean {

    private String name;
    private Skill firstSkill;
    private Skill secondSkill;
    private Skill thirdSkill;
    private Skill finalSkill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getFirstSkill() {
        return firstSkill;
    }

    public void setFirstSkill(Skill firstSkill) {
        this.firstSkill = firstSkill;
    }

    public Skill getSecondSkill() {
        return secondSkill;
    }

    public void setSecondSkill(Skill secondSkill) {
        this.secondSkill = secondSkill;
    }

    public Skill getThirdSkill() {
        return thirdSkill;
    }

    public void setThirdSkill(Skill thirdSkill) {
        this.thirdSkill = thirdSkill;
    }

    public Skill getFinalSkill() {
        return finalSkill;
    }

    public void setFinalSkill(Skill finalSkill) {
        this.finalSkill = finalSkill;
    }
}
