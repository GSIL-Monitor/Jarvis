package com.mrliuxia.design_pattern.builder;

/**
 * Description: 蔬菜汉堡item
 * Author: liuxiao
 * Date: 2018/3/30
 */
public class VegetableBurgerItem extends BaseBurgerItem {

    @Override
    public String getName() {
        return "VegetableBurgerItem";
    }

    @Override
    public float getPrice() {
        return 5.0f;
    }
}
