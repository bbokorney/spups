import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import model.GameModel;
import model.JavaGameModel;
import model.board.Board;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.JavaPlayerAdapter;
import model.palacefestival.PalaceCard;
import model.palacefestival.PalaceCardComponent;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;
import model.player.JavaPlayer;
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
    	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				SwingUtilities.invokeLater(new Runnable(){
		            public void run(){
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
		                Controller controller = new Controller(frame);
		                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                frame.setVisible(true);
		                
		                frame.refreshGame(model,festival,null,null,null);
		                
		            }
		        });
					return null;
			}
		};
		worker.execute();
    }    
    
    public PalaceFestival createPalaceFestival(GameModel model) { 
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
