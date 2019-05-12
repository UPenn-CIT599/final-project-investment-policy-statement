package edu.upenn.seas.mcit591.ips.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
 
public class RiskObjectivePanel extends JPanel {

	/*
	 * This class displays the analysis of the user's risk tolerance results
	 */
	
	
	private static final long serialVersionUID = 3237437573175694458L;

	public int getSum() {
		return RiskTolerancePanel.getSum();
	}

	public RiskObjectivePanel() {

		Border innerBorder = BorderFactory.createTitledBorder("Risk Objective");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel label1 = new JLabel(
				"<html>Here is your risk profile, including your willingness to tolerate risk and your ability to tolerate risk.</html>");
		label1.setFont(new Font("Georgia", Font.PLAIN, 16));
		label1.setBorder(new EmptyBorder(30, 0, 20, 0));
		this.add(label1);

		int sum = getSum();
		System.out.println(sum);
		JLabel label2 = new JLabel(
				"<html>Your overall risk score is <em>" + DataManager.getRiskScore() + "</em> out of 10.</html>");
		label2.setFont(new Font("Georgia", Font.BOLD, 16));
		label2.setBorder(new EmptyBorder(30, 0, 20, 0));
		this.add(label2);

		JLabel label3 = new JLabel("<html>Your willingness to take risk is <em>" + DataManager.getWillingnessAssesment()
				+ "</em>. Your ability to take risk is <em>" + DataManager.getAbilityAssesment() + "</em>.</html>");
		label3.setFont(new Font("Georgia", Font.BOLD, 16));
		label3.setBorder(new EmptyBorder(30, 0, 20, 0));
		this.add(label3);

		if (DataManager.getWillingAndAbilityEquality() == true) {
			JLabel label4 = new JLabel(
					"<html><font color='red'>Your ability to take investment risk is not consistent with your willingness to take investment risk. We recomend you to balance these two options.</red></html>");
			label4.setFont(new Font("Georgia", Font.BOLD, 16));
			label4.setBorder(new EmptyBorder(30, 0, 10, 0));
			this.add(label4);
		}

		JLabel label5 = new JLabel("Factors that impact your recommended risk score: ");
		label5.setFont(new Font("Georgia", Font.BOLD, 14));
		label5.setBorder(new EmptyBorder(30, 0, 10, 0));
		this.add(label5);

		JLabel label6 = new JLabel("<html>More risk usually means higher expected returns over the long term, "
				+ "but bigger ups and downs along the way. "
				+ "<br> Too much risk could leave you at a loss when you need the money, but too little may mean slower growth. "
				+ "<br> We calculate the right balance for you based on:</html>");
		label6.setFont(new Font("Georgia", Font.PLAIN, 14));
		this.add(label6);

		JLabel label7 = new JLabel("(1) How long you have to invest:");
		label7.setFont(new Font("Georgia", Font.PLAIN, 14));
		label7.setBorder(new EmptyBorder(30, 0, 10, 0));
		this.add(label7);

		JLabel label8 = new JLabel(
				"The younger you are, the longer you have for your portfolio to rebound from a significant downturn.");
		label8.setFont(new Font("Georgia", Font.PLAIN, 14));
		this.add(label8);

		JLabel label9 = new JLabel("(2)Your financial capacity for risk:");
		label9.setFont(new Font("Georgia", Font.PLAIN, 14));
		label9.setBorder(new EmptyBorder(30, 0, 10, 0));
		this.add(label9);

		JLabel label10 = new JLabel(
				"The more comfortable your finances, the more risk you can afford to take, and vice versa.");
		label10.setFont(new Font("Georgia", Font.PLAIN, 14));
		this.add(label10);

		JLabel label11 = new JLabel("(3) Your personal comfort zone:");
		label11.setFont(new Font("Georgia", Font.PLAIN, 14));
		label11.setBorder(new EmptyBorder(30, 0, 10, 0));
		this.add(label11);

		JLabel label12 = new JLabel(
				"<html>Ups and downs come standard in long-term investing, but not everyone is comfortable riding out the downturns. "
						+ "<br>Since the best long-term plan is one you can stick with, we consider your willingness to take risk and endure the ups and downs of the market.</html>");
		label12.setFont(new Font("Georgia", Font.PLAIN, 16));
		this.add(label12);

	}

}
