import javax.swing.SwingUtilities;

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
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
            	GameModel game = new JavaGameModel();
                GameFrame frame = new GameFrame(game);
                @SuppressWarnings("unused")
                Controller controller = new Controller(frame);
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }    
}
