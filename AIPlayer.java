package guessWho;

import java.util.ArrayList;
import java.util.Random;

public class AIPlayer {
	private ArrayList<GameChar> possibleGameChars = new ArrayList<GameChar>(); // All possible characters which the
																				// player could be
	private int questionNumber = -1; // The question that was previously asked
	private String[] attributes = { "whiteSkin", "blackSkin", "whiteHair", "brownHair", "blondeHair", "blackHair",
			"gingerHair", "maleGender", "femaleGender", "brownEye", "blueEye", "trueGlasses", "falseGlasses", "trueHat",
			"falseHat", "trueFaceHair", "falseFaceHair", "trueEaring", "falseEaring", "trueMustache", "falseMustache",
			"trueTeethShowing", "falseTeethShowing" }; // All the attributes of the GameChars
	private int[] numberOfAttributes = new int[attributes.length]; // Number of GameChar that have the attributes,
																	// indexes
																	// correspond to those of the attributes
	private ArrayList<String> questionBank = new ArrayList<String>();
	private String question = ""; // Question that was previously asked

	public AIPlayer(ArrayList<GameChar> gameChars) {
		for (int i = 0; i < gameChars.size(); i++) {
			possibleGameChars.add(gameChars.get(i));
		}
		for (int i = 0; i < 23; i++) {
			questionBank.add(GuessWho.questions(i));
		}
	}

	/**
	 * Players the Ai's turn
	 * 
	 * @param answer The player answer to the previous AI question
	 */
	public GameChar playTurn(boolean answer) {
		Random ran = new Random();

		if (possibleGameChars.size() == 1) { // When only one character is possible this method will return a guess
			// Must make a guess
			return possibleGameChars.get(0);
		}
		// Calculates the most prevalent attribute
		int indexOfHighest = 0; // By default

		// For all the attributes
		for (int i = 0; i < numberOfAttributes.length; i++) {
			// If the a attribute is more common than the current highest attribute and has
			// yet to be previously chosen

			if (numberOfAttributes[i] >= numberOfAttributes[indexOfHighest] && (questionBank.get(i) != null)) {
				indexOfHighest = i; // Becomes new highest
			}
		}

		if (questionBank.size() == 0) {
			System.out.println(indexOfHighest);
			System.out.println(numberOfAttributes[indexOfHighest] + ":" + attributes[indexOfHighest]);
			System.out.print(questionBank.get(indexOfHighest));
			return possibleGameChars.get(ran.nextInt(possibleGameChars.size()));
		}
		// removing characters
		question = questionBank.get(indexOfHighest);
		System.out.println(questionBank.get(indexOfHighest));
		questionBank.set(indexOfHighest, null); // Question gets removed as to not ask same GuessWho.questions
		
		// If question number is equal to -1, this means that it is the first question,
		// and therefore no characters need to be removed
		if (!question.equals("")) {
			// Algorithm for getting rid of impossible characters for the player to have
			// chosen
			// The character that is currently being
			// checked if is valid

			// if question has hair in the string, it will check what color it is, and if it
			// is meant to be that color, the index i is increased, otherwise, that
			// character is removed from possible options, and i is not incremented, because
			// the next player will replace the current player in index, same logic for
			// every attribute
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
						if (!(possibleGameChars.get(i).getHasGlasses() == false)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHasGlasses() == false) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(13))) {
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
			} else if (question.equals(GuessWho.questions(14))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHasHat() == false)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHasHat() == false) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(15))) {
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
			} else if (question.equals(GuessWho.questions(16))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHasFacialHair() == false)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHasFacialHair() == false) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(17))) {
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
			} else if (question.equals(GuessWho.questions(18))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHasEarings() == false)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHasEarings() == false) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(19))) {
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
			} else if (question.equals(GuessWho.questions(20))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getHasMustache() == false)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getHasMustache() == false) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			} else if (question.equals(GuessWho.questions(21))) {
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
			} else if (question.equals(GuessWho.questions(22))) {
				if (answer) {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (!(possibleGameChars.get(i).getIsShowingTeeth() == false)) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				} else {
					for (int i = 0; i < possibleGameChars.size(); i++) {
						if (possibleGameChars.get(i).getIsShowingTeeth() == false) {
							possibleGameChars.remove(possibleGameChars.get(i));
							i--;
						}
					}
				}
			}
		}

		System.out.println();
		for (int i = 0; i < possibleGameChars.size(); i++) {
			System.out.print(possibleGameChars.get(i).getName() + ", ");
		}
		System.out.println();
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
			numberOfAttributes[findIndex(possibleGameChars.get(i).getHasGlasses() + "Glasses")]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getHasHat() + "Hat")]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getHasFacialHair() + "FaceHair")]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getHasEarings() + "Earing")]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getHasMustache() + "Mustache")]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getIsShowingTeeth() + "TeethShowing")]++;
		}

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
