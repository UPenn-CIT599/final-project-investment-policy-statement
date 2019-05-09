package edu.upenn.seas.mcit591.ips.view;

public class FutureValueCalc {

		public double calculateFuturetValue(double currentAssetHolding, double annuity, int numberofYears, double PortfolioReturn) {
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

			return finalFutureValue;

		}
}
