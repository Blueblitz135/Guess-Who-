package guessWho;
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class will contain the game board and run the game Guess Who when the main method calls it.
 *
 */
public class GameLogic extends JFrame implements ActionListener {
	private JFrame startFrame;
	private JFrame rulesFrame;
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
	private JButton submitQuestionButton;
	private JButton closeRulesButton;
	private ImageIcon gameTitleImage;
	private ArrayList<String> questionBank;
	private int currentQuestionIndex;
	
	/**
	 * This is the constructor which will initiate the graphics of the game board
	 */
	public GameLogic() {
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
	
	
	// actionListener has if statements to determine which question is pressed
	// 
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource()).equals(startButton)) {
			startFrame.setVisible(false);
			gameFrame.setVisible(true);
			rulesFrame.setVisible(true);
		}
		
		if ((e.getSource()).equals(rulesButton)) {
			rulesFrame.setVisible(true);
		}
		
		if ((e.getSource()).equals(submitGuessButton)) {
			
			
		}
		
		if ((e.getSource()).equals(rightArrowForNextQuestion)) {
			// If at the last question, loop back to the very first question
			if (currentQuestionIndex == questionBank.size() - 1) {
				currentQuestionIndex = 0;
			} else {
				currentQuestionIndex++;
			}
			
			questiontoAsk.setText(questionBank.get(currentQuestionIndex));

		}
		
		if ((e.getSource()).equals(leftArrowForNextQuestion)) {
			
			// If at the first question, loop back to the very last question
			if (currentQuestionIndex == 0) {
				currentQuestionIndex = questionBank.size() - 1;
			} else {
				// Else subtract one from the index to go back to the previous index
				currentQuestionIndex--;
			}
			
			questiontoAsk.setText(questionBank.get(currentQuestionIndex));

			
		}
		
		if ((e.getSource()).equals(closeRulesButton)) {
			rulesFrame.setVisible(false);
			
		}
		
		if ((e.getSource()).equals(submitQuestionButton)) {

		}
		
	}


	
}
