package factory;

/**
 * 扩充BeanFactory 提供遍历方法
 */
public interface ListableBeanFactory extends BeanFactory {

    int getBeanDefinitionCount();

    String[] getBeanDefinitionNames();
}
