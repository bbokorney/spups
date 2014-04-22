package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.actions.ActionResult;
import model.potentialactions.HexComponentRotation;

import java.awt.event.KeyEvent;

/**
 * Created by Baker on 4/21/2014.
 */
public abstract class RotateableHexComponentUIState extends HexComponentMovementUIState {
    private final int KEY_ROTATE = KeyEvent.VK_SPACE;

    private HexComponentRotation potentialAction;

    public RotateableHexComponentUIState(Controller controller, KeyListener keyListener,
                                         GameModel model){
        super(controller, keyListener, model);
    }

    protected void setRotatablePotentialAction(HexComponentRotation potentialAction) {
        this.potentialAction = potentialAction;
    }

    public void rotate() {
        potentialAction.rotateClockwise();
        updateView();
    }

    protected void initAdditionalListeners() {
        InternalListener listener = new InternalListener(KEY_ROTATE, new Funktor() {
            @Override
            public void call() {
                rotate();
            }
        });
        getKeyListener().addTemporaryListener(listener);
    }
}
