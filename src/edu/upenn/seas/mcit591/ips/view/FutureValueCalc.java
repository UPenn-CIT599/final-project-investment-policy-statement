package edu.upenn.seas.mcit591.ips.view;

public class FutureValueCalc {

	/*
	 * This class calculates future value of an portfolio, given the present value,
	 * annuity, investment horizon, and a portfolio return In the project, this
	 * class produces the portfolio amount at the end of the investment horizon
	 */

	public double calculateFuturetValue(double currentAssetHolding, double annuity, int numberofYears,
			double PortfolioReturn) {
		currentAssetHolding = DataManager.getCurrentAssetHolding();
		annuity = DataManager.getAnnuity();
		numberofYears = DataManager.getNumberofYears();
		PortfolioReturn = DataManager.getIRR();
		double futurevalueofCurrentAssetHolding = currentAssetHolding * Math.pow(1.00 + PortfolioReturn, numberofYears);

		double futureValueofAnnuity = 0;

		for (int i = 1; i <= numberofYears; i++) {

			futureValueofAnnuity = futureValueofAnnuity + annuity * Math.pow(1.00 + PortfolioReturn, i);
		}

		double finalFutureValue = futurevalueofCurrentAssetHolding + futureValueofAnnuity;

		return finalFutureValue; // this value will be displayed for user to understand the portfolio amount at
									// the end of their investment horizon

	}
}
