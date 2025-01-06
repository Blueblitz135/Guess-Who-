package guessWho;

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
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel crossOutGrid;
	private JLabel nameGuessLabel;
	private JLabel guessLabel;
	private JLabel questiontoAsk;
	private JButton rulesButton;
	private JButton submitGuessButton;
	private JButton rightArrowForNextQuestion;
	private JButton leftArrowForNextQuestion;
	
	
	
	/**
	 * This is the constructor which will initiate the graphics of the game board
	 */
	public GuessWho() {
		
	}
	
	/**
	 * This method will create the pop up for the win screen when there is a winner.
	 */
	public static void winScreen() {
		
	}
	
	/**
	 * This method will call the the methods from other classes while the game is running
	 * @param e the action event that was registered
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
}
