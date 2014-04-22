package view;

import rungame.RunGame;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class JavaMenu extends JMenuBar {
	CreateGameFrame createGame;
	JFrame parent;
	
	public JavaMenu(JFrame parent) {
		super();
		this.parent = parent;
		
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
				ActionListener listener = new StartGameListener();
				createGame = new CreateGameFrame(listener);
			}
		});
	
	    this.add(file);
	}
	
	class StartGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			final String[] playerNames = createGame.getPlayerNames();
			
			createGame.dispose();
			SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    @SuppressWarnings("unused")
					RunGame game = new RunGame(playerNames);
                    parent.dispose();
                }
            });			
		}
	}
}
