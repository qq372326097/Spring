package com.yantang.test;

import com.yantang.config.MainConfig;
import com.yantang.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {
    @Test
    public void Test(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

    }

    @Test
    public void Test2(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println("IOC容器已经将Person创建完成");
            Object bean = applicationContext.getBean("Person");
            Object bean2= applicationContext.getBean("Person");
            System.out.println(bean == bean2);
            System.out.println(name);
        }

    }
}
