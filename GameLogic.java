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
public class GuessWho extends JFrame implements ActionListener {
	private JFrame startFrame;
	private JFrame rulesFrame;
	private JFrame gameFrame;
	private JLabel gameTitle;
	private JLabel[] cross;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel crossOutGrid;
	private JLabel guessLabel;
	private JLabel questiontoAsk;
	private JButton startButton;
	private JButton rulesButton;
	private JButton submitGuessButton;
	private JButton rightArrowForNextQuestion;
	private JButton leftArrowForNextQuestion;
	private JButton submitQuestionButton;
	private JButton closeRulesButton;
	private JTextField nameGuessField;
	private ImageIcon gameTitleImage;
	private ArrayList<String> questionBank;
	private int currentQuestionIndex;
	private String[] characterlist;
	private ArrayList<Character> characters = new ArrayList<>();

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
		
		// Initialize "X" labels
		for (int i = 0; i < cross.length; i++) {
			cross[i] = new JLabel();
			
		}

		/**
		 * Creates and fills the character list
		 */
		
		
		characters.add(new Character("white", "brown", "female", "brown", "RACHEL", false, true, false, false, false, false));
		
		characters.add(new Character("white", "white", "male", "brown", "JON", false, false, true, false, false, false));

		characters.add(new Character("white", "brown", "male", "blue", "NICK", true, false, false, false, false, false));

		characters.add(new Character("white", "ginger", "female", "brown", "ASHLEY", false, true, false, true, false, false));
	
		characters.add(new Character("white", "blonde", "male", "brown", "JAKE", false, false, true, false, true, false));
	
		characters.add(new Character("white","white","male","brown","JOSHUA",false,false,true,false,true,false));
	
		characters.add(new Character("white","white","female","blue","EMILY",true,false,false,true,false,false));
	
		characters.add(new Character("white","blonde","male","blue","KYLE",false,false,false,false,false,true));
	
		characters.add(new Character("white","white","male","brown","ALEX",true,false,false,false,false,false));
	
		characters.add(new Character("black","black","female","brown","SARAH",true,false,false,true,false,false));
	
		characters.add(new Character("white", "brown", "male", "brown", "JUSTIN", false, false, true, false, true, false));
	
		characters.add(new Character("white", "blonde", "female", "blue", "MEGAN", false, false, false, true, false, false));
	
		characters.add(new Character("white", "white", "male", "brown", "MATT", false, false, false, false, false, false));
	
		characters.add(new Character("white", "blonde", "male", "brown", "BRANDON", false, true, false, false, false, true));
	
		characters.add(new Character("white", "blonde", "male", "brown", "WILLIAM", false, false, true, false, false, false));
	
		characters.add(new Character("black", "brown", "male", "brown", "CONNOR", false, false, true, false, true, false));
	
		characters.add(new Character("white", "black", "male", "brown", "CHRIS", false, true, false, false, false, false));
	
		characters.add(new Character("black", "brown", "male", "brown", "DANIEL", false, true, false, false, false, false));
	
		characters.add(new Character("black", "black", "male", "brown", "ANDY", false, false, true, false, false, true));
	
		characters.add(new Character("black", "brown", "male", "brown", "JAMES", false, false, true, false, false, false));
	
		characters.add(new Character("white", "ginger", "male", "brown", "DAVID", false, false, true, false, true, false));
	
		characters.add(new Character("white", "ginger", "male", "brown", "ZACHARY", false, false, false, false, false, false));
	
		characters.add(new Character("white", "ginger", "male", "blue", "JOSEPH", true, false, false, false, false, false));
	
		characters.add(new Character("white", "black", "male", "brown", "TYLER", false, false, false, false, false, true));

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
		
		// If the start game button is pressed, close the start frame, and open the game and rule frames.
		if ((e.getSource()).equals(startButton)) {
			startFrame.setVisible(false);
			gameFrame.setVisible(true);
			rulesFrame.setVisible(true);
		}
		
		// If the rules button is pressed, open the rules frame
		if ((e.getSource()).equals(rulesButton)) {
			rulesFrame.setVisible(true);
		}
		
		// If the close rules button is clicked, close the rules frame
		if ((e.getSource()).equals(closeRulesButton)) {
			rulesFrame.setVisible(false);
		}
		
		// If the submit guess button is clicked, submit the text within the text field
		if ((e.getSource()).equals(submitGuessButton)) {
			
			String name = nameGuessField.getText();
			
			// Go through the array of characters to see if the name submitted is valid
			for (int i = 0; i < characterlist.length; i++) {
				if (characterlist[i].equalsIgnoreCase(name));
			}
			
			
		}
		
		// If the right arrow is clicked, go to the next question. 
		// If the right arrow is clicked at the last question, loop back to the first question.
		if ((e.getSource()).equals(rightArrowForNextQuestion)) {
							
			if (currentQuestionIndex == questionBank.size() - 1) {
				currentQuestionIndex = 0;
			} else {
		
				currentQuestionIndex++;
			}
			
			questiontoAsk.setText(questionBank.get(currentQuestionIndex));

		}
		
		// If the left arrow is clicked, go to the previous question.
		// If the left arrow is clicked at the first question, loop back to the last question.
		if ((e.getSource()).equals(leftArrowForNextQuestion)) {
			
			if (currentQuestionIndex == 0) {
				currentQuestionIndex = questionBank.size() - 1;
			} else {
				currentQuestionIndex--;
			}
			
			questiontoAsk.setText(questionBank.get(currentQuestionIndex));

			
		}
		
		// Submit the question and cross out characters accordingly based on the results
		// of the question asked.
		if ((e.getSource()).equals(submitQuestionButton)) {

			String question = questiontoAsk.getText();

			if (question.equalsIgnoreCase("Is Your Character Male?")) {
				
				for (int i = 0; i < characters.size(); i++) {
					String gender = characters.get(i).getGender();
					
					if (gender.equalsIgnoreCase("Male")) {
						
					}
				}
				
			} else if (question.equalsIgnoreCase("Does Your Character Have Facial Hair")) {

				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Is Your Character White?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Does Your Character Have A Moustache?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Is Your Character Wearing Glasses?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Does Your Characters Name Start With A J")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Does Your Character Have Blue Eyes?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Does Your Character Have A Hat?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Does Your Character Have A Hat?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Is Your Character Wearing Earings?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Does Your Character Have White Hair?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Does Your Character Have Orange Hair?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Can You See Your Characters Teeth?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Is Your Character Blonde?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
				
			} else if (question.equalsIgnoreCase("Does Your Character Have Brown Hair?")) {
				
				for (int i = 0; i < characters.size(); i++) {

				}
			}
		}
		
	}


	
}
