package com.yantang.config;

import com.yantang.Person;
import com.yantang.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

/**
 * 配置类相当于bean.xml
 */
@Configuration //该注解标注后告诉Spring这是一个配置类
/**
 * 包扫描，相当于XML中的<context:component-scan base-package="com.yantang" />
 * value指定要扫面的包
 * useDefaultFilters自动扫描，默认全部扫描
 * excludeFilters指定不扫描那些自动扫描
 * includeFilters指定扫描包含的
 * ComponentScan.Filter扫描规则，可出现多个即指定多条过滤规则
 * FilterType.ANNOTATION扫描类型按照注解
 * FilterType.ASSIGNABLE_TYPE扫描类型按照指定的类型
 * FilterType.REGEX扫描类型按照指定的正则表达式类型
 * FilterType.CUSTOM扫描自定义规则
 */
@ComponentScan(value = "com.yantang",useDefaultFilters = false,includeFilters =  {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Repository.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {PersonService.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,value = {MyFilterType.class})
})
public class MainConfig {
    @Bean //该注解就是注册bean相当于bean.xml；类型为返回值的类型、id默认是以方法名作为id即Person
    public Person person(){
        return new Person(15,"李四");
    }
}
