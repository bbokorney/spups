package view.palacefestival;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.GameModel;
import model.palacefestival.PalaceCard;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class PalaceFestivalPlayerPanel extends JPanel {
	BufferedImage cardsImage; 
	private static final int cardPerLine = 9;
	JLabel[] palace = new JLabel[5];
	JLabel score;
	JLabel name;
	
	public PalaceFestivalPlayerPanel() {		
		cardsImage = new BufferedImage(550, 300, BufferedImage.TYPE_INT_ARGB);
		score = new JLabel();		
		name = new JLabel();
		this.add(name, BorderLayout.EAST);
		this.add(score, BorderLayout.SOUTH);
	}

	public void refreshView(GameModel model, PalaceFestival festival, PalaceFestivalPlayer player) {
		name.setText(player.getPlayerName() +"'s Played Cards");
		score.setText("Score: " + festival.getCurrentPlayer().getScore());
		
		PalaceCard[] cards = player.getHand().toArray(new PalaceCard[0]);
		
		Graphics2D g2d = cardsImage.createGraphics();
        g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.cyan);
		for(int x = 0; x < cards.length; ++x) { 
			Image card = PalaceCardImageLoader.getImage(cards[x]);
			int width = (x%cardPerLine)*60+10;
			int height = (x/cardPerLine)*75+50;
			g2d.drawImage(card, width, height, null);
		}
		g2d.dispose();
		// TODO put picture of festival card
		//card.setText(""+festival.peekAtFestivalCard());
		repaint();
	}
}
