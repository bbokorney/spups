package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.keylistener.KeyListener;
import model.GameModel;
import model.actions.ActionResult;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.tiles.TileComponent;
import view.actionpanel.ActionPanel;
import view.gamepanel.GamePanel;
import view.palacefestival.CardsFrame;
import view.palacefestival.CurrentPlayerHandPanel;
import view.palacefestival.FestivalPanel;


/**
 * Created by Baker on 4/14/2014.
 */

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
    private final static int WIDTH = 1040; // 1300;
    private final static int HEIGHT = 820; // 850;
    public static final Color[] playerColors = {Color.red, Color.blue, Color.green, Color.orange};
    public static final Color defaultBackground = new Color(79, 140, 255);
    
    JavaMenu menu;
    GamePanel gamePanel;
    controller.keylistener.KeyListener listener;
    ActionPanel actionPanel;
    FestivalPanel festivalPanel;
    
	public GameFrame(KeyListener keyListener){
		this.setTitle("Java Spups");
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        menu = new JavaMenu(this);
        gamePanel = new GamePanel();
        actionPanel = new ActionPanel();
        festivalPanel = new FestivalPanel();
        
        this.add(gamePanel);
        this.setJMenuBar(menu);

        this.listener = keyListener;
        addKeyListener(listener);
        setFocusTraversalKeysEnabled(false);

        requestFocusInWindow();
        requestFocus();
        
        
	}

    public controller.keylistener.KeyListener getKeyListener() { return listener; }

    public void refreshGame( GameModel game, PalaceFestival festival, ActionResult actionResult, Map<Location, TileComponent> potentialComponents, List<Location> highlightedComponents) {
        //this gives all the information during the java game
    	gamePanel.refreshView(festivalPanel, game, festival, actionResult, potentialComponents, highlightedComponents);
//    	actionPanel.refreshView();
    }

    @SuppressWarnings("rawtypes")
	public void refreshCardView(List<Card> cards){
        //shows cards of the current player when it is the players turn in the Java Game
    	CardsFrame cardsFrame = new CardsFrame(new CurrentPlayerHandPanel());
    	cardsFrame.setVisible(true);
        cardsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	cardsFrame.refresh(cards);
    }

    @SuppressWarnings("rawtypes")
	public void refreshView(PalaceFestival festival, List<Card> cardsOfCurrentPlayer, List<Integer> cardsSelected){
        //picking cards
        //sorry they aren't a list of pairs with card and a boolean for selection
        //it was implemented this way in the model and I don't feel like working on it
    }

    @SuppressWarnings("rawtypes")
	public void refreshFestivalView(GameModel model, PalaceFestival festival, List<Card> cardsOfCurrentPlayer, List<Integer> cardsSelected){
    	gamePanel.refreshFestivalView(festivalPanel);
    	festivalPanel.refreshView(model, festival, cardsOfCurrentPlayer, cardsSelected);
    }
}
