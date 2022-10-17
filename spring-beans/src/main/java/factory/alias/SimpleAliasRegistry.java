package factory.alias;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleAliasRegistry implements AliasRegistry {

    private final Map<String, String> aliasMap = new ConcurrentHashMap<String, String>(16);


    public void registerAlias(String name, String alias) {
        this.aliasMap.put(alias, name);
    }

    public void removeAlias(String alias) {
        this.aliasMap.remove(alias);
    }

    public boolean isAlias(String beanName) {
        return this.aliasMap.containsKey(beanName);
    }

    public String[] getAliases(String name) {
        ArrayList<String> retList = new ArrayList<String>();
        for (Map.Entry<String, String> item : aliasMap.entrySet()) {
            if (item.getValue().equals(name)) {
                retList.add(item.getKey());
            }
        }
        String[] retString = new String[retList.size()];
        retList.toArray(retString);
        return retString;
    }
}
