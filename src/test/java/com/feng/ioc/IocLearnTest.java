package com.feng.ioc;

import com.zhiwei.annotation.AnnotationConfig;
import com.zhiwei.annotation.value.DataDemo;
import com.zhiwei.annotation.value.ValueDemo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: IocLearnTest
 * @Description:
 * @Author: wei
 * @DateTime: 2023/1/5 23:39
 * @Motto: 时间顺流而下，生活逆水行舟
 **/
public class IocLearnTest {

    

    @Test
    public void function1() {
        /**
         * new Object();不是IOC操作，通过ApplicationContext才是IOC操作，
         * IOC初始化时会自动调用Bean的无参构造函数
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationIoc.class);
        IocLearn bean = context.getBean(IocLearn.class);
        bean.string();
    }

    @Test
    public void function2() {
//        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ConfigurationIOC.class);
    }

    @Test
    public void function3() {
        /**
         * 编译器会强制类型转换，如果转换不成功会报错
         * instanceof 左边必须是引用类型，不能是基本类型
         */
        Assert.assertTrue("type not match", this.object() instanceof Double);
    }

    private Object object() {
        return 0D;
    }

    @Test
    public void function4() {
        Long i1 = Long.valueOf(200);
        Long i2 = Long.valueOf(200);
        double i3 = 200.0;
        double i4 = 200.0;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }

    @Test
    public void function5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        System.out.println(context.getBean(ValueDemo.class));
    }

    @Test
    public void function6() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("pro");
        context.register(AnnotationConfig.class);
        context.refresh();
        System.out.println(context.getBean(DataDemo.class));
    }

    @Test
    public void function7() {
        String s2 = "abc";
        String s1 = new String("abc");
        System.out.println(s1 == s2);
        String s3 = s1.intern();
        System.out.println(s2 == s3);
        System.out.println(s1 == s3);
    }

    @Test
    public void fun8(){

    }
}
