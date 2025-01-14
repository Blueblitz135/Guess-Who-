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
	private String aiQuestion; // Question that was previously asked

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

		// If question number is equal to -1, this means that it is the first question,
		// and therefore no characters need to be removed
		if (questionNumber != -1) {
			// if the question has a not, the answer is fliped, so that the question
			// without a not is held true, with the answer variable
			if (aiQuestion.indexOf("Not") > -1) {
				answer = !answer;
			}
			// Algorithm for getting rid of impossible characters for the player to have
			// chosen
			int i = 0;
			for (int j = 0; j < possibleGameChars.size(); j++) {
				GameChar characterUnderReview = possibleGameChars.get(i); // The character that is currently being
																			// checked if is valid

				// if question has hair in the string, it will check what color it is, and if it
				// is meant to be that color, the index i is increased, otherwise, that
				// character is removed from possible options, and i is not incremented, because
				// the next player will replace the current player in index, same logic for
				// every attribute
				if (aiQuestion.indexOf("Hair") > -1) {
					if (aiQuestion.indexOf("White") > -1) {
						if (characterUnderReview.getHairColor().equals("white") && answer == true) {
							i++;
							continue;
						} else {
							possibleGameChars.remove(characterUnderReview);
						}
					} else if (aiQuestion.indexOf("Brown") > -1) {
						if (characterUnderReview.getHairColor().equals("brown") && answer == true) {
							i++;
							continue;
						} else {
							possibleGameChars.remove(characterUnderReview);
						}
					} else if (aiQuestion.indexOf("Blonde") > -1) {
						if (characterUnderReview.getHairColor().equals("blonde") && answer == true) {
							i++;
							continue;
						} else {
							possibleGameChars.remove(characterUnderReview);
						}
					} else if (aiQuestion.indexOf("Ginger") > -1) {
						if (characterUnderReview.getHairColor().equals("ginger") && answer == true) {
							i++;
							continue;
						} else {
							possibleGameChars.remove(characterUnderReview);
						}
					}
				} else if (aiQuestion.indexOf("Eye") > -1) {
					if (aiQuestion.indexOf("Blue") > -1) {
						if (characterUnderReview.getEyeColor().equals("blue") && answer == true) {
							i++;
							continue;
						} else {
							possibleGameChars.remove(characterUnderReview);
						}
					} else if (aiQuestion.indexOf("Brown") > -1) {
						if (characterUnderReview.getEyeColor().equals("brown") && answer == true) {
							i++;
							continue;
						} else {
							possibleGameChars.remove(characterUnderReview);
						}
					}
				} else if (aiQuestion.indexOf("Skin") > -1) {
					if (aiQuestion.indexOf("white") > -1) {
						if (characterUnderReview.getSkinColor().equals("white") && answer == true) {
							i++;
							continue;
						} else {
							possibleGameChars.remove(characterUnderReview);
						}
					} else if (aiQuestion.indexOf("Black") > -1 && answer == true) {
						if (characterUnderReview.getSkinColor().equals("black") && answer == true) {
							i++;
							continue;
						} else {
							possibleGameChars.remove(characterUnderReview);
						}
					}
				} else if (aiQuestion.indexOf("Male") > -1) {
					if (characterUnderReview.getGender().equals("male") && answer == true) {
						i++;
						continue;
					} else {
						possibleGameChars.remove(characterUnderReview);
					}
				} else if (aiQuestion.indexOf("Female") > -1) {
					if (characterUnderReview.getGender().equals("female") && answer == true) {
						i++;
						continue;
					} else {
						possibleGameChars.remove(characterUnderReview);
					}
				} else if (aiQuestion.indexOf("Glasses") > -1) {
					if (characterUnderReview.getHasGlasses() && answer == true) {
						i++;
						continue;
					} else {
						possibleGameChars.remove(characterUnderReview);
					}
				} else if (aiQuestion.indexOf("Hat") > -1) {
					if (characterUnderReview.getHasHat() && answer == true) {
						i++;
						continue;
					} else {
						possibleGameChars.remove(characterUnderReview);
					}
				} else if (aiQuestion.indexOf("Face") > -1) {
					if (characterUnderReview.getHasFacialHair() && answer == true) {
						i++;
						continue;
					} else {
						possibleGameChars.remove(characterUnderReview);
					}
				} else if (aiQuestion.indexOf("Earing") > -1) {
					if (characterUnderReview.getHasEarings() && answer == true) {
						i++;
						continue;
					} else {
						possibleGameChars.remove(characterUnderReview);
					}
				} else if (aiQuestion.indexOf("Mustache") > -1) {
					if (characterUnderReview.getHasMustache() && answer == true) {
						i++;
						continue;
					} else {
						possibleGameChars.remove(characterUnderReview);
					}
				} else if (aiQuestion.indexOf("Teeth") > -1) {
					if (characterUnderReview.getIsShowingTeeth() && answer == true) {
						i++;
						continue;
					} else {
						possibleGameChars.remove(characterUnderReview);
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
			numberOfAttributes[findIndex(possibleGameChars.get(i).getHasGlasses() + "Glasses")]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getHasHat() + "Hat")]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getHasFacialHair() + "FaceHair")]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getHasEarings() + "Earing")]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getHasMustache() + "Mustache")]++;
			numberOfAttributes[findIndex(possibleGameChars.get(i).getIsShowingTeeth() + "TeethShowing")]++;
		}

		// Calculates the most prevalent attribute
		int indexOfHighest = 0; // By default

		// For all the attributes
		for (int i = 0; i < numberOfAttributes.length; i++) {
			// If the a attribute is more common than the current highest attribute and has
			// yet to be previously chosen

			if (numberOfAttributes[i] > numberOfAttributes[indexOfHighest] && (questionBank.get(i) != null)) {
				indexOfHighest = i; // Becomes new highest
			}
		}

		if (numberOfAttributes[indexOfHighest] == 0) {
			while (aiQuestion != null) {
				aiQuestion = questionBank.get(ran.nextInt(questionBank.size())); // Ai question set to question
																					// resulting in highest
			}
		}
		if (questionBank.size() == 0) {
			return possibleGameChars.get(ran.nextInt(possibleGameChars.size()));

		}
		// removing characters
		aiQuestion = questionBank.get(indexOfHighest);
		System.out.println(questionBank.get(indexOfHighest));
		questionBank.set(indexOfHighest, null); // Question gets removed as to not ask same questions
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
		return aiQuestion;
	}
}
