package com.runyu.thinking.in.spring.bean.definition;

import com.runyu.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * 注解 BeanDefinition 示例
 *
 * @version 1.0 created by 2021.03.28 14:05:04 星期日
 * @auth 港岛妹夫
 */
// 3. 通过 @Import 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Config Class 配置类
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        // 通过 BeanDefinition 注册 API 实现
        // 1. 命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext,"meifu");
        registerUserBeanDefinition(applicationContext);

        // 启动应用上下文
        applicationContext.refresh();
        // 1. 通过 @Bean 方式定义
        // 2. 通过 @Component 方式
        // 3. 通过 @Import 来进行导入

        Map<String, Config> configBeans = applicationContext.getBeansOfType(Config.class);

        System.out.println("Config :" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User :" + applicationContext.getBeansOfType(User.class));

        System.out.println(System.currentTimeMillis());

        // 显示的关闭 Spring 应用上下文
        applicationContext.close();

    }

    /**
     * 命名 Bean 的注册方式
     *
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1L).addPropertyValue("name", "runyu");
        //  如果 beanName 参数存在时
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名 Bean 注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }

    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    // 2. 通过 @Component 方式
    @Component // 定义当前类作为 Spring Bean 组件
    public static class Config {
        /**
         * 注解方式定义一个User Bean
         *
         * @return
         */
        @Bean(name = {"user", "gangdao-meifu"})
        public User user() {
            User user = new User();
            user.setId(2L);
            user.setName("runyu12345");
            return user;
        }
    }


}
