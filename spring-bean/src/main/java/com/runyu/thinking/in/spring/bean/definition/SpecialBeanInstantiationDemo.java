package com.runyu.thinking.in.spring.bean.definition;

import com.runyu.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.runyu.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 特殊的 Bean 实例化 demo
 * ServiceLoader
 *
 * @version 1.0 created by 2021.04.11 15:58:12 星期日
 * @auth 港岛妹夫
 */
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件  objectFactory
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/special-bean-instantiation-context.xml");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/special-bean-instantiation-context.xml");
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();


        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);
        displayServiceLoader(serviceLoader);
        demoServiceLoader();
        // 创建 UserFactory 对象,通过 AutowireCapableBeanFactory
        UserFactory userFactory = autowireCapableBeanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());
    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    public static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}
