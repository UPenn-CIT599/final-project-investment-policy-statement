package edu.upenn.seas.mcit591.ips.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FinanceEquationsTest {

	@Test
	void testGetPortfolioReturn() {
		
		FinanceEquations ReturnTest = new FinanceEquations();

		double[] Coefficient = { 0.1, 0.1, 0.05, 0.15, 0.15, 0.15, 0.05, 0.15, 0.05, 0.0, 0.0, 0.05, 0.0 };

		ReturnTest.getPortfolioReturn(Coefficient);
	}

	@Test
	void testGetPortfolioStandardDeviation() {
		
		FinanceEquations STDVTest = new FinanceEquations();

		double[] Coefficient = { 0.1, 0.1, 0.05, 0.15, 0.15, 0.15, 0.05, 0.15, 0.05, 0.0, 0.0, 0.05, 0.0 };

		STDVTest.getPortfolioReturn(Coefficient);

	}

} 
