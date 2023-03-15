package com.zhiwei.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: <a href="mailto:hiourearth@gmail.com">Jack</a>
 * @since
 */
@Component
public class JackBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    // 这个方法一定是在刚才的两段代码中进行回调的
    /*
        // Invoke factory processors registered as beans in the context.
				invokeBeanFactoryPostProcessors(beanFactory);

				// Register bean processors that intercept bean creation.
				registerBeanPostProcessors(beanFactory);
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        beanFactory.setTempClassLoader();
        System.out.println("哈哈，对beanFactory进行了修改操作...");
    }
}
