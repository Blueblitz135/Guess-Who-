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

	public AIPlayer(ArrayList<Character> characters) {
		possibleCharacters = characters;
		
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
	public void playTurn(ArrayList<Character> characters) {
		for (int i = 0; i < characters.size(); i++) {
			numberOfAttributes[getIndex(characters.get(i).getSkinColor() + "Skin")]++;
			numberOfAttributes[getIndex(characters.get(i).getHairColor() + "Hair")]++;
			numberOfAttributes[getIndex(characters.get(i).getGender() + "Gender")]++;
			numberOfAttributes[getIndex(characters.get(i).getEyeColor() + "Eye")]++;
			numberOfAttributes[getIndex(characters.get(i).getHasGlasses() + "Glasses")]++;
			numberOfAttributes[getIndex(characters.get(i).getHasHat() + "Hat")]++;
			numberOfAttributes[getIndex(characters.get(i).getHasFacialHair() + "FaceHair")]++;
			numberOfAttributes[getIndex(characters.get(i).getHasEarings() + "Earing")]++;
			numberOfAttributes[getIndex(characters.get(i).getHasMustache() + "Mustache")]++;
			numberOfAttributes[getIndex(characters.get(i).getIsShowingTeeth() + "TeethShowing")]++;
		}
		
		int highest = 0;
		int key = -1;
		for(int i = 0; i < numberOfAttributes.length; i++) {
			if (numberOfAttributes[i] > highest) {
				key = i;
				highest = numberOfAttributes[i];
			}
		}
		
		questions(key);
		
		

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

	public String questions(int questionNumber) {
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
			return "Does Your Character Have Blonde Skin?";
		case 5:
			return "Does Your Character Have Ginger Skin?";
		case 6:
			return "Is Your Character Male?";
		case 7:
			return "Is Your Character Female?";
		case 8:
			return "Does Your Character Have Brown Eyes?";
		case 9:
			return "Does Your Character Have Blue Eyes?";
		case 10:
			return "Does Your Character Have Glasses";
		case 11:
			return "Does Your Character Not Have Glasses?";
		case 12:
			return "Is Your Character Wearing A Hat?";
		case 13:
			return "Is Your Character Not Wearing A Hat?";
		case 14:
			return "Does Your Character Have Facial Hair";
		case 15:
			return "Does Your Character Not Have Facial Hair";
		case 16:
			return "Does Your Character Have Earings";
		case 17:
			return "Does Your Character Not Have Earings";
		case 18:
			return "Does Your Character Have A Mustache";
		case 19:
			return "Does Your Character Not Have A Mustache";
		case 20:
			return "Is Your Character Showing Teeth?";
		case 21:
			return "Is Your Character Not Showing Teeth?";
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
