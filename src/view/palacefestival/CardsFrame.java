package view.palacefestival;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class CardsFrame extends JFrame {
	CurrentPlayerHandPanel panel;
	public CardsFrame(CurrentPlayerHandPanel panel) {
		this.panel = panel; 
		this.add(panel);
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 70){
					dispose();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}
	public void refresh() { 
		repaint();
	}
	
}
