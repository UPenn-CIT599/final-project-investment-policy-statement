package edu.upenn.seas.mcit591.ips.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.commons.lang3.StringUtils;

public class PersonalInfoPanel extends JPanel {
	
	
	/*
	 * This class incorporates the error check to validate the user's input format for "Personal Info" 
	 */

	private static final long serialVersionUID = 4195362496344533857L;
	public FormPanel formPanel;
	
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
				
				
				StringBuilder errorHtml = new StringBuilder();
				errorHtml.append("<html>");
				errorHtml.append("<div style='color:red;font-size:14px;'>");
				errorHtml.append("<ul>");
				
				if(StringUtils.isBlank(name)) {
					errorHtml.append("<li>");
					errorHtml.append("Your name can't be empty.");
					errorHtml.append("</li>");
				}
				if(StringUtils.isBlank(occupation)) {
					errorHtml.append("<li>");
					errorHtml.append("Occupation Goal can't be empty.");
					errorHtml.append("</li>");
				}
				if(StringUtils.isBlank(age)) {
					errorHtml.append("<li>");
					errorHtml.append("Investment Horizon can't be empty.");
					errorHtml.append("</li>");
				}
				else if(!StringUtils.isNumeric(age)) {
					errorHtml.append("<li>");
					errorHtml.append("Investment Horizon can only be number.");
					errorHtml.append("</li>");
				}
				if(StringUtils.isBlank(annualIncome)) {
					errorHtml.append("<li>");
					errorHtml.append("Annual Income can't be empty.");
					errorHtml.append("</li>");
				}
				else if(!StringUtils.isNumeric(annualIncome)) {
					errorHtml.append("<li>");
					errorHtml.append("Annual Income can only be number.");
					errorHtml.append("</li>");
				}
				if(StringUtils.isBlank(currentAssets)) {
					errorHtml.append("<li>");
					errorHtml.append("Current Asset can't be empty.");
					errorHtml.append("</li>");
				}
				else if(!StringUtils.isNumeric(currentAssets)) {
					errorHtml.append("<li>");
					errorHtml.append("Current Asset can only be number.");
					errorHtml.append("</li>");
				}
				if(StringUtils.isBlank(expense)) {
					errorHtml.append("<li>");
					errorHtml.append("Annual Expense can't be empty.");
					errorHtml.append("</li>");
				}
				else if(!StringUtils.isNumeric(expense)) {
					errorHtml.append("<li>");
					errorHtml.append("Annual Expense can only be number.");
					errorHtml.append("</li>");
				}
				if(StringUtils.isBlank(retiermentGoal)) {
					errorHtml.append("<li>");
					errorHtml.append("Investment Goal can't be empty.");
					errorHtml.append("</li>");
				}
				else if(!StringUtils.isNumeric(retiermentGoal)) {
					errorHtml.append("<li>");
					errorHtml.append("Investment Goal can only be number.");
					errorHtml.append("</li>");
				}
				
				errorHtml.append("<ul>");
				errorHtml.append("</div>");
				errorHtml.append("</html>");
				
				// error checking
				if (StringUtils.contains(errorHtml, "<li>")) {
					ErrorControl.setPersonalInfoError(true);
					ErrorControl.setError(errorHtml.toString());
					showErrorPanel(errorLabel);
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
		formPanel.setMaximumSize(new Dimension(1000, 400));
		this.add(formPanel);
		
		JPanel expainPanel = new JPanel();
		JLabel hint1 = new JLabel("<html><div style='font-size:14px;font-weight:normal;text-align:left;widht:100%;'>Investment Horizon: Years between Today and Desired Retirement Year</div></html>");
		JLabel hint2 = new JLabel("<html><div style='font-size:14px;font-weight:normal;text-align:left;widht:100%;'>Investment Target: Desired Asset Amount at Retirement</div></html>");
		JLabel hint3 = new JLabel("<html><div style='font-size:14px;font-weight:normal;text-align:left;widht:100%;'>Annual Income - Annual Expense: Fund available to invest each year </div></html>");		
		
		expainPanel.add(hint1);
		expainPanel.add(hint2);
		expainPanel.add(hint3);
		expainPanel.setMaximumSize(new Dimension(1000, 100));
		add(expainPanel);
		
		// setsError from errorChecking method
		if (ErrorControl.getPersonalInfoError()) {
			showErrorPanel(errorLabel);
		}

	}

	private void showErrorPanel(JLabel errorLabel) {
		JPanel errorPanel = new JPanel();
		errorPanel.setName("ErrorPanel");
		String panelError = ErrorControl.getError();
		errorLabel.setText(panelError);
		errorLabel.setFont(new Font("Georgia", Font.ITALIC, 16));
		errorPanel.add(errorLabel);
		errorPanel.setMaximumSize(new Dimension(1000, 300));
		if(errorLabel.isVisible()) {
			for(Component c : this.getComponents()) {
				if(StringUtils.equals(c.getName(), "ErrorPanel")) {
					this.remove(c);
				}
			}
		}
		this.add(errorPanel);
		errorLabel.setVisible(true);
		
	}
}