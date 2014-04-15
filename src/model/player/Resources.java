package model.player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Baker on 4/14/2014.
 */
public class Resources<T> {

    private Map<T, Integer> resources;

    public Resources() {
        resources = new HashMap<T, Integer>();
    }

    public int getCount(T resource) {
        return resources.containsKey(resource) ? resources.get(resource) : 0;
    }

    public void useResource(T resource) {
        int oldCount = resources.get(resource);
        resources.remove(resource);
        resources.put(resource, --oldCount);
    }

    public void addResource(T resource, int count) {
        resources.put(resource, count);
    }

}
