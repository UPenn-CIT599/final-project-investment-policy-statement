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

	private static final long serialVersionUID = -3365938643776092717L;

	public WelcomePanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Border innerBorder = BorderFactory.createTitledBorder("Welcome");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		
        
        JTextField txtWelcome = new JTextField();
        txtWelcome.setText("Welcome to Wealth Organizer");
        txtWelcome.setFont(new Font("Bell MT",Font.BOLD, 50));
        txtWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtWelcome.setEditable(false);
        txtWelcome.setBorder(new EmptyBorder(50, 50, 10, 0));//top, left, bottom, right
        this.add(txtWelcome);
        
        JTextArea txtPurpose = new JTextArea();
        txtPurpose.setText("The purpose of this Investment Policy Statement (IPS) generator is to help you understand  the investment goals "
        		+ "\r\n\r\nand objectives and management policies applicable to your investment portfolio (“Portfolio”)."
        		+ "\r\n\r\nThis Investment Policy Statement will:\r\n\r\n(1) establish reasonable expectations, objectives and guidelines in the investment of your Portfolio’s assets; "
        		+ "\r\n\r\n(2) describing an appropriate risk posture for the investment of your Portfolio; and "
        		+ "\r\n\r\n(3) specifying the target asset allocation policy."
        		+ "\r\n\r\n\r\n\r\nThis IPS is not a contract. \r\n\r\nThis investment policy has not been reviewed by any legal counsel. "
        		+ "\r\n\r\nThis IPS is intended to be a summary of an investment philosophy and the procedures that provide guidance for you. "
        		+ "\r\n\r\nThe investment policies described in this IPS should be dynamic. "
        		+ "\r\n\r\nThese policies should reflect your current status and philosophy regarding the investment of the Portfolio. "
        		+ "\r\n\r\nThese policies should be reviewed and revised periodically to ensure they adequately reflect any changes related to your Portfolio, \r\n\r\nto you, or to the capital markets. "
        		+ "\r\n\r\nIt is understood that there can be no guarantee about the attainment of the goals or investment objectives outlined herein."
        		+ "\r\n\r\nThis IPS generator DOES NOT collect or share any data you provided.");
        txtPurpose.setEditable(false);
        txtPurpose.setFont(new Font("Arial", Font.PLAIN, 16));
        txtPurpose.setBorder(new EmptyBorder(50, 50, 10, 0));
        this.add(txtPurpose);
        
        JScrollPane scroll = new JScrollPane (txtPurpose, 
        		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(scroll);
        
	}
}
