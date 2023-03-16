package com.zhiwei.pattern.abstractwei.color;

import com.zhiwei.pattern.abstractwei.AbstractFactory;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: ColorFacory
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 14:26
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class ColorFactory extends ColorAbstract implements AbstractFactory {

    public static final String red = "RED";
    public static final String black = "BLACK";
    public static final String yellow = "YELLOW";

    public Color getColor(String color) {
        if (StringUtils.isBlank(color)) {
            throw new RuntimeException("创建的Bean不存在！");
        }
        Color colorBean;
        switch (color) {
            case red:
                colorBean = new Red();
                break;
            case black:
                colorBean = new Black();
                break;
            case yellow:
                colorBean = new Yellow();
                break;
            default:
                throw new RuntimeException("创建的Bean不存在！");
        }
        return colorBean;
    }
}
