import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import model.GameModel;
import model.JavaGameModel;
import model.palacefestival.Card;
import model.palacefestival.PalaceCard;
import model.palacefestival.PalaceCardComponent;
import model.palacefestival.PalaceFestival;
import controller.Controller;
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
		            	GameModel model = new JavaGameModel(3);
		                PalaceFestival festival = createPalaceFestival();
		                GameFrame frame = new GameFrame();
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
    
    public PalaceFestival createPalaceFestival() { 
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
         return new PalaceFestival(null, deck);
    }
}
