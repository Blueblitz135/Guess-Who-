package guessWho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AIPlayer {

	private GameChar GameChar;
	private ArrayList<GameChar> possibleGameChars = new ArrayList<GameChar>();
	private int questionNumber = -1;
	private String[] attributes = { "whiteSkin", "blackSkin", "whiteHair", "brownHair", "blondeHair", "blackHair",
			"gingerHair", "maleGender", "femaleGender", "brownEye", "blueEye", "trueGlasses", "falseGlasses", "trueHat",
			"falseHat", "trueFaceHair", "falseFaceHair", "trueEaring", "falseEaring", "trueMustache", "falseMustache",
			"trueTeethShowing", "falseTeethShowing" }; // All the attributes of the GameChars

	private int[] numberOfAttributes = new int[attributes.length]; // Number of GameChar that have the attributes,
																	// indexes
																	// correspond to those of the attributes

	public AIPlayer(ArrayList<GameChar> GameChars) {
		possibleGameChars = GameChars;
	}

	/**
	 * Chooses a GameChar randomly from the 24 available GameChars
	 * 
	 * @param GameChars
	 */
	public void chooseGameChar(ArrayList<GameChar> GameChars) {
		Random rand = new Random();
		setGameChar(GameChars.get(rand.nextInt(24)));
	}

	public void pop() {

	}

	/**
	 * 
	 * @param GameChars
	 */
	public GameChar playTurn(boolean answer) {
		if (possibleGameChars.size() == 1) {
			// Must make a guess
			return possibleGameChars.get(0);
		}

		if (questionNumber != -1) {
			String question = questions(questionNumber);
			if (question.indexOf("Not") > -1) {
				answer = !answer;
			}
			for (GameChar i : possibleGameChars) {
				if (question.indexOf("Hair") > -1) {
					if (question.indexOf("White") > -1) {
						if (i.getHairColor().equals("white") && answer == true) {
							continue;
						} else {
							possibleGameChars.remove(i);
						}
					} else if (question.indexOf("Brown") > -1) {
						if (i.getHairColor().equals("brown") && answer == true) {
							continue;
						} else {
							possibleGameChars.remove(i);
						}
					} else if (question.indexOf("Blonde") > -1) {
						if (i.getHairColor().equals("blonde") && answer == true) {
							continue;
						} else {
							possibleGameChars.remove(i);
						}
					} else if (question.indexOf("Ginger") > -1) {
						if (i.getHairColor().equals("ginger") && answer == true) {
							continue;
						} else {
							possibleGameChars.remove(i);
						}
					}
				} else if (question.indexOf("Eye") > -1) {
					if (question.indexOf("Blue") > -1) {
						if (i.getEyeColor().equals("blue") && answer == true) {
							continue;
						} else {
							possibleGameChars.remove(i);
						}
					} else if (question.indexOf("Brown") > -1) {
						if (i.getEyeColor().equals("brown") && answer == true) {
							continue;
						} else {
							possibleGameChars.remove(i);
						}
					}
				} else if (question.indexOf("Skin") > -1) {
					if (question.indexOf("white") > -1) {
						if (i.getSkinColor().equals("brown") && answer == true) {
							
						}
					}
				}
			}
		}

		for (

				int i = 0; i < possibleGameChars.size(); i++) {
			numberOfAttributes[getIndex(possibleGameChars.get(i).getSkinColor())]++;
			numberOfAttributes[getIndex(possibleGameChars.get(i).getHairColor())]++;
			numberOfAttributes[getIndex(possibleGameChars.get(i).getGender() + "Gender")]++;
			numberOfAttributes[getIndex(possibleGameChars.get(i).getEyeColor() + "Eye")]++;
			numberOfAttributes[getIndex(possibleGameChars.get(i).getHasGlasses() + "Glasses")]++;
			numberOfAttributes[getIndex(possibleGameChars.get(i).getHasHat() + "Hat")]++;
			numberOfAttributes[getIndex(possibleGameChars.get(i).getHasFacialHair() + "FaceHair")]++;
			numberOfAttributes[getIndex(possibleGameChars.get(i).getHasEarings() + "Earing")]++;
			numberOfAttributes[getIndex(possibleGameChars.get(i).getHasMustache() + "Mustache")]++;
			numberOfAttributes[getIndex(possibleGameChars.get(i).getIsShowingTeeth() + "TeethShowing")]++;
		}

		int highest = -1;
		for (int i = 0; i < numberOfAttributes.length; i++) {
			if (numberOfAttributes[i] > highest) {
				questionNumber = i;
				highest = numberOfAttributes[i];
			}
		}

		questions(questionNumber);
		return null;
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
			return "Does Your Character Have Blonde Hair?";
		case 5:
			return "Does Your Character Have Ginger Hair?";
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

	public GameChar getGameChar() {
		return this.GameChar;
	}

	public void setGameChar(GameChar GameChar) {
		this.GameChar = GameChar;
	}
}
