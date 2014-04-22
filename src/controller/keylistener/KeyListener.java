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
	private boolean modified;

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
	    modified = false;
    	System.out.println(e.getKeyChar());
	    for(int i = 0; i < temporary.size(); i++) {
		    if(modified == true) return;
		    temporary.get(i).actionPerformed(e);
	    }
        if(persistentEnabled) {
	        for(int i = 0; i < persistent.size(); i++) {
		        if(modified == true) return;
		        persistent.get(i).actionPerformed(e);
	        }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void replaceTemporaryListener(List<InternalListener> listeners) {
        temporary = listeners;
	    modified = true;
    }

    public void addTemporaryListeners(List<InternalListener> listeners) {
	    temporary.addAll(listeners);
        modified = true;
    }

    public void addTemporaryListener(InternalListener listener) {
	    temporary.add(listener);
        modified = true;
    }

    public void addPersistentListeners(List<InternalListener> listeners) {
	    persistent.addAll(listeners);
	    modified = true;
    }

    public void clearPersistentListeners() {
        persistent.clear();
	    modified = true;
    }

    public void disablePersistentListeners() {
        persistentEnabled = false;
    }

    public void enablePersistentListeners() {
        persistentEnabled = true;
    }
}
