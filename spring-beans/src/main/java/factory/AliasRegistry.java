package factory;

/**
 * 别名管理接口
 */
public interface AliasRegistry {

    /**
     * 将标准名称注册成别名
     *
     * @param name  标准名称
     * @param alias 别名
     */
    void registerAlias(String name, String alias);
}
