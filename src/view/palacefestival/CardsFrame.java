package view.palacefestival;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JFrame;

import model.palacefestival.Card;


@SuppressWarnings("serial")
public class CardsFrame extends JFrame {
	CurrentPlayerHandPanel panel;
	public CardsFrame(CurrentPlayerHandPanel panel) {
        this.setTitle("Player Hand");
		this.setSize(550, 300);
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = panel; 
		this.add(panel);
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE){
					dispose();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

        setFocusTraversalKeysEnabled(false);
        panel.setVisible(true);
        requestFocusInWindow();
        requestFocus();	
	}
	
	@SuppressWarnings("rawtypes")
	public void refresh(List<Card> cards) { 
		panel.refreshView(cards, null, null);
		repaint();
	}
	
}
