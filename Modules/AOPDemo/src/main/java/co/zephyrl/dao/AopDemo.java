package co.zephyrl.dao;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopDemo {
    public void before() {
        System.out.println("验证用户权限");
    }

    public void af(int num) {
        System.out.println("开启后置通知：删除 + " + num);
    }

    public void ar(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开启环绕前通知");
        Object proceed = joinPoint.proceed();
        System.out.println("开启环绕后通知");
    }

    public void th(Throwable thr) {
        System.out.println("开启异常通知通知：" + thr.getMessage());
    }

    public void zz() {
        System.out.println("无论怎么样都开起了最终通知。");
    }
}
