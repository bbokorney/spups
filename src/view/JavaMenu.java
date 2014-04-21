package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
	
	    this.add(file);
	}
}
