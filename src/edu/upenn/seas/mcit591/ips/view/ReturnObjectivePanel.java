package edu.upenn.seas.mcit591.ips.view;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ReturnObjectivePanel extends JPanel {
	
	private static final long serialVersionUID = -1922861097867949730L;

	public ReturnObjectivePanel(){
		
		Border innerBorder = BorderFactory.createTitledBorder("Return Objective");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel label1 = new JLabel("<html>Based on the information you provided, here is a listing of your required rate of return (//after tax or before tax ) is: </html>");
        label1.setFont(new Font("Bell MT", Font.BOLD, 25));
        label1.setBorder(new EmptyBorder(50, 0, 30, 0));
        this.add(label1);
        
        JLabel label2 = new JLabel("<html>For the retirement amount you entered, your after-tax required rate of return is ___% at the age of 65.</html>");
        label2.setFont(new Font("Bell MT", Font.BOLD, 25));
        label2.setBorder(new EmptyBorder(50, 0, 30, 0));
        this.add(label2);
        
        JLabel label3 = new JLabel("<html>From ____ to ____, your required rate of return is ___%. By the end of ___, you will have an estimated asset of $___.</html>");
        label3.setFont(new Font("Bell MT", Font.BOLD, 25));
        label3.setBorder(new EmptyBorder(50, 0, 90, 0));
        this.add(label3);
        
	}

}
