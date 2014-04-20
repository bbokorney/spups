package view;

import java.awt.Color;
import javax.swing.JFrame;

import model.GameModel;
import view.actionpanel.ActionPanel;
import view.gamepanel.GamePanel;
import view.palacefestival.FestivalPanel;


/**
 * Created by Baker on 4/14/2014.
 */

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
    private final static int WIDTH = 1040; // 1300;
    private final static int HEIGHT = 820; // 850;
    JavaMenu menu;
    GamePanel gamePanel;
    ActionPanel actionPanel;
    FestivalPanel festivalPanel;
    
	public GameFrame(GameModel model){
		this.setTitle("Java Spups");
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(true);
        this.setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        menu = new JavaMenu();
        gamePanel = new GamePanel(model);
        actionPanel = new ActionPanel(); 
        festivalPanel = new FestivalPanel();
        
        this.add(gamePanel);
        this.setJMenuBar(menu);
        
        //this.setContentPane(gamePanel);
	}
}
