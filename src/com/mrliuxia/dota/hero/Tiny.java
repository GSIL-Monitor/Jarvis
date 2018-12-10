package com.mrliuxia.dota.hero;

import com.mrliuxia.dota.base.BaseHero;
import com.mrliuxia.dota.base.BaseSkill;
import com.mrliuxia.util.JsonUtil;

/**
 * Author: liuxiao
 * Created: 2018/8/18 23:36
 * Description:
 * first skill:     v - 75 150 225 300
 * second skill:    t - 100 180 260 300 , * 120%
 * final skill:     135% 150% 165%
 */
public class Tiny {


    public static void main(String[] args) {
        BaseHero hero = new BaseHero("Tiny");
        BaseSkill skill1 = new BaseSkill("v", 100, 180, 260, 300);
        BaseSkill skill2 = new BaseSkill("t", 75, 150, 225, 300);
        BaseSkill skill3 = new BaseSkill("c", 25, 35, 45, 55);
        BaseSkill skill4 = new BaseSkill("w", 1.35f, 1.5f, 1.65f);
        hero.firstSkill(skill1).secondSkill(skill2).thirdSkill(skill3).finalSkill(skill4);
        System.out.println(JsonUtil.toJson(hero));
    }

}
