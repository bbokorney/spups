package view.gamepanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import model.GameModel;
import model.actions.ActionResult;
import model.board.Location;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;
import model.player.JavaPlayer;
import model.tiles.TileComponent;

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
	public GamePanel() {
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
		commonPanel.setBackground(Color.BLUE);
		for(int x = 0; x < numOfPlayerPanels; ++x) 
			playerPanel[x].setBackground(Color.RED);
		
		boardPanel.setPreferredSize(new Dimension(600, 200));
		cardsPanel.setPreferredSize(new Dimension(245, 200));
		commonPanel.setPreferredSize(new Dimension(245, 200));
		for(int x = 0; x < numOfPlayerPanels; ++x) 
			playerPanel[x].setPreferredSize(new Dimension(245, 245));
		
		this.add(left, BorderLayout.WEST);
		this.add(boardPanel, BorderLayout.CENTER);
		this.add(right, BorderLayout.EAST);
		
		this.setVisible(true);
	}

	public void refreshView(GameModel model, PalaceFestival festival, ActionResult actionResult, Map<Location, TileComponent> potentialComponents, List<Location> highlightedComponents) {
		boardPanel.refreshView(model.getBoard());
		cardsPanel.refreshView(model);
		commonPanel.refreshView(model, festival);
		
		JavaPlayer[] players = model.getJavaPlayers().toArray(new JavaPlayer[0]);

		System.out.println(players.length);
		for(int x = 0; x < players.length; ++x){
			System.out.println("Player : " + x);
			playerPanel[x].refreshView(players[x], festival.getPlayers().toArray(new PalaceFestivalPlayer[0])[x].getHand().size());
		}
		for(int x = players.length; x < numOfPlayerPanels; ++x) { 
			playerPanel[x].removeAll();
		}
		repaint();
	}
}
