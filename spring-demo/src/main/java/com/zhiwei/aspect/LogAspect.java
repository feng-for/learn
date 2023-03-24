package com.zhiwei.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    // 切入点   Pointcut
    @Pointcut("execution(* com.jack.service.*.*(..))")
    public void mypointcut(){}
    // 前置通知
    @Before(value = "mypointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("[前置通知] 准备开始记录日志...");
        System.out.println("[前置通知] 目标类是: "+joinPoint.getTarget());
        System.out.println("[前置通知] 目标方法是: "+joinPoint.getSignature().getName());
    }
    // 后置通知
    @AfterReturning(value = "mypointcut()", returning = "res")
    public void afterReturning(JoinPoint joinPoint, Object res){
        System.out.println("[后置通知] 记录日志完成...");
        System.out.println("[后置通知] 目标类是: "+joinPoint.getTarget());
        System.out.println("[后置通知] 目标方法是: "+joinPoint.getSignature().getName());
    }

    @Around(value = "mypointcut()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("[环绕通知] 日志记录前的操作...");
        try {
            joinPoint.proceed();
            System.out.println("[环绕通知] 日志记录后的操作...");
            System.out.println("[环绕通知] "+joinPoint.getTarget());
            System.out.println("[环绕通知] "+joinPoint.getSignature().getName());
        } catch (Throwable throwable) {
            System.out.println("[环绕通知] 发生异常的操作...");
            throwable.printStackTrace();
        }finally {
            System.out.println("[环绕通知] 最终的操作...");
        }
    }

    @AfterThrowing(value = "execution(* com.feng.service.*.*(..))", throwing = "exception")
    public void afterThrow(JoinPoint joinPoint, Exception exception){

    }
}