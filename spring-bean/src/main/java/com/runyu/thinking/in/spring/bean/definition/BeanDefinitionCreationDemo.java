package com.runyu.thinking.in.spring.bean.definition;

import com.runyu.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Beandefinition 构建示例
 *
 * @version 1.0 created by 2021.03.27 21:29:51 星期六
 * @auth 港岛妹夫
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {

        // 1. 通过 BeanDefinitionBulider 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("name", "港岛妹夫")
                .addPropertyValue("id", 1);
        // 获取 BeanDefinition 实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //  BeanDefinition 并非 Bean 终态, 可以自定义修改

        // 2. 通过 AbstractBeanDefinition   以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        //        propertyValues.add("name","港岛妹夫");
        //        propertyValues.add("id",2);

        propertyValues.add("name", "港岛妹夫").add("id", 2);
        // 通过 set MutablePropertyValues 批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);


    }
}
