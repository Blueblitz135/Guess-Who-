package guessWho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AIPlayer {
	private Character character;
	private ArrayList<Boolean> questionAnswers = new ArrayList<Boolean>();
	private int aiTurn = 0;

	public AIPlayer() {

	}

	public void chooseCharacter(Character[] characters) {
		Random rand = new Random();
		setCharacter(characters[rand.nextInt(characters.length)]);
	}

	/**
	 * 
	 * 
	 * @return return the next question number
	 */
	public int playTurn() {
		
	}

	/**
	 * This method should be called in the panel which holds the question which the
	 * ai is asking
	 * 
	 * @param questionNumber
	 * @return
	 */
	public String askQuestion(int questionNumber) {
		switch (questionNumber) {

		case 0:
			return "Is Your Character Male?";
		case 1:
			return "Does Your Character Have Facial Hair";
		case 2:
			return "Is Your Character White?";
		case 3:
			return "Does Your Character Have A Moustache?";
		case 4:
			return "Is Your Character Wearing Glasses?";
		case 5:
			return "Does Your Characters Name Start With A J";
		case 6:
			return "Does Your Character Have Blue Eyes?";
		case 7:
			return "Does Your Character Have A Hat?";
		case 8:
			return "Is Your Character Wearing Earings?";
		case 9:
			return "Does Your Character Have White Hair?";
		case 10:
			return "Does Your Character Have Orange Hair?";
		case 11:
			return "Can You See Your Characters Teeth?";
		case 12:
			return "Is Your Character Blonde?";
		case 13:
			return "Does Your Character Have Brown Hair?";
		}
		return "Error";
	}

	public void addQuestionAnswers(boolean answer) {
		getQuestionAnswers().add(answer);
	}

	public ArrayList<Boolean> getQuestionAnswers() {
		return questionAnswers;
	}

	public Character getCharacter() {
		return this.character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public int getAiTurn() {
		return aiTurn;
	}

	public void setAiTurn(int aiTurn) {
		this.aiTurn = aiTurn;
	}

}
