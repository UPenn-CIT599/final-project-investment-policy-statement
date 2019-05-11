package edu.upenn.seas.mcit591.ips.view;

public class PortfolioAllocation {

		int riskScore; // risk score from user
		double returnObjective; // return objective from user

		// declare variables for return allocation portion to each asset class

		double VTIallocation;
		double VOallocation;
		double VBallocation;
		double SHYallocation;
		double BNDallocation;
		double TLTallocation;
		double TIPallocation;
		double MUBallocation;
		double VEUallocation;
		double VSSallocation;
		double VWOallocation;
		double VNQallocation;
		double GLDallocation;
		
		// a set of value 
		
		
	 	
		

		// declare variables for return value to each asset class

		double VTIreturn = 0.1166;
		double VOreturn = 0.1126;
		double VBreturn = 0.1132;
		double SHYreturn = 0.0085;
		double BNDreturn = 0.0301;
		double TLTreturn = 0.0652;
		double TIPreturn = 0.0265;
		double MUBreturn = 0.0351;
		double VEUreturn = 0.0348;
		double VSSreturn = 0.0459;
		double VWOreturn = 0.017;
		double VNQreturn = 0.1021;
		double GLDreturn = 0.0137;

		// declare variables for standard deviation value to each asset class

		double VTIstdv = 0.1282;
		double VOstdv = 0.1393;
		double VBstdv = 0.1591;
		double SHYstdv = 0.0079;
		double BNDstdv = 0.0296;
		double TLTstdv = 0.1253;
		double TIPstdv = 0.0449;
		double MUBstdv = 0.0451;
		double VEUstdv = 0.1538;
		double VSSstdv = 0.1572;
		double VWOstdv = 0.1821;
		double VNQstdv = 0.1563;
		double GLDstdv = 0.1647;

		// declare variables for correlation bewtween any two assets

		double CorrVOvsVTI = 0.98;
		double CorrVBvsVTI = 0.95;
		double CorrVBvsVO = 0.97;
		double CorrSHYvsVTI = -0.38;
		double CorrSHYvsVO = -0.22;
		double CorrSHYvsVB = -0.14;
		double CorrBNDvsVTI = -0.18;
		double CorrBNDvsVO = -0.09;
		double CorrBNDvsVB = -0.15;
		double CorrBNDvsSHY = 0.44;
		double CorrTLTvsVTI = -0.33;
		double CorrTLTvsVO = -0.29;
		double CorrTLTvsVB = -0.38;
		double CorrTLTvsSHY = 0.27;
		double CorrTLTvsBND = 0.91;
		double CorrTIPvsVTI = -0.33;
		double CorrTIPvsVO = -0.28;
		double CorrTIPvsVB = -0.26;
		double CorrTIPvsSHY = 0.42;
		double CorrTIPvsBND = 0.91;
		double CorrTIPvsTLT = 0.8;
		double CorrMUBvsVTI = -0.41;
		double CorrMUBvsVO = -0.43;
		double CorrMUBvsVB = -0.54;
		double CorrMUBvsSHY = 0;
		double CorrMUBvsBND = 0.75;
		double CorrMUBvsTLT = 0.91;
		double CorrMUBvsTIP = 0.73;
		double CorrVEUvsVTI = 0.82;
		double CorrVEUvsVO = 0.78;
		double CorrVEUvsVB = 0.77;
		double CorrVEUvsSHY = -0.38;
		double CorrVEUvsBND = -0.12;
		double CorrVEUvsTLT = -0.36;
		double CorrVEUvsTIP = -0.15;
		double CorrVEUvsMUB = -0.36;
		double CorrVSSvsVTI = 0.79;
		double CorrVSSvsVO = 0.81;
		double CorrVSSvsVB = 0.79;
		double CorrVSSvsSHY = -0.23;
		double CorrVSSvsBND = -0.08;
		double CorrVSSvsTLT = -0.38;
		double CorrVSSvsTIP = -0.16;
		double CorrVSSvsMUB = -0.42;
		double CorrVSSvsVEU = 0.97;
		double CorrVWOvsVTI = 0.59;
		double CorrVWOvsVO = 0.6;
		double CorrVWOvsVB = 0.6;
		double CorrVWOvsSHY = -0.12;
		double CorrVWOvsBND = 0.2;
		double CorrVWOvsTLT = -0.09;
		double CorrVWOvsTIP = 0.17;
		double CorrVWOvsMUB = -0.19;
		double CorrVWOvsVEU = 0.87;
		double CorrVWOvsVSS = 0.86;
		double CorrVNQvsVTI = 0.26;
		double CorrVNQvsVO = 0.4;
		double CorrVNQvsVB = 0.33;
		double CorrVNQvsSHY = 0.2;
		double CorrVNQvsBND = 0.67;
		double CorrVNQvsTLT = 0.5;
		double CorrVNQvsTIP = 0.46;
		double CorrVNQvsMUB = 0.31;
		double CorrVNQvsVEU = 0.18;
		double CorrVNQvsVSS = 0.28;
		double CorrVNQvsVWO = 0.4;
		double CorrGLDvsVTI = -0.16;
		double CorrGLDvsVO = -0.05;
		double CorrGLDvsVB = -0.02;
		double CorrGLDvsSHY = 0.62;
		double CorrGLDvsBND = 0.75;
		double CorrGLDvsTLT = 0.47;
		double CorrGLDvsTIP = 0.77;
		double CorrGLDvsMUB = 0.27;
		double CorrGLDvsVEU = 0.16;
		double CorrGLDvsVSS = 0.23;
		double CorrGLDvsVWO = 0.55;
		double CorrGLDvsVNQ = 0.48;

	

		public double getPortfolioStandardDeviation() {

			double PortfolioStandardDeviation = Math.sqrt(Math.pow(VTIallocation * VTIstdv, 2) + Math.pow(VOallocation * VOstdv, 2)
					+ Math.pow(VBallocation * VBstdv, 2) + Math.pow(SHYallocation * SHYstdv, 2)
					+ Math.pow(BNDallocation * BNDstdv, 2) + Math.pow(TLTallocation * TLTstdv, 2)
					+ Math.pow(TIPallocation * TIPstdv, 2) + Math.pow(MUBallocation * MUBstdv, 2)
					+ Math.pow(VEUallocation * VEUstdv, 2) + Math.pow(VSSallocation * VSSstdv, 2)
					+ Math.pow(VWOallocation * VWOstdv, 2) + Math.pow(VNQallocation * VNQstdv, 2)
					+ Math.pow(GLDallocation * GLDstdv, 2)
					+ 2 * CorrVOvsVTI * VOstdv * VTIstdv * VOallocation * VTIallocation
					+ 2 * CorrVBvsVTI * VBstdv * VTIstdv * VBallocation * VTIallocation
					+ 2 * CorrVBvsVO * VBstdv * VOstdv * VBallocation * VOallocation
					+ 2 * CorrSHYvsVTI * SHYstdv * VTIstdv * SHYallocation * VTIallocation
					+ 2 * CorrSHYvsVO * SHYstdv * VOstdv * SHYallocation * VOallocation
					+ 2 * CorrSHYvsVB * SHYstdv * VBstdv * SHYallocation * VBallocation
					+ 2 * CorrBNDvsVTI * BNDstdv * VTIstdv * BNDallocation * VTIallocation
					+ 2 * CorrBNDvsVO * BNDstdv * VOstdv * BNDallocation * VOallocation
					+ 2 * CorrBNDvsVB * BNDstdv * VBstdv * BNDallocation * VBallocation
					+ 2 * CorrBNDvsSHY * BNDstdv * SHYstdv * BNDallocation * SHYallocation
					+ 2 * CorrTLTvsVTI * TLTstdv * VTIstdv * TLTallocation * VTIallocation
					+ 2 * CorrTLTvsVO * TLTstdv * VOstdv * TLTallocation * VOallocation
					+ 2 * CorrTLTvsVB * TLTstdv * VBstdv * TLTallocation * VBallocation
					+ 2 * CorrTLTvsSHY * TLTstdv * SHYstdv * TLTallocation * SHYallocation
					+ 2 * CorrTLTvsBND * TLTstdv * BNDstdv * TLTallocation * BNDallocation
					+ 2 * CorrTIPvsVTI * TIPstdv * VTIstdv * TIPallocation * VTIallocation
					+ 2 * CorrTIPvsVO * TIPstdv * VOstdv * TIPallocation * VOallocation
					+ 2 * CorrTIPvsVB * TIPstdv * VBstdv * TIPallocation * VBallocation
					+ 2 * CorrTIPvsSHY * TIPstdv * SHYstdv * TIPallocation * SHYallocation
					+ 2 * CorrTIPvsBND * TIPstdv * BNDstdv * TIPallocation * BNDallocation
					+ 2 * CorrTIPvsTLT * TIPstdv * TLTstdv * TIPallocation * TLTallocation
					+ 2 * CorrMUBvsVTI * MUBstdv * VTIstdv * MUBallocation * VTIallocation
					+ 2 * CorrMUBvsVO * MUBstdv * VOstdv * MUBallocation * VOallocation
					+ 2 * CorrMUBvsVB * MUBstdv * VBstdv * MUBallocation * VBallocation
					+ 2 * CorrMUBvsSHY * MUBstdv * SHYstdv * MUBallocation * SHYallocation
					+ 2 * CorrMUBvsBND * MUBstdv * BNDstdv * MUBallocation * BNDallocation
					+ 2 * CorrMUBvsTLT * MUBstdv * TLTstdv * MUBallocation * TLTallocation
					+ 2 * CorrMUBvsTIP * MUBstdv * TIPstdv * MUBallocation * TIPallocation
					+ 2 * CorrVEUvsVTI * VEUstdv * VTIstdv * VEUallocation * VTIallocation
					+ 2 * CorrVEUvsVO * VEUstdv * VOstdv * VEUallocation * VOallocation
					+ 2 * CorrVEUvsVB * VEUstdv * VBstdv * VEUallocation * VBallocation
					+ 2 * CorrVEUvsSHY * VEUstdv * SHYstdv * VEUallocation * SHYallocation
					+ 2 * CorrVEUvsBND * VEUstdv * BNDstdv * VEUallocation * BNDallocation
					+ 2 * CorrVEUvsTLT * VEUstdv * TLTstdv * VEUallocation * TLTallocation
					+ 2 * CorrVEUvsTIP * VEUstdv * TIPstdv * VEUallocation * TIPallocation
					+ 2 * CorrVEUvsMUB * VEUstdv * MUBstdv * VEUallocation * MUBallocation
					+ 2 * CorrVSSvsVTI * VSSstdv * VTIstdv * VSSallocation * VTIallocation
					+ 2 * CorrVSSvsVO * VSSstdv * VOstdv * VSSallocation * VOallocation
					+ 2 * CorrVSSvsVB * VSSstdv * VBstdv * VSSallocation * VBallocation
					+ 2 * CorrVSSvsSHY * VSSstdv * SHYstdv * VSSallocation * SHYallocation
					+ 2 * CorrVSSvsBND * VSSstdv * BNDstdv * VSSallocation * BNDallocation
					+ 2 * CorrVSSvsTLT * VSSstdv * TLTstdv * VSSallocation * TLTallocation
					+ 2 * CorrVSSvsTIP * VSSstdv * TIPstdv * VSSallocation * TIPallocation
					+ 2 * CorrVSSvsMUB * VSSstdv * MUBstdv * VSSallocation * MUBallocation
					+ 2 * CorrVSSvsVEU * VSSstdv * VEUstdv * VSSallocation * VEUallocation
					+ 2 * CorrVWOvsVTI * VWOstdv * VTIstdv * VWOallocation * VTIallocation
					+ 2 * CorrVWOvsVO * VWOstdv * VOstdv * VWOallocation * VOallocation
					+ 2 * CorrVWOvsVB * VWOstdv * VBstdv * VWOallocation * VBallocation
					+ 2 * CorrVWOvsSHY * VWOstdv * SHYstdv * VWOallocation * SHYallocation
					+ 2 * CorrVWOvsBND * VWOstdv * BNDstdv * VWOallocation * BNDallocation
					+ 2 * CorrVWOvsTLT * VWOstdv * TLTstdv * VWOallocation * TLTallocation
					+ 2 * CorrVWOvsTIP * VWOstdv * TIPstdv * VWOallocation * TIPallocation
					+ 2 * CorrVWOvsMUB * VWOstdv * MUBstdv * VWOallocation * MUBallocation
					+ 2 * CorrVWOvsVEU * VWOstdv * VEUstdv * VWOallocation * VEUallocation
					+ 2 * CorrVWOvsVSS * VWOstdv * VSSstdv * VWOallocation * VSSallocation
					+ 2 * CorrVNQvsVTI * VNQstdv * VTIstdv * VNQallocation * VTIallocation
					+ 2 * CorrVNQvsVO * VNQstdv * VOstdv * VNQallocation * VOallocation
					+ 2 * CorrVNQvsVB * VNQstdv * VBstdv * VNQallocation * VBallocation
					+ 2 * CorrVNQvsSHY * VNQstdv * SHYstdv * VNQallocation * SHYallocation
					+ 2 * CorrVNQvsBND * VNQstdv * BNDstdv * VNQallocation * BNDallocation
					+ 2 * CorrVNQvsTLT * VNQstdv * TLTstdv * VNQallocation * TLTallocation
					+ 2 * CorrVNQvsTIP * VNQstdv * TIPstdv * VNQallocation * TIPallocation
					+ 2 * CorrVNQvsMUB * VNQstdv * MUBstdv * VNQallocation * MUBallocation
					+ 2 * CorrVNQvsVEU * VNQstdv * VEUstdv * VNQallocation * VEUallocation
					+ 2 * CorrVNQvsVSS * VNQstdv * VSSstdv * VNQallocation * VSSallocation
					+ 2 * CorrVNQvsVWO * VNQstdv * VWOstdv * VNQallocation * VWOallocation
					+ 2 * CorrGLDvsVTI * GLDstdv * VTIstdv * GLDallocation * VTIallocation
					+ 2 * CorrGLDvsVO * GLDstdv * VOstdv * GLDallocation * VOallocation
					+ 2 * CorrGLDvsVB * GLDstdv * VBstdv * GLDallocation * VBallocation
					+ 2 * CorrGLDvsSHY * GLDstdv * SHYstdv * GLDallocation * SHYallocation
					+ 2 * CorrGLDvsBND * GLDstdv * BNDstdv * GLDallocation * BNDallocation
					+ 2 * CorrGLDvsTLT * GLDstdv * TLTstdv * GLDallocation * TLTallocation
					+ 2 * CorrGLDvsTIP * GLDstdv * TIPstdv * GLDallocation * TIPallocation
					+ 2 * CorrGLDvsMUB * GLDstdv * MUBstdv * GLDallocation * MUBallocation
					+ 2 * CorrGLDvsVEU * GLDstdv * VEUstdv * GLDallocation * VEUallocation
					+ 2 * CorrGLDvsVSS * GLDstdv * VSSstdv * GLDallocation * VSSallocation
					+ 2 * CorrGLDvsVWO * GLDstdv * VWOstdv * GLDallocation * VWOallocation
					+ 2 * CorrGLDvsVNQ * GLDstdv * VNQstdv * GLDallocation * VNQallocation);

			return PortfolioStandardDeviation;

		}



}

