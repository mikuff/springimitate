package factory;

import exception.BeansException;

/**
 * 该类是访问spring容器的根接口，定义一系列获取bean的规则
 */
public interface BeanFacotry {

    /**
     * 通过bean的名称从Spring获取容器中的Bean
     *
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;


    /**
     * 根据Bean的名称判断Spring 容器中是否包含Bean
     *
     * @param name
     * @return
     */
    boolean containsBean(String name);


}
