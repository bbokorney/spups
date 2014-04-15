package controller.keylistener;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Baker on 4/14/2014.
 */
public class InternalListener {
    private int keyCode;
    private Funktor method;

    public InternalListener(int keyCode, Funktor method) {
        this.keyCode = keyCode;
        this.method = method;
    }

    public void actionPerformed(KeyEvent event) {
        if(event.getKeyCode() == keyCode) {
            method.call();
        }
    }
}
