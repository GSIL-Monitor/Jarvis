package com.mrliuxia.dota.base;

/**
 * Author: liuxiao
 * Created: 2018/8/19 18:33
 * Description:
 */
public class Hero {

    private HeroData mHeroData;
    public int level, firstSkillLevel, secondSkillLevel, thirdSkillLevel, finalSkillLevel;

    public Hero(HeroData heroData) {
        this.mHeroData = heroData;
    }

    public HeroData getHeroData() {
        return mHeroData;
    }
}
