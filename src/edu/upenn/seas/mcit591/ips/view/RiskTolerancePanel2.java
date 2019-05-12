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

public class RiskTolerancePanel2 extends JPanel {

	// declare variables to collect user scores
	public static int q1selected = 0;
	public static int q2selected = 0;
	public static int q3selected = 0;
	
	public JButton okButton;

	private static final long serialVersionUID = 7133849259611110654L;
	
	// design the display of the questionnaire 
	public RiskTolerancePanel2() {

		Border innerBorder = BorderFactory.createTitledBorder("Risk Tolerance");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel label1 = new JLabel(
				"<html>The following questionnaire is a continuation from the previous page."
				+ "<font color='red'>"+ ErrorControl.getError() +"</font></html>");
		label1.setBorder(new EmptyBorder(50, 0, 10, 0));
		this.add(label1);

		JLabel q1 = new JLabel(
				"<html>Q4: I would describe my knowledge of investments as...</html>");
		q1.setBorder(new EmptyBorder(50, 0, 10, 0));
		ButtonGroup q1ButtonGroup = new ButtonGroup();
		JRadioButton q1a = new JRadioButton("None");
		JRadioButton q1b = new JRadioButton("Limited");
		JRadioButton q1c = new JRadioButton("Good");
		JRadioButton q1d = new JRadioButton("Extensive");
		if(q1selected == 1) q1a.setSelected(true);
		if(q1selected == 2) q1b.setSelected(true);
		if(q1selected == 3) q1c.setSelected(true);
		if(q1selected == 4) q1d.setSelected(true);
		this.add(q1);
		this.add(q1a);
		this.add(q1b);
		this.add(q1c);
		this.add(q1d);

		q1ButtonGroup.add(q1a);
		q1ButtonGroup.add(q1b);
		q1ButtonGroup.add(q1c);
		q1ButtonGroup.add(q1d);
		
		JLabel q2 = new JLabel("<html>Q5: What is your household profile? </html>");
		q2.setBorder(new EmptyBorder(50, 0, 10, 0));
		ButtonGroup q2ButtonGroup = new ButtonGroup();
		JRadioButton q2a = new JRadioButton("Single income, no dependents");
		JRadioButton q2b = new JRadioButton("Single income, at least one dependent");
		JRadioButton q2c = new JRadioButton("Dual income, no dependents");
		JRadioButton q2d = new JRadioButton("Dual income, at least one dependent");
		JRadioButton q2e = new JRadioButton("Retired");
		JRadioButton q2f = new JRadioButton("Financially independent");
		if(q2selected == 1) q2a.setSelected(true);
		if(q2selected == 2) q2b.setSelected(true);
		if(q2selected == 3) q2c.setSelected(true);
		if(q2selected == 4) q2d.setSelected(true);
		if(q2selected == 5) q2e.setSelected(true);
		if(q2selected == 6) q2f.setSelected(true);
		
		this.add(q2);
		this.add(q2a);
		this.add(q2b);
		this.add(q2c);
		this.add(q2d);
		this.add(q2e);
		this.add(q2f);

		q2ButtonGroup.add(q2a);
		q2ButtonGroup.add(q2b);
		q2ButtonGroup.add(q2c);
		q2ButtonGroup.add(q2d);
		q2ButtonGroup.add(q2e);
		q2ButtonGroup.add(q2f);

		JLabel q3 = new JLabel("Q6: What is your main current asset holding?");
		q3.setBorder(new EmptyBorder(50, 0, 10, 0));
		ButtonGroup q3ButtonGroup = new ButtonGroup();
		JRadioButton q3a = new JRadioButton("Cash");
		JRadioButton q3b = new JRadioButton("Bonds and/or bond funds ");
		JRadioButton q3c = new JRadioButton("Stocks and/or stock funds");
		JRadioButton q3d = new JRadioButton("International securities and/ or international funds");
		
		if(q3selected == 1) q3a.setSelected(true);
		if(q3selected == 2) q3b.setSelected(true);
		if(q3selected == 3) q3c.setSelected(true);
		if(q3selected == 4) q3d.setSelected(true);

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

			@Override
			public void actionPerformed(ActionEvent e) {

				int point1 = 0;
				int point2 = 0;
				int point3 = 0;

				if (q1a.isSelected()) {
					q1selected = 1;
					point1 = 0;// make sure these are correct value for
									// calculation
				} else if (q1b.isSelected()) {
					q1selected = 2;
					point1 = 5;
				} else if (q1c.isSelected()) {
					q1selected = 3;
					point1 = 10;
				}else if(q1d.isSelected()) {
					q1selected = 4;
					point1 = 20;
				}

				if (q2a.isSelected()) {
					q2selected = 1;
					point2 = 10;// make sure these are correct value for
								// calculation
				} else if (q2b.isSelected()) {
					q2selected = 2;
					point2 = 0;
				} else if (q2c.isSelected()) {
					q2selected = 3;
					point2 = 20;
				} else if (q2d.isSelected()) {
					q2selected = 4;
					point2 = 5;
				} else if (q2e.isSelected()) {
					q2selected = 5;
					point2 = 10;
				} else if (q2f.isSelected()) {
					q2selected =6;
					point2 = 20;
				}


				if (q3a.isSelected()) {
					q3selected = 1;
					point3 = 0;// make sure these are correct value for
									// calculation
				} else if (q3b.isSelected()) {
					q3selected = 2;
					point3 = 5;
				} else if (q3c.isSelected()) {
					q3selected = 3;
					point3 = 10;
				} else if (q3d.isSelected()) {
					q3selected = 4;
					point3 = 20;
				}
				

				if(q1selected==0 && q2selected==0 && q3selected==0) {
					ErrorControl.setTolerancePanelError(true);

				}else {
					ErrorControl.setError(" ");
				ErrorControl.setTolerancePanelError(false);
				
				
				DataManager.setQuestion4(point1);
				DataManager.setQuestion5(point2);
				DataManager.setQuestion6(point3);
				
				}
				
			}
		});
		
		for(Component comp: this.getComponents()) {
			comp.setFont(new Font("Georgia", Font.PLAIN, 14));
		}
		
	}

}
