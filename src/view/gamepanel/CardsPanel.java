package view.gamepanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import view.JavaImageLoader;
import model.actions.ActionResult;

/**
 * Created by Baker on 4/14/2014.
 */
@SuppressWarnings("serial")
public class CardsPanel extends JPanel {
	Graphics g;
	JLabel stack;
	JLabel card;
	JTextArea textArea;
	JButton planningMode;
	JButton replayMode;
	
	public CardsPanel() {
		stack = newJLabel("3", new ImageIcon(JavaImageLoader.getImage("resources/card.png")), 75, 200);
		card = newJLabel("3", new ImageIcon(JavaImageLoader.getImage("resources/card.png")), 75, 200);
//		this.add(stack);
//		this.add(card);
		
		planningMode = new JButton(); planningMode.setText("Planning Mode");
		replayMode = new JButton(); replayMode.setText("Replay Mode");
		
		this.add(planningMode);
		this.add(replayMode);
		textArea = new JTextArea();
		this.add(textArea);
	}

	
	private JLabel newJLabel(String value, String src, int width, int height){
		ImageIcon icon = new ImageIcon(src);
		return newJLabel(value, icon, width, height);
	}
	
	private JLabel newJLabel(String value, ImageIcon icon, int width, int height){
		JLabel label= new JLabel(value);
		label.setIcon(icon);
		label.setFont(new Font("Lucida Grande", 0, 14));
		label.setPreferredSize(new Dimension(width, height));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		return label;
	}
	
	public void refreshView(ActionResult actionResult) {
		if(actionResult != null) {
			textArea.setText(actionResult.getMessage());
		} else {
			textArea.setText("ACTION RESULT NULL");
		}
	}
}
