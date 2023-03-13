package com.gupaoedu.vip.demo02;

import com.gupaoedu.vip.demo03.RedisConfiguration;
import com.gupaoedu.vip.demo04.MybatisConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

public class ImportSelectorDemo implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //在这个方法里面完成各不同的技术组件的配置类的寻找，并且把配置类的类名返回
        return new String[]{RedisConfiguration.class.getName(), MybatisConfiguration.class.getName()};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
