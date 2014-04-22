package controller.keylistener;

import controller.keylistener.InternalListener;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class KeyListener implements java.awt.event.KeyListener{

    private List<InternalListener> temporary;
    private List<InternalListener> persistent;
    private boolean persistentEnabled;

    public KeyListener() {
        persistentEnabled = true;
        temporary = new ArrayList<InternalListener>();
        persistent = new ArrayList<InternalListener>();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    	System.out.println(e.getKeyChar());
        for(InternalListener i : temporary) {
            i.actionPerformed(e);
        }
        if(persistentEnabled) {
            for(InternalListener i : persistent) {
                i.actionPerformed(e);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void replaceTemporaryListener(List<InternalListener> listeners) {
        temporary = listeners;
    }

    public void addTemporaryListeners(List<InternalListener> listeners) { temporary.addAll(listeners); }

    public void addTemporaryListener(InternalListener listener) { temporary.add(listener); }

    public void addPersistentListeners(List<InternalListener> listeners) {
        persistent.addAll(listeners);
    }

    public void clearPersistentListeners() {
        persistent.clear();
    }

    public void disablePersistentListeners() {
        persistentEnabled = false;
    }

    public void enablePersistentListeners() {
        persistentEnabled = true;
    }
}
