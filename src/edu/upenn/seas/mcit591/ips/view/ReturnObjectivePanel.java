package edu.upenn.seas.mcit591.ips.view;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


/*
 * This class designs part of display on the Return Objective Panel 
 */
 

public class ReturnObjectivePanel extends JPanel {
	
	private static final long serialVersionUID = -1922861097867949730L;
	
	public ReturnObjectivePanel(){
		
		Border innerBorder = BorderFactory.createTitledBorder("Return Objective");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel label1 = new JLabel(DataManager.getIRRstring());
        label1.setFont(new Font("Georgia", Font.BOLD, 16));
        label1.setBorder(new EmptyBorder(50, 0, 30, 0));
        this.add(label1);
        
        JLabel label3 = new JLabel("<html>During the next "+ DataManager.getAge() + " years investment horizon, your annual required rate of return is <font color='red'>" + String.format("%.2f", DataManager.getIRR()*100) + "</font>%. If this return is achievable, by the end of " + (Calendar.getInstance().get(Calendar.YEAR) + DataManager.getNumberofYears())  + ", you will have an estimated asset of $"+ String.format("%.2f", DataManager.getFutureValue())+".</html>");
        label3.setFont(new Font("Georgia", Font.BOLD, 16));
        label3.setBorder(new EmptyBorder(50, 0, 90, 0));
        this.add(label3);
        
        JLabel label2 = new JLabel(DataManager.getIRRString2());
        label2.setFont(new Font("Georgia", Font.BOLD, 16));
        label2.setBorder(new EmptyBorder(50, 0, 30, 0));
        this.add(label2);
        
	}

}
