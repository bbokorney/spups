package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class JavaMenu extends JMenuBar {
	public JavaMenu() {
		super();
		
		JMenu file = new JMenu("File");
		JMenuItem newGame = new JMenuItem("New Game");
		JMenuItem saveGame = new JMenuItem("Save Game");
		JMenuItem loadGame = new JMenuItem("Load Game");
		file.add(newGame);
		file.add(saveGame);
		file.add(loadGame);
		
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//check if there is already a game running 
				new CreateGameFrame();
			}

			private void displayNewGameFrame() {
			}
		});
		file.add(newGame);
	
	    this.add(file);
	}
}
