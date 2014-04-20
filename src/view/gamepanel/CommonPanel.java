package view.gamepanel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.HexLabel;
import model.GameModel;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class CommonPanel extends JPanel {
	JLabel p2;
	JLabel p4;
	JLabel p6;
	JLabel p8;
	JLabel p10;
	JLabel irrigation;
	JLabel threetile;
	
	public CommonPanel() {
		p2 = newJLabel("3", "/Users/maumau/spups/resources/Palace2.png", 70, 80);
		p4 = newJLabel("3", "/Users/maumau/spups/resources/Palace4.png", 70, 80);
		p6 = newJLabel("3", "/Users/maumau/spups/resources/Palace6.png", 70, 80);
		p8 = newJLabel("3", "/Users/maumau/spups/resources/Palace8.png", 70, 80);
		p10 = newJLabel("3", "/Users/maumau/spups/resources/Palace10.png", 70, 80);
		threetile = newJLabel("3", "/Users/maumau/spups/resources/Threetile.png", 100, 100);
		irrigation = newJLabel("3", "/Users/maumau/spups/resources/Irrigation.png", 70, 80);

		this.add(p2);
		this.add(p4);
		this.add(p6);
		this.add(p8);
		this.add(p10);
		this.add(threetile);
		this.add(irrigation);
	}


	private JLabel newJLabel(String value, String src, int width, int height){
		HexLabel label= new HexLabel(value, new int[] {35}, new int[] {35}, width, height);
		label.setFont(new Font("Lucida Grande", 0, 14));
//		label.setIcon(new ImageIcon(src));
		label.setPreferredSize(new Dimension(width, height));
		label.setHorizontalTextPosition(SwingConstants.RIGHT);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		return label;
	}

	public void refreshView(GameModel model) {
		// TODO Auto-generated method stub
		
	}
}
