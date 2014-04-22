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

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class FestivalPanel extends JPanel {
	private static final int numOfPlayerPanels = 4;
	private FestivalCardPanel cardsPanel;
	private CurrentPlayerHandPanel handPanel;
	private PalaceFestivalPlayerPanel[] playerPanel;
	public FestivalPanel() {
		handPanel = new CurrentPlayerHandPanel();
		cardsPanel = new FestivalCardPanel();
		playerPanel = new PalaceFestivalPlayerPanel[numOfPlayerPanels];
		for(int x = 0; x < numOfPlayerPanels; ++x)
			playerPanel[x] = new PalaceFestivalPlayerPanel();
		
		this.setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		
		top.add(playerPanel[0], BorderLayout.WEST);
		top.add(playerPanel[1], BorderLayout.EAST);
		bottom.add(playerPanel[2], BorderLayout.EAST);
		bottom.add(playerPanel[3], BorderLayout.WEST);
		center.add(handPanel, BorderLayout.WEST);
		center.add(cardsPanel, BorderLayout.EAST);

		cardsPanel.setBackground(Color.BLUE);
		for(int x = 0; x < numOfPlayerPanels; ++x) {
			playerPanel[x].setBackground(Color.yellow);
			playerPanel[x].setBorder(BorderFactory.createLineBorder(Color.black));
		}
		
		handPanel.setPreferredSize(new Dimension(600, 200));
		cardsPanel.setPreferredSize(new Dimension(245, 200));
		for(int x = 0; x < numOfPlayerPanels; ++x) 
			playerPanel[x].setPreferredSize(new Dimension(245, 245));
		
		this.add(top, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}

	@SuppressWarnings("rawtypes")
	public void refreshView(GameModel model, PalaceFestival festival, List<Card> cardsOfCurrentPlayer, List<Integer> cardsSelected) {
		// cardsSelect = highlight these cards of the current player
//		cardsPanel.refreshView(cardsOfCurrentPlayer, cardsSelected);
	}
}
