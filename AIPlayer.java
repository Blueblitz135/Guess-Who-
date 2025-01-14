package guessWho;

import java.util.ArrayList;
import java.util.Random;

public class AIPlayer {
	private ArrayList<GameChar> possibleGameChars = new ArrayList<GameChar>(); // All possible characters which the
																				// player could be
	private String[] attributes = { "whiteSkin", "blackSkin", "whiteHair", "brownHair", "blondeHair", "blackHair",
			"gingerHair", "maleGender", "femaleGender", "brownEye", "blueEye", "glasses", "hat", "faceHair", "earing",
			"mustache", "teethShowing" }; // All the attributes
											// of the GameChars
	private int[] numberOfAttributes = new int[attributes.length]; // Number of GameChar that have the attributes,
																	// indexes
																	// correspond to those of the attributes
	private ArrayList<String> questionBank = new ArrayList<String>(); // ArrayList of all questions

	private String question = ""; // Question the AI is asking, will be accessed

	private int indexOfHighest; // index of the most prevalent attribute

	public AIPlayer(ArrayList<GameChar> gameChars) {
		// Adds all characters to possibleCharacters which AI can guess
		for (int i = 0; i < gameChars.size(); i++) {
			possibleGameChars.add(gameChars.get(i));
		}
		// Adds all questions to question bank
		for (int i = 0; i < 17; i++) {
			questionBank.add(GuessWho.questions(i));
		}
	}

	/**
	 * Uses algorithm which chooses best question to asked based on most prevalent
	 * attribute, after one character is remaining possible, it will return that
	 * character
	 * 
	 * @param answer The player answer to the previous AI question
	 * @return The guess of the AI, for what the players character is
	 */
	public GameChar playTurn(boolean answer) {
		Random ran = new Random();

		// If the question String is empty, it represents the first run of the game,
		// therefore no characters need to be removed
		if (!question.equals("")) {
			/*
			 * Algorithm for removing possible characters player could have based on the
			 * previous question asked by AI.
			 */
			if (question.equals(GuessWho.questions(0))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getSkinColor().equals("whiteSkin"))) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getSkinColor().equals("whiteSkin")) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(1))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getSkinColor().equals("blackSkin"))) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getSkinColor().equals("blackSkin")) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(2))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHairColor().equals("whiteHair"))) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHairColor().equals("whiteHair")) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(3))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHairColor().equals("brownHair"))) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHairColor().equals("brownHair")) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(4))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHairColor().equals("blondeHair"))) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHairColor().equals("blondeHair")) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(5))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHairColor().equals("gingerHair"))) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHairColor().equals("gingerHair")) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(6))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHairColor().equals("blackHair"))) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHairColor().equals("blackHair")) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(7))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getGender().equals("maleGender"))) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getGender().equals("maleGender")) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(8))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getGender().equals("femaleGender"))) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getGender().equals("femaleGender")) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(9))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getEyeColor().equals("brownEye"))) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getEyeColor().equals("brownEye")) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(10))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getEyeColor().equals("blueEye"))) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getEyeColor().equals("blueEye")) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(11))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHasGlasses() == true)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHasGlasses() == true) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(12))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHasHat() == true)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHasHat() == true) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(13))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHasFacialHair() == true)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHasFacialHair() == true) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(14))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHasEarings() == true)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHasEarings() == true) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(15))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHasMustache() == true)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHasMustache() == true) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(16))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getIsShowingTeeth() == true)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getIsShowingTeeth() == true) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			}
		}

		// Sets default values of attributes
		for (int i = 0; i < numberOfAttributes.length; i++) {
			numberOfAttributes[i] = 0;
		}
		// From all possible characters, increases number of each attribute present
		for (int i = 0; i < possibleGameChars.size(); i++) {
			numberOfAttributes[findIndex(possibleGameChars.get(i).getSkinColor())]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getHairColor())]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getGender())]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getEyeColor())]++;
			numberOfAttributes[findIndex("glasses")]++;
			numberOfAttributes[findIndex("hat")]++;
			numberOfAttributes[findIndex("faceHair")]++;
			numberOfAttributes[findIndex("earing")]++;
			numberOfAttributes[findIndex("mustache")]++;
			numberOfAttributes[findIndex("teethShowing")]++;
		}
		if (possibleGameChars.size() == 1) { // When only one character is possible this method will return a guess
			// Must make a guess
			return possibleGameChars.get(0);
		}
		// Calculates the most prevalent attribute by default
		int half = possibleGameChars.size() / 2;
		int res = numberOfAttributes[0];
		// For all the attributes
		for (int i = 1; i < numberOfAttributes.length; i++) {
			// If the a attribute is more common than the current highest attribute and has
			// yet to be previously chosen
			if (Math.abs(numberOfAttributes[i] - half) <= Math.abs(res - half) && (questionBank.get(i) != null)) {
				res = numberOfAttributes[i];
				indexOfHighest = i; // Becomes new highest
			}
		}

		// If the AI runs out of questions to ask, then it will guess a random character
		if (questionBank.size() == 0) {
			return possibleGameChars.get(ran.nextInt(possibleGameChars.size()));
		}

		// Set the question to ask
		// If the best question to ask has already been asked,
		// the AI will guess a random question that hasn't been asked yet
		question = questionBank.get(indexOfHighest);
		while (question == null) {
			question = questionBank.get(ran.nextInt(questionBank.size()));
		}
		questionBank.set(indexOfHighest, null); // Question gets removed as to not ask same GuessWho.questions

		// sets AI question
		return null; // Returns null if no character is chosen
	}

	/**
	 * Chooses a GameChar randomly from the 24 available GameChars
	 * 
	 * @param GameChars Returns the Ai's character
	 */
	public static GameChar chooseGameChar(ArrayList<GameChar> GameChars) {
		Random rand = new Random();
		return GameChars.get(rand.nextInt(24));
	}

	/**
	 * Finds the index of certain string key in attributes ArrayList
	 * 
	 * @param key String being looked for in array
	 * @return The index of string in array
	 * @return -1 if key is not in array
	 */
	public int findIndex(String key) {
		for (int i = 0; i < attributes.length; i++) {
			if (attributes[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}

	public ArrayList<GameChar> getPossibleCharacters() {
		return possibleGameChars;
	}

	public String getAiQuestion() {
		return question;
	}
}
