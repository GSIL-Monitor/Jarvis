package com.mrliuxia.design_pattern.builder;

/**
 * Description: 可口可乐
 * Author: liuxiao
 * Date: 2018/3/30
 */
public class CokeDrinkItem extends BaseColdDrinkItem {

    @Override
    public String getName() {
        return "CokeDrinkItem";
    }

    @Override
    public float getPrice() {
        return 2.0f;
    }
}
