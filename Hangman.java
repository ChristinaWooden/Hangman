import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Hangman{

	public static int guesses;
	public static String[] choices = {"y e e t", "b i t c h a s s", "h u m m u s", "b o b a", "s w a l l o w i n g"};
	public static int num = (int)((Math.random())*5); //chooses a random number between 1 and 5
	public static String letterGuess; 
	public static ArrayList<String> display; //first, the word is shown as blanks.  As letters are guessed correctly, the blanks are replaced
	public static String saveAnswer = choices[num]; //chooses a word in "choices" of index "num"
	public static ArrayList<String> answer = new ArrayList<String>(Arrays.asList((saveAnswer.split(" "))));
	public static ArrayList<String> keepAnswer = new ArrayList<String>(Arrays.asList((saveAnswer.split(" "))));


	//Main class.  This is where the game will be played
	public static void main (String[] args){

		Scanner keyboard = new Scanner(System.in); //for reading in user inputs
		display = new ArrayList<String>();

		//adds in blanks for the number of letters in "answer"
		for (int i = 0; i < answer.size(); i++){
			display.add("_");
		}

		for (int i = 0; i < display.size(); i++){
			System.out.print(display.get(i) + " ");
		}
		System.out.println("\n");



		do {

			System.out.println("Enter a letter guess :: ");
			letterGuess = (keyboard.nextLine()); //reads in the user's input

				if (answer.contains(letterGuess)){
					do {
						int replace = keepAnswer.indexOf(letterGuess);
						keepAnswer.set(replace, "*");
						System.out.println(replace);
						answer.remove(answer.indexOf(letterGuess));
						display.set(replace, letterGuess);
					} while (answer.contains(letterGuess));
					for (int i = 0; i < display.size(); i++){
						System.out.print(display.get(i) + " ");
					}
				}
				else {
					System.out.println("Incorrect.  You have " + (10 - guesses) + " guesses left.");
					guesses++;
					for (int i = 0; i < display.size(); i++){
						System.out.print(display.get(i) + " ");
					}
				}




		}while (!gameOver()); //play the game while gameOver returns false

		if (gameOver()){
			System.out.println("\n \n Game over.  The correct answer is " + saveAnswer);
		}
	}



	//Checks to see the user has not won yet
	public static boolean gameOver(){
		return (guesses == 10 || answer.size() == 0);
	}






}