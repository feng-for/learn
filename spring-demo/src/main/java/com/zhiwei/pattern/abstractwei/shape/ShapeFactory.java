package com.zhiwei.pattern.abstractwei.shape;

import com.zhiwei.pattern.abstractwei.AbstractFactory;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: ColorFacory
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 14:26
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class ShapeFactory extends ShapeAbstract implements AbstractFactory {

    public static final String square = "SQUARE";
    public static final String round = "ROUND";
    public static final String triangle = "TRIANGLE";

    public Shape getShape(String shape) {
        if (StringUtils.isBlank(shape)) {
            throw new RuntimeException("创建的Bean不存在！");
        }
        Shape shapeBean;
        switch (shape) {
            case square:
                shapeBean = new Square();
                break;
            case round:
                shapeBean = new Round();
                break;
            case triangle:
                shapeBean = new Triangle();
                break;
            default:
                throw new RuntimeException("创建的Bean不存在！");
        }
        return shapeBean;
    }
}
