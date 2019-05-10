package edu.upenn.seas.mcit591.ips.view;

public class SuggestedAllocation {

	public int OverallRiskScore; // the same score as user's overall risk score from "RiskScore" class

	// declare variables for return allocation portion to each asset class

	public double VTIallocation;
	public double VOallocation;
	public double VBallocation;
	public double SHYallocation;
	public double BNDallocation;
	public double TLTallocation;
	public double TIPallocation;
	public double MUBallocation;
	public double VEUallocation;
	public double VSSallocation;
	public double VWOallocation;
	public double VNQallocation;
	public double GLDallocation;

	/*
	 * Step 1: get the benchmark asset allocation based on user's risk score
	 */

	public double[] getBenchmarkCoefficient(int OverallRiskScore) {

		if (OverallRiskScore < 3) {

			//"Conservative Allocation n/ Short-term Bonds  30% "
			//		+ "n/ Fixed Income 50%  n/ US Stock 15% n/ International 5% n/Alternative Assets 0%

			VTIallocation = 0.15; // US Stock
			VOallocation = 0.0; // US Midcap Stock
			VBallocation = 0.0; // US Smallcap Stock
			SHYallocation = 0.30; // Treasury 1-3 years
			BNDallocation = 0.15; // Total Bond
			TLTallocation = 0.15; // 20+ year long-term bond
			TIPallocation = 0.05; // TIPS
			MUBallocation = 0.15; // Muni Bonds
			VEUallocation = 0.05; // Foreign Market
			VSSallocation = 0.0; // Foreign Market Small Cap
			VWOallocation = 0.0; // Emerging Market
			VNQallocation = 0.0; // Real Estate
			GLDallocation = 0.0; // Gold Commodity

		}

		else if (OverallRiskScore >= 3 && OverallRiskScore < 5) {

			//"Moderately Conservative n/ Short-term Bonds 15% "
			//		+ "n/ Fixed Income 50%  n/ US Stock 25% n/ International 5% n/Alternative Assets 5% ");

			VTIallocation = 0.10; // US Stock
			VOallocation = 0.10; // US Midcap
			VBallocation = 0.05; // US Smallcap
			SHYallocation = 0.15; // Treasury 1-3 years
			BNDallocation = 0.15; // Total Bond
			TLTallocation = 0.15; // 20+ year long-term bond
			TIPallocation = 0.05; // TIPS
			MUBallocation = 0.15; // Muni Bonds
			VEUallocation = 0.05; // Foreign Market
			VSSallocation = 0.0; // Foreign Market Small Cap
			VWOallocation = 0.0; // Emerging Market
			VNQallocation = 0.05; // Real Estate
			GLDallocation = 0.0; // Gold Commodity
			
		
		}

		else if (OverallRiskScore >= 5 && OverallRiskScore < 7) {

			//"Moderate Allocation n/ Short-term Bonds 5% "
			//"n/ Fixed Income 35%  n/ US Stock 35% n/ Foreign Market 10% "
			//"n/Emerging Market 5% n/Real Estate 5% n/Commodity 5% ");

			VTIallocation = 0.20; // US Stock
			VOallocation = 0.10; // US Midcap
			VBallocation = 0.05; // US Smallcap
			SHYallocation = 0.05; // Treasury 1-3 years
			BNDallocation = 0.10; // Total Bond
			TLTallocation = 0.05; // 20+ year long-term bond
			TIPallocation = 0.05; // TIPS
			MUBallocation = 0.15; // Muni Bonds
			VEUallocation = 0.05; // Foreign Market
			VSSallocation = 0.05; // Foreign Market Small Cap
			VWOallocation = 0.05; // Emerging Market
			VNQallocation = 0.05; // Real Estate
			GLDallocation = 0.05; // Gold Commodity
		}

		else if (OverallRiskScore >= 7 && OverallRiskScore < 9) {

			//"Moderately Aggressive n/ Short-term Bonds 5% "
			//"n/ Fixed Income 15%  n/ US Stock 45% n/ Foreign Market 20% "
			//"n/Emerging Market 5% n/Real Estate 5% n/Commodity 5% ");

			VTIallocation = 0.15; // US Stock
			VOallocation = 0.15; // US Midcap
			VBallocation = 0.15; // US Smallcap
			SHYallocation = 0.05; // Treasury 1-3 years
			BNDallocation = 0.05; // Total Bond
			TLTallocation = 0.05; // 20+ year long-term bond
			TIPallocation = 0.0; // TIPS
			MUBallocation = 0.05; // Muni Bonds
			VEUallocation = 0.10; // Foreign Market
			VSSallocation = 0.10; // Foreign Market Small Cap
			VWOallocation = 0.05; // Emerging Market
			VNQallocation = 0.05; // Real Estate
			GLDallocation = 0.05; // Gold Commodity
		}

		else if (OverallRiskScore == 9) {

			//"Aggressive Allocation n/ Short-term Bonds 5% "
			//"n/ Fixed Income 15%  n/ US Stock 45% n/ Foreign Market 20% "
			//"n/Emerging Market 5% n/Real Estate 5% n/Commodity 5% ");

			VTIallocation = 0.15; // US Stock
			VOallocation = 0.15; // US Midcap
			VBallocation = 0.20; // US Smallcap
			SHYallocation = 0.05; // Treasury 1-3 years
			BNDallocation = 0.0; // Total Bond
			TLTallocation = 0.0; // 20+ year long-term bond
			TIPallocation = 0.0; // TIPS
			MUBallocation = 0.0; // Muni Bonds
			VEUallocation = 0.10; // Foreign Market
			VSSallocation = 0.15; // Foreign Market Small Cap
			VWOallocation = 0.05; // Emerging Market
			VNQallocation = 0.10; // Real Estate
			GLDallocation = 0.05; // Gold Commodity
		}

		double[] BenchmarkCoefficient = { VTIallocation, VOallocation, VBallocation, SHYallocation, BNDallocation,
				TLTallocation, TIPallocation, MUBallocation, VEUallocation, VSSallocation, VWOallocation, VNQallocation,
				GLDallocation };

		return BenchmarkCoefficient;

	}


}
