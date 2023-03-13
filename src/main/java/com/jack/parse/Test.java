package com.jack.parse;

import com.jack.config.BatchConfiguration;
import com.jack.config.SingleConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author: <a href="mailto:hiourearth@gmail.com">Jack</a>
 * @since
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BatchConfiguration.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    private static void extracted() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SingleConfiguration.class);
        System.out.println(context.getBean("person"));
    }
}
