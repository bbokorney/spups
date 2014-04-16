package model.tiles;

import model.rules.tiles.Visitor;

/**
 * Created by Baker on 4/14/2014.
 */
public interface Visitable {
    public void accept(Visitor visitor);
}
