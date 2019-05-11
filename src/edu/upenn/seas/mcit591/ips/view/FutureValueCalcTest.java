package edu.upenn.seas.mcit591.ips.view;

import org.junit.jupiter.api.Test;

class FutureValueCalcTest {

	@Test
	void testCalculateFuturetValue() {
		FutureValueCalc newTest = new FutureValueCalc();
		double currentAssetHolding = 10000.00;
		double PortfolioReturn = 1000000.00;
		double annuity = 2000.00;
		int numberofYears = 30;
		newTest.calculateFuturetValue(currentAssetHolding, annuity, numberofYears, PortfolioReturn);
	}

}
 