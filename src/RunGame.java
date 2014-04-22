import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;

import model.GameModel;
import model.JavaGameModel;
import model.board.Board;
import model.board.HexLocation;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.JavaPlayerAdapter;
import model.palacefestival.PalaceCard;
import model.palacefestival.PalaceCardComponent;
import model.palacefestival.PalaceFestival;
import model.player.JavaPlayer;
import model.tiles.TileComponent;
import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;
import controller.Controller;
import controller.keylistener.KeyListener;
import view.GameFrame;


/**
 * Created by Baker on 4/14/2014.
 */
public class RunGame {    
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        RunGame game = new RunGame();
    }
    
    public RunGame() {
    	KeyListener listener = new KeyListener();
    	GameModel model = new JavaGameModel(3);
    	Board board = model.getBoard();
    	board.getSpace(board.getAllLocations().toArray(new Location[0])[0]).accept(new VillageTileComponent());
    	board.getSpace(board.getAllLocations().toArray(new Location[0])[1]).accept(new PalaceTileComponent(2));
    	board.getSpace(board.getAllLocations().toArray(new Location[0])[2]).accept(new RiceTileComponent());
    	board.getSpace(board.getAllLocations().toArray(new Location[0])[3]).accept(new IrrigationTileComponent());
        PalaceFestival festival = createPalaceFestival(model);
        
        model.getJavaPlayers().toArray(new JavaPlayer[0])[0].addDeveloper(board.getAllLocations().toArray(new Location[0])[0]);
        
        
        GameFrame frame = new GameFrame(listener);
        @SuppressWarnings("unused")
        Controller controller = new Controller(frame, model, createPalaceFestival(model));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.requestFocusInWindow();
        
        
        HashMap<Location, TileComponent> map = new HashMap<Location, TileComponent>();
        map.put(board.getAllLocations().toArray(new Location[0])[6], new VillageTileComponent());
        map.put(board.getAllLocations().toArray(new Location[0])[7], new RiceTileComponent());
        map.put(board.getAllLocations().toArray(new Location[0])[8], new RiceTileComponent());
        
        LinkedList<Location> highlights = new LinkedList<Location>();
        highlights.add((HexLocation) board.getAllLocations().toArray(new Location[0])[10]);
        highlights.add((HexLocation) board.getAllLocations().toArray(new Location[0])[11]);
        highlights.add((HexLocation) board.getAllLocations().toArray(new Location[0])[12]);
        
        frame.refreshGame(model,festival,null,map,highlights);
        
        frame.requestFocus();//or inWindow
        
        List<Card> cardsOfCurrentPlayer = new LinkedList<Card>();
        for(int x = 0; x < 20; ++x) {
        	PalaceCard card = new PalaceCard(PalaceCardComponent.values()[(new Random()).nextInt(3)]);
        	cardsOfCurrentPlayer.add(card);
        }
        
        frame.refreshFestivalView(model, festival, cardsOfCurrentPlayer, null);
    }    
    
    public PalaceFestival createPalaceFestival(GameModel model) { 
    	 @SuppressWarnings("rawtypes")
		 Stack<Card> deck = new Stack<Card>();
         for (int i = 0; i < 5; i++) {
             PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM);
             deck.add(card);
         }
         for (int i = 0; i < 5; i++) {
             PalaceCard card = new PalaceCard(PalaceCardComponent.MASK);
             deck.add(card);
         }
         for (int i = 0; i < 5; i++) {
             PalaceCard card = new PalaceCard(PalaceCardComponent.PUPPET);
             deck.add(card);
         }
         for (int i = 0; i < 5; i++) {
             PalaceCard card = new PalaceCard(PalaceCardComponent.MASK,
                     PalaceCardComponent.PUPPET);
             deck.add(card);
         }
         for (int i = 0; i < 5; i++) {
             PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM,
                     PalaceCardComponent.MASK);
             deck.add(card);
         }
         for (int i = 0; i < 5; i++) {
             PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM,
                     PalaceCardComponent.PUPPET);
             deck.add(card);
         }
         PalaceFestival festival = new PalaceFestival(null, deck);
         for(JavaPlayer player : model.getJavaPlayers())
        	 festival.addPlayer(new JavaPlayerAdapter(player));
         return festival;
    }
}
