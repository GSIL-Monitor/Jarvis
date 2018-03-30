package design_pattern.builder;

/**
 * Description: 鸡肉汉堡
 * Author: liuxiao
 * Date: 2018/3/30
 */
public class ChickenBurgerItem extends BaseBurgerItem {

    @Override
    public String getName() {
        return "ChickenBurgerItem";
    }

    @Override
    public float getPrice() {
        return 6.0f;
    }
}
