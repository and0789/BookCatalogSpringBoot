package com.itc.bookcatalogv2.aspect;


import com.itc.bookcatalogv2.dto.BookDetailResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Slf4j
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.itc.bookcatalogv2.web.*.*(..))")
    public void restAPI() {

    }

    // execution == bisa menetukan sampai ke level method
    // within == hanya bisa sampai level class.

    @Pointcut("within(com.itc.bookcatalogv2.web.*)")
    private void withinPointcutExample() {

    }

    @Pointcut("args(com.itc.bookcatalogv2.dto.PublisherCreateRequestDTO)")
    private void argsPointcutExample() {

    }

    @Pointcut("@args(com.itc.bookcatalogv2.annotation.LogThisArgs)")
    private void argsAnnotationPointcutExample() {
    }


    @Pointcut("@annotation(com.itc.bookcatalogv2.annotation.LogThisMethod)")
    private void annotationPointcutExample() {
    }

    @Before("annotationPointcutExample()")
    public void beforeExecutedLogging() {
        log.info("this is log from aspect before method executed");
    }


    @After("annotationPointcutExample()")
    public void afterExecutedLogging() {
        log.info("this is log from aspect after method executed");
    }

    @AfterReturning("annotationPointcutExample()")
    public void afterReturningExecutedLogging() {
        log.info("this is log from aspect after returning method executed");
    }

    @AfterThrowing("annotationPointcutExample()")
    public void afterThrowingExecutedLogging() {
        log.info("this is log from aspect after Throwing method executed");
    }

    @Around("restAPI()")
    public Object processingTimeLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        try {
            log.info("Start {}{} ", joinPoint.getTarget().getClass().getName(),
                    joinPoint.getSignature().getName());
            stopWatch.start();
            return joinPoint.proceed();
        } finally {
            stopWatch.stop();
            log.info("finish {}.{} execution time {}", joinPoint.getTarget().getClass().getName(),
                    joinPoint.getSignature().getName(),
                    stopWatch.getTotalTimeMillis());
        }


    }
}
