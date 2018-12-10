package com.mrliuxia.design_pattern.builder;

/**
 * Description: 一条商品
 * Author: liuxiao
 * Date: 2018/3/30
 */
public interface IItem {

    String getName();

    IPacking getPacking();

    float getPrice();

}
