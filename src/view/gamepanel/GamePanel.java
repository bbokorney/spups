package view.gamepanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.GameModel;
import model.player.Player;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	private static final int numOfPlayerPanels = 4;
	private BoardPanel boardPanel;
	private CardsPanel cardsPanel;
	private CommonPanel commonPanel;
	private PlayerPanel[] playerPanel;
	public GamePanel(GameModel model) {
		boardPanel = new BoardPanel();
		cardsPanel = new CardsPanel();
		commonPanel = new CommonPanel(); 
		playerPanel = new PlayerPanel[numOfPlayerPanels];
		for(int x = 0; x < numOfPlayerPanels; ++x)
			playerPanel[x] = new PlayerPanel();
		
		this.setLayout(new BorderLayout());
		
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		JPanel right = new JPanel();
		right.setLayout(new BorderLayout());
		
		left.add(playerPanel[0], BorderLayout.NORTH);
		right.add(playerPanel[1], BorderLayout.NORTH);
		left.add(commonPanel, BorderLayout.CENTER);
		right.add(cardsPanel, BorderLayout.CENTER);
		right.add(playerPanel[2], BorderLayout.SOUTH);
		left.add(playerPanel[3], BorderLayout.SOUTH);

		cardsPanel.setBackground(Color.BLUE);
		commonPanel.setBackground(Color.BLACK);
		for(int x = 0; x < numOfPlayerPanels; ++x) 
			playerPanel[x].setBackground(Color.RED);
		
		boardPanel.setPreferredSize(new Dimension(510, 200));
		cardsPanel.setPreferredSize(new Dimension(245, 200));
		commonPanel.setPreferredSize(new Dimension(245, 200));
		for(int x = 0; x < numOfPlayerPanels; ++x) 
			playerPanel[x].setPreferredSize(new Dimension(245, 245));
		
		this.add(left, BorderLayout.WEST);
		this.add(boardPanel, BorderLayout.CENTER);
		this.add(right, BorderLayout.EAST);
		
		this.setVisible(true);
	}

	public void refreshView(GameModel model) {
		boardPanel.refreshView(model.getBoard());
		cardsPanel.refreshView(model);
		commonPanel.refreshView(model);
		int x = 0;
//		for(Player player : model.getJavaPlayers())
//			playerPanel[x++].refreshView(player);
//		repaint();
	}
}
