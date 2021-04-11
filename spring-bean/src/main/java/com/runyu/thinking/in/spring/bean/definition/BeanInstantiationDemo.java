package com.runyu.thinking.in.spring.bean.definition;

import com.runyu.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例化 demo
 *
 * @version 1.0 created by 2021.04.11 15:58:12 星期日
 * @auth 港岛妹夫
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件  objectFactory
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation-context.xml");
        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userInstanceethod = beanFactory.getBean("user-by-instance-method", User.class);
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(user);
        System.out.println(userInstanceethod);
        System.out.println(userByFactoryBean);
    }
}
