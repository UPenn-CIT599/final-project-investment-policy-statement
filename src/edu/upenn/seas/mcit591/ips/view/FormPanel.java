package edu.upenn.seas.mcit591.ips.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


	/*
	 * This is a class to set up the FormPanel, where we can take some basic user information.
	 * TODO we are still working on the layout, and content
	 */
public class FormPanel extends JPanel{
		
	private static final long serialVersionUID = -125104934430563506L;
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener formListener;
	private JList ageList;
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

		
	public FormPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
			
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		ageLabel = new JLabel("Years to Retirement: ");
		annualIncomeLabel = new JLabel("Annual income: ");
		ageField = new JTextField(10);
		annualIncomeField = new JTextField(10);
		currentAssetsLabel = new JLabel("Current Assets: ");
		currentAssetsField = new JTextField(10);
		expensesLabel = new JLabel("Annual Expenses");
		expensesField = new JTextField(10);
		retiermentGoalLabel = new JLabel("Investment Target: ");
		retiermentGoalField = new JTextField(10);
		
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		occupationLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		ageLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		annualIncomeLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		currentAssetsLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		retiermentGoalLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		expensesLabel.setFont(new Font("Arial", Font.PLAIN, 22));
			
		okBtn = new JButton("OK");
			
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				String age = ageField.getText();
				String annualIncome = annualIncomeField.getText();
				String currentAssets = currentAssetsField.getText();
				String expenses = expensesField.getText();
				String retiermentGoal = retiermentGoalField.getText();
					
				FormEvent ev = new FormEvent(this,name,occupation,age,annualIncome, currentAssets, expenses, retiermentGoal);
					
				if(formListener != null){
					formListener.formEventOccurred(ev);
				}
			}
		});
			
		Border innerBorder = BorderFactory.createTitledBorder("Personal Information");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
			
		setLayout(new GridBagLayout());
			
		GridBagConstraints gc = new GridBagConstraints();
			
			
			
			//////////First row////////////////////////////
			
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			gc.gridx = 0;
			gc.gridy = 0;
			gc.fill = GridBagConstraints.NONE;
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 0, 5);
			add(nameLabel,gc);
			
			gc.gridx = 1;
			gc.gridy = 0;
			gc.anchor = GridBagConstraints.LINE_START;
			add(nameField,gc);
			
			
			//////////Second row////////////////////////////
			
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			gc.gridy = 1;
			gc.gridx = 0;
			gc.anchor = GridBagConstraints.LINE_END;
			add(occupationLabel,gc);
			
			gc.gridx = 1;
			gc.gridy = 1;
			gc.anchor = GridBagConstraints.LINE_START;
			add(occupationField,gc);
			
			
			//////////Third row////////////////////////////
			
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			gc.gridy = 2;
			gc.gridx = 0;
			gc.anchor = GridBagConstraints.LINE_END;
			add(ageLabel,gc);

			gc.gridy = 2;
			gc.gridx = 1;
			gc.anchor = GridBagConstraints.LINE_START;
			add(ageField,gc);
			
			
			//////////Fourth row////////////////////////////
			
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			gc.gridy = 3;
			gc.gridx = 0;
			gc.anchor = GridBagConstraints.LINE_END;
			add(annualIncomeLabel,gc);
			
			gc.gridy = 3;
			gc.gridx = 1;
			gc.anchor = GridBagConstraints.LINE_START;
			add(annualIncomeField,gc);
			
			
			//////////Fifth row////////////////////////////
			
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			gc.gridy = 4;
			gc.gridx = 0;
			gc.anchor = GridBagConstraints.LINE_END;
			add(currentAssetsLabel,gc);
			
			gc.gridy = 4;
			gc.gridx = 1;
			gc.anchor = GridBagConstraints.LINE_START;
			add(currentAssetsField,gc);
			
			
			//////////Sixth row////////////////////////////
			
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			gc.gridy = 5;
			gc.gridx = 0;
			gc.anchor = GridBagConstraints.LINE_END;
			add(expensesLabel,gc);
			
			gc.gridy = 5;
			gc.gridx = 1;
			gc.anchor = GridBagConstraints.LINE_START;
			add(expensesField,gc);
			
			
			//////////Seventh row////////////////////////////
			
			
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			gc.gridy = 6;
			gc.gridx = 0;
			gc.anchor = GridBagConstraints.LINE_END;
			add(retiermentGoalLabel,gc);
			
			gc.gridy = 6;
			gc.gridx = 1;
			gc.anchor = GridBagConstraints.LINE_START;
			add(retiermentGoalField,gc);
			
			//////////Eight row////////////////////////////
			
			gc.weightx = 1;
			gc.weighty = 2;
			
			gc.gridy = 7;
			gc.gridx = 1;
			gc.anchor = GridBagConstraints.FIRST_LINE_START;
			add(okBtn,gc);
			
		}
		
		public void setFormListener(FormListener formListener){
			this.formListener = formListener;
			
		}

	}


