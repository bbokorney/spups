package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * Created by Baker on 4/14/2014.
 */

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
    private final static int WIDTH = 500; // 1300;
    private final static int HEIGHT = 300; // 850;
	//NewGameFrame frame;

	public GameFrame(){
		setTitle("Spups Java");
		setSize(WIDTH, HEIGHT);
		setResizable(true);

        JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newGame = new JMenuItem("New Game");
		JMenuItem saveGame = new JMenuItem("Save Game");
		JMenuItem loadGame = new JMenuItem("Load Game");
		file.add(newGame);
		file.add(saveGame);
		file.add(loadGame);
		System.out.println("test");

        menuBar.add(file);
        this.setJMenuBar(menuBar);
		// todo addMenu
	}
}
