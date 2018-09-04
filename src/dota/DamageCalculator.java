package dota;

import dota.base.Hero;
import dota.base.HeroData;
import util.FileUtil;
import util.JsonUtil;

/**
 * Author: liuxiao
 * Created: 2018/8/18 23:32
 * Description:
 */
public class DamageCalculator {

    public static void main(String[] args) {
        DamageCalculator calculator = new DamageCalculator();
        Hero tiny = new Hero(JsonUtil.fromJson(FileUtil.readFromFile("src/dota/data/hero_tiny.json"), HeroData.class));
        System.out.println("Tiny's max VT-damage plan:\n");
        for (int heroLevel = 1; heroLevel < 10; heroLevel++) {
            System.out.println("heroLevel=" + heroLevel);
            calculator.calculateMaxVTDamage(tiny.getHeroData(), heroLevel);
            System.out.println();
        }
    }

    private float calculateMaxVTDamage(HeroData heroData, int currHeroLevel) {
        float maxVTDamage = 0;
        String log = "";
        for (int finalSkillLevel = 0; finalSkillLevel <= currHeroLevel / 6; finalSkillLevel++) {
            int leftSkillLevel = currHeroLevel - finalSkillLevel;
            for (int vLevel = 0; vLevel <= (leftSkillLevel + 1) / 2; vLevel++) {
                int tLevel = leftSkillLevel - vLevel;
                boolean valid = checkNormalSkillLevel(vLevel, currHeroLevel) && checkNormalSkillLevel(tLevel, currHeroLevel);
                if (valid) {
                    int vDamage = vLevel == 0 ? 0 : (int) (heroData.getFirstSkill().getValues()[vLevel - 1]);
                    int tDamage = tLevel == 0 ? 0 : (int) (heroData.getSecondSkill().getValues()[tLevel - 1]);
                    float addition = 0.20f;
                    if (finalSkillLevel >= 1) {
                        addition = heroData.getFinalSkill().getValues()[finalSkillLevel - 1];
                    }

                    float vtOriDamage = calculateVTDamage(vDamage, tDamage, addition);
                    float hitOriDamage = finalSkillLevel == 0 ? 70 * 3 : 120 * 3;
                    float totalOriDamage = vtOriDamage + hitOriDamage;
                    float vtRealDamage = vtOriDamage * 0.75f;
                    float hitRealDamage = hitOriDamage * 0.9f; //2护甲
                    float totalRealDamage = vtRealDamage + hitRealDamage;

                    if (totalOriDamage > maxVTDamage) {
                        maxVTDamage = totalOriDamage;
                        log = "vLevel=" + vLevel + ", tLevel=" + tLevel + ", wLevel=" + finalSkillLevel + ", valid=" + valid
                                + "\nvDamage=" + vDamage + ", tDamage=" + tDamage + ", addition=" + addition
                                + "\nvtOriDamage=" + vtOriDamage + ", hitOriDamage=" + hitOriDamage
                                + ", totalOriDamage=" + totalOriDamage
                                + "\nvtRealDamage=" + vtRealDamage + ", hitRealDamage=" + hitRealDamage
                                + ", totalRealDamage=" + totalRealDamage;
                    }
                }
            }
        }
        System.out.println(log);
        return maxVTDamage;
    }

    private float calculateVTDamage(int vDamage, int tDamage, float addition) {
        if (tDamage == 0) {
            return vDamage;
        } else {
            return vDamage * 2 + tDamage * (1 + addition);
        }
    }

    private boolean checkNormalSkillLevel(int skillLevel, int heroLevel) {
        if (skillLevel > 4) {
            return false;
        }
        if (skillLevel <= (heroLevel + 1) / 2) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkFinalSkillLevel(int skillLevel, int heroLevel) {
        if (skillLevel > 3) {
            return false;
        }
        if (skillLevel <= heroLevel / 6) {
            return true;
        } else {
            return false;
        }
    }

}
