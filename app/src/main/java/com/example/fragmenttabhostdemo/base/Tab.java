package com.example.fragmenttabhostdemo.base;

/**
 * Created by 杜松阳 on 2018/11/25.
 */

public class Tab {
    private int icon_tab;
    private int txt_indicator;
    private Class fragment;


    public Tab(int icon_tab, int txt_indicator, Class fragment) {
        this.icon_tab = icon_tab;
        this.txt_indicator = txt_indicator;
        this.fragment = fragment;
    }

    public int getIcon_tab() {
        return icon_tab;
    }

    public void setIcon_tab(int icon_tab) {
        this.icon_tab = icon_tab;
    }

    public int getTxt_indicator() {
        return txt_indicator;
    }

    public void setTxt_indicator(int txt_indicator) {
        this.txt_indicator = txt_indicator;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
