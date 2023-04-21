package com.fengzhiwei.photo.aspect;

import com.fengzhiwei.photo.vo.Result;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
@Slf4j
public class PhotoAspect {

    private static final RateLimiter rateLimiter = RateLimiter.create(15.0);

    @Around("execution(public * com.fengzhiwei.photo.controller.PhotoController.upload(..))")
    public Object aroundDoSomething(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String start = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("{}.{}--------开始时间--------{}", className, methodName, start);
        if (!rateLimiter.tryAcquire()) {
            // 如果不希望执行目标方法，则直接返回
            log.info("{}.{}--------访问人数过多，稍后再试试吧--------", className, methodName);
            return Result.error(2005, "访问人数过多，稍后再试试吧");
        }
        // 如果希望执行目标方法，可以调用 proceed() 方法
        Object proceed = joinPoint.proceed();
        String end = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("{}.{}--------结束时间--------{}", className, methodName, end);
        return proceed;
    }
}
