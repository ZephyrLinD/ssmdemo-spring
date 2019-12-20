package co.zephyrl;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class People {
    private String pname;

    public People() {

    }

    public String getName() {
        return pname;
    }

    public void setName(String pname) {
        this.pname = pname;
    }

    // Bean配置生命周期
    public void onInit() {
        System.out.println("初始化");
    }

    public void onDestroy() {
        System.out.println("销毁");
    }

//    // 类实现接口
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("实现接口的销毁方法");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("实现接口的初始化方法");
//    }

//    // 注解法
//    @PostConstruct
//    public void onInit2() {
//        System.out.println("初始化");
//    }
//
//    @PreDestroy
//    public void onDestroy2() {
//        System.out.println("销毁");
//    }
}
