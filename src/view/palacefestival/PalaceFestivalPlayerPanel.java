package view.palacefestival;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.GameModel;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class PalaceFestivalPlayerPanel extends JPanel {
	JLabel[] palace = new JLabel[5];
	JLabel stack;
	
	public PalaceFestivalPlayerPanel() {		
		stack = newJLabel("", "/Users/maumau/spups/resources/card.png", 60, 100);
		this.add(stack);
	}
	
	private JLabel newJLabel(String value, String src, int width, int height){
		JLabel label= new JLabel(value);
		label.setIcon(new ImageIcon(src));
		label.setFont(new Font("Lucida Grande", 0, 14));
		label.setPreferredSize(new Dimension(width, height));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		return label;
	}

	public void refreshView(GameModel model, PalaceFestival festival, PalaceFestivalPlayer player) {
		stack.setText(""+player.getHand().size());
		repaint();
	}
}
