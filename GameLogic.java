package guesswho;

public class GameLogic {

	public boolean gameOver() {
		
		return false;
	}
	
	public boolean isChoiceValid(Character[] charactersChosen, Character character) {
		return true; 
	}
	
	public boolean isWinner(Character character, Character chosenCharacter) {
		if (character == chosenCharacter) {
			return true; 
		}
		return false; 
	}
}
