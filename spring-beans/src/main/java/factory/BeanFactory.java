package factory;

import beans.NoSuchBeanDefinitionException;
import exception.BeansException;

import java.util.HashMap;
import java.util.Map;

public interface BeanFactory {

    String FACTORY_BEAN_PREFIX = "&";

    Object getBean(String name) throws BeansException;
}
