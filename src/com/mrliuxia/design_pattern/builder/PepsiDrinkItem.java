package com.mrliuxia.design_pattern.builder;

/**
 * Description: 百事可乐
 * Author: liuxiao
 * Date: 2018/3/30
 */
public class PepsiDrinkItem extends BaseColdDrinkItem {

    @Override
    public String getName() {
        return "PepsiDrinkItem";
    }

    @Override
    public float getPrice() {
        return 2.0f;
    }
}
