package model.palacefestival;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class Card<T> {

    private ArrayList<T> components;

    public Card(T... components) {
        this.components = new ArrayList<T>();
        for (T component : components) {
            this.components.add(component);
        }
    }

    public List<T> getComponents() {
        return components;
    }

    @Override
    public abstract boolean equals(Object other);

}
