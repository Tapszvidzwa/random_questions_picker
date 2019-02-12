import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.ArrayList;

class Chapter {

	 private ArrayList<Integer> questions = new ArrayList<>();
	 private String CHAPTER_NUM;

	 public Chapter() {

	 }

	 public void insertQuestion(String question) {
	 	if(question.contains("-")) {
	 		insertRange(question);
	 	} else {
	 		insertSingleQuestion(question);
	 	}
	 } 

	 public String getChapterNum() {
	 	return CHAPTER_NUM;
	 }

	 public void setChapterNum(String chapter) {
	 	this.CHAPTER_NUM = chapter;
	 }

	 public void printAllQuestions() {
	 	for (int i = 0; i < questions.size(); i++) {
	 		System.out.print(questions.get(i));
	 	}
	 }

	 public void setChapterNum(int num) {
	 this.CHAPTER_NUM = Integer.toString(num);
	 }

	 private void insertSingleQuestion(String num) {
	 	if(num.length() == 0) {
	 		return;
	 	}
	 	int num_int = Integer.parseInt(num);
	 	questions.add(num_int);
	 }

	 public String getRandomQuestion() {
	 	int size = questions.size();

	 	Random rand = new Random(); 
	   	int randomQuestion = rand.nextInt(size);

	   	return "ch" + CHAPTER_NUM + "." + questions.get(randomQuestion);
	 }

	 private void insertRange(String range) {
	 	int start_num;
	 	int end_num;

	 	String[] parts = range.split("-");
		start_num = Integer.parseInt(parts[0]); 
		end_num = Integer.parseInt(parts[1]); 

	 	for(int i = start_num; i <= end_num; i++) {
	 		questions.add(i);
	 	}
	 } 
}
