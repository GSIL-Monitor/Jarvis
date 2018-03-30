package design_pattern.builder;

/**
 * Description: 凉饮料item基类
 * Author: liuxiao
 * Date: 2018/3/30
 */
public abstract class BaseColdDrinkItem implements IItem {

    private IPacking mPacking;

    public BaseColdDrinkItem() {
        this.mPacking = new BottlePacking();
    }

    @Override
    public IPacking getPacking() {
        return mPacking;
    }

}
