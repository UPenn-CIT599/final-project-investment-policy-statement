package edu.upenn.seas.mcit591.ips.view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PersonalInfoPanel extends JPanel {

	private static final long serialVersionUID = 4195362496344533857L;
	private FormPanel formPanel;

	public PersonalInfoPanel() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		formPanel = new FormPanel();

		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				String age = e.getAge();
				String annualIncome = e.getAnnualIncome();
				String currentAssets = e.getCurrentAssets();
				String retiermentGoal = e.getRetiermentGoal();
				String expense = e.getExpenses();
				double annuity = Double.parseDouble(annualIncome) - Double.parseDouble(expense);
				// textPanel.appendText("Hello, " + name + "!" + "\n" + "Welcome
				// to WealthOrganizer!" + "\n");
				// 65 can change later.
				int numberofYears = 65 - Integer.parseInt(age);
				// TODO we can get the age and annual income here to do some
				// analyze calculation
				// TimeValueOfMoneyCalc retiermentCalculation = new
				// TimeValueOfMoneyCalc();
				// double RequiredRateofRetrun =
				// retiermentCalculation.calculateIRR(Double.parseDouble(currentAssets),
				// Double.parseDouble(retiermentGoal), annuity, numberofYears);
			}

		});
		
		this.add(formPanel);
		
	}
}