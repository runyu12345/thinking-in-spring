package com.runyu.thinking.in.spring.ioc.overview.dependency.injection;

import com.runyu.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖查找示例
 * 1. 通过名称查找
 * 2. 通过类型查找
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件  objectFactory
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        //
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        // 自定义Bean
        UserRepository userRepository =  beanFactory.getBean(UserRepository.class);
        //System.out.println(userRepository.getUsers());
        // 注入的 beanFactory 和 实际的主方法 beanFactory 不是一个对象
        System.out.println(userRepository.getBeanFactory()); // 注入
        ObjectFactory objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject() == beanFactory);

        //System.out.println(beanFactory.getBean(BeanFactory.class)); // 查找(错误代码)

        // 容器自建Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);

        /**
         * 依赖来源
         * 1. 自定义Bean
         * 2. 容器内建的 Bean 对象
         * 3. 容器内建依赖
         */
    }


    private static void whoIsIoCContainer(UserRepository userRepository,BeanFactory beanFactory) {
        // 这个表达式为什么不成立?
        System.out.println(userRepository.getBeanFactory() == beanFactory);
        // ApplicationContext is BeanFactory
        // ApplicationContext is sub-interface of BeanFactory
    }
}
