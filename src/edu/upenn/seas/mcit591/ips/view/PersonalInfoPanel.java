package edu.upenn.seas.mcit591.ips.view;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PersonalInfoPanel extends JPanel {
	
	
	/*
	 * This class incorporates the error check to validate the user's input format
	 */

	private static final long serialVersionUID = 4195362496344533857L;
	private FormPanel formPanel;

	public PersonalInfoPanel() {
		JLabel errorLabel = new JLabel(" ");
		errorLabel.setVisible(false);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		formPanel = new FormPanel();

		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				String name = "";
				name = e.getName();
				String occupation = "";
				occupation = e.getOccupation();
				String age = "";
				age = e.getAge();
				String annualIncome = "";
				annualIncome = e.getAnnualIncome();
				String currentAssets = "";
				currentAssets = e.getCurrentAssets();
				String retiermentGoal = "";
				retiermentGoal = e.getRetiermentGoal();
				String expense = "";
				expense = e.getExpenses();

				// error checking
				if (name.equals("") || occupation.equals("") || age.equals("") || annualIncome.equals("")
						|| currentAssets.equals("") || retiermentGoal.equals("") || expense.equals("")) {
					ErrorControl.setPersonalInfoError(true);

				} else {
					errorLabel.setVisible(false);
					ErrorControl.setError(" ");

					ErrorControl.setPersonalInfoError(false);
					double annuity = Double.parseDouble(annualIncome) - Double.parseDouble(expense);

					double rateofReturnVar = 10.0;
					int numberofYears = Integer.parseInt(age);
					DataManager.updateTimeValueVars(Integer.parseInt(age), Double.parseDouble(currentAssets),
							Double.parseDouble(retiermentGoal), annuity, numberofYears, rateofReturnVar);
				}

			}

		});
		this.add(formPanel);

		// setsError from errorChecking method
		if (ErrorControl.getPersonalInfoError()) {
			String panelError = ErrorControl.getError();
			errorLabel.setText(panelError);
			errorLabel.setFont(new Font("Bell MT", Font.BOLD, 16));
			errorLabel.setBorder(new EmptyBorder(50, 0, 90, 0));
			this.add(errorLabel);
			errorLabel.setVisible(true);
		}

	}
}