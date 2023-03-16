package com.feng.service.impl;

import com.feng.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author: <a href="mailto:hiourearth@gmail.com">Jack</a>
 * @since
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void query() {

        // sout("before")
        System.out.println("query db ...");

        // sout("after");
    }
}

/*

    orderService#query就相当于调用的动态代理的OrderServiceImpl@Cglib#query方法

    OrderServiceImpl通过cglib生成一个动态代理类com.jack.service.impl.OrderServiceImpl@Cglib@4e9b0940
       class OrderServiceImpl@Cglib{

            query(){
                LogAspect#before();
                System.out.println("query db ...");
                LogAspect#after();
            }

       }


       对于一个Bean是否要生成动态代理类这个需求，不是正好符合BeanPostProcessor的逻辑吗？
 */









