package factory.support;

import beans.BeanDefinition;
import exception.BeansException;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
