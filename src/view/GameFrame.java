package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;

import model.GameModel;
import model.actions.ActionResult;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.potentialactions.ActionState;
import model.tiles.TileComponent;
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

    public void refreshGame( GameModel game, PalaceFestival festival, ActionResult actionResult, Map<Location, TileComponent> potentialComponents, List<Location> highlightedComponents) {
        //ths gives all the information during the java game
    }

    public void refreshCardView(List<Card> cards){
        //shows cards of the current player when it is the players turn in the Java Game
    }

    public void refreshView(PalaceFestival festival, List<Card> cardsOfCurrentPlayer, List<Integer> cardsSelected){
        //picking cards
        //sorry they aren't a list of pairs with card and a boolean for selection
        //it was implemented this way in the model and I don't feel like working on it
    }
}
