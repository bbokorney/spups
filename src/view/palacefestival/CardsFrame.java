package view.palacefestival;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CardsFrame extends JFrame {
	CurrentPlayerHandPanel panel;
	public CardsFrame(CurrentPlayerHandPanel panel, KeyListener listener) {
		this.panel = panel; 
		this.add(panel);
	}
	
	
}
