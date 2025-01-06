package guessWho;

public class GameLogic {

	public boolean gameOver(Character character, Character chosenCharacter) {
		
		return isWinner(character, chosenCharacter);
		
	}
	
	
	public boolean isChoiceValid(Character[] charactersChosen, Character chosenCharacter) {
		
		for (int i = 0; i < charactersChosen.length; i++) {
			if (charactersChosen[i] == chosenCharacter) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public boolean isWinner(Character character, Character chosenCharacter) {
		if (character == chosenCharacter) {
			return true; 
		}
		return false; 
	}
}
