package factory.alias;

import beans.BeanDefinition;

public interface BeanDefinitionRegistry extends AliasRegistry{

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
