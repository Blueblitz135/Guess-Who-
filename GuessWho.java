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

public class GuessWho implements ActionListener {
	private JFrame startFrame;
	private JFrame rulesFrame;
	private JFrame gameBoardFrame;
	private JFrame statsFrame;
	private JLabel gameTitle;
	private JLabel smallGameTitle;
	private JPanel GameCharPanel;
	private JPanel questionPanel;
	private JPanel crossOutPanel;
	private JPanel sidePanel;
	private JPanel statsPanel;
	private JPanel rulesPanel;
	private JLabel guessGameCharLabel;
	private JLabel questionToAsk;
	private JLabel GameCharBoardLabel;
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
	private JLayeredPane GameCharLayerPane;
	private ImageIcon gameLogo;
	private ImageIcon GameCharBoardImage;
	private ImageIcon redCrossImage;
	private ImageIcon rightArrowImage;
	private ImageIcon leftArrowImage;
	private ImageIcon checkMarkImage;
	private GridBagConstraints gbc;
	private Color backgroundColor;

	private int numOfQuestionsAsked;
	private ArrayList<String> questionBank;
	private int currentQuestionIndex;
	// private GameChar aiGameChar;
	private boolean playerAnswer;
	private ArrayList<GameChar> gameChars = new ArrayList<GameChar>();
	private ArrayList<GameChar> notCrossGameChars = new ArrayList<GameChar>();
	private JLabel[] crossOutLabelGrid;
	private boolean aiTurn = true;
	private int numGamesWon;
	private int maxNumQuestionsAskedToWin;
	private int minNumQuestionsAskedToWin;
	private int choice = -1; 
	// Kian Fixing Everytthing Variables
	private AIPlayer ai;
	private GameChar aiGameChar;

	/**
	 * This is the constructor which will initiate the graphics of the game board
	 * 
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
		File statsFile = new File("stats.txt");
		Scanner statsScan = new Scanner(statsFile);

		// These should be not on file
		numGamesWon = statsScan.nextInt();
		maxNumQuestionsAskedToWin = statsScan.nextInt();
		minNumQuestionsAskedToWin = statsScan.nextInt();

		// Initialize rules variables using file i/o
		File rulesFile = new File("GuessWhoRules.txt");
		Scanner ruleScan = new Scanner(rulesFile);

		String[] rules = new String[12];
		for (int i = 0; i < 12; i++) {
			rules[i] = ruleScan.nextLine();
		}

//		System.out.println(numGamesWon);
//		System.out.println(maxNumQuestionsAskedToWin);
//		System.out.println(minNumQuestionsAskedToWin);

		// Add questions to the question bank
		questionBank = new ArrayList<>();
		for (int i = 0; i < 23; i++) {
			questionBank.add(questions(i));
		}

		// Initialize GameChars
		gameChars.add(new GameChar("blackSkin", "brownHair", "maleGender", "brownEye", "CONNOR", false, false, true,
				false, true, false));
		gameChars.add(new GameChar("blackSkin", "blackHair", "maleGender", "brownEye", "ANDY", false, false, true,
				false, false, true));
		gameChars.add(new GameChar("blackSkin", "blackHair", "femaleGender", "brownEye", "SARAH", true, false, false,
				true, false, false));
		gameChars.add(new GameChar("whiteSkin", "blondeHair", "maleGender", "brownEye", "WILLIAM", false, false, true,
				false, false, false));
		gameChars.add(new GameChar("whiteSkin", "gingerHair", "maleGender", "brownEye", "DAVID", false, false, true,
				false, true, false));
		gameChars.add(new GameChar("whiteSkin", "blondeHair", "maleGender", "blueEye", "KYLE", false, false, false,
				false, false, true));
		gameChars.add(new GameChar("whiteSkin", "whiteHair", "maleGender", "brownEye", "JON", false, false, true, false,
				false, false));
		gameChars.add(new GameChar("whiteSkin", "whiteHair", "maleGender", "brownEye", "JOSHUA", false, false, true,
				false, true, false));
		gameChars.add(new GameChar("whiteSkin", "gingerHair", "maleGender", "brownEye", "ZACHARY", false, false, false,
				false, false, false));
		gameChars.add(new GameChar("whiteSkin", "brownHair", "maleGender", "blueEye", "NICK", true, false, false, false,
				false, false));
		gameChars.add(new GameChar("whiteSkin", "whiteHair", "femaleGender", "blueEye", "EMILY", true, false, false,
				true, false, false));
		gameChars.add(new GameChar("blackSkin", "brownHair", "maleGender", "brownEye", "DANIEL", false, true, false,
				false, false, false));
		gameChars.add(new GameChar("whiteSkin", "brownHair", "maleGender", "brownEye", "JUSTIN", false, false, true,
				false, true, false));
		gameChars.add(new GameChar("blackSkin", "brownHair", "maleGender", "brownEye", "JAMES", false, false, true,
				false, false, false));
		gameChars.add(new GameChar("whiteSkin", "gingerHair", "femaleGender", "brownEye", "ASHLEY", false, true, false,
				true, false, true));
		gameChars.add(new GameChar("whiteSkin", "blondeHair", "femaleGender", "blueEye", "MEGAN", false, false, false,
				true, false, false));
		gameChars.add(new GameChar("whiteSkin", "blackHair", "maleGender", "brownEye", "TYLER", false, false, false,
				false, false, true));
		gameChars.add(new GameChar("whiteSkin", "blondeHair", "maleGender", "brownEye", "BRANDON", false, true, false,
				false, false, true));
		gameChars.add(new GameChar("whiteSkin", "whiteHair", "maleGender", "brownEye", "MATT", false, false, false,
				false, false, false));
		gameChars.add(new GameChar("whiteSkin", "gingerHair", "maleGender", "blueEye", "JOSEPH", true, false, false,
				false, false, false));
		gameChars.add(new GameChar("whiteSkin", "blondeHair", "maleGender", "brownEye", "JAKE", false, false, true,
				false, true, true));
		gameChars.add(new GameChar("whiteSkin", "whiteHair", "maleGender", "brownEye", "ALEX", true, false, false,
				false, false, false));
		gameChars.add(new GameChar("whiteSkin", "brownHair", "femaleGender", "brownEye", "RACHEL", false, true, false,
				false, false, false));
		gameChars.add(new GameChar("whiteSkin", "blackHair", "maleGender", "brownEye", "CHRIS", false, true, false,
				false, false, false));

		for (int i = 0; i < gameChars.size(); i++) {
			notCrossGameChars.add(gameChars.get(i));
		}
		ai = new AIPlayer(gameChars);
		aiGameChar = AIPlayer.chooseGameChar(gameChars);

		// ---------------------------------Graphics
		// Initialization-------------------------------

		// Initialize and set sizing and set sizing for the GameChar board image
		GameCharBoardImage = new ImageIcon("character_board.jpg");
		Image tempImage = GameCharBoardImage.getImage(); // transform it
		Image tempNewImg = tempImage.getScaledInstance(850, 595, java.awt.Image.SCALE_SMOOTH);
		GameCharBoardImage = new ImageIcon(tempNewImg);

		// Initialize and set sizing and set sizing for red cross image
		redCrossImage = new ImageIcon("red_cross.png");
		tempImage = redCrossImage.getImage(); // transform it
		tempNewImg = tempImage.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		redCrossImage = new ImageIcon(tempNewImg);

		// Initialize and set sizing and set sizing for left and right arrows
		rightArrowImage = new ImageIcon("right_arrow.png");
		tempImage = rightArrowImage.getImage(); // transform it
		tempNewImg = tempImage.getScaledInstance(65, 50, java.awt.Image.SCALE_SMOOTH);
		rightArrowImage = new ImageIcon(tempNewImg);

		leftArrowImage = new ImageIcon("left_arrow.png");
		tempImage = leftArrowImage.getImage(); // transform it
		tempNewImg = tempImage.getScaledInstance(65, 50, java.awt.Image.SCALE_SMOOTH);
		leftArrowImage = new ImageIcon(tempNewImg);

		// Initialize and set sizing for the check mark image, which will be used for
		// the submit question button
		checkMarkImage = new ImageIcon("check_mark.png");
		tempImage = checkMarkImage.getImage(); // transform it
		tempNewImg = tempImage.getScaledInstance(65, 50, java.awt.Image.SCALE_SMOOTH);
		checkMarkImage = new ImageIcon(tempNewImg);

		// Initialize the starting frame before the game starts, including the start
		// button and the title logo on the frame
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
		rulesFrame.setSize(new Dimension(1300, 750));
		rulesFrame.setLayout(new BorderLayout());
		rulesFrame.getContentPane().setBackground(new Color(187, 238, 252));
		rulesFrame.setResizable(false);

		rulesPanel = new JPanel();
		rulesPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
		rulesPanel.setLayout(new BoxLayout(rulesPanel, BoxLayout.Y_AXIS));
		rulesPanel.setBackground(backgroundColor);
		rulesFrame.add(rulesPanel);

		rulesPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		JLabel rulesTitle = new JLabel();
		rulesTitle.setText(rules[0]);
		rulesTitle.setFont(new Font("Helvetica", Font.BOLD, 50));
		rulesTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		rulesPanel.add(rulesTitle);

		for (int i = 1; i < 12; i++) {
			rulesPanel.add(Box.createRigidArea(new Dimension(0, 30)));
			JLabel rulesLabel = new JLabel();
			rulesLabel.setText(rules[i]);
			rulesLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
			rulesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			rulesPanel.add(rulesLabel);
		}
		// rulesFrame.setVisible(true);

		// Initialize frame for game board
		gameBoardFrame = new JFrame();
		gameBoardFrame.setResizable(false);
		gameBoardFrame.setSize(new Dimension(1200, 800));
		// gameBoardFrame.setVisible(true);
		gameBoardFrame.setLayout(new GridBagLayout());
		gameBoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameBoardFrame.getContentPane().setBackground(backgroundColor);

		// Initialize panel with the GameChars which can be crossed out on the game
		// board
		// It will use a layered pane to overlap the cross grid with the GameChar board
		// image
		GameCharPanel = new JPanel();
		GameCharPanel.setLayout(null);
		GameCharPanel.setPreferredSize(new Dimension(850, 620));
		GameCharPanel.setBackground(backgroundColor);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		GameCharPanel.setVisible(true);
		gameBoardFrame.add(GameCharPanel, gbc);

		GameCharLayerPane = new JLayeredPane();
		GameCharLayerPane.setBounds(0, 0, 850, 620);
		GameCharPanel.add(GameCharLayerPane);

		// Initialize the cross out labels on the cross out panel
		// The cross out panel will be in the GameChar panel
		crossOutPanel = new JPanel();
		crossOutPanel.setBounds(0, 15, 850, 550);
		crossOutPanel.setBorder(new EmptyBorder(10, 22, 0, 0));
		crossOutPanel.setLayout(new GridLayout(4, 6, 24, 80));
		crossOutPanel.setOpaque(false);
		crossOutLabelGrid = new JLabel[24];

		for (int i = 0; i < 24; i++) {
			crossOutLabelGrid[i] = new JLabel();
			crossOutLabelGrid[i].setBackground(Color.black);
			crossOutLabelGrid[i].setVisible(false);
			crossOutLabelGrid[i].setIcon(redCrossImage);
			crossOutPanel.add(crossOutLabelGrid[i]);
		}
		GameCharLayerPane.add(crossOutPanel, JLayeredPane.DRAG_LAYER);

		// Initialize the GameChar board image which will be on a JLabel
		GameCharBoardLabel = new JLabel();
		GameCharBoardLabel.setIcon(GameCharBoardImage);
		GameCharBoardLabel.setBackground(Color.white);
		GameCharBoardLabel.setBounds(0, 0, 850, 630);
		GameCharLayerPane.add(GameCharBoardLabel, JLayeredPane.DEFAULT_LAYER);

		// Initialize the panel where the player can select and ask questions
		questionPanel = new JPanel();
		questionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 15)); // change later
		questionPanel.setPreferredSize(new Dimension(850, 100));
		questionPanel.setBackground(Color.white);
		questionPanel.setOpaque(false);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5, 5, 5, 5);
		gameBoardFrame.add(questionPanel, gbc);

		// Initialize and add the arrows question field, and submit button for the
		// questions panel
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

		// Initialize the sidepanel where the player can guess the AI's GameChar during
		// their turn
		// They can also see the number of questions they have currently asked,
		// view rules, and view previous game stats
		sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		// sidePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		sidePanel.setPreferredSize(new Dimension(220, 700));
		sidePanel.setBorder(new EmptyBorder(30, 15, 0, 0));
		sidePanel.setOpaque(false);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.insets = new Insets(5, 10, 5, 5);
		gameBoardFrame.add(sidePanel, gbc);

		// Add Guess Who logo at the top of the panel for design
		// The logo image needs to be resized smaller to fit the panel
		tempImage = gameLogo.getImage(); // transform it
		tempNewImg = tempImage.getScaledInstance(180, 100, java.awt.Image.SCALE_SMOOTH);
		gameLogo = new ImageIcon(tempNewImg);

		smallGameTitle = new JLabel();
		sidePanel.add(smallGameTitle);
		smallGameTitle.setIcon(gameLogo);
		smallGameTitle.setVisible(true);

		// Initialize and add the label and text field for the player to type in their
		// guess for the AI's GameChar
		guessGameCharLabel = new JLabel("Guess:");
		sidePanel.add(guessGameCharLabel);
		guessGameCharLabel.setBorder(new EmptyBorder(70, 1, 10, 0));
		guessGameCharLabel.setHorizontalAlignment(SwingConstants.CENTER);
		guessGameCharLabel.setVerticalAlignment(SwingConstants.CENTER);
		guessGameCharLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		guessGameCharLabel.setForeground(Color.black);
		guessGameCharLabel.setPreferredSize(new Dimension(50, 50));
		guessGameCharLabel.setFont(new Font("Helvetica", Font.BOLD, 27));
		guessGameCharLabel.setVisible(true);

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

		// Initialize and label for player to see how many questions they have currently
		// asked
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

		// Initialize frame and panel to display stats
		statsFrame = new JFrame("Stats");
		statsFrame.setSize(new Dimension(700, 400));
		// statsFrame.setLayout(new BorderLayout());
		statsFrame.getContentPane().setBackground(new Color(187, 238, 252));
		statsFrame.setResizable(false);
		// statsFrame.setVisible(true);

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
			maxNumQuestionsAskedToWinLabel
					.setText("Maximum number of questions asked to win: " + maxNumQuestionsAskedToWin);
			minNumQuestionsAskedToWinLabel
					.setText("Minimum number of questions asked to win: " + minNumQuestionsAskedToWin);
		}

	}

	/**
	 * Question bank for all questions
	 * 
	 * @param questionNumber index for each question
	 * @return The question at a String
	 */
	public static String questions(int questionNumber) {
		switch (questionNumber) {

		case 0:
			return "Does Your Character Have White Skin?";
		case 1:
			return "Does Your Character Have Black Skin?";
		case 2:
			return "Does Your Character Have White Hair?";
		case 3:
			return "Does Your Character Have Brown Hair?";
		case 4:
			return "Does Your Character Have Blonde Hair?";
		case 5:
			return "Does Your Character Have Ginger Hair?";
		case 6:
			return "Does Your Character Have Black Hair?";
		case 7:
			return "Is Your Character Male?";
		case 8:
			return "Is Your Character Female?";
		case 9:
			return "Does Your Character Have Brown Eyes?";
		case 10:
			return "Does Your Character Have Blue Eyes?";
		case 11:
			return "Does Your Character Have Glasses?";
		case 12:
			return "Does Your Character Not Have Glasses?";
		case 13:
			return "Is Your Character Wearing A Hat?";
		case 14:
			return "Is Your Character Not Wearing A Hat?";
		case 15:
			return "Does Your Character Have Facial Hair?";
		case 16:
			return "Does Your Character Not Have Facial Hair?";
		case 17:
			return "Does Your Character Have Earings?";
		case 18:
			return "Does Your Character Not Have Earings?";
		case 19:
			return "Does Your Character Have A Mustache?";
		case 20:
			return "Does Your Character Not Have A Mustache?";
		case 21:
			return "Is Your Character Showing Teeth?";
		case 22:
			return "Is Your Character Not Showing Teeth?";
		}
		return "Error";
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
	 * This method will call the the methods from other classes while the game is
	 * running
	 * 
	 * @param e the action event that was registered
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// If it is the AI's turn, there will be a pop up prompting the user to answer
		// the AI's question
		// If it is the player's turn, then they will be able to choose and ask a
		// question, or access the other buttons/textfield
		// The result screen will be displayed when either after the AI or the player
		// makes a guess

		// If the start game button is pressed, close the start frame, and open the game
		// and rule frames
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

			// Go through the array of GameChars to see if the name submitted is valid
			for (int i = 0; i < gameChars.size(); i++) {
				if (gameChars.get(i).getName().equalsIgnoreCase(name)) {

				}
			}

		}

		// If the right arrow is clicked, go to the next question.
		// If the right arrow is clicked at the last question, loop back to the first
		// question.
		if ((e.getSource()).equals(rightArrow)) {

			if (currentQuestionIndex == questionBank.size() - 1) {
				currentQuestionIndex = 0;
			} else {

				currentQuestionIndex++;
			}

			questionToAsk.setText(questionBank.get(currentQuestionIndex));

		}

		// If the left arrow is clicked, go to the previous question.
		// If the left arrow is clicked at the first question, loop back to the last
		// question.
		if ((e.getSource()).equals(leftArrow)) {

			if (currentQuestionIndex == 0) {
				currentQuestionIndex = questionBank.size() - 1;
			} else {
				currentQuestionIndex--;
			}

			questionToAsk.setText(questionBank.get(currentQuestionIndex));
		}

		// Submit the question and cross out GameChars accordingly based on the results
		// of the question asked.
		// The question that is asked will be removed from the question bank after

		if ((e.getSource()).equals(submitQuestionButton)) {
			String question = questionToAsk.getText();
			if (question.equals(questions(0))) {
				if (aiGameChar.getSkinColor().equals("whiteSkin")) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getSkinColor().equals("whiteSkin"))) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getSkinColor().equals("whiteSkin")) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(1))) {
				if (aiGameChar.getSkinColor().equals("blackSkin")) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getSkinColor().equals("blackSkin"))) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getSkinColor().equals("blackSkin")) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(2))) {
				if (aiGameChar.getHairColor().equals("whiteHair")) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHairColor().equals("whiteHair"))) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHairColor().equals("whiteHair")) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(3))) {
				if (aiGameChar.getHairColor().equals("brownHair")) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHairColor().equals("brownHair"))) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHairColor().equals("brownHair")) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(4))) {
				if (aiGameChar.getHairColor().equals("blondeHair")) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHairColor().equals("blondeHair"))) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHairColor().equals("blondeHair")) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(5))) {
				if (aiGameChar.getHairColor().equals("gingerHair")) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHairColor().equals("gingerHair"))) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHairColor().equals("gingerHair")) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(6))) {
				if (aiGameChar.getHairColor().equals("blackHair")) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHairColor().equals("blackHair"))) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHairColor().equals("blackHair")) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(7))) {
				if (aiGameChar.getGender().equals("maleGender")) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getGender().equals("maleGender"))) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getGender().equals("maleGender")) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(8))) {
				if (aiGameChar.getGender().equals("femaleGender")) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getGender().equals("femaleGender"))) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getGender().equals("femaleGender")) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(9))) {
				if (aiGameChar.getEyeColor().equals("brownEye")) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getEyeColor().equals("brownEye"))) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getEyeColor().equals("brownEye")) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(10))) {
				if (aiGameChar.getEyeColor().equals("blueEye")) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getEyeColor().equals("blueEye"))) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getEyeColor().equals("blueEye")) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(11))) {
				if (aiGameChar.getHasGlasses() == true) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHasGlasses() == true)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHasGlasses() == true) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(12))) {
				if (aiGameChar.getHasGlasses() == false) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHasGlasses() == false)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHasGlasses() == false) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(13))) {
				if (aiGameChar.getHasHat() == true) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHasHat() == true)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHasHat() == true) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(14))) {
				if (aiGameChar.getHasHat() == false) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHasHat() == false)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHasHat() == false) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(15))) {
				if (aiGameChar.getHasFacialHair() == true) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHasFacialHair() == true)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHasFacialHair() == true) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(16))) {
				if (aiGameChar.getHasFacialHair() == false) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHasFacialHair() == false)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHasFacialHair() == false) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(17))) {
				if (aiGameChar.getHasEarings() == true) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHasEarings() == true)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHasEarings() == true) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(18))) {
				if (aiGameChar.getHasEarings() == false) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHasEarings() == false)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHasEarings() == false) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(19))) {
				if (aiGameChar.getHasMustache() == true) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHasMustache() == true)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHasMustache() == true) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(20))) {
				if (aiGameChar.getHasMustache() == false) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getHasMustache() == false)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getHasMustache() == false) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(21))) {
				if (aiGameChar.getIsShowingTeeth() == true) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getIsShowingTeeth() == true)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getIsShowingTeeth() == true) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(questions(22))) {
				if (aiGameChar.getIsShowingTeeth() == false) {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (!(notCrossGameChars.get(i).getIsShowingTeeth() == false)) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < notCrossGameChars.size(); i++) {
						if (notCrossGameChars.get(i).getIsShowingTeeth() == false) {
							notCrossGameChars.remove(notCrossGameChars.get(i));
							i--;
						}
					}
				}
			}
			for (int i = 0; i < gameChars.size(); i++) {
				if (!notCrossGameChars.contains(gameChars.get(i))) {
					crossOutLabelGrid[i].setVisible(true);
				}
			} // Increment the number of questions asked by 1 and display it
			numOfQuestionsAsked += 1;
			numQuestionsAskedLabel.setText("# of Questions Asked: " + numOfQuestionsAsked);

			// Remove question from question bank
			// If there are no more questions left, then create a pop up to tell the user
			// they have to enter a guess
			questionBank.remove(currentQuestionIndex);
			currentQuestionIndex = 0;

			if (questionBank.size() != 0) {
				questionToAsk.setText(questionBank.get(currentQuestionIndex));
			} else {
				JOptionPane.showMessageDialog(null, "There are no more questions left! Now input a guess!",
						"No More Guesses", JOptionPane.WARNING_MESSAGE);
				questionToAsk.setText("");
				leftArrow.setEnabled(false);
				rightArrow.setEnabled(false);
				submitQuestionButton.setEnabled(false);

			}

			GameChar aiGuess = ai.playTurn(playerAnswer);
			if (aiGuess == null) {
				do {
					choice = JOptionPane.showConfirmDialog(null, ai.getAiQuestion(), "Answer Ai's Question",
							JOptionPane.YES_NO_OPTION);
				} while (choice == -1);
			}
			if (choice == 0) {
				playerAnswer = true;
			} else {
				playerAnswer = false;
			}
			if (!(aiGuess == null)) {
				choice = JOptionPane.showConfirmDialog(null, "Is Your Character: " + aiGuess.getName(), "AI Is Guessing",
						JOptionPane.YES_NO_OPTION);
			}
		}

	}

}
