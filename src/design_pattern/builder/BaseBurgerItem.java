package design_pattern.builder;

/**
 * Description: 汉堡item基类
 * Author: liuxiao
 * Date: 2018/3/30
 */
public abstract class BaseBurgerItem implements IItem {

    private IPacking mPacking;

    public BaseBurgerItem() {
        mPacking = new WrapperPacking();
    }

    @Override
    public IPacking getPacking() {
        return mPacking;
    }

}
