package rungame;

import java.util.*;

import javax.swing.*;

import model.GameModel;
import model.JavaGameModel;
import model.actions.StartGame;
import model.board.Board;
import model.board.Directions;
import model.board.HexLocation;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceCard;
import model.palacefestival.PalaceCardComponent;
import model.palacefestival.PalaceFestival;
import model.player.JavaPlayer;
import model.tiles.*;
import controller.Controller;
import controller.keylistener.KeyListener;
import view.GameFrame;


/**
 * Created by Baker on 4/14/2014.
 */
public class RunGame {    
    public static void main(String[] args) {
        int numPlayers = args.length;
        if (numPlayers < 2 || numPlayers > 4)
            //System.out.println("Please enter a number between 2 and 4 inclusive.");
        else {
            final ArrayList<String> names = new ArrayList<String>();
            for (int i = 0; i < args.length; i++) {
                names.add(args[i]);
            }
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    @SuppressWarnings("unused")
					RunGame game = new RunGame(names.toArray(new String[0]));
                }
            });

        }
    }

    public RunGame(String[] playerNames){
    	KeyListener listener = new KeyListener();
    	GameModel model = new JavaGameModel();
        PalaceFestival festival = new PalaceFestival(null, createDeck());


        GameFrame frame = new GameFrame(listener);
        @SuppressWarnings("unused")

        StartGame startGame = new StartGame(model, festival, playerNames);
        Controller controller = new Controller(frame, model, festival, startGame);
        //System.out.println(startGame.doAction().getMessage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.requestFocusInWindow();
        
        HashMap<Location, TileComponent> map = new HashMap<Location, TileComponent>();

        LinkedList<Location> highlights = new LinkedList<Location>();

        frame.requestFocus();//or inWindow

        @SuppressWarnings("rawtypes")
		List<Card> cardsOfCurrentPlayer = new LinkedList<Card>();
        List<Integer> cardsHighlighted = new LinkedList<Integer>();
        
//        initTestBoard(model, festival, highlights, cardsOfCurrentPlayer, cardsHighlighted, map, frame);

        frame.refreshGame(model,festival,null,map,highlights);
//        frame.refreshFestivalView(model, festival, cardsOfCurrentPlayer, cardsHighlighted);
//        frame.refreshGame(model,festival,null,map,highlights);
    }
    


    @SuppressWarnings("unused")
	private void initTestBoard(GameModel model, PalaceFestival festival,
			LinkedList<Location> highlights, @SuppressWarnings("rawtypes") List<Card> cardsOfCurrentPlayer,
			List<Integer> cardsHighlighted, HashMap<Location, TileComponent> map, GameFrame frame) {
		// TODO Auto-generated method stub
        
    	Board board = model.getBoard();

        //SACHITS TEST CODE (PATENT PENDING)
        ArrayList<Directions> list = new ArrayList<Directions>();
        board.placeRiceTileComponent(new HexLocation(list), new RiceTileComponent(new Tile(1)));
        model.placeDeveloperOnBoard(new HexLocation(new ArrayList<Directions>()));
        list.add(Directions.NORTH);
        model.placeDeveloperOnBoard(new HexLocation(list));

    	board.getSpace(board.getAllLocations().toArray(new Location[0])[0]).accept(new VillageTileComponent());
    	board.getSpace(board.getAllLocations().toArray(new Location[0])[1]).accept(new PalaceTileComponent(2));
    	board.getSpace(board.getAllLocations().toArray(new Location[0])[2]).accept(new RiceTileComponent());
    	board.getSpace(board.getAllLocations().toArray(new Location[0])[3]).accept(new IrrigationTileComponent());
        model.getJavaPlayers().toArray(new JavaPlayer[0])[0].addDeveloper(board.getAllLocations().toArray(new Location[0])[0]);
        map.put(board.getAllLocations().toArray(new Location[0])[6], new VillageTileComponent());
        map.put(board.getAllLocations().toArray(new Location[0])[7], new RiceTileComponent());
        map.put(board.getAllLocations().toArray(new Location[0])[8], new RiceTileComponent());
        highlights.add((HexLocation) board.getAllLocations().toArray(new Location[0])[10]);
        highlights.add((HexLocation) board.getAllLocations().toArray(new Location[0])[11]);
        highlights.add((HexLocation) board.getAllLocations().toArray(new Location[0])[12]);
        for(int x = 0; x < 27; ++x) {
        	PalaceCard card = new PalaceCard(PalaceCardComponent.values()[(new Random()).nextInt(3)]);
        	cardsOfCurrentPlayer.add(card);
        }
        cardsHighlighted.add(3); cardsHighlighted.add(5); cardsHighlighted.add(9); cardsHighlighted.add(13); 

		
	}   
    
    @SuppressWarnings("rawtypes")
	public Stack<Card> createDeck() {
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

         return deck;
    }
}
