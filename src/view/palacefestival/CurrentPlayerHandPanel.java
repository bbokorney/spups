package view.palacefestival;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.palacefestival.Card;
import model.palacefestival.PalaceCard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferedImage;


@SuppressWarnings("serial")
public class CurrentPlayerHandPanel extends JPanel {
	private static final int cardPerLine = 9;
	private static final int widthMargin = 10; 
	private static final int heightMargin = 50; 
	private static final int cardWidth = 50; 
	private static final int cardHeight = 70;
	private static final int cardMargin = 10;
	
	BufferedImage cards; 
	JLabel user;
	
	public CurrentPlayerHandPanel() {
		cards = new BufferedImage(550, 300, BufferedImage.TYPE_INT_ARGB);
		user = new JLabel();
		this.add(user);
	}

	
	
	@SuppressWarnings("rawtypes")
	public void refreshView(List<Card> cardsOfCurrentPlayer, List<Integer> cardsSelected, String playerName) {
		user.setText(playerName + "'s Hand:");
		Graphics2D g2d = cards.createGraphics();
        g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.green);
		for(int x = 0; x < cardsOfCurrentPlayer.size(); ++x) { 
			Image card = PalaceCardImageLoader.getImage((PalaceCard) cardsOfCurrentPlayer.get(x));
			int width = (x%cardPerLine)*(cardWidth+cardMargin)+widthMargin;
			int height = (x/cardPerLine)*(cardHeight+cardMargin)+heightMargin;
			g2d.drawImage(card, width, height, null);
		}

		for(Integer i : cardsSelected) { 
			int width = (i%cardPerLine)*(cardWidth+cardMargin)+widthMargin;
			int height = (i/cardPerLine)*(cardHeight+cardMargin)+heightMargin;
			g2d.drawPolygon(new Polygon(new int[] {width, width+cardWidth, width+cardWidth, width}, new int[] {height, height, height+cardHeight, height+cardHeight}, 4)); 
		}
		g2d.dispose();
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(cards, 0, 0, null);
	}
}
