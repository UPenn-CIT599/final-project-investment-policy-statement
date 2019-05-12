package edu.upenn.seas.mcit591.ips.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class RiskTolerancePanel extends JPanel {
	public static int sum;
	public JButton okButton;

	// declare variables to collect the questionnaire user choice scores
	public static int q1selected = 0;
	public static int q2selected = 0;
	public static int q3selected = 0;

	private static final long serialVersionUID = 7133849259611110654L;

	// getter and setter to take the total scores for these three questions
	public static void setSum(int sum) {
		RiskTolerancePanel.sum = sum;
	}

	public static int getSum() {
		return RiskTolerancePanel.sum;
	}

	// set the display of the questionaire that the user needs to fill out
	public RiskTolerancePanel() {

		Border innerBorder = BorderFactory.createTitledBorder("Risk Tolerance");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel label1 = new JLabel(
				"<html>The following questionnaire can help assess your risk tolerance in investing activities."
						+ "Your risk tolerance has two parts: willingness to take risk and ability to take risk."
						+ "<font color='red'>" + ErrorControl.getError() + "</font></html>");
		label1.setBorder(new EmptyBorder(50, 0, 8, 0));
		this.add(label1);

		JLabel q1 = new JLabel(
				"<html>Q1: When deciding how to invest your money, which do you care about more?</html>");
		q1.setBorder(new EmptyBorder(50, 0, 8, 0));
		ButtonGroup q1ButtonGroup = new ButtonGroup();
		JRadioButton q1a = new JRadioButton("Maximizing gains");
		JRadioButton q1b = new JRadioButton("Minimizing losses");
		JRadioButton q1c = new JRadioButton("Both equally");
		if (q1selected == 1)
			q1a.setSelected(true);
		if (q1selected == 2)
			q1b.setSelected(true);
		if (q1selected == 3)
			q1c.setSelected(true);
		this.add(q1);
		this.add(q1a);
		this.add(q1b);
		this.add(q1c);

		q1ButtonGroup.add(q1a);
		q1ButtonGroup.add(q1b);
		q1ButtonGroup.add(q1c);

		JLabel q2 = new JLabel("<html>Q2: The global stock market is often volatile.<br> "
				+ "If your entire investment portfolio lost 10% of its value in a month during a market decline, what would you do?"
				+ " Your behavior during a market downturn is important to understanding your risk tolerance.</html>");
		q2.setBorder(new EmptyBorder(50, 0, 8, 0));
		ButtonGroup q2ButtonGroup = new ButtonGroup();
		JRadioButton q2a = new JRadioButton("Sell all of your investments");
		JRadioButton q2b = new JRadioButton("Sell some");
		JRadioButton q2c = new JRadioButton("Keep all");
		JRadioButton q2d = new JRadioButton("Buy more");
		if (q2selected == 1)
			q2a.setSelected(true);
		if (q2selected == 2)
			q2b.setSelected(true);
		if (q2selected == 3)
			q2c.setSelected(true);
		if (q2selected == 4)
			q2d.setSelected(true);

		this.add(q2);
		this.add(q2a);
		this.add(q2b);
		this.add(q2c);
		this.add(q2d);

		q2ButtonGroup.add(q2a);
		q2ButtonGroup.add(q2b);
		q2ButtonGroup.add(q2c);
		q2ButtonGroup.add(q2d);

		JLabel q3 = new JLabel(
				"Q3: How much short-term investment risk are you willing to take in order to achieve larger long-term investment returns?");
		q3.setBorder(new EmptyBorder(50, 0, 10, 0));
		ButtonGroup q3ButtonGroup = new ButtonGroup();
		JRadioButton q3a = new JRadioButton("I am not willing to take any risk");
		JRadioButton q3b = new JRadioButton("I am willing to take a small amount of risk with my investments");
		JRadioButton q3c = new JRadioButton("I am willing to take a moderate amount of risk with my investments");
		JRadioButton q3d = new JRadioButton("I am willing to take as much risk as is needed with my investments");

		if (q3selected == 1)
			q3a.setSelected(true);
		if (q3selected == 2)
			q3b.setSelected(true);
		if (q3selected == 3)
			q3c.setSelected(true);
		if (q3selected == 4)
			q3d.setSelected(true);

		this.add(q3);
		this.add(q3a);
		this.add(q3b);
		this.add(q3c);
		this.add(q3d);

		q3ButtonGroup.add(q3a);
		q3ButtonGroup.add(q3b);
		q3ButtonGroup.add(q3c);
		q3ButtonGroup.add(q3d);

		okButton = new JButton("OK");
		okButton.setVisible(false);
		add(okButton);
		okButton.setAlignmentY(CENTER_ALIGNMENT);
		okButton.addActionListener(new ActionListener() {

			// set scores for each multiple choice options
			@Override
			public void actionPerformed(ActionEvent e) {

				int point1 = 0;
				int point2 = 0;
				int point3 = 0;

				if (q1a.isSelected()) {
				 	point1 = 20;// make sure these are correct value for
								// calculation
					q1selected = 1;
				} else if (q1b.isSelected()) {
					point1 = 5;
					q1selected = 2;
				} else if (q1c.isSelected()) {
					point1 = 10;
					q1selected = 3;
				}
 
				if (q2a.isSelected()) {
					point2 += 0;// make sure these are correct value for
								// calculation
					q2selected = 1;
				} else if (q2b.isSelected()) {
					point2 = 5;
					q2selected = 2;
				} else if (q2c.isSelected()) {
					point2 = 10;
					q2selected = 3;
				} else if (q2d.isSelected()) {
					point2 = 20;
					q2selected = 4;
				}

				if (q3a.isSelected()) {
					point3 += 0;// make sure these are correct value for
								// calculation
					q3selected = 1;
				} else if (q3b.isSelected()) {
					point3 = 5;
					q3selected = 2;
				} else if (q3c.isSelected()) {
					point3 = 10;
					q3selected = 3;
				} else if (q3d.isSelected()) {
					point3 = 20;
					q3selected = 4;
				}

				// errorChecking
				if (q1selected == 0 && q2selected == 0 && q3selected == 0) {
					ErrorControl.setTolerancePanelError(true);

				} else {
					ErrorControl.setError(" ");
					ErrorControl.setTolerancePanelError(false);

					DataManager.setQuestion1(point1);
					DataManager.setQuestion2(point2);
					DataManager.setQuestion3(point3);

				}

				// System.out.println("sum is "+ sum);

			}
		});

		for (Component comp : this.getComponents()) {
			comp.setFont(new Font("Georgia", Font.PLAIN, 14));
		}

	}

}
