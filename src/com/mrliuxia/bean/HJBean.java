package com.mrliuxia.bean;

import java.util.List;

/**
 * Author: liuxiao
 * Created: 2017/10/23 22:45
 * Description:
 */
public class HJBean {

    private Data father;
    private Data me;
    private List<Data> children;
    private double distance;

    private class Data {
        private String name;
        private String content;

    }
}

