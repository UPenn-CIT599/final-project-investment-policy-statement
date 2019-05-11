package edu.upenn.seas.mcit591.ips.view;

//This Method is used as an intermediate to store and transfer data between view component and logic.

public class DataManager {

	// Variables to transfer data from RiskTolerancePanel classes 1 and 2 to View

	private static int Question1;
	private static int Question2;
	private static int Question3;
	private static int Question4;
	private static int Question5;
	private static int Question6;
	private static int Question7;

	// Variables to transfer data from RiskScore class to View
	private static String WillingnessScore;
	private static String AbilityScore;
	private static int OverallScore;
	private static double IRR;

	// Variables to transfer data from for TimeValueofMoney class to View
	public static int sum;
	private static double currentAssetHolding;
	private static double futureValue;
	private static double annuity;
	private static int numberofYears;
	private static double rateofReturn;
	private static int age;
	private static double presentValue;

	private static double finalFutureValue;

	// Variables to transfer data from RiskScore methods to View
	private static boolean willingAndAbilityEqual = true;
	private static String IRRstring;
	private static String IRRString2;
	public static String WillingnessString;

	// Variable initializer for table object in RecommendPortfolioPanel
	private static Object[][] table = new Object[13][3];

	// setters and getter for FutureValue
	public static void setFutureValue(double FutureValue) {

		finalFutureValue = FutureValue;
	}

	public static double getFutureValue() {
		return finalFutureValue;
	}

	// getters and setters for TimeValueofMoney Methods
	public static void setPresentValue(double Value) {
		presentValue = Value;
	}

	public static double getPresentValue() {
		return presentValue;
	}

	public static void updatePanel4Var() {
		sum = 0;
	}

	public static double getCurrentAssetHolding() {
		return currentAssetHolding;
	}

	public static double getfutureValue() {
		return futureValue;
	}

	public static double getAnnuity() {
		return annuity;
	}

	public static int getNumberofYears() {
		return numberofYears;
	}

	public static double getRateofReturn() {
		return rateofReturn;
	}

	// getters and setters for RiskScore Question variables
	public static void setQuestion1(int Q1) {
		Question1 = Q1;
	}

	public static void setQuestion2(int Q2) {
		Question2 = Q2;
	}

	public static void setQuestion3(int Q3) {
		Question3 = Q3;
	}

	public static void setQuestion4(int Q4) {
		Question4 = Q4;
	}

	public static void setQuestion5(int Q5) {
		Question5 = Q5;
	}

	public static void setQuestion6(int Q6) {
		Question6 = Q6;
	}

	public static int getQuestion1() {
		return Question1;
	}

	public static int getQuestion2() {
		return Question2;
	}

	public static int getQuestion3() {
		return Question3;
	}

	public static int getQuestion4() {
		return Question4;
	}

	public static int getQuestion5() {
		return Question5;
	}

	public static int getQuestion6() {
		return Question6;
	}

	public static int getQuestion7() {
		return Question7;
	}

//	DataManager.updateTimeValueVars(Integer.parseInt(age), Double.parseDouble(currentAssets), Double.parseDouble(retiermentGoal), annuity, numberofYears, rateofReturnVar);
	// getters and setters for RiskScore Evaluation methods.
	public static void setRiskScoreVar() {
		RiskScore getRiskScore = new RiskScore();
		OverallScore = getRiskScore.getOverallRiskScore(numberofYears, getQuestion1(), getQuestion2(), getQuestion3(),
				getQuestion4(), getQuestion5(), getQuestion6());
		WillingnessScore = getRiskScore.getWillingnessRiskScore(getQuestion1(), getQuestion2(), getQuestion3(),
				getQuestion4());
		AbilityScore = getRiskScore.getAbilityRiskScore(getQuestion5(), getQuestion6(), numberofYears);
	}

	public static int getRiskScore() {
		return OverallScore;
	}

	public static String getWillingnessAssesment() {
		return WillingnessScore;
	}

	public static String getAbilityAssesment() {
		return AbilityScore;
	}

	// getter and setter for IRR calculation
	public static void setIRR() {
		TimeValueOfMoney newIRRCalc = new TimeValueOfMoney();
		IRR = newIRRCalc.calculateIRR(getCurrentAssetHolding(), getfutureValue(), getAnnuity(), numberofYears);
	}

	public static double getIRR() {
		return IRR;
	}

	public static int getAge() {
		return age;
	}

	// setting variables for Personal Info Panel
	public static void updateTimeValueVars(int Userage, double currentAssetHoldingVar, double futureValueVar,
			double annuityVar, int numberofYearsVar, double rateofReturnVar) {
		age = Userage;
		currentAssetHolding = currentAssetHoldingVar;
		futureValue = -futureValueVar;
		annuity = annuityVar;
		numberofYears = numberofYearsVar;
		rateofReturn = rateofReturnVar;
	}

	// get the Equality of Willingness and Ability to take risk for display in to
	// View
	public static boolean getWillingAndAbilityEquality() {
		return willingAndAbilityEqual;
	}

	// set the Equality of Willingness and Ability to take risk for display in to
	// View
	public static void setWillingAndAbilityEquality() {
		if (WillingnessScore.equals(AbilityScore)) {
			willingAndAbilityEqual = false;
		}
	}

	// getters and Setters for IRR methods
	public static String getIRRstring() {
		return IRRstring;
	}

	public static String getIRRString2() {
		return IRRString2;
	};

	// setter method to validate the IRR and customize the string that will be
	// displayed based on IRR value
	public static void setString() {

		if (IRR <= 0.19 && IRR > 0) {
			IRRstring = "<html>Based on the information you provided, your required rate of return is "
					+ DataManager.getIRR() * 100 + "%.</html>";

		} else if (IRR > 0.19) {

			IRRstring = "<html>Your investment return objective requires an investment return of more than "
					+ DataManager.getIRR() * 100 + "%."
					+ " This is difficult to achieve within your length of investment horizon, investment funds, and desired investment goal. "
					+ "Please consider revising your investment goal. You can proceed to check the recomended portfolio based on your risk profile.</html>";

		} else if (IRR == 0.00) {

			IRRstring = "<html>Your investment return objective is zero or negative, which means your current fund is "
					+ "sufficient to cover your investment objective. You can proceed to check the recomended portfolio based on your risk profile.</html>";

		}
		IRRString2 = "<html>Please proceed to check the recomended portfolio based on your risk profile.</html>";

	}

	// Setting the type of securities
	private static String[] vehicleDescription = { "US Stock", "US Mid Cap", "US Small Cap", "Treasury 1-3 years",
			"Total Bond", "20 year long-term bond", "TIPS", "Municipal Bonds", "Foregin Market",
			"Foregin Market Small Cap", "Emerging Market", "Real Estate", "Gold Community" };

	// Setting the fund names
	private static String[] fundName = { "Vanguard Total Stock Market ETF", "Vanguard Mid-Cap ETF",
			"Vanguard Small-Cap Index Fund", "Barclays 1-3 Year Treasury Bnd", "Vangaurd Total Bond Market ETF",
			"iShares 20+ Year Treasury Bond ETF", "iShares TIPS Bond ETF", "iShares National Municipal Bond ETF",
			"Vangaurd FTSE All-World ETF (no US)", "Vangaurd FTSE All-World Small Cap ETF (no US)",
			"Vanguard Emerging Markets Stock Fund", "Vangaurd Real Estate Fund", "SPDR Gold Shares" };

	private static double[] FundPercent;

	// getters and setters to get data from above and set the data in
	// RecommendPortfolioPanel class
	public static String[] getVehicleDescription() {
		return vehicleDescription;
	}

	public static String[] getFundName() {
		return fundName;
	}

	public static void setFundPercent(double[] fundPerc) {
		FundPercent = fundPerc;

	}

	public static double[] getFundPercent() {
		return FundPercent;
	}

	// Setters and getters for Table array for display in RecommendPortforlioPanel
	private static double portfolioReturn;

	public static void setPortfolioReturn(double portfolioRet) {
		portfolioReturn = portfolioRet;
	}

	public static double getPortfolioReturn() {
		return portfolioReturn;
	}

	private static double portfolioStdDev;

	public static void setPortfolioStdDev(double portfolioStd) {
		portfolioStdDev = portfolioStd;
	}

	public static double getPortfolioReturnStdDev() {
		return portfolioStdDev;
	}

	public static Object[][] getTable() {
		return table;
	}

	//
	public static void setTableForAllocation() {
		double[] FundPercent = getFundPercent();
		String[] vehicleDescription = getVehicleDescription();
		String[] fundName = getFundName();

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 3; j++) {
				switch (j) {
				case 0:
					table[i][j] = vehicleDescription[i];
					break;
				case 1:
					table[i][j] = FundPercent[i] * 100;
					break;
				case 2:
					table[i][j] = fundName[i];
					break;
				}

			}
		}

	}

}
