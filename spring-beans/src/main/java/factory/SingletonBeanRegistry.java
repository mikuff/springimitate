package factory;

/**
 * 单例bean的注册表接口，定义了一系列访问单例Bean的功能，该类由Bean的间接子类进行实现
 */
public interface SingletonBeanRegistry {

    /**
     * 注册单例对象
     *
     * @param beanName        bean名称
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * 获取单例对象
     *
     * @param beanName bean名称
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * 检查注册表中是否包含提供的bean名称
     *
     * @param beanName bean名称
     * @return
     */
    boolean containsSingleton(String beanName);

}
