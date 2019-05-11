package edu.upenn.seas.mcit591.ips.view;

public class RiskScore {

	public int numberofYears; // equal to number of years between expenditure year and now
	public int Q1Score; // the score from user's answer in multiple choice of Q1
	public int Q2Score; // the score from user's answer in multiple choice of Q2
	public int Q3Score; // the score from user's answer in multiple choice of Q3
	public int Q4Score; // the score from user's answer in multiple choice of Q4
	public int Q5Score; // the score from user's answer in multiple choice of Q5
	public int Q6Score; // the score from user's answer in multiple choice of Q6
	public int Q7Score; // the score from user's length of investment time horizon

	public int OverallRiskScore;
	public String WillingRiskScore;
	public String AbilityRiskScore;

	/*
	 * Method1 : The holding period length is an important metric for ability to
	 * tolerate risk.
	 */

	public void setQuestionAnswers() {
		numberofYears = DataManager.getNumberofYears();
		Q1Score = DataManager.getQuestion1();
		Q2Score = DataManager.getQuestion2();
		Q3Score = DataManager.getQuestion3();
		Q4Score = DataManager.getQuestion4();
		Q5Score = DataManager.getQuestion5();
		Q6Score = DataManager.getQuestion6();
		Q7Score = DataManager.getQuestion7();
	}

	public int getQ7Score(int numberofYears) {

		if (numberofYears <= 3) {

			Q7Score = 0;

		} else if (numberofYears > 3 && numberofYears <= 5) {

			Q7Score = 5;
		}

		else if (numberofYears > 5 && numberofYears <= 10) {

			Q7Score = 10;
		}

		else if (numberofYears > 10) {

			Q7Score = 20;
		}

		return Q7Score;
	}

	/*
	 * This method is to get Overall Risk Score for the user
	 */
	public int getOverallRiskScore(int numberofYears, int Q1Score, int Q2Score, int Q3Score, int Q4Score, int Q5Score,
			int Q6Score) {

//		setQuestionAnswers();

		int RiskScore = Q1Score + Q2Score + Q3Score + Q4Score + Q5Score + Q6Score + getQ7Score(numberofYears);
		System.out.println(RiskScore + "****");
		if (RiskScore <= 25) {

			OverallRiskScore = 1;
		}

		else if (RiskScore > 25 && RiskScore <= 35) {

			OverallRiskScore = 2;
		}

		else if (RiskScore > 35 && RiskScore <= 45) {

			OverallRiskScore = 3;
		}

		else if (RiskScore > 45 && RiskScore <= 55) {

			OverallRiskScore = 4;
		}

		else if (RiskScore > 55 && RiskScore <= 65) {

			OverallRiskScore = 5;
		}

		else if (RiskScore > 65 && RiskScore <= 80) {

			OverallRiskScore = 6;
		}

		else if (RiskScore > 80 && RiskScore <= 90) {

			OverallRiskScore = 7;
		}

		else if (RiskScore > 90 && RiskScore <= 105) {

			OverallRiskScore = 8;
		}

		else if (RiskScore > 105) {

			OverallRiskScore = 9;
		}
		return OverallRiskScore;

	}

	/*
	 * This method is to get Willingness Risk Score for the user
	 */
	public String getWillingnessRiskScore(int Q1Score, int Q2Score, int Q3Score, int Q4Score) {

		int RiskScore1 = Q1Score + Q2Score + Q3Score + Q4Score;

		if (RiskScore1 <= 30) {

			WillingRiskScore = "Below Average";
		}

		else if (RiskScore1 > 30 && RiskScore1 < 60) {

			WillingRiskScore = "Average";
		}

		else if (RiskScore1 >= 60) {

			WillingRiskScore = "Above Average";
		}
		return WillingRiskScore;

	}

	/*
	 * This method is to get ability Risk Score for the user
	 */

	public String getAbilityRiskScore(int Q5Score, int Q6Score, int numberofYears) {

		int RiskScore2 = Q5Score + Q6Score + getQ7Score(numberofYears);

		if (RiskScore2 <= 25) {

			AbilityRiskScore = "Below Average";
		}

		else if (RiskScore2 > 25 && RiskScore2 <= 45) {

			AbilityRiskScore = "Average";
		}

		else if (RiskScore2 > 45) {

			AbilityRiskScore = "Above Average";
		}
		return AbilityRiskScore;

	}

	/*
	 * This method is to analyze the risk profile of the user
	 */

	public void analyzeRisk() {

		System.out.println(
				"Your overall risk score is " + OverallRiskScore + " out of 10. Your willingness to take risk is "
						+ WillingRiskScore + ". Your ability to take risk is " + AbilityRiskScore + ".");

		if (!(AbilityRiskScore == WillingRiskScore)) {

			System.out.println(
					"Your ability to take investment risk is not consistent with your willingness to take investment risk. We recomend you to balance these two options.");
		}

		System.out.println(
				"The recommended amount of risk  More risk usually means higher expected returns over the long term, but bigger ups and downs along the way. Too much risk could leave you at a loss   when you need the money, but too little may mean slower growth. We calculate the right balance for you based on:\n"
						+ "How long you have to invest The younger you are, the longer you have for your portfolio to rebound from a significant downturn.\n"
			 			+ " \n"
						+ " Your financial capacity for risk The more comfortable your finances, the more risk you can afford to take, and vice versa.\n"
						+ " \n"
						+ "Your personal comfort zone Ups and downs come standard in long-term investing, but not everyone is comfortable riding out the downturns. Since the best long-term plan is one you can stick with, we consider your willingness to take risk and endure the ups and downs of the market.\n"
						+ "\n" + " ");

		System.out.println("Please proceed to check the recomended portfolio based on your risk profile.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
