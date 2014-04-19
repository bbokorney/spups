package model.rules.developer;

import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Baker on 4/18/2014.
 */
public class DeveloperTraversalRuleTest {
    @Test
    public void test() {
        DeveloperTraversalRule dtr = new DeveloperTraversalRule(new VillageTileComponent(),
                new VillageTileComponent());
        assertEquals(0, dtr.getCost());
        dtr = new DeveloperTraversalRule(new RiceTileComponent(),
                new VillageTileComponent());
        assertEquals(1, dtr.getCost());
    }
}
