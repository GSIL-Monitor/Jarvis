package dota.base;

/**
 * Author: liuxiao
 * Created: 2018/8/18 23:42
 * Description:
 */
public class BaseHero {

    private String name;
    private int hexoLevel;
    private int firstSkillLevel;
    private int secondSkillLevel;
    private int thirdSkillLevel;
    private int finalSkillLevel;
    private ISkill firstSkill;
    private ISkill secondSkill;
    private ISkill thirdSkill;
    private ISkill finalSkill;

    public BaseHero(String name) {
        this.name = name;
    }

    public BaseHero firstSkill(ISkill firstSkill) {
        this.firstSkill = firstSkill;
        return this;
    }

    public BaseHero secondSkill(ISkill secondSkill) {
        this.secondSkill = secondSkill;
        return this;
    }

    public BaseHero thirdSkill(ISkill thirdSkill) {
        this.thirdSkill = thirdSkill;
        return this;
    }

    public BaseHero finalSkill(ISkill finalSkill) {
        this.finalSkill = finalSkill;
        return this;
    }
}
