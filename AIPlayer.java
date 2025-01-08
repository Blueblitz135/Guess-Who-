package guessWho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AIPlayer {

	private Character character;
	private ArrayList<Boolean> questionAnswers = new ArrayList<Boolean>();
	private ArrayList<Character> possibleCharacters = new ArrayList<Character>();

	private String[] attributes = { "whiteSkin", "blackSkin", "whiteHair", "brownHair", "blondeHair", "blackHair",
			"gingerHair", "maleGender", "femaleGender", "brownEye", "blueEye", "trueGlasses", "falseGlasses", "trueHat",
			"falseHat", "trueFaceHair", "falseFaceHair", "trueEaring", "falseEaring", "trueMustache", "falseMustache",
			"trueTeethShowing", "falseTeethShowing" }; // All the attributes of the characters

	private int[] numberOfAttributes = new int[attributes.length]; // Number of people that have the attributes, indexes
																	// correspond to those of the attributes

	public AIPlayer() {

	}

	/**
	 * Chooses a character randomly from the 24 available characters 
	 * @param characters
	 */
	public void chooseCharacter(Character[] characters) {
		Random rand = new Random();
		setCharacter(characters[rand.nextInt(characters.length)]);
	}
	
	/**
	 * 
	 * @param characters
	 */
	public void playTurn(Character[] characters) {
		for (int i = 0; i < characters.length; i++) {
			numberOfAttributes[getIndex(characters[i].getSkinColor() + "Skin")]++;
			numberOfAttributes[getIndex(characters[i].getHairColor() + "Hair")]++;
			numberOfAttributes[getIndex(characters[i].getGender() + "Gender")]++;
			numberOfAttributes[getIndex(characters[i].getEyeColor() + "Eye")]++;
			numberOfAttributes[getIndex(characters[i].getHasGlasses() + "Glasses")]++;
			numberOfAttributes[getIndex(characters[i].getHasHat() + "Hat")]++;
			numberOfAttributes[getIndex(characters[i].getHasFacialHair() + "FaceHair")]++;
			numberOfAttributes[getIndex(characters[i].getHasEarings() + "Earing")]++;
			numberOfAttributes[getIndex(characters[i].getHasMustache() + "Mustache")]++;
			numberOfAttributes[getIndex(characters[i].getIsShowingTeeth() + "TeethShowing")]++;
		}

	}

	public int getIndex(String key) {
		for (int i = 0; i < attributes.length; i++) {
			if (attributes[i] == key) {
				return i;
			}
		}
		return -1;
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
