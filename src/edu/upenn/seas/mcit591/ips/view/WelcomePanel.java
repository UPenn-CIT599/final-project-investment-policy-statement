package edu.upenn.seas.mcit591.ips.view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class WelcomePanel extends JPanel {

	/*
	 * This class is the first screen the user encounters. This page displays the
	 * terms and conditions as a disclaimer of the product function from a legal
	 * perspective.
	 */

	private static final long serialVersionUID = -3365938643776092717L;

	public WelcomePanel() {

		Border innerBorder = BorderFactory.createTitledBorder("Welcome");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		
		String welcomeTitle = "Welcome to Investment Policy Statement (IPS) Planner!";
		
		JLabel welcomeLabel = new JLabel(welcomeTitle);
		welcomeLabel.setFont(new Font("Georgia", Font.BOLD, 30));
		welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		welcomeLabel.setBorder(new EmptyBorder(50, 0, 60, 0));
		this.add(welcomeLabel);
		
		String termsAndConditions = "<html>"
				+ "<h1>TERMS AND CONDITIONS</h1>"
				+ "<div style='font-size:13px;'>The purpose of this Investment Policy Statement (IPS) generator is to help you understand the investment goals <br />"
				+ "and objectives and management policies applicable to your investment portfolio (\"Portfolio\").<br />"
				+ "<br />This Investment Policy Statement will:<br />"
				+ "<ol>"
				+ "<li>Establish reasonable expectations, objectives and guidelines in the investment of your Port assets; </li>"
				+ "<li>describing an appropriate risk posture for the investment of your Portfolio; and </li>"
				+ "<li>specifying the target asset allocation policy.</li>"
				+ "</ol>"
				+ "<br />"
				+ "<ul>"
				+ "<li>This IPS is not a contract. This investment policy has not been reviewed by any legal counsel. </li>"
				+ "<li>This IPS is intended to be a summary of an investment philosophy and the procedures that provide guidance for you. </li>"
				+ "<li>The investment policies described in this IPS should be dynamic. </li>"
				+ "<li>These policies should reflect your current status and philosophy regarding the investment of the Portfolio. </li>"
				+ "<li>These policies should be reviewed and revised periodically to ensure they adequately reflect any changes related to your <br />"
				+ "Portfolio, to you, or to the capital markets. </li>"
				+ "<li>It is understood that there can be no guarantee about the attainment of the goals or investment objectives outlined herein.</li>"
				+ "<li>This IPS generator DOES NOT collect or share any data you provided.</li>"
				+ "</ul>"
				+ "<br /><br />By clicking 'Next' you agree to the <b>TERMS AND CONDITIONS</b> above."
				+ "</div></html>";
		
		JLabel termsAndConditionsLabel = new JLabel(termsAndConditions);

		termsAndConditionsLabel.setFont(new Font("Georgia", Font.PLAIN, 16));
		this.add(termsAndConditionsLabel);

	}
}
