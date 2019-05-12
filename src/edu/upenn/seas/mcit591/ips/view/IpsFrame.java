package edu.upenn.seas.mcit591.ips.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.commons.lang3.StringUtils;

import edu.upenn.seas.mcit591.ips.main.MyCardLayout;

public class IpsFrame extends JFrame {

	private static final long serialVersionUID = 3963422631779874066L;

	private int currentCard = 1;

	private CardLayout cl;
	
	public JPanel cardPanel; 
 	
	public IpsFrame() {

		setTitle("Investment Policy Statement (IPS) Planner");

		this.cardPanel = getCardPanel();
		getContentPane().add(cardPanel, BorderLayout.CENTER);
        // Function to set buttons 
		JPanel buttonPanel = createButtonPanel(cardPanel);
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
		this.pack();
		// Function to set default operation of JFrame. 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
        // Function to set visibility of JFrame. 
        this.setVisible(true); 
        

	}
	
	private JPanel getCardPanel() {

		JPanel cardPanel = new JPanel();

		// Set CardLayout to cardPanel.
		cl = new MyCardLayout();
		cardPanel.setLayout(cl);

		drawCards(cardPanel);
		
		return cardPanel;
	}

	private void drawCards(JPanel cardPanel) {
		
		/**
		 * 1. Welcome Panel 
		 * 2. Personal Info Panel 
		 * 3. Risk Tolerance Panel 
		 * 4. Risk Objective Panel 
		 * 5. Return Objective Panel 
		 * 6. Recommend Portfolio Panel
		 */
		
		String[] panels = {"welcomePanel", 
				"personalInfoPanel", 
				"riskTolerancePanel", 
				"riskTolerancePanel2",
				"riskObjectivePanel",
				"returnObjectivePanel", 
				"recommendPortfolioPanel"
				};
		for(Component c : cardPanel.getComponents()) {
			if(Arrays.asList(panels).contains(c.getName())) {
				cardPanel.remove(c);
			}
		}
		
		// 1st panel
		JPanel welcomePanel = new WelcomePanel();
		welcomePanel.setName("welcomePanel");
		welcomePanel.setPreferredSize(new Dimension(1200, 780));
		cardPanel.add(welcomePanel, "1");

		// 2nd Panel
		JPanel personalInfoPanel = new PersonalInfoPanel();
		personalInfoPanel.setName("personalInfoPanel");
		personalInfoPanel.setPreferredSize(new Dimension(1200, 780));
		cardPanel.add(personalInfoPanel, "2");

		// 3rd Panel
		JPanel riskTolerancePanel = new RiskTolerancePanel();
		riskTolerancePanel.setName("riskTolerancePanel");
		riskTolerancePanel.setPreferredSize(new Dimension(1200, 780));
		cardPanel.add(riskTolerancePanel, "3");
		
		// 4rd Panel
		JPanel riskTolerancePanel2 = new RiskTolerancePanel2();
		riskTolerancePanel2.setName("riskTolerancePanel2");
		riskTolerancePanel2.setPreferredSize(new Dimension(1200, 780));
		cardPanel.add(riskTolerancePanel2, "4");

		// 5th Panel
		JPanel riskObjectivePanel = new RiskObjectivePanel();
		riskObjectivePanel.setName("riskObjectivePanel");
		riskObjectivePanel.setPreferredSize(new Dimension(1200, 780));
		cardPanel.add(riskObjectivePanel, "5");
		
		// 6th panel
		JPanel returnObjectivePanel = new ReturnObjectivePanel();
		returnObjectivePanel.setName("returnObjectivePanel");
		returnObjectivePanel.setPreferredSize(new Dimension(1200, 780));
		cardPanel.add(returnObjectivePanel, "6");

		// 7th panel
		JPanel recommendPortfolioPanel = new RecommendPortfolioPanel();
		recommendPortfolioPanel.setName("recommendPortfolioPanel");
		recommendPortfolioPanel.setPreferredSize(new Dimension(880, 780));
		cardPanel.add(recommendPortfolioPanel, "7");
		
	}
	
// This is to set buttons panel 
	private JPanel createButtonPanel(JPanel cardPanel) {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEtchedBorder());
		JButton startBtn = new JButton("Start");
		startBtn.setFont(new Font("Georgia", Font.PLAIN, 20));
		startBtn.setPreferredSize(new Dimension(100, 40));
		JButton nextBtn = new JButton("Next");
		nextBtn.setPreferredSize(new Dimension(100, 40));
		nextBtn.setFont(new Font("Georgia", Font.PLAIN, 20));
		JButton previousBtn = new JButton("Previous");
		previousBtn.setPreferredSize(new Dimension(150, 40));
		previousBtn.setFont(new Font("Georgia", Font.PLAIN, 20));
		JButton exitBtn = new JButton("Exit");
		exitBtn.setPreferredSize(new Dimension(100, 40));
		exitBtn.setFont(new Font("Georgia", Font.PLAIN, 20));
		
		buttonPanel.add(startBtn);
		buttonPanel.add(nextBtn);
		buttonPanel.add(previousBtn);
		buttonPanel.add(exitBtn);

		// add startbtn in ActionListener
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// used first c1 CardLayout
				cl.first(cardPanel);

				// value of currentcard is 1
				currentCard = 1;
				
				Dimension dim = new Dimension(1200, 1000);
                setPreferredSize(dim);
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        pack();
                    }
                });
			}
		});

		// add exitbtn in ActionListener
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// exit the program
				 System.exit(0);
				
				Dimension dim = new Dimension(1200, 1000);
                setPreferredSize(dim);
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        pack();
                    }
                });
			}
		});
		
		
		// add nextbtn in ActionListener
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Sets data variables and updates cards 6 and 7 with proper info
				if(currentCard == 4) {
					
					for( Component c : cardPanel.getComponents() ) {
						if(StringUtils.equals("riskTolerancePanel2", c.getName())) {
							RiskTolerancePanel2 p2  = (RiskTolerancePanel2) c;
							p2.okButton.doClick();
						}
					}
					
					TimeValueOfMoney newCalculation = new TimeValueOfMoney();
					
					newCalculation.calculateIRR(DataManager.getCurrentAssetHolding(), DataManager.getfutureValue(), DataManager.getAnnuity(), DataManager.getNumberofYears());
					RiskScore newScore = new RiskScore();
					newScore.setQuestionAnswers();
					DataManager.setRiskScoreVar();
					DataManager.setWillingAndAbilityEquality();
					DataManager.setIRR();
					DataManager.setString();
					SuggestedAllocation percents = new SuggestedAllocation();
					double[] percent = percents.getBenchmarkCoefficient(DataManager.getRiskScore());
					FutureValueCalc finalValue = new FutureValueCalc();
					double FutureValue = finalValue.calculateFuturetValue(DataManager.getCurrentAssetHolding(), DataManager.getAnnuity(), DataManager.getNumberofYears(), DataManager.getIRR());
					DataManager.setFutureValue(FutureValue);
					DataManager.setFundPercent(percent);
					DataManager.setTableForAllocation();
					FinanceEquations newPortfolioReturn = new FinanceEquations();
					DataManager.setPortfolioReturn(newPortfolioReturn.getPortfolioReturn(DataManager.getFundPercent()));
					DataManager.setPortfolioStdDev(newPortfolioReturn.getPortfolioStandardDeviation((DataManager.getFundPercent())));
					
					cardPanel.revalidate();
					cardPanel.repaint();
					drawCards(cardPanel);
				}
				
				if(currentCard == 2) {
					for( Component c : cardPanel.getComponents() ) {
						if(StringUtils.equals("personalInfoPanel", c.getName())) {
							PersonalInfoPanel p  = (PersonalInfoPanel) c;
							p.formPanel.okBtn.doClick();
						}
					}
				}
				
				if(currentCard == 3) {
					for( Component c : cardPanel.getComponents() ) {
						if(StringUtils.equals("riskTolerancePanel", c.getName())) {
							RiskTolerancePanel p  = (RiskTolerancePanel) c;
							p.okButton.doClick();
						}
					}
				}
				
				if(currentCard == 7) {

					// exit the program
					 System.exit(0);
				}
				
				if (currentCard < 7) {
					//ErrorControl
					if(ErrorControl.errorCheck(currentCard)) {
						cardPanel.revalidate();
						cardPanel.repaint();
						drawCards(cardPanel);
					} else {
					// increment the value of currentcard by 1
					currentCard += 1;
					}
					cardPanel.revalidate();
					cardPanel.repaint();
					drawCards(cardPanel);
					
					// show the value of currentcard
					cl.show(cardPanel, "" + (currentCard));
				}
				
				Dimension dim = new Dimension();
                for (Component comp : cardPanel.getComponents()) {
                	
                    if (comp.isVisible() == true) {
                        dim = comp.getPreferredSize();
                        
                    }
                }
                setPreferredSize(dim);
                java.awt.EventQueue.invokeLater(new Runnable() {

                    public void run() {
                        pack();
                    }
                });
			}
		});

		// add previousbtn in ActionListener
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if condition apply
				
				if (currentCard > 1) {

					// decrement the value
					// of currentcard by 1
					currentCard -= 1;

					// show the value of currentcard
					cl.show(cardPanel, "" + (currentCard));
				}
				
				Dimension dim = new Dimension();
                for (Component comp : cardPanel.getComponents()) {
                    if (comp.isVisible() == true) {
                        dim = comp.getPreferredSize();
                    }
                }
                setPreferredSize(dim);
                java.awt.EventQueue.invokeLater(new Runnable() {

                    public void run() {
                        pack();
                    }
                });
			}
		});
		return buttonPanel;
	}
	
	
	
	
}
