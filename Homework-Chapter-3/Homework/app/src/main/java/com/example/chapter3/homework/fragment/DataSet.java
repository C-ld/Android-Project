package com.example.chapter3.homework.fragment;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
    public static List<TestData> getData() {
        List<TestData> result = new ArrayList();
        result.add(new TestData("让人忘记原唱的歌手", "好友1"));
        result.add(new TestData("林丹退役", "好友2"));
        result.add(new TestData("你在教我做事？", "好友3"));
        result.add(new TestData("投身乡村教育的燃灯者", "好友4"));
        result.add(new TestData("暑期嘉年华", "好友5"));
        result.add(new TestData("2020年三伏天有40天", "好友6"));
        result.add(new TestData("会跟游客合照的老虎", "好友7"));
        result.add(new TestData("苏州暴雨", "好友8"));
        result.add(new TestData("6月全国菜价上涨", "好友9"));
        result.add(new TestData("猫的第六感有多强", "好友10"));
        result.add(new TestData("IU真好看", "好友11"));
        return result;
    }
}
