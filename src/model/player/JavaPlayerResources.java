package model.player;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaPlayerResources extends Resources<JavaPlayerResourceType> {

    public JavaPlayerResources() {
        super();
        // TODO: add resources once enum is completed (see below?)
        super.addResource(JavaPlayerResourceType.DEVELOPER, 12);
        super.addResource(JavaPlayerResourceType.EXTRAACTIONTOKEN, 3);
        super.addResource(JavaPlayerResourceType.TWO, 5);
        super.addResource(JavaPlayerResourceType.RICE, 3);
        super.addResource(JavaPlayerResourceType.VILLAGE, 2);
        //TODO:Add palace card?
        //super.addResource();
    }

}
