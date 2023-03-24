package com.zhiwei.pattern.abstractwei;

import com.zhiwei.pattern.abstractwei.color.ColorFactory;
import com.zhiwei.pattern.abstractwei.shape.ShapeFactory;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: ProviderFactory
 * @Description:
 * @Author: wei
 * @DateTime: 2022/12/28 14:48
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class ProviderFactory {

    public static final String square = "SQUARE";
    public static final String color = "COLOR";

    public AbstractFactory getFactory(String factory) throws ClassNotFoundException {
        if (StringUtils.isBlank(factory)) {
//            ClassNotFoundException（加载时找不到类）；NotClassFoundException（编译时找不到类）
            throw new ClassNotFoundException("未加载到需要创建的Bean！");
        }
        AbstractFactory abstractFactory;
        switch (factory) {
            case square:
                abstractFactory = new ShapeFactory();
                break;
            case color:
                abstractFactory = new ColorFactory();
                break;
            default:
                throw new ClassNotFoundException("未加载到需要创建的Bean！");
        }
        return abstractFactory;
    }
}
