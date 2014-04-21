import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import model.GameModel;
import model.JavaGameModel;
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
		                GameFrame frame = new GameFrame();
		                @SuppressWarnings("unused")
		                Controller controller = new Controller(frame);
		                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                frame.setVisible(true);
		            }
		        });
					return null;
			}
		};
		worker.execute();
//        SwingUtilities.invokeLater(new Runnable(){
//            public void run(){
//            	GameModel model = new JavaGameModel(3);
//                GameFrame frame = new GameFrame(model);
//                @SuppressWarnings("unused")
//                Controller controller = new Controller(frame);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setVisible(true);
//            }
//        });
    }    
}
