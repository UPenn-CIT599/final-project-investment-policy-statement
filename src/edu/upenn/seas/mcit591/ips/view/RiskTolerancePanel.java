package edu.upenn.seas.mcit591.ips.view;

import java.awt.Component;
import java.awt.Dimension;
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

	private JButton okButton;

	private static final long serialVersionUID = 7133849259611110654L;

	public RiskTolerancePanel() {

		Border innerBorder = BorderFactory.createTitledBorder("Risk Tolerance");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel label1 = new JLabel(
				"<html>The following questionnaire can help assess your risk tolerance in investing activities."
						+ "Your risk tolerance has two parts: willingness to take risk and ability to take risk.</html>");
		label1.setBorder(new EmptyBorder(50, 0, 10, 0));
		this.add(label1);

		JLabel q1 = new JLabel(
				"<html>Q1: When deciding how to invest your money, which do you care about more?</html>");
		q1.setBorder(new EmptyBorder(50, 0, 10, 0));
		ButtonGroup q1ButtonGroup = new ButtonGroup();
		JRadioButton q1a = new JRadioButton("Maximizing gains");
		JRadioButton q1b = new JRadioButton("Minimizing losses");
		JRadioButton q1c = new JRadioButton("Both equally");
		this.add(q1);
		this.add(q1a);
		this.add(q1b);
		this.add(q1c);

		q1ButtonGroup.add(q1a);
		q1ButtonGroup.add(q1b);
		q1ButtonGroup.add(q1c);

		JLabel q2 = new JLabel("<html>Q2: The global stock market is often volatile.<br> "
				+ "If your entire investment portfolio lost 10% of its value in a month during a market decline, what would you do?<br> "
				+ "Your behavior during a market downturn is important to understanding your risk tolerance.</html>");
		q2.setBorder(new EmptyBorder(50, 0, 10, 0));
		ButtonGroup q2ButtonGroup = new ButtonGroup();
		JRadioButton q2a = new JRadioButton("Sell all of your investments");
		JRadioButton q2b = new JRadioButton("Sell some");
		JRadioButton q2c = new JRadioButton("Keep all");
		JRadioButton q2d = new JRadioButton("Buy more");
		this.add(q2);
		this.add(q2a);
		this.add(q2b);
		this.add(q2c);
		this.add(q2d);

		q2ButtonGroup.add(q2a);
		q2ButtonGroup.add(q2b);
		q2ButtonGroup.add(q2c);
		q2ButtonGroup.add(q2d);

		JLabel q3 = new JLabel("Q3: What is your household profile?");
		q3.setBorder(new EmptyBorder(50, 0, 10, 0));
		ButtonGroup q3ButtonGroup = new ButtonGroup();
		JRadioButton q3a = new JRadioButton("Single income, no dependents");
		JRadioButton q3b = new JRadioButton("Single income, at least one dependent");
		JRadioButton q3c = new JRadioButton("Dual income, no dependents");
		JRadioButton q3d = new JRadioButton("Dual income, at least one dependent");
		JRadioButton q3e = new JRadioButton("Retired");
		JRadioButton q3f = new JRadioButton("Financially independent");
		this.add(q3);
		this.add(q3a);
		this.add(q3b);
		this.add(q3c);
		this.add(q3d);
		this.add(q3e);
		this.add(q3f);

		q3ButtonGroup.add(q3a);
		q3ButtonGroup.add(q3b);
		q3ButtonGroup.add(q3c);
		q3ButtonGroup.add(q3d);
		q3ButtonGroup.add(q3e);
		q3ButtonGroup.add(q3f);

		okButton = new JButton("OK");
		add(okButton);
		okButton.setAlignmentY(CENTER_ALIGNMENT);
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int point1 = 0;
				int point2 = 0;
				int point3 = 0;
				int sum = 0;// keep track of the user selection with appointed
							// value

				if (q1a.isSelected()) {
					point1 += 20;// make sure these are correct value for
									// calculation
				} else if (q1b.isSelected()) {
					point1 += 0;
				} else if (q1c.isSelected()) {
					point1 += 10;
				}

				if (q2a.isSelected()) {
					point2 += 0;// make sure these are correct value for
								// calculation
				} else if (q2b.isSelected()) {
					point2 += 5;
				} else if (q2c.isSelected()) {
					point2 += 10;
				} else if (q2d.isSelected()) {
					point2 += 20;
				}

				if (q3a.isSelected()) {
					point3 += 20;// make sure these are correct value for
									// calculation
				} else if (q3b.isSelected()) {
					point3 += 10;
				} else if (q3c.isSelected()) {
					point3 += 20;
				} else if (q3d.isSelected()) {
					point3 += 10;
				} else if (q3e.isSelected()) {
					point3 += 10;
				} else if (q3f.isSelected()) {
					point3 += 20;
				}

				sum = point1 + point2 + point3;
				// System.out.println("sum is "+ sum);

			}
		});
		
		for(Component comp: this.getComponents()) {
			comp.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		
	}

}
