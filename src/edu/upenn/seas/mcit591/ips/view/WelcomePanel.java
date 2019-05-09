package edu.upenn.seas.mcit591.ips.view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Border innerBorder = BorderFactory.createTitledBorder("Welcome");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		JTextField txtWelcome = new JTextField();
		txtWelcome.setText("Welcome to Investment Policy Statement (IPS) Planner!");
		txtWelcome.setFont(new Font("Georgia", Font.BOLD, 30));
		txtWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);
		txtWelcome.setEditable(false);
		txtWelcome.setBorder(new EmptyBorder(50, 50, 10, 0));// top, left, bottom, right
		this.add(txtWelcome);

		JTextArea txtPurpose = new JTextArea();
		txtPurpose.setText("TERMS AND CONDITIONS"
				+ "\r\n\r\nThe purpose of this Investment Policy Statement (IPS) generator is to help you understand the investment goals and objectives and management"
				+ "\r\n\r\npolicies applicable to your investment portfolio (“Portfolio”)."
				+ "\r\n\r\nThis Investment Policy Statement will:\r\n\r\n(1) establish reasonable expectations, objectives and guidelines in the investment of your Portfolio’s assets; "
				+ "\r\n\r\n(2) describing an appropriate risk posture for the investment of your Portfolio; and "
				+ "\r\n\r\n(3) specifying the target asset allocation policy."
				+ "\r\n\r\n\r\n\r\nThis IPS is not a contract. This investment policy has not been reviewed by any legal counsel. This IPS is intended to be a summary of an "
				+ "\r\n\r\ninvestment philosophy and the procedures that provide guidance for you. The investment policies described in this IPS should be dynamic. These   "
				+ "\r\n\r\npolicies should reflect your current status and philosophy regarding the investment of the Portfolio. These policies should be reviewed and "
				+ "\r\n\r\nrevised periodically to ensure they adequately reflect any changes related to your Portfolio, to you, or to the capital markets. It is understood"
				+ "\r\n\r\nthat there can be no guarantee about the attainment of the goals or investment objectives outlined herein."
				+ "\r\n\r\nThis IPS generator DOES NOT collect or share any data you provided."
				+ "\r\n\r\n\r\n\r\nBy clicking 'Next' you agree to the TERMS AND CONDITIONS above.");
		txtPurpose.setEditable(false);
		txtPurpose.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtPurpose.setBorder(new EmptyBorder(50, 50, 10, 0));
		this.add(txtPurpose);

		JScrollPane scroll = new JScrollPane(txtPurpose, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(scroll);

	}
}
