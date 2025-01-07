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
	private JFrame rulesFrame;
	private JFrame gameFrame;
	private JLabel gameTitle;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel crossOutGrid;
	private JLabel nameGuessLabel;
	private JLabel guessLabel;
	private JLabel questiontoAsk;
	private JButton submitQuestionButton;
	private JButton closeRulesButton;
	private JButton startButton;
	private JButton rulesButton;
	private JButton submitGuessButton;
	private JButton rightArrowForNextQuestion;
	private JButton leftArrowForNextQuestion;
	private ImageIcon gameLogo;
	private ArrayList<String> questionBank = new ArrayList<>();
	
	
	
	/**
	 * This is the constructor which will initiate the graphics of the game board
	 */
	public GuessWho() {
		ImageIcon gameLogo = new ImageIcon("GuessWho_Icon.png");
		
		
		// Initialize the starting frame before the game starts, including the start button and the title logo on the frame
		startFrame = new JFrame("Guess Who");
		startFrame.setSize(new Dimension(1100, 800));
		startFrame.setLayout(new BoxLayout(startFrame.getContentPane(), BoxLayout.Y_AXIS));
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.getContentPane().setBackground(new Color(187, 238, 252));
		startFrame.setResizable(false);
		startFrame.setVisible(true);
		
		gameTitle = new JLabel();
		gameTitle.setIcon(gameLogo);
		gameTitle.setVisible(true);
		startFrame.add(gameTitle);
		startButton = new JButton();
		
		
		
		
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
