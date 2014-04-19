package model.sharedresources;

import model.player.JavaPlayerResourceType;
import model.player.Resources;

/**
 * Created by Sachit on 4/16/2014.
 */
public class SharedResources extends Resources<SharedResourceType> {

    public SharedResources() {
        super();
        // TODO: add resources once enum is completed (see below?)
        super.addResource(SharedResourceType.IRRIGATION, 16);
        super.addResource(SharedResourceType.THREE, 3);
        super.addResource(SharedResourceType.PALACELEVELTWO, 6);
        super.addResource(SharedResourceType.PALACELEVELFOUR, 7);
        super.addResource(SharedResourceType.PALACELEVELSIX, 8);
        super.addResource(SharedResourceType.PALACELEVELEIGHT, 9);
        super.addResource(SharedResourceType.PALACELEVELTEN, 10);
        //TODO:Add palace card?
        //super.addResource();
    }
}
