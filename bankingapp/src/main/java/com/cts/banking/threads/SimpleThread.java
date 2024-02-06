package com.cts.banking.threads;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class SimpleThread extends Thread{

	private String name;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*
		 * System.out.println(Thread.currentThread().getName()); //display the name
		 * for(char ch : name.toCharArray()) { System.out.print(ch); try {
		 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } }
		 */
		List<String> questions=getQuestions();
		int i=0;
	  	while(i<questions.size()) {
	  		
	  		System.out.println(questions.get(i));
	  		try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				i++;
			}
	  		i++;
	  	}
		
	}
	
	 public List<String> getQuestions(){
		   
		   List<String> questions = new ArrayList<String>();
		   questions.add("1. Who is the CEO of Alphabet?");
		   questions.add("2. Who created Next?");
		   questions.add("3.What is the fullform of LLM");
		   return questions;
		   
	   }
	
	

}
