package view.palacefestival;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JFrame;

import model.palacefestival.Card;
import view.JavaMenu;
import view.actionpanel.ActionPanel;
import view.gamepanel.GamePanel;


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
			}
			
			@Override
			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode() == KeyEvent.VK_SPACE){
					dispose();
				}
			}
		});

        setFocusTraversalKeysEnabled(false);
        panel.setVisible(true);
        requestFocusInWindow();
        requestFocus();	
        this.setTitle("Player Hand");
		this.setSize(550, 300);
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//        menu = new JavaMenu();
//        gamePanel = new GamePanel();
//        actionPanel = new ActionPanel();
//        festivalPanel = new FestivalPanel();
//        
//        this.add(gamePanel);
//        this.setJMenuBar(menu);
//
//        this.listener = keyListener;
//        addKeyListener(listener);
        setFocusTraversalKeysEnabled(false);

        requestFocusInWindow();
        requestFocus();        
	}
	
	public void refresh(List<Card> cards) { 
		panel.refreshView(cards, null, null);
		repaint();
	}
	
}
