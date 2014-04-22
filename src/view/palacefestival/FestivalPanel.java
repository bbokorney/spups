package view.palacefestival;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
//import javax.swing.JScrollPane;





import model.GameModel;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class FestivalPanel extends JPanel {
	private static final int numOfPlayerPanels = 4;
	private CurrentPlayerHandPanel handPanel;
	private PalaceFestivalPlayerPanel[] playerPanel;
	public FestivalPanel() {
		handPanel = new CurrentPlayerHandPanel();
		playerPanel = new PalaceFestivalPlayerPanel[numOfPlayerPanels];
		for(int x = 0; x < numOfPlayerPanels; ++x)
			playerPanel[x] = new PalaceFestivalPlayerPanel();
		
		this.setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		
		top.add(playerPanel[0], BorderLayout.WEST);
		top.add(playerPanel[1], BorderLayout.EAST);
		bottom.add(playerPanel[2], BorderLayout.EAST);
		bottom.add(playerPanel[3], BorderLayout.WEST);

		handPanel.setBackground(Color.green);
		handPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		for(int x = 0; x < numOfPlayerPanels; ++x) {
			playerPanel[x].setBackground(Color.yellow);
			playerPanel[x].setBorder(BorderFactory.createLineBorder(Color.black));
		}
		
		handPanel.setPreferredSize(new Dimension(550, 200));
		for(int x = 0; x < numOfPlayerPanels; ++x) 
			playerPanel[x].setPreferredSize(new Dimension(275, 245));
		

		this.add(top, BorderLayout.NORTH);
		this.add(handPanel, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}

	@SuppressWarnings("rawtypes")
	public void refreshView(GameModel model, PalaceFestival festival, List<Card> cardsOfCurrentPlayer, List<Integer> cardsSelected) {
		PalaceFestivalPlayer[] players = festival.getPlayers().toArray(new PalaceFestivalPlayer[0]);
		for(int x = 0; x < numOfPlayerPanels; ++x) {
			if(x < players.length)
				playerPanel[x].refreshView(model, festival, players[x]);
			else
				playerPanel[x].removeAll();
		}
		handPanel.refreshView(cardsOfCurrentPlayer, cardsSelected, festival.getCurrentPlayer().getPlayerName());
	}
}
