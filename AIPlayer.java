package guessWho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AIPlayer {
	private File file = new File("AIPlayerQuestions.txt");
	private ArrayList<String> questions = new ArrayList<String>();
	
	
	public void readQuestionFile() throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		
		for (int i = 0; i < file.length(); i++) {
			setQuestions(sc.nextLine());
		}
	}
	
	/**
	 * Tester method to test readQuestionFile method 
	 * @param string
	 */
	public void test() {
		for (int i = 0; i < questions.size(); i++) {
			System.out.println(questions.get(i));
		}
	}
	
	
	public void setQuestions(String string) {
		getQuestions().add(string);
	}
	
	public ArrayList<String> getQuestions() {
		return questions; 
	}
	
	public File getFile() {
		return file;
	}
}
