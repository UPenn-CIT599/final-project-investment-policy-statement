package edu.upenn.seas.mcit591.ips.view;

import java.util.EventObject;

/*
 * This class sets the events and collect the user’s input information needed for further analysis. 
 */
public class FormEvent extends EventObject {

	private static final long serialVersionUID = 6002427665101544218L;
	private String name;
	private String occupation;
	private String age;
	private String annualIncome;
	private String currentAssets;
	private String retiermentGoal;
	private String expenses;

	public String getExpenses() {
		return expenses;
	}

	public void setExpenses(String expenses) {
		this.expenses = expenses;
	}

	public String getRetiermentGoal() {
		return retiermentGoal;
	}

	public void setRetiermentGoal(String retiermentGoal) {
		this.retiermentGoal = retiermentGoal;
	}

	public String getCurrentAssets() {
		return currentAssets;
	}

	public void setCurrentAssets(String currentAssets) {
		this.currentAssets = currentAssets;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String occupation, String age, String annualIncome,
			String currentAssets, String expenses, String retiermentGoal) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.age = age;
		this.annualIncome = annualIncome;
		this.currentAssets = currentAssets;
		this.retiermentGoal = retiermentGoal;
		this.expenses = expenses;
	}

}
