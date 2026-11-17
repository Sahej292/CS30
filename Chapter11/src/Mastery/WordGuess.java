package Mastery;


import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class WordGuess 
{

    public static void main(String[] args) 
    {
        final String FLAG = "!";

        //Create a File object
        File file = new File("C:/Users/410029506/git/CS30/Chapter11/src/Mastery/words.txt"                                                                 );
        //Declare a File reader object
        FileReader fr;

        //Declare a BufferedReader object
        BufferedReader br;

        //Create a random number object
        Random rand = new Random();

        Scanner input = new Scanner(System.in);

        int numWords, wordToGuess;
        String secretWord = "";
        String wordSoFar = "", updatedWord = "";
        String letterGuess, wordGuess = "";
        int numGuesses = 0;    
        
        

        /* select secret word */
        try {
            //initialize the file reader object
            fr = new FileReader(file);

            //initialize the BufferedReader object
            br = new BufferedReader(fr);

            //Get the number of words in the file
            numWords = 0;

            while (br.readLine() != null)
            {
                numWords++;
            }

            //Choose a random word
            wordToGuess = rand.nextInt(numWords) + 1;

            //Close and reopen the file
            br.close();
            fr.close();

            fr = new FileReader(file);
            br = new BufferedReader(fr);

            //Read until the chosen word
            for (int i = 1; i <= wordToGuess; i++)
            {
                secretWord = br.readLine();
            }

            //Close the files
            br.close();
            fr.close();

        } catch (FileNotFoundException e) 
        {
            System.out.println("File not found!");
            return;
        } catch (IOException e) 
        {
            System.out.println("Error reading file!");
            return;
        }



        /* begin the game */
        System.out.println("WordGuess game.");

        //Make dashes
        for (int i = 0; i < secretWord.length(); i++)
        {
            wordSoFar = wordSoFar + "-";
        }

        System.out.println(wordSoFar);



        /* allow player to make guesses*/

        do {
            //Ask for a letter
            System.out.print("Guess a letter (! to quit): ");
            letterGuess = input.nextLine();

            //Count guesses
            numGuesses++;

            //Check if the player wants to quit
            if (!letterGuess.equals(FLAG))
            {
                updatedWord = "";

                for (int i = 0; i < secretWord.length(); i++)
                {
                    if (secretWord.charAt(i) == letterGuess.charAt(0))
                    {
                        updatedWord = updatedWord + letterGuess;
                    }
                    else
                    {
                        updatedWord = updatedWord + wordSoFar.charAt(i);
                    }
                }

                wordSoFar = updatedWord;
            }

            //Display the word
            System.out.println(wordSoFar);

        } while (!letterGuess.equals(FLAG) && !wordSoFar.equals(secretWord));



        /* finish game and display message and number of guesses */
        
        if (wordSoFar.equals(secretWord))
        {
            System.out.println("You win!");
        }
        else
        {
            System.out.println("The word was: " + secretWord);
        }

        System.out.println("Number of guesses: " + numGuesses);

        input.close();
    }
}



