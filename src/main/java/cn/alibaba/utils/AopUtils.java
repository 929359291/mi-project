package cn.alibaba.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zengxc
 * @since 2018/6/19
 */
@Aspect
@Component
public class AopUtils {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private static final String[] EXCEPTION_STATUS = {"normal", "exception"};

    /**
     * 当小于这个毫秒数时不打印
     */
    public static long MILLISECOND_CONDITION = 10;

    //execution(public * cn.alibaba.mapper.*Mapper.*(..)) ||
    @Pointcut("execution(public * cn.alibaba.service.*Service.*(..)) || execution(public * cn.alibaba.controller.*Controller.*(..))" )
    public void componentAspect(){}

    @Around("componentAspect()")
    public Object componentTimeAround(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();

        String execptionStatus = EXCEPTION_STATUS[0];
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            execptionStatus = EXCEPTION_STATUS[1];
            throw e;
        } finally {
            long endTime = System.currentTimeMillis();
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            String methodName = joinPoint.getTarget().getClass().getSimpleName() + "." + signature.getName();
            this.printExecTime(methodName, startTime, endTime, execptionStatus);
        }
    }

    /**
     * 打印方法执行耗时的信息，如果超过了一定的时间，才打印
     * @param methodName
     * @param startTime
     * @param endTime
     */
    private void printExecTime(String methodName, long startTime, long endTime, String exeStatus) {

        long diffTime = endTime - startTime;
//        if (diffTime > MILLISECOND_CONDITION) {
        LOGGER.trace(methodName + " 方法执行耗时：" + diffTime + " ms " + exeStatus);
//        }
    }

}
