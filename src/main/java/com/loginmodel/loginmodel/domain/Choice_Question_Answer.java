package com.loginmodel.loginmodel.domain;

import java.util.ArrayList;

public class Choice_Question_Answer {

	public Choice_Question_Answer(ChoiceQuestion question, ArrayList<ChoiceOptions> options) {
		super();
		this.question = question;
		this.options = options;
	}
	ChoiceQuestion question;
	ArrayList<ChoiceOptions> options;
	
}
