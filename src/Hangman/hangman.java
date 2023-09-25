import java.util.Scanner;
import java.util.Random;
public class hangman {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		//DECLARE String[] wordList
        String[] wordList = {"hangman", "word", "none", "break", "hunter", "occupy", "student", "decoration", "automatic", "hippopotomonstrosesquippedaliophobia"};
		int rand_int = rand.nextInt(wordList.length);
		// DECLARE boolean user = true, this is for keeping user in infinite loop
		boolean user = true;
		// DECLARE int guesses = 0
		int lives = 0;
		// 	Pick random word from wordList
		// 	DECLARE string word = word picked from wordList
		String targetWord = wordList[rand_int];
		// 	Take the length of word picked, add one to it, and display number of characters in the form of underscores
		String guessedWord = displayHiddenWord(targetWord);
		int chars_left1 = guessedWord.length();
		// WHILE user == true
		while (user){
			// 	WHILE guesses <= 8
			while (lives <= 8 && !guessedWord.equals(targetWord)){
				System.out.println("Your current word is: ");
				System.out.println(guessedWord);
				// 		Prompt user to enter a character
				System.out.println("Please enter a single character: ");
				// DECLARE char user_input
				char userChar = sc.next().charAt(0);
				
				char guessedChar = userChar;
				guessedWord = revealCharacter(guessedChar, targetWord, guessedWord);
				System.out.println(guessedWord);
				int chars_left = displayCharsLeft(guessedWord);
				// 		IF user_input not in word THEN
				if (chars_left == chars_left1){
					//ELSE IF user_input in word THEN
					//Display user_input in place of the underscore in every correct position
					//updates user_word
					System.out.println("That character wasn't in the word!");
					lives += 1;
					printHangMan(lives-1);
				}
				chars_left1 = chars_left;
			}
			if (lives > 8){ // 	If guesses > 8
				System.out.println("Sorry!, you ran out of lives!"); //Inform User they lost
				System.out.println("Would you like to play again? Respond with y/n"); //Prompt to play again
				char response = sc.next().charAt(0);
				if (response == 'y'){ //IF yes
					user = true; //reset boolean (This should in theory restart the loop)
					//reset all variables
					rand_int = rand.nextInt(wordList.length);
					lives = 0;
					targetWord = wordList[rand_int];
					guessedWord = displayHiddenWord(targetWord);
					chars_left1 = guessedWord.length();
				} else{
					//Prompt user thanks for playing the game
					System.out.println("Thanks for playing!");
					user = false; //user = false (This breaks the main loop)
				}
				// 		IF '_' not in user_word
			} else if (guessedWord == targetWord || lives <= 8){
				// 		Prompt to play again
				System.out.println("Congratulations!, you guessed the word!");//Inform User they lost
				System.out.println("Would you like to play again? Respond with y/n");//Prompt to play again
				char response = sc.next().charAt(0);
				if (response == 'y'){ //IF yes
					user = true;//reset boolean (This should in theory restart the loop)
					//reset all variables
					rand_int = rand.nextInt(wordList.length);
					lives = 0;
					targetWord = wordList[rand_int];
					guessedWord = displayHiddenWord(targetWord);
					chars_left1 = guessedWord.length();
				} else{
					//Prompt user thanks for playing the game
					System.out.println("Thanks for playing!");
					user = false; //user = false (This breaks the main loop)
				} //ENDIF
			} //ENDIF
		} //ENDWHILE
		sc.close();
	}
		

	
	public static void printHangMan(int guesses) {
		switch(guesses) {
		case 0:
			System.out.println("		 _______ 		");
			System.out.println("		|	| 		");
			System.out.println("		|	0 		");
			System.out.println("		|		 		");
			System.out.println("		|				");
			System.out.println("		|				");
			System.out.println("		|				");
			System.out.println("	     ___|___				");
			break;
		case 1: 
			System.out.println("		 _______ 		");
			System.out.println("		|	| 		");
			System.out.println("		|	0 		");
			System.out.println("		|	| 		");
			System.out.println("		|				");
			System.out.println("		|				");
			System.out.println("		|				");
			System.out.println("	     ___|___				");
			break;
		case 2: 
			System.out.println("		 _______ 		");
			System.out.println("		|	| 		");
			System.out.println("		|	0 		");
			System.out.println("		|	| 		");
			System.out.println("		|     --|--		");
			System.out.println("		|				");
			System.out.println("		|				");
			System.out.println("	     ___|___				");
			break;
		case 3: 
			System.out.println("		 _______ 		");
			System.out.println("		|	| 		");
			System.out.println("		|	0 		");
			System.out.println("		|	| 		");
			System.out.println("		|     --|--		");
			System.out.println("		|	|		");
			System.out.println("		|				");
			System.out.println("	     ___|___				");
			break;
		case 4: 
			System.out.println("		 _______ 		");
			System.out.println("		|	| 		");
			System.out.println("		|	0 		");
			System.out.println("		|	| 		");
			System.out.println("		|     --|--		");
			System.out.println("		|	|		");
			System.out.println("		|      /		");
			System.out.println("	     ___|___				");
			break;
		case 5: 
			System.out.println("		 _______ 		");
			System.out.println("		|	| 		");
			System.out.println("		|	0 		");
			System.out.println("		|	| 		");
			System.out.println("		|     --|--		");
			System.out.println("		|	|		");
			System.out.println("		|      / \\		");
			System.out.println("	     ___|___				");
			break; 
		case 6: 
			System.out.println("		 _______ 		");
			System.out.println("		|	| 		");
			System.out.println("		|	0 		");
			System.out.println("		|	| 		");
			System.out.println("		|     --|--		");
			System.out.println("		|	|		");
			System.out.println("		|      / \\		");
			System.out.println("	 	|     /				");
			System.out.println("	     ___|___ 		");
			break;
		case 7: 
			System.out.println("		 _______ 		");
			System.out.println("		|	| 		");
			System.out.println("		|	0 		");
			System.out.println("		|	| 		");
			System.out.println("		|     --|--		");
			System.out.println("		|	|		");
			System.out.println("		|      / \\		");
			System.out.println("	        |     /   \\");
			System.out.println("	     ___|___ 		");
			break;
		}
		
	}
	public static String displayHiddenWord(String targetword){
		StringBuilder displayWord = new StringBuilder();

		for (int i = 0; i<targetword.length(); i++){
			displayWord.append('-');
		}
		return displayWord.toString();
	}
	public static int displayCharsLeft(String target){
		int char_left = 0;
		for (int i = 0; i<target.length(); i++){
			if (target.charAt(i) == '-'){
				char_left++;
			}
		}
		return char_left;
	}
	public static String revealCharacter(char guess, String target, String revealed){
		StringBuilder result = new StringBuilder(revealed);
		
		for (int i = 0; i<target.length(); i++){
			if (target.charAt(i) == guess){
				result.setCharAt(i, guess);
			}
		}
		return result.toString();
	}
}

