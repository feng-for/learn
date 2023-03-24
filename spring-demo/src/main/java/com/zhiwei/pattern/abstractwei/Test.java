package com.zhiwei.pattern.abstractwei;

import com.zhiwei.pattern.abstractwei.color.Color;
import com.zhiwei.pattern.abstractwei.color.ColorFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 14:55
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class Test {

    public static void main(String[] args) {
        ProviderFactory providerFactory = new ProviderFactory();
        try {
            AbstractFactory factory = providerFactory.getFactory(ProviderFactory.color);
            Color color = factory.getColor(ColorFactory.red);
            color.draw();

            List<String> strings = new ArrayList<>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
