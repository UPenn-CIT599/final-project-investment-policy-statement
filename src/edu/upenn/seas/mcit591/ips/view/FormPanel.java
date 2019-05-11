package edu.upenn.seas.mcit591.ips.view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * This is a class to set up the FormPanel, where we can take some basic user information.
 */
public class FormPanel extends JPanel {

	private static final long serialVersionUID = -125104934430563506L;
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	public JButton okBtn;
	private FormListener formListener;
	private JLabel ageLabel;
	private JLabel annualIncomeLabel;
	private JLabel currentAssetsLabel;
	private JLabel retiermentGoalLabel;
	private JLabel expensesLabel;
	private JTextField ageField;
	private JTextField currentAssetsField;
	private JTextField retiermentGoalField;
	private JTextField annualIncomeField;
	private JTextField expensesField;
	
	private static String name;
	private static String occupation;
	private static String age;
	private static String annualIncome;
	private static String currentAssets;
	private static String expenses;
	private static String retiermentGoal;

// The section below sets the display of the 2nd screen which allows the user to enter investment information
	public FormPanel() {
//		Dimension dim = getPreferredSize();
//		dim.width = 250;
//		setPreferredSize(dim);
		
		setLayout(new GridLayout(0, 4));
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));        
	    JPanel rightPanel = new JPanel();
	    rightPanel.setLayout(new FlowLayout((FlowLayout.LEFT)));
		
		nameLabel = new JLabel("Your Name ", JLabel.TRAILING);
		occupationLabel = new JLabel("Occupation ", JLabel.TRAILING);
		nameField = new JTextField(10);
		nameField.setText(name);
		occupationField = new JTextField(10);
		occupationField.setText(occupation);
		ageLabel = new JLabel("Investment Horizon ", JLabel.TRAILING);
		annualIncomeLabel = new JLabel("Annual Income $ ", JLabel.TRAILING);
		ageField = new JTextField(10);
		ageField.setText(age);
		annualIncomeField = new JTextField(10);
		annualIncomeField.setText(annualIncome);
		currentAssetsLabel = new JLabel("Current Assets $ ", JLabel.TRAILING);
		currentAssetsField = new JTextField(10);
		currentAssetsField.setText(currentAssets);
		expensesLabel = new JLabel("Annual Expenses $ ", JLabel.TRAILING);
		expensesField = new JTextField(10);
		expensesField.setText(expenses);
		retiermentGoalLabel = new JLabel("Investment Target $ ", JLabel.TRAILING);
		retiermentGoalField = new JTextField(10);
		retiermentGoalField.setText(retiermentGoal);
		  
		okBtn = new JButton("OK");
		okBtn.setVisible(false);

		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				name = nameField.getText();
				occupation = occupationField.getText();
				age = ageField.getText();
				annualIncome = annualIncomeField.getText();
				currentAssets = currentAssetsField.getText();
				expenses = expensesField.getText();
				retiermentGoal = retiermentGoalField.getText();
				
				FormEvent ev = new FormEvent(this, name, occupation, age, annualIncome, currentAssets, expenses,
						retiermentGoal);

				if (formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Personal Information");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		leftPanel.add(nameLabel);
		rightPanel.add(nameField);
		leftPanel.add(occupationLabel);
		rightPanel.add(occupationField);
		leftPanel.add(ageLabel);
		rightPanel.add(ageField);
		leftPanel.add(annualIncomeLabel);
		rightPanel.add(annualIncomeField);
		leftPanel.add(currentAssetsLabel);
		rightPanel.add(currentAssetsField);
		leftPanel.add(expensesLabel);
		rightPanel.add(expensesField);
		leftPanel.add(retiermentGoalLabel);
		rightPanel.add(retiermentGoalField);
		rightPanel.add(okBtn);
		
		for(Component c : leftPanel.getComponents()) {
			c.setFont(new Font("Georgia", Font.PLAIN, 25));
		}
		for(Component c : rightPanel.getComponents()) {
			c.setFont(new Font("Georgia", Font.PLAIN, 16));
		}
		
		add(new JPanel());
		add(leftPanel);
	    add(rightPanel);
	    add(new JPanel());
		
	}

	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;

	}

}
