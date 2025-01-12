package guessWho;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.EmptyBorder;
/**
 * This class will contain the game board and run the game Guess Who when the main method calls it.
 *
 */
public class GuessWho implements ActionListener {
	private JFrame startFrame;
	private JFrame rulesFrame;
	private JFrame gameBoardFrame;
	private JFrame statsFrame;
	private JLabel gameTitle;
	private JLabel smallGameTitle;
	private JPanel characterPanel;
	private JPanel questionPanel;
	private JPanel crossOutPanel;
	private JPanel sidePanel;
	private JPanel statsPanel;
	private JLabel guessCharacterLabel;
	private JLabel questionToAsk;
	private JLabel characterBoardLabel;
	private JLabel numQuestionsAskedLabel;
	private JLabel numGamesWonLabel;
	private JLabel maxNumQuestionsAskedToWinLabel;
	private JLabel minNumQuestionsAskedToWinLabel;
	private JLabel statsTitle;
	private JButton startButton;
	private JButton rulesButton;
	private JButton submitGuessButton;
	private JButton rightArrow;
	private JButton leftArrow;
	private JButton submitQuestionButton;
	private JButton closeRulesButton; // maybe we don't need cause they can just "x" out
	private JButton statsButton;
	private JTextField nameGuessField;
	private JLayeredPane characterLayerPane;
	private ImageIcon gameLogo;
	private ImageIcon characterBoardImage;
	private ImageIcon redCrossImage;
	private ImageIcon rightArrowImage;
	private ImageIcon leftArrowImage;
	private ImageIcon checkMarkImage;
	private GridBagConstraints gbc;
	private Color backgroundColor;
	
	private int numOfQuestionsAsked;
	private ArrayList<String> questionBank;
	private int currentQuestionIndex;
	//private GameChar aiCharacter;
	private boolean playerAnswer;
	private ArrayList<GameChar> characters = new ArrayList<>();
	private JLabel[] crossOutLabelGrid;
	private boolean aiTurn;
	private int numGamesWon;
	private int maxNumQuestionsAskedToWin;
	private int minNumQuestionsAskedToWin;
	
	/**
	 * This is the constructor which will initiate the graphics of the game board
	 * @throws FileNotFoundException 
	 */
	public GuessWho() throws FileNotFoundException {	
		
		// Initialize variables and constant objects for the game
		gameLogo = new ImageIcon("guessWho_Icon.png");
		gbc = new GridBagConstraints(); // variable used to determine the panel position and spacing for the game frame
		backgroundColor = new Color(114, 163, 247);
		numOfQuestionsAsked = 0;
		currentQuestionIndex = 0;
		playerAnswer = false;
		aiTurn = false;
		
		// Initialize stats variables using file i/o
		File statsFile = new File("stats");
		Scanner statsScan = new Scanner(statsFile);
		numGamesWon = statsScan.nextInt();
		maxNumQuestionsAskedToWin = statsScan.nextInt();
		minNumQuestionsAskedToWin = statsScan.nextInt();
		
		System.out.println(numGamesWon);
		System.out.println(maxNumQuestionsAskedToWin);
		System.out.println(minNumQuestionsAskedToWin);
		
		// Add questions to the question bank
		questionBank = new ArrayList<>();
		questionBank.add("Is Your Character Male?");
		questionBank.add("Does Your Character Have Facial Hair");
		questionBank.add("Is Your Character White?");
		questionBank.add("Does Your Character Have A Moustache?");
		questionBank.add("Is Your Character Wearing Glasses?");
		questionBank.add("Does Your Character's Name Start With A J");
		questionBank.add("Does Your Character Have Blue Eyes?");
		questionBank.add("Does Your Character Have A Hat?");
		questionBank.add("Does Your Character Not Have A Hat?");
		questionBank.add("Is Your Character Wearing Earings?");
		questionBank.add("Does Your Character Have White Hair?");
		questionBank.add("Does Your Character Have Ginger Hair?");
		questionBank.add("Can You See Your Character's Teeth?");
		questionBank.add("Is Your Character Blonde?");
		questionBank.add("Does Your Character Have Brown Hair?");
		
		// Initialize characters
		
		
		
		//---------------------------------Graphics Initialization-------------------------------
		
		// Initialize and set sizing and set sizing for the character board image
		characterBoardImage = new ImageIcon("character_board.jpg");
		Image tempImage = characterBoardImage.getImage(); // transform it 
		Image tempNewImg = tempImage.getScaledInstance(850, 595,  java.awt.Image.SCALE_SMOOTH); 
		characterBoardImage = new ImageIcon(tempNewImg);
		
		// Initialize and set sizing and set sizing for red cross image
		redCrossImage = new ImageIcon("red_cross.png");
		tempImage = redCrossImage.getImage(); // transform it 
		tempNewImg = tempImage.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
		redCrossImage = new ImageIcon(tempNewImg);
		
		// Initialize and set sizing and set sizing for left and right arrows
		rightArrowImage = new ImageIcon("right_arrow.png");
		tempImage = rightArrowImage.getImage(); // transform it 
		tempNewImg = tempImage.getScaledInstance(65, 50,  java.awt.Image.SCALE_SMOOTH); 
		rightArrowImage = new ImageIcon(tempNewImg);

		leftArrowImage = new ImageIcon("left_arrow.png");
		tempImage = leftArrowImage.getImage(); // transform it 
		tempNewImg = tempImage.getScaledInstance(65, 50,  java.awt.Image.SCALE_SMOOTH); 
		leftArrowImage = new ImageIcon(tempNewImg);
		
		// Initialize and set sizing for the check mark image, which will be used for the submit question button
		checkMarkImage = new ImageIcon("check_mark.png");
		tempImage = checkMarkImage.getImage(); // transform it 
		tempNewImg = tempImage.getScaledInstance(65, 50,  java.awt.Image.SCALE_SMOOTH); 
		checkMarkImage = new ImageIcon(tempNewImg);
		
		
		// Initialize the starting frame before the game starts, including the start button and the title logo on the frame
		startFrame = new JFrame("Guess Who");
		startFrame.setSize(new Dimension(1200, 800));
		startFrame.setLayout(new BorderLayout());
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.getContentPane().setBackground(backgroundColor);
		startFrame.setResizable(false);
		startFrame.setVisible(true);
		
		JPanel topStartPanel = new JPanel();
		startFrame.add(topStartPanel, BorderLayout.NORTH);
		topStartPanel.setBackground(backgroundColor);
		topStartPanel.setBorder(new EmptyBorder(90, 0, 0, 0));
		
		JPanel bottomStartPanel = new JPanel();
		startFrame.add(bottomStartPanel, BorderLayout.SOUTH);
		bottomStartPanel.setBackground(backgroundColor);
		bottomStartPanel.setBorder(new EmptyBorder(0, 0, 130, 0));
		
		gameTitle = new JLabel();
		gameTitle.setIcon(gameLogo);
		gameTitle.setVisible(true);
		topStartPanel.add(gameTitle);
		topStartPanel.setVisible(true);
		
		startButton = new JButton();
		startButton.addActionListener(this);
		startButton.setVisible(true);
		startButton.setPreferredSize(new Dimension(280, 110));
		bottomStartPanel.add(startButton);
		startButton.setBackground(new Color(247, 238, 156));
		startButton.setFont(new Font("Helvetica", Font.BOLD, 60));
		startButton.setFocusable(false);
		startButton.setText("START");

		
		
		// Initialize the rules frame
		rulesFrame = new JFrame("Rules");
		rulesFrame.setSize(new Dimension(400, 700));
		rulesFrame.setLayout(new BorderLayout());
		rulesFrame.getContentPane().setBackground(new Color(187, 238, 252));
		rulesFrame.setResizable(false);
		//rulesFrame.setVisible(true);
		
		
		
		// Initialize frame for game board
		gameBoardFrame = new JFrame();
		gameBoardFrame.setResizable(false);
		gameBoardFrame.setSize(new Dimension(1200, 800));
		//gameBoardFrame.setVisible(true);
		gameBoardFrame.setLayout(new GridBagLayout());
		gameBoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameBoardFrame.getContentPane().setBackground(backgroundColor);
		
		
		// Initialize panel with the characters which can be crossed out on the game board
		// It will use a layered pane to overlap the cross grid with the character board image
		characterPanel = new JPanel();
		characterPanel.setLayout(null);
		characterPanel.setPreferredSize(new Dimension(850, 620));
		characterPanel.setBackground(backgroundColor);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		characterPanel.setVisible(true);
		gameBoardFrame.add(characterPanel, gbc);
		
		characterLayerPane = new JLayeredPane();
		characterLayerPane.setBounds(0, 0, 850, 620);
		characterPanel.add(characterLayerPane);
		
		// Initialize the cross out labels on the cross out panel
		// The cross out panel will be in the character panel
		crossOutPanel = new JPanel();
		crossOutPanel.setBounds(0, 15, 850, 550);
		crossOutPanel.setBorder(new EmptyBorder(10, 22, 0, 0));
		crossOutPanel.setLayout(new GridLayout(4, 6, 24, 80));
		crossOutPanel.setOpaque(false);
		crossOutLabelGrid = new JLabel[24];
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 4; j++) {
//				crossOutLabelGrid[j][i] = new JLabel();
//				crossOutLabelGrid[j][i].setBackground(Color.black);
//				crossOutLabelGrid[j][i].setVisible(true);
//				crossOutLabelGrid[j][i].setIcon(redCrossImage);
//				crossOutPanel.add(crossOutLabelGrid[j][i]);
//				
//			}
//		}
		for (int i = 0; i < 24; i++) {
			crossOutLabelGrid[i] = new JLabel();
			crossOutLabelGrid[i].setBackground(Color.black);
			crossOutLabelGrid[i].setVisible(true);
			crossOutLabelGrid[i].setIcon(redCrossImage);
			crossOutPanel.add(crossOutLabelGrid[i]);
		}
		characterLayerPane.add(crossOutPanel, JLayeredPane.DRAG_LAYER);
		
		// Initialize the character board image which will be on a JLabel 
		characterBoardLabel = new JLabel();
		characterBoardLabel.setIcon(characterBoardImage);
		characterBoardLabel.setBackground(Color.white);
		characterBoardLabel.setBounds(0, 0, 850, 630);
		characterLayerPane.add(characterBoardLabel, JLayeredPane.DEFAULT_LAYER);
		
		
		// Initialize the panel where the player can select and ask questions
		questionPanel = new JPanel();
		questionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 15)); // change later
		questionPanel.setPreferredSize(new Dimension(850, 100));
		questionPanel.setBackground(Color.white);
		questionPanel.setOpaque(false);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		gameBoardFrame.add(questionPanel, gbc);
		
		// Initialize and add the arrows question field, and submit button for the questions panel
		leftArrow = new JButton();
		questionPanel.add(leftArrow);
		leftArrow.addActionListener(this);
		leftArrow.setIcon(leftArrowImage);
		leftArrow.setSize(60, 45);
		leftArrow.setFocusable(false);
		leftArrow.setBackground(backgroundColor);
		leftArrow.setBorderPainted(false);
		leftArrow.setVisible(true);
		
		questionToAsk = new JLabel();
		questionPanel.add(questionToAsk);
		questionToAsk.setHorizontalAlignment(SwingConstants.CENTER);
		questionToAsk.setVerticalAlignment(SwingConstants.CENTER);
		questionToAsk.setText("Does Your Character Not Have Facial Hair?");
		questionToAsk.setOpaque(true);
		questionToAsk.setBackground(new Color(38, 65, 110));
		questionToAsk.setForeground(Color.white);
		questionToAsk.setPreferredSize(new Dimension(550, 50));
		questionToAsk.setFont(new Font("Helvetica", Font.BOLD, 23));
		questionToAsk.setVisible(true);
		
		rightArrow = new JButton();
		questionPanel.add(rightArrow);
		rightArrow.addActionListener(this);
		rightArrow.setIcon(rightArrowImage);
		rightArrow.setSize(60, 45);
		rightArrow.setFocusable(false);
		rightArrow.setBackground(backgroundColor);
		rightArrow.setBorderPainted(false);
		rightArrow.setVisible(true);
		
		submitQuestionButton = new JButton();
		questionPanel.add(submitQuestionButton);
		submitQuestionButton.addActionListener(this);
		submitQuestionButton.setIcon(checkMarkImage);
		submitQuestionButton.setSize(60, 50);
		submitQuestionButton.setFocusable(false);
		submitQuestionButton.setBackground(backgroundColor);
		submitQuestionButton.setBorderPainted(false);
		submitQuestionButton.setVisible(true);
		
		
		// Initialize the sidepanel where the player can guess the AI's character during their turn
		// They can also see the number of questions they have currently asked, 
		// view rules, and view previous game stats
		sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		//sidePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		sidePanel.setPreferredSize(new Dimension(220, 700));
		sidePanel.setBorder(new EmptyBorder(30, 15, 0, 0));
		sidePanel.setOpaque(false);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.insets = new Insets(5,10,5,5);
		gameBoardFrame.add(sidePanel, gbc);
		
		// Add Guess Who logo at the top of the panel for design
		// The logo image needs to be resized smaller to fit the panel
		tempImage = gameLogo.getImage(); // transform it 
		tempNewImg = tempImage.getScaledInstance(180, 100,  java.awt.Image.SCALE_SMOOTH); 
		gameLogo = new ImageIcon(tempNewImg);
		
		smallGameTitle = new JLabel();
		sidePanel.add(smallGameTitle);
		smallGameTitle.setIcon(gameLogo);
		smallGameTitle.setVisible(true);
		
		// Initialize and add the label and text field for the player to type in their guess for the AI's character
		guessCharacterLabel = new JLabel("Guess:");
		sidePanel.add(guessCharacterLabel);
		guessCharacterLabel.setBorder(new EmptyBorder(70, 1, 10, 0));
		guessCharacterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		guessCharacterLabel.setVerticalAlignment(SwingConstants.CENTER);
		guessCharacterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		guessCharacterLabel.setForeground(Color.black);
		guessCharacterLabel.setPreferredSize(new Dimension(50, 50));
		guessCharacterLabel.setFont(new Font("Helvetica", Font.BOLD, 27));
		guessCharacterLabel.setVisible(true);
		
		nameGuessField = new JTextField();
		sidePanel.add(nameGuessField);
		nameGuessField.setForeground(Color.black);
		nameGuessField.setBorder(new CompoundBorder(new LineBorder(Color.black, 1), new EmptyBorder(0, 5, 0, 0)));
		nameGuessField.setSize(new Dimension(190, 50));
		nameGuessField.setPreferredSize(new Dimension(190, 50));
		nameGuessField.setMaximumSize(new Dimension(190, 50));
		nameGuessField.setFont(new Font("Helvetica", Font.BOLD, 27));
		nameGuessField.setAlignmentX(Component.LEFT_ALIGNMENT);
		nameGuessField.setBackground(new Color(146, 160, 179));
		nameGuessField.setVisible(true);
		
		// Initialize and add the button for player to submit guess
		submitGuessButton = new JButton();
		sidePanel.add(Box.createRigidArea(new Dimension(0, 15)));
		sidePanel.add(submitGuessButton);
		submitGuessButton.addActionListener(this);
		submitGuessButton.setText("Submit");
		submitGuessButton.setSize(80, 60);
		submitGuessButton.setFont(new Font("Helvetica", Font.BOLD, 20));
		submitGuessButton.setFocusable(false);
		submitGuessButton.setBackground(new Color(190, 209, 237));
		submitGuessButton.setVisible(true);
		
		// Initialize and label for player to see how many questions they have currently asked
		numQuestionsAskedLabel = new JLabel();
		sidePanel.add(Box.createRigidArea(new Dimension(0, 70)));
		sidePanel.add(numQuestionsAskedLabel);
		numQuestionsAskedLabel.setText("# of Questions Asked: " + 0);
		numQuestionsAskedLabel.setForeground(Color.black);
		numQuestionsAskedLabel.setPreferredSize(new Dimension(200, 50));
		numQuestionsAskedLabel.setFont(new Font("Helvetica", Font.BOLD, 17));
		numQuestionsAskedLabel.setVisible(true);
		
		// Initialize and add button to stats from previous games
		statsButton = new JButton("View Stats");
		sidePanel.add(Box.createRigidArea(new Dimension(0, 70)));
		sidePanel.add(statsButton);
		statsButton.addActionListener(this);
		statsButton.setSize(100, 70);
		statsButton.setFocusable(false);
		statsButton.setBackground(new Color(62, 74, 92));
		statsButton.setForeground(Color.white);
		statsButton.setFont(new Font("Helvetica", Font.BOLD, 27));
		statsButton.setVisible(true);

		// Initialize and add the button where the player can access the rules
		rulesButton = new JButton("View Rules");
		sidePanel.add(Box.createRigidArea(new Dimension(0, 40)));
		sidePanel.add(rulesButton);
		rulesButton.addActionListener(this);
		rulesButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		rulesButton.setSize(100, 70);
		rulesButton.setFocusable(false);
		rulesButton.setBackground(new Color(62, 74, 92));
		rulesButton.setForeground(Color.white);
		rulesButton.setFont(new Font("Helvetica", Font.BOLD, 27));
		rulesButton.setVisible(true);
		
		
		//Initialize frame and panel to display stats
		statsFrame = new JFrame("Stats");
		statsFrame.setSize(new Dimension(700, 400));
		//statsFrame.setLayout(new BorderLayout());
		statsFrame.getContentPane().setBackground(new Color(187, 238, 252));
		statsFrame.setResizable(false);
		//statsFrame.setVisible(true);
		
		statsPanel = new JPanel();
		statsPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
		statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
		statsPanel.setBackground(backgroundColor);
		statsFrame.add(statsPanel);
		
		// Initialize the text for all stats labels and display them on the stats frame
		statsTitle = new JLabel();
		statsPanel.add(statsTitle);
		statsTitle.setText("STATS");
		statsTitle.setFont(new Font("Helvetica", Font.BOLD, 70));
		statsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		numGamesWonLabel = new JLabel();
		numGamesWonLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
		numGamesWonLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		minNumQuestionsAskedToWinLabel = new JLabel();
		minNumQuestionsAskedToWinLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
		minNumQuestionsAskedToWinLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		maxNumQuestionsAskedToWinLabel = new JLabel();
		maxNumQuestionsAskedToWinLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
		maxNumQuestionsAskedToWinLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		statsPanel.add(Box.createRigidArea(new Dimension(0, 30)));
		statsPanel.add(numGamesWonLabel);
		statsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		statsPanel.add(minNumQuestionsAskedToWinLabel);
		statsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		statsPanel.add(maxNumQuestionsAskedToWinLabel);
		
		numGamesWonLabel.setText("Number of Games Won: " + numGamesWon);
		
		if (numGamesWon == 0) {
			maxNumQuestionsAskedToWinLabel.setText("Maximum number of questions asked to win: No Games Won Yet");
			minNumQuestionsAskedToWinLabel.setText("Minimum number of questions asked to win: No Games Won Yet");
		} else {
			maxNumQuestionsAskedToWinLabel.setText("Maximum number of questions asked to win: " + maxNumQuestionsAskedToWin);
			minNumQuestionsAskedToWinLabel.setText("Minimum number of questions asked to win: " + minNumQuestionsAskedToWin);
		}
		
	}
	
	/**
	 * This method will create the pop up for the win screen when there is a winner.
	 */
	public static void resultScreen(boolean playerWins) {
		// might change how this works
		if (playerWins) {
			
		}
	}
	
	
	
	/**
	 * This method will call the the methods from other classes while the game is running
	 * @param e the action event that was registered
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// If it is the AI's turn, there will be a pop up prompting the user to answer the AI's question
		// If it is the player's turn, then they will be able to choose and ask a question, or access the other buttons/textfield
		// The result screen will be displayed when either after the AI or the player makes a guess
		if (aiTurn) {
			// code here for the pop and when AI asks the question, and if it makes a guess
		} else {
			
		
			// If the start game button is pressed, close the start frame, and open the game and rule frames
			if ((e.getSource()).equals(startButton)) {
				startFrame.setVisible(false);
				gameBoardFrame.setVisible(true);
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
			
			if ((e.getSource()).equals(statsButton)) {
				statsFrame.setVisible(true);
			}
			
			
			// If the submit guess button is clicked, submit the text within the text field
			if ((e.getSource()).equals(submitGuessButton)) {
				
				String name = nameGuessField.getText();
				
				// Go through the array of characters to see if the name submitted is valid
				for (int i = 0; i < characters.size(); i++) {
					if (characters.get(i).getName().equalsIgnoreCase(name)) {
						
					}
				}
				
				
			}
			
			// If the right arrow is clicked, go to the next question. 
			// If the right arrow is clicked at the last question, loop back to the first question.
			if ((e.getSource()).equals(rightArrow)) {
								
				if (currentQuestionIndex == questionBank.size() - 1) {
					currentQuestionIndex = 0;
				} else {
			
					currentQuestionIndex++;
				}
				
				questionToAsk.setText(questionBank.get(currentQuestionIndex));
	
			}
			
			// If the left arrow is clicked, go to the previous question.
			// If the left arrow is clicked at the first question, loop back to the last question.
			if ((e.getSource()).equals(leftArrow)) {
				
				if (currentQuestionIndex == 0) {
					currentQuestionIndex = questionBank.size() - 1;
				} else {
					currentQuestionIndex--;
				}
				
				questionToAsk.setText(questionBank.get(currentQuestionIndex));
	
				
			}
			
			// Submit the question and cross out characters accordingly based on the results of the question asked.
			// The question that is asked will be removed from the question bank after
			if ((e.getSource()).equals(submitQuestionButton)) {
	
				String question = questionToAsk.getText();
	
	//				if (question.equalsIgnoreCase("Is Your Character Male?")) {
	//					//	String correctGender = character.getGender;
	//					
	//					
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						
	//						// Go through the character list, and if the character attribute does not match the Ai's character's attribute, put a cross on top of them.
	//						
	//						String gender = characters.get(i).getGender();
	//						
	//						if (!gender.equalsIgnoreCase(correctGender)) {
	//							// put a cross on top
	//						} 
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Does Your Character Have Facial Hair")) {
	//					//	boolean correctFacialHair = character.getFacialHair;
	//
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						
	//						boolean facialHair = characters.get(i).getHasFacialHair();
	//						
	//						if (facialHair != correctFacialHair) {
	//							//put in cross
	//						} 
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Is Your Character White?")) {
	//					// String correctSkinColor = character.getSkinColor
	//
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						String skinColor = characters.get(i).getSkinColor();
	//						
	//						if (!skinColor.equalsIgnoreCase(correctSkinColor)) {
	//							// put in cross
	//						}
	//						
	//					}  
	//					
	//				} else if (question.equalsIgnoreCase("Does Your Character Have A Moustache?")) {
	//					// boolean correctMoustache = character.getHasMoustache;
	//
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						
	//						boolean moustache = characters.get(i).getHasMustache();
	//						
	//						if (moustache == correctMoustache) {
	//							
	//						}
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Is Your Character Wearing Glasses?")) {
	//					// boolean correctGlasses = character.getHasGlasses;
	//
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						
	//						boolean glasses = characters.get(i).getHasGlasses();
	//						
	//						if (glasses = correctGlasses) {
	//							// cross out
	//						}
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Does Your Character's Name Start With A J")) {
	//					//	char correctFirstLetter = character.getName.charAt(0);
	//
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						
	//						char firstLetter = characters.get(i).getName().charAt(0);
	//						
	//						if (firstLetter != correctFirstLetter) {
	//							// cross out
	//						}
	//						
	//						
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Does Your Character Have Blue Eyes?")) {
	//					// String correctEyeColor = character.getEyeColor;
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						String eyeColor = characters.get(i).getEyeColor();
	//						
	//						if (!eyeColor.equalsIgnoreCase(correctEyeColor)) {
	//							// Cross out
	//						}
	//						
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Does Your Character Have A Hat?")) {
	//					
	//					// boolean correctHat = character.getHasHat;
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						boolean characterHat = characters.get(i).getHasHat();
	//						
	//						if (characterHat != correctHat) {
	//							// Cross out
	//						}
	//						
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Does Your Character Not Have A Hat?")) {
	//					
	//					// boolean correctHat = character.getHasHat;
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						boolean characterHat = characters.get(i).getHasHat();
	//						
	//						if (characterHat != correctHat) {
	//							// Cross out
	//						}
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Is Your Character Wearing Earings?")) {
	//					
	//					// boolean correctEarings = character.getHasEarings();
	//					for (int i = 0; i < characters.size(); i++) {
	//						boolean characterEaring = characters.get(i).getHasEarings();
	//						
	//						if (characterEaring == correctEaring) {
	//							// cross out
	//						}
	//
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Does Your Character Have White Hair?")) {
	//					
	//					// String correctHairColor = character.getHairColor();
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						String characterHairColor = characters.get(i).getHairColor();
	//						
	//						if (!characterHairColor.equalsIgnoreCase(correctHairColor)) {
	//							// Cross out
	//						}
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Does Your Character Have Ginger Hair?")) {
	//					
	//					// String correctHairColor = character.getHairColor();
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						String characterHairColor = characters.get(i).getHairColor();
	//						
	//						if (!characterHairColor.equalsIgnoreCase(correctHairColor)) {
	//							// Cross out
	//						}
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Can You See Your Character's Teeth?")) {
	//					
	//					// boolean correctIsShowingTeeth = character.getIsShowingTeeth();
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						boolean characterShowingTeeth = characters.get(i).getIsShowingTeeth();
	//						
	//						if (characterShowingTeeth == correctIsShowingTeeth) {
	//							// Cross out
	//						}
	//					}
	//					
	//				} else if (question.equalsIgnoreCase("Is Your Character Blonde?")) {
	//					
	//					// String correctHairColor = character.getHairColor();
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						String characterHairColor = characters.get(i).getHairColor();
	//						
	//						if (!characterHairColor.equalsIgnoreCase(correctHairColor)) {
	//							// Cross out
	//						}
	//					}
	//						
	//				} else if (question.equalsIgnoreCase("Does Your Character Have Brown Hair?")) {
	//					
	//					// String correctHairColor = character.getHairColor();
	//					for (int i = 0; i < characters.size(); i++) {
	//						
	//						String characterHairColor = characters.get(i).getHairColor();
	//						
	//						if (!characterHairColor.equalsIgnoreCase(correctHairColor)) {
	//							// Cross out
	//						}
	//					}
	//				}
				
				// Increment the number of questions asked by 1 and display it
				numOfQuestionsAsked += 1;
				numQuestionsAskedLabel.setText("# of Questions Asked: " + numOfQuestionsAsked);
				
				// Remove question from question bank
				// If there are no more questions left, then create a pop up to tell the user they have to enter a guess
				questionBank.remove(currentQuestionIndex);
				currentQuestionIndex = 0;
				
				if (questionBank.size() != 0) {
					questionToAsk.setText(questionBank.get(currentQuestionIndex));
				} else {
					JOptionPane.showMessageDialog(null, "There are no more questions left! Now input a guess!", "No More Guesses", JOptionPane.WARNING_MESSAGE);
					questionToAsk.setText("");
					leftArrow.setEnabled(false);
					rightArrow.setEnabled(false);
					submitQuestionButton.setEnabled(false);
					
				}
			}
			
			
			
		}
			
		
		
	}
	
}
