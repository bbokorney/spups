package model.actions.serialization;

/**
 * Created by idinamenzel on 4/14/14.
 */
public interface Serializable<E> {

    public String serialize();

    public E restore(String serial);


}
