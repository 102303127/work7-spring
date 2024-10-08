package com.zhang.beans.factory.config;


import com.zhang.beans.BeansException;
import com.zhang.beans.PropertyValues;

/**
 * @author zhang
 * @date 2024/7/16
 * @Description
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    /**
     *在Bean的实例化之前执行
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    default Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException{
        return null;
    }

    /**
     * 在Bean的实例化完成之后执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    default boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException{
        return true;
    }

    /**
     * 对属性值进行修改，
     * 如果postProcessAfterInstantiation方法返回false，该方法可能不会被调用。
     * 可以在该方法内对属性值进行修改
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    default PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException{
        return pvs;
    }


    /**
     * bean实例化之后，设置属性之前执行
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    default PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName)
            throws BeansException, Exception{
        return pvs;
    }


    /**
     * 获取用于早期访问指定 Bean 的引用，通常用于解析循环引用。
     * 源码中是在SmartInstantiationAwareBeanPostProcessor(该接口的子接口)中定义的
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    default Object getEarlyBeanReference(Object bean, String beanName) throws BeansException{
        return bean;
    }
}
