package com.cdac.model;

import java.util.List;

public class Question {
	
	private String question;
	
	
	//used collections as iit is dynamic in anture
	/*we can use arrays also but in case options are different for every question then
	collections may be preferable so it is used.*/
	
	private List<Option>options;
	
	public Question() {
		
	}
	
	public Question(String question) {
		super();
		this.question = question;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<Option>getOptions(){
		return options;
	}
	
	public void setOptions(List<Option> options) {
		this.options = options;
	}

}
