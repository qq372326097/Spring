package com.yantang.config;

import com.yantang.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(value = "com.yantang")
public class MainConfig2 {
    /**
     * singleton 单例的，默认不设置范围就是单例的，在IOC容器启动的时候就会创建对象放入IOC容器中
     * 以后每次用都是从IOC容器中拿
     * prototype 多例的，IOC容器启动的时候不会创建对象只有在调用对象的时候才会创建(懒加载机制)
     * request 同一请求创建一个实例
     * session 同一session创建一个实例
     */
    @Scope(value = "prototype")//设置组件的作用域
    @Bean(name = "Person")//该注解默认拿到的Bean是单例子的可以通过Scope指定作用范围
    public Person persion(){
        System.out.println("给容器添加Person组件");
        return new Person(20,"张三");
    }
}
