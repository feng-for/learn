package com.jack.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: <a href="mailto:hiourearth@gmail.com">Jack</a>
 * @since
 */
@Component
public class JackBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 如果ioc容器中有userController这个bean，就表示可以进行数据统计了
//        if(bean.equals())
        // TODO: 需求   对bean进行一些后置处理操作

        // bean的全路径是否符合* com.jack.service.*.*(..))
        // userServiceImpl 的全路径就符合切面表达式的要求
        // 说明userServiceImpl就需要生成动态代理类
        // Enhancer#enhance()----> map#(
        // 依赖注入@Resource userService=OrderServiceImpl@Cglib




        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}












