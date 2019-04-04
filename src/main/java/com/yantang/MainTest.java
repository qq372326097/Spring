package com.yantang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.yantang.config.MainConfig;

public class MainTest {
    public static void main(String[] args) {
//        读取XML文件
       /* ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person bean = (Person)applicationContext.getBean("Person");*/
//       读取配置类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);


    }
}
