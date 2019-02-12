import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.Character;
import java.util.Random;
import java.util.ArrayList;


class PracticeQuestions {

	private static ArrayList<Chapter> chapters = new ArrayList<>();
	private static int NUM_TO_PRINT = 10;

	public static void main(String [] args) {
		run(args[0]);
	}

	private static void run(String questions_filename) {
		initializeTestQuestions(questions_filename);
		printQuestions();
	}

	private static void initializeTestQuestions(String filename) {

		BufferedReader br = null;

		try {
			  br = new BufferedReader(new FileReader(filename));
			} catch (FileNotFoundException e) {
				System.out.println("File containing questions not found");
				System.exit(1);
		}

		ArrayList<String> txt = new ArrayList<>();

		while(true) {
			try {
				String ipt = br.readLine();
			 if(ipt != null && ipt.length() != 0) {
			 	txt.add(ipt);
			 } else {
			 	break;
			 }
			} catch (IOException e) {
				//
			}
		}

		for(int i = 0; i < txt.size(); i++) {
			 
			 Chapter chapter = new Chapter();
			 
			 String[] parts = txt.get(i).split(">");
			 
			 String chapter_part = parts[0].trim();
			 chapter.setChapterNum(chapter_part); 
			 
			 String[] questions = parts[1].split(" ");

			 for(int x = 0; x < questions.length; x++) {
			 	if(questions[x].length() != 0) {
			 	chapter.insertQuestion(questions[x]);
				 }
			 }

			  chapters.add(chapter);
		} 

			try {
				br.close();
			} catch(IOException e) {
				System.out.println("Something went wrong closing file");
				System.exit(1);
			}
	}

	private static void printAll() {
		for(int i = 0; i < 10; i++) {
			System.out.println(chapters.get(i).getChapterNum() + ": ");
			chapters.get(i).printAllQuestions();
			System.out.println("\n");
		}
	}

	private static void printQuestions() {
		int size = chapters.size();
		Random rand = new Random(); 

		for (int i = 0; i < NUM_TO_PRINT; i++) {	
	   		int randomChapter = rand.nextInt(size);
			System.out.println(chapters.get(randomChapter).getRandomQuestion());
		} 
	}
}