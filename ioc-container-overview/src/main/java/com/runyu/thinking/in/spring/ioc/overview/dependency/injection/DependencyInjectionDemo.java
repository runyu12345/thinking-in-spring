package com.runyu.thinking.in.spring.ioc.overview.dependency.injection;

import com.runyu.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        UserRepository userRepository =  beanFactory.getBean(UserRepository.class);
        //System.out.println(userRepository.getUsers());
        // 注入的 beanFactory 和 实际的主方法 beanFactory 不是一个对象
        System.out.println(userRepository.getBeanFactory()); // 注入
        ObjectFactory objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject() == beanFactory);

        // System.out.println(userRepository.getBeanFactory() == beanFactory);
        //System.out.println(beanFactory.getBean(BeanFactory.class)); // 查找(错误代码)

    }

}
