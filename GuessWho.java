package guessWho;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * This class will contain the game board and run the game Guess Who when the main method calls it.
 *
 */
public class GuessWho implements ActionListener {
	private JFrame startFrame;
	private JFrame rulesFrame;
	private JFrame gameBoardFrame;
	private JLabel gameTitle;
	private JPanel rulesPanel;
	private JPanel characterPanel;
	private JPanel questionPanel;
	private JPanel crossOutPanel;
	private JPanel characterGuessPanel;
	private JLabel guessCharacterLabel;
	private JLabel questionToAsk;
	private JLabel characterBoardLabel;
	private JButton startButton;
	private JButton rulesButton;
	private JButton submitGuessButton;
	private JButton rightArrow;
	private JButton leftArrow;
	private JButton submitQuestionButton;
	private JButton closeRulesButton;
	private JTextField nameGuessField;
	private JLayeredPane characterLayerPane;
	private ImageIcon gameLogo;
	private ImageIcon characterBoardImage;
	private ImageIcon redCrossImage;
	private ImageIcon rightArrowImage;
	private ImageIcon leftArrowImage;
	private GridBagConstraints gbc;
	private Color backgroundColor;
	private ArrayList<String> questionBank;
	private int currentQuestionIndex;
	//private GameChar aiCharacter;
	private boolean playerAnswer;
	private JLabel[][] crossOutLabelGrid;
	
	
	/**
	 * This is the constructor which will initiate the graphics of the game board
	 */
	public GuessWho() {	
		
		// Initialize variables and constant objects for the game
		gameLogo = new ImageIcon("guessWho_Icon.png");
		gbc = new GridBagConstraints(); // variable used to determine the panel position and spacing for the game frame
		backgroundColor = new Color(114, 163, 247);
		questionBank = new ArrayList<>();
		questionBank.add("Is Your Character Male?");
		questionBank.add("Does Your Character Have Facial Hair");
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
		// need more questions
		
		
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
		tempNewImg = tempImage.getScaledInstance(70, 40,  java.awt.Image.SCALE_SMOOTH); 
		rightArrowImage = new ImageIcon(tempNewImg);

		leftArrowImage = new ImageIcon("left_arrow.png");
		tempImage = leftArrowImage.getImage(); // transform it 
		tempNewImg = tempImage.getScaledInstance(70, 40,  java.awt.Image.SCALE_SMOOTH); 
		leftArrowImage = new ImageIcon(tempNewImg);
		
		
		
		// Initialize the starting frame before the game starts, including the start button and the title logo on the frame
		startFrame = new JFrame("Guess Who");
		startFrame.setSize(new Dimension(1200, 800));
		startFrame.setLayout(new BorderLayout());
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.getContentPane().setBackground(backgroundColor);
		startFrame.setResizable(false);
		//startFrame.setVisible(true);
		
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
		gameBoardFrame.setVisible(true);
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
		crossOutLabelGrid = new JLabel[4][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				crossOutLabelGrid[j][i] = new JLabel();
				crossOutLabelGrid[j][i].setBackground(Color.black);
				crossOutLabelGrid[j][i].setVisible(true);
				crossOutLabelGrid[j][i].setIcon(redCrossImage);
				crossOutPanel.add(crossOutLabelGrid[j][i]);
				
			}
		}
		characterLayerPane.add(crossOutPanel, JLayeredPane.DRAG_LAYER);
		//crossOutPanel.setVisible(false);
		
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
		
		// Initialize and add the arrows and question field for the questions panel
		leftArrow = new JButton();
		questionPanel.add(leftArrow);
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
		questionToAsk.setPreferredSize(new Dimension(550, 45));
		questionToAsk.setFont(new Font("Helvetica", Font.BOLD, 23));
		questionToAsk.setVisible(true);
		
		rightArrow = new JButton();
		questionPanel.add(rightArrow);
		rightArrow.setIcon(rightArrowImage);
		rightArrow.setSize(60, 45);
		rightArrow.setFocusable(false);
		rightArrow.setBackground(backgroundColor);
		rightArrow.setBorderPainted(false);
		rightArrow.setVisible(true);
		
		// add submit guess button
		
		// Initialize the panel where the player can guess the AI's character during their turn
		characterGuessPanel = new JPanel();
		characterGuessPanel.setLayout(new BoxLayout(characterGuessPanel, BoxLayout.Y_AXIS));
		characterGuessPanel.setPreferredSize(new Dimension(200, 620));
		//characterGuessPanel.setVisible(false);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5,5,5,5);
		gameBoardFrame.add(characterGuessPanel, gbc);
		
		// Initialize and add the label and text field for the player to type in their guess for the AI's character
		guessCharacterLabel = new JLabel("Guess:");
		characterGuessPanel.add(guessCharacterLabel);
		guessCharacterLabel.setSize(10, 10);
		guessCharacterLabel.setBackground(Color.black);
		
		// add text field for guess
		// add some mystery character visual on the panel
		
		
		rulesPanel = new JPanel();
		rulesPanel.setLayout(new BoxLayout(rulesPanel, BoxLayout.Y_AXIS)); // change later
		rulesPanel.setPreferredSize(new Dimension(200, 100));
		rulesPanel.setBackground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		gameBoardFrame.add(rulesPanel, gbc);

		// Initialize and add the button where the player can access the rules
		rulesButton = new JButton();
		
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
