package com.fengzhiwei.photo.aspect;

import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PhotoAspect {

    private static final RateLimiter rateLimiter = RateLimiter.create(15.0);

    @Around("execution(public * com.fengzhiwei.photo.controller.PhotoController.upload(..))")
    public void aroundDoSomething(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!rateLimiter.tryAcquire()) {
            // 如果不希望执行目标方法，则直接返回
            return;
        }
        // 如果希望执行目标方法，可以调用 proceed() 方法
        joinPoint.proceed();
    }
}
