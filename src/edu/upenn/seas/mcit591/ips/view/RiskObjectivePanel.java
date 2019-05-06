package edu.upenn.seas.mcit591.ips.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class RiskObjectivePanel extends JPanel {
	JLabel label2 = new JLabel("<html>Willingness: your risk score is __ out of ___</html>");
	private static final long serialVersionUID = 3237437573175694458L;
	
	public int getSum() {
		return RiskTolerancePanel.getSum();
	}
	
	
	public RiskObjectivePanel(){
		
		
		Border innerBorder = BorderFactory.createTitledBorder("Risk Obejective");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel label1 = new JLabel("<html>Here is your risk profile, including your willingness to tolerate risk and your ability to tolerate risk.</html>");
        label1.setFont(new Font("Arial", Font.PLAIN, 18));
        label1.setBorder(new EmptyBorder(50, 0, 30, 0));
        this.add(label1);
        
        int sum = getSum();
        System.out.println(sum);
        this.label2.setText("<html>Willingness: your risk score is" + sum + "out of ___</html>");
        label2.setFont(new Font("Bell MT", Font.BOLD, 25));
        label2.setBorder(new EmptyBorder(50, 0, 30, 0));
        this.add(label2);
        
        JLabel label3 = new JLabel("<html>Ability: your risk score is __ out of __ </html>");
        label3.setFont(new Font("Bell MT", Font.BOLD, 25));
        label3.setBorder(new EmptyBorder(50, 0, 50, 0));
        this.add(label3);
        
        JLabel label4 = new JLabel("Illustration");
        label4.setFont(new Font("Bell MT", Font.BOLD, 20));
        label4.setBorder(new EmptyBorder(50, 0, 10, 0));
        label4.setForeground(Color.darkGray);
        this.add(label4);
        
        JLabel label5 = new JLabel("The recommended amount of risk ");
        label5.setFont(new Font("Bell MT", Font.BOLD, 18));
        label5.setBorder(new EmptyBorder(20, 0, 10, 0));
        label5.setForeground(Color.darkGray);
        this.add(label5);
       
        JLabel label6 = new JLabel("<html>More risk usually means higher expected returns over the long term, "
        		+ "but bigger ups and downs along the way. "
        		+ "<br> Too much risk could leave you at a loss when you need the money, but too little may mean slower growth. "
        		+ "<br> We calculate the right balance for you based on:</html>");
        label6.setForeground(Color.darkGray);
        label6.setFont(new Font("Arial", Font.PLAIN, 17));
        this.add(label6);
        
        JLabel label7 = new JLabel("How long you have to invest");
        label7.setFont(new Font("Bell MT", Font.BOLD, 18));
        label7.setForeground(Color.darkGray);
        label7.setBorder(new EmptyBorder(20, 0, 10, 0));
        this.add(label7);
        
        JLabel label8 = new JLabel("<html>The younger you are, the longer you have for your portfolio to rebound from a significant downturn.</html>");
        label8.setForeground(Color.darkGray);
        label8.setFont(new Font("Arial", Font.PLAIN, 17));
        this.add(label8);
        
        JLabel label9 = new JLabel("Your financial capacity for risk");
        label9.setFont(new Font("Bell MT", Font.BOLD, 18));
        label9.setBorder(new EmptyBorder(20, 0, 10, 0));
        label9.setForeground(Color.darkGray);
        this.add(label9);
        
        JLabel label10 = new JLabel("<html>The more comfortable your finances, the more risk you can afford to take, and vice versa.</html>");
        label10.setForeground(Color.darkGray);
        label10.setFont(new Font("Arial", Font.PLAIN, 17));
        this.add(label10);
        
        JLabel label11 = new JLabel("Your personal comfort zone");
        label11.setFont(new Font("Bell MT", Font.BOLD, 18));
        label11.setBorder(new EmptyBorder(20, 0, 10, 0));
        label11.setForeground(Color.darkGray);
        this.add(label11);
        
        JLabel label12 = new JLabel("<html>Ups and downs come standard in long-term investing, but not everyone is comfortable riding out the downturns. "
        		+ "<br>Since the best long-term plan is one you can stick with, we consider your willingness to take risk and endure the ups and downs of the market.");
        label12.setFont(new Font("Arial", Font.PLAIN, 17));
        label12.setForeground(Color.darkGray);
        this.add(label12);
        
	}

}
