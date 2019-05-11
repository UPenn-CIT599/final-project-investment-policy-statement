package edu.upenn.seas.mcit591.ips.view;

import org.junit.jupiter.api.Test;
 
class TimeValueOfMoneyTest {

	@Test
	void testCalculatePresentValue() {
		TimeValueOfMoney testPresentValCalc = new TimeValueOfMoney();
		double currentAssetHolding = 10000.00;
		double futureValue = 1000000.00;
		double annuity = 2000.00;
		int numberofYears = 30;
		double rateofReturn = 0.05;
		testPresentValCalc.calculatePresentValue(currentAssetHolding, futureValue, annuity, numberofYears, rateofReturn);
	}
 
	@Test
	void testCalculateIRR() {
		TimeValueOfMoney newIRRCalcTest = new TimeValueOfMoney();
		double currentAssetHolding = 10000.00;
		double futureValue = 1000000.00;
		double annuity = 2000.00;
		int numberofYears = 30;
		newIRRCalcTest.calculateIRR(currentAssetHolding, futureValue, annuity, numberofYears);
	}

}
