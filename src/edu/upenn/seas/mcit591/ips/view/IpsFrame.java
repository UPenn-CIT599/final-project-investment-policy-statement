package edu.upenn.seas.mcit591.ips.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.upenn.seas.mcit591.ips.main.MyCardLayout;
import java.awt.Insets;

public class IpsFrame extends JFrame {

	private static final long serialVersionUID = 3963422631779874066L;

	private int currentCard = 1;

	private CardLayout cl;
	
	
	public JPanel cardPanel; 
	
	
	public IpsFrame() {

		setTitle("Investment Policy Statement (IPS) Planner");

		this.cardPanel = getCardPanel();
		getContentPane().add(cardPanel, BorderLayout.CENTER);

		JPanel buttonPanel = createButtonPanel(cardPanel);
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
		this.pack();
		// Function to set default operation of JFrame. 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
        // Function to set visibility of JFrame. 
        this.setVisible(true); 
        
        this.setLocation(150, 150);
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
		
		// 1st panel
		JPanel welcomePanel = new WelcomePanel();
		welcomePanel.setPreferredSize(new Dimension(1200, 1000));
		cardPanel.add(welcomePanel, "1");

		// 2nd Panel
		JPanel personalInfoPanel = new PersonalInfoPanel();
		personalInfoPanel.setPreferredSize(new Dimension(800, 800));
		cardPanel.add(personalInfoPanel, "2");

		// 3rd Panel
		JPanel riskTolerancePanel = new RiskTolerancePanel();
		riskTolerancePanel.setPreferredSize(new Dimension(800, 1000));
		cardPanel.add(riskTolerancePanel, "3");
		
		// 4rd Panel
		JPanel riskTolerancePanel2 = new RiskTolerancePanel2();
		riskTolerancePanel2.setPreferredSize(new Dimension(800, 1000));
		cardPanel.add(riskTolerancePanel2, "4");

		// 5th Panel
		JPanel riskObjectivePanel = new RiskObjectivePanel();
		riskObjectivePanel.setPreferredSize(new Dimension(800, 1000));
		cardPanel.add(riskObjectivePanel, "5");
		
		// 6th panel
		JPanel returnObjectivePanel = new ReturnObjectivePanel();
		returnObjectivePanel.setPreferredSize(new Dimension(800, 800));
		cardPanel.add(returnObjectivePanel, "6");

		// 7th panel
		JPanel recommendPortfolioPanel = new RecommendPortfolioPanel();
		recommendPortfolioPanel.setPreferredSize(new Dimension(800, 700));
		cardPanel.add(recommendPortfolioPanel, "7");

		
	}
	

	private JPanel createButtonPanel(JPanel cardPanel) {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEtchedBorder());
		JButton startBtn = new JButton("Start");
		JButton nextBtn = new JButton("Next");
		JButton previousBtn = new JButton("Previous");
		buttonPanel.add(startBtn);
		buttonPanel.add(nextBtn);
		buttonPanel.add(previousBtn);

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

		// add nextbtn in ActionListener
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String errorReport = "";
				
				//Sets data variables and updates cards 6 and 7 with proper info
				if(currentCard == 4) {
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
				
				
				if (currentCard < 7) {
					//ErrorControl
					if(ErrorControl.errorCheck(currentCard)) {
						cardPanel.revalidate();
						cardPanel.repaint();
						drawCards(cardPanel);
					}else {
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
