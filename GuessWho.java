package guessWho;

import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class will contain the game board and run the game Guess Who when the
 * main method calls it.
 *
 */
public class GuessWho extends JFrame implements ActionListener {
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
	public GuessWho() {
		// Initialize the starting frame before the game starts
		startFrame = new JFrame("Guess Who");
		startFrame.setSize(new Dimension(1100, 800));
		// startFrame.setLayout();
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.getContentPane().setBackground(new Color(154, 231, 252));
		startFrame.setResizable(false);
		startFrame.setVisible(true);

		// Initialize the rules

		// Initialize objects for the game board
		// startFrame = new JFrame();

		/**
		 * Creates and fills the character list
		 */

		Character[] characters = new Character[24];
		characters[0] = new Character("white", "brown", "female", "brown", "RACHEL", false, true, false, false, false,
				false);

		characters[1] = new Character("white", "white", "male", "brown", "JON", false, false, true, false, false,
				false);

		characters[2] = new Character("white", "brown", "male", "blue", "NICK", true, false, false, false, false,
				false);

		characters[3] = new Character("white", "orange", "female", "brown", "ASHLEY", false, true, false, true, false,
				false);

		characters[4] = new Character("white", "blonde", "male", "brown", "JAKE", false, false, true, false, true,
				false);

		characters[5] = new Character("white", "white", "male", "brown", "JOSHUA", false, false, true, false, true,
				false);

		characters[6] = new Character("white", "white", "female", "blue", "EMILY", true, false, false, true, false,
				false);

		characters[7] = new Character("white", "blonde", "male", "blue", "KYLE", false, false, false, false, false,
				true);

		characters[8] = new Character("white", "white", "male", "brown", "ALEX", true, false, false, false, false,
				false);

		characters[9] = new Character("black", "black", "female", "brown", "SARAH", true, false, false, true, false,
				false);

		characters[10] = new Character("white", "brown", "male", "brown", "JUSTIN", false, false, true, false, true,
				false);

		characters[11] = new Character("white", "blonde", "female", "blue", "MEGAN", false, false, false, true, false,
				false);

		characters[12] = new Character("white", "white", "male", "brown", "MATT", false, false, false, false, false,
				false);

		characters[13] = new Character("white", "blonde", "male", "brown", "BRANDON", false, true, false, false, false,
				true);

		characters[14] = new Character("white", "blonde", "male", "brown", "WILLIAM", false, false, true, false, false,
				false);

		characters[15] = new Character("black", "brown", "male", "brown", "CONNOR", false, false, true, false, true,
				false);

		characters[16] = new Character("white", "black", "male", "brown", "CHRIS", false, true, false, false, false,
				false);

		characters[17] = new Character("black", "brown", "male", "brown", "DANIEL", false, true, false, false, false,
				false);

		characters[18] = new Character("black", "black", "male", "brown", "ANDY", false, false, true, false, false,
				true);

		characters[19] = new Character("black", "brown", "male", "brown", "JAMES", false, false, true, false, false,
				false);

		characters[20] = new Character("white", "orange", "male", "brown", "DAVID", false, false, true, false, true,
				false);

		characters[21] = new Character("white", "orange", "male", "brown", "ZACHARY", false, false, false, false, false,
				false);

		characters[22] = new Character("white", "orange", "male", "blue", "JOSEPH", true, false, false, false, false,
				false);

		characters[23] = new Character("white", "black", "male", "brown", "TYLER", false, false, false, false, false,
				true);

	}

	/**
	 * This method will create the pop up for the win screen when there is a winner.
	 */
	public static void resultScreen() {

	}

	/**
	 * This method will call the the methods from other classes while the game is
	 * running
	 * 
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
