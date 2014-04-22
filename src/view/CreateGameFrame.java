package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CreateGameFrame extends JFrame {
	public JPanel panel;
	public JButton startGame;
	public JPanel[] players;
	public JTextField[] playerNames;
	public JComboBox<String> selectNumPlayers;
	public int maxNumPlayers = 4;
	
	public CreateGameFrame(ActionListener listener) {
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 600));
		
		players = new JPanel[maxNumPlayers];
		playerNames = new JTextField[maxNumPlayers];
		startGame = new JButton("Play");
		
		setTitle("New Game");
		setSize(400, 600);
		setResizable(false);
		
		JLabel numPlayers = new JLabel("Number of Players");
		
		selectNumPlayers = new JComboBox<String>(new String[] {"1", "2", "3", "4"});
		selectNumPlayers.setSelectedIndex(0);
		
		selectNumPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numOfPlayers = selectNumPlayers.getSelectedIndex();
				for(int x = 0; x < players.length; ++x)
					if(x <= numOfPlayers)
						players[x].setVisible(true);
					else
						players[x].setVisible(false);
			}
		});
		
		panel.add(numPlayers);
		panel.add(selectNumPlayers);
		
		for(int x = 0; x < players.length; ++x){
			players[x] = new JPanel();
			players[x].setPreferredSize(new Dimension(400, 100));
			players[x].add(new JLabel("name "));
			
			playerNames[x] = new JTextField();
			playerNames[x].setPreferredSize(new Dimension(100, 25));
			players[x].add(playerNames[x]);
			
			panel.add(players[x]);
			players[x].setVisible(false);
		}

		panel.add(startGame);
		this.add(panel);
		this.setVisible(true);
		startGame.addActionListener(listener);
	}

	public String[] getPlayerNames(){
		int numPlayers = selectNumPlayers.getSelectedIndex() + 1;
		final String names[] = new String[numPlayers];
		for(int x = 0; x < numPlayers; ++x)
			names[x] = playerNames[x].getText();
		return names;
	}
}