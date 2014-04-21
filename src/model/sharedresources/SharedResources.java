package model.sharedresources;

import model.player.Resources;

/**
 * Created by Sachit on 4/16/2014.
 */
public class SharedResources extends Resources<SharedResourceType> {

    public SharedResources() {
        super();
        // TODO: add resources once enum is completed (see below?)
        super.addResource(SharedResourceType.IRRIGATION, 16);
        super.addResource(SharedResourceType.THREE, 56);
        super.addResource(SharedResourceType.PALACELEVEL2, 6);
        super.addResource(SharedResourceType.PALACELEVEL4, 7);
        super.addResource(SharedResourceType.PALACELEVEL6, 8);
        super.addResource(SharedResourceType.PALACELEVEL8, 9);
        super.addResource(SharedResourceType.PALACELEVEL10, 10);
        //TODO:Add palace card?
        //super.addResource();
    }
}
