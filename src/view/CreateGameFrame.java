package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CreateGameFrame extends JFrame {
	JPanel newGamePanel;
	JButton startGame;
	JPanel[] newPlayers;
	JTextField[] playerNames;
	JComboBox<String> playerSelectionBox;
	int width = 500;
	int height = 500;
	
	@SuppressWarnings("unchecked")
	public CreateGameFrame() {
		newGamePanel = new JPanel();
		newGamePanel.setPreferredSize(new Dimension(width, height));
		newGamePanel.setLayout(new FlowLayout());
		newGamePanel.setBackground(Color.WHITE);
		newGamePanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
		
		newPlayers = new JPanel[4];
		playerNames = new JTextField[4];
		
		startGame = new JButton("Let's Play!");
		
		setTitle("Setup New Game");
		setSize(width, height);
		setResizable(false);
		
		setUpView();
		displayPanel(newGamePanel);
	}

	private void setUpView(){
		JPanel numPlayerPanel = new JPanel();
		numPlayerPanel.setPreferredSize(new Dimension(480, 70));
		numPlayerPanel.setBackground(Color.WHITE);
		JLabel numPlayers = new JLabel("Number of Players: ");
		numPlayerPanel.add(numPlayers);
		
		String[] players = {"Select number of Players", "2", "3", "4"};
		playerSelectionBox = new JComboBox<String>(players);
		playerSelectionBox.setSelectedIndex(0);
		playerSelectionBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = playerSelectionBox.getSelectedIndex();
				if(selectedIndex > 0){
					displayPlayerNamePanels(selectedIndex+1);
				}
				
			}
		});
		numPlayerPanel.add(playerSelectionBox);
		
		newGamePanel.add(numPlayerPanel);
		
		String[] colors = {"Red", "Orange", "Yellow", "Green", "Blue", "Purple"}; 
		
		for(int i = 0; i < newPlayers.length; ++i){
			newPlayers[i] = new JPanel();
			newPlayers[i].setPreferredSize(new Dimension(480, 70));
			newPlayers[i].setBackground(Color.WHITE);
			newPlayers[i].add(new JLabel("Player "+(i+1)+" name: "));
			
			playerNames[i] = new JTextField();
			playerNames[i].setPreferredSize(new Dimension(100, 25));
			newPlayers[i].add(playerNames[i]);
			
			newGamePanel.add(newPlayers[i]);
			newPlayers[i].setVisible(false);
			
		}
		
		newGamePanel.add(startGame);
		
	}
	
	private void displayPlayerNamePanels(int players){
		for(int i = 0; i < newPlayers.length; ++i){
			newPlayers[i].setVisible(true);
			if(i >= players){
				newPlayers[i].setVisible(false);
			}
		}
	}
	
	private void displayPanel(JPanel panel){
		this.setContentPane(panel);
		this.validate();
	}
	
	public void addStartNewGameListener(ActionListener listenForStartGameButton){
		startGame.addActionListener(listenForStartGameButton);
	}
	
	public void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this,  errorMessage);
	}
	
	public JComboBox<String> getPlayerSelectionComboBox(){
		return this.playerSelectionBox;
	}
	public JTextField[] getPlayerNames(){
		return this.playerNames;
	}

}