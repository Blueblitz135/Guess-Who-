package guessWho;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class will contain the game board and run the game Guess Who when the main method calls it.
 *
 */
public class GuessWho extends JFrame implements ActionListener {
	private JFrame startFrame;
	private JFrame ruleFrame;
	private JFrame gameFrame;
	private JLabel gameTitle;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel crossOutGrid;
	private JLabel nameGuessLabel;
	private JLabel guessLabel;
	private JLabel questiontoAsk;
	private JButton startButton;
	private JButton rulesButton;
	private JButton submitGuessButton;
	private JButton rightArrowForNextQuestion;
	private JButton leftArrowForNextQuestion;
	private ImageIcon gameTitleImage;
	
	
	
	/**
	 * This is the constructor which will initiate the graphics of the game board
	 */
	public GuessWho() {
		// Initialize the starting frame before the game starts
		startFrame = new JFrame("Guess Who");
		startFrame.setSize(new Dimension(1100, 800));
		//startFrame.setLayout();
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.getContentPane().setBackground(new Color(154, 231, 252));
		startFrame.setResizable(false);
		startFrame.setVisible(true);
		
		
		// Initialize the rules 
		
		// Initialize objects for the game board
		//startFrame = new JFrame();
		
	}
	
	/**
	 * This method will create the pop up for the win screen when there is a winner.
	 */
	public static void resultScreen() {
		
	}
	
	
	
	/**
	 * This method will call the the methods from other classes while the game is running
	 * @param e the action event that was registered
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
}
