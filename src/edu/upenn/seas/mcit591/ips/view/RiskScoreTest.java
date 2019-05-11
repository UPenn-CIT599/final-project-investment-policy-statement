package edu.upenn.seas.mcit591.ips.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RiskScoreTest {

	@Test
	void testGetQ7Score() {

		RiskScore Q7Test = new RiskScore();

		int NumberofYears = 40;

		Q7Test.getQ7Score(NumberofYears);

	} 

	@Test
	void testGetOverallRiskScore() {
		RiskScore OverallTest = new RiskScore();

		int numberofYears = 40;
		int Q1Score = 20;
		int Q2Score = 5;
		int Q3Score = 0;
		int Q4Score = 10;
		int Q5Score = 10;
		int Q6Score = 5;
 
		OverallTest.getOverallRiskScore(numberofYears, Q1Score, Q2Score, Q3Score, Q4Score, Q5Score, Q6Score);
	}

	@Test
	void testGetWillingnessRiskScore() {
		RiskScore WillingTest = new RiskScore();

		int Q1Score = 20;
		int Q2Score = 5;
		int Q3Score = 0;
		int Q4Score = 10;

		WillingTest.getWillingnessRiskScore(Q1Score, Q2Score, Q3Score, Q4Score);

	}

	@Test
	void testGetAbilityRiskScore() {

		RiskScore WillingTest = new RiskScore();

		int numberofYears = 40;
		int Q5Score = 10;
		int Q6Score = 5;

		WillingTest.getAbilityRiskScore(Q5Score, Q6Score, numberofYears);

	}

	@Test
	void testAnalyzeRisk() {

		RiskScore AnalyzeTest = new RiskScore();

		AnalyzeTest.AbilityRiskScore = "Average";
		AnalyzeTest.WillingRiskScore = "Below Average";
		AnalyzeTest.analyzeRisk();

	}
	
	@Test
	void testAnalyzeRisk2() {

		RiskScore AnalyzeTest = new RiskScore();

		AnalyzeTest.AbilityRiskScore = "Average";
		AnalyzeTest.WillingRiskScore = "Average";
		AnalyzeTest.analyzeRisk();

	}
	@Test
	void testAnalyzeRisk3() {

		RiskScore AnalyzeTest = new RiskScore();

		AnalyzeTest.AbilityRiskScore = "Average";
		AnalyzeTest.WillingRiskScore = "Above Average";
		AnalyzeTest.analyzeRisk();

	}
}
