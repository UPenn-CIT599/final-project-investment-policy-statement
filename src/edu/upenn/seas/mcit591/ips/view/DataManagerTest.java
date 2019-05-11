 package edu.upenn.seas.mcit591.ips.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataManagerTest {

	@Test
	void testUpdateTimeValueVars() {
		int Userage =23;
		double currentAssetHoldingVar=10000.00;
		double futureValueVar=1290212.00;
		double annuityVar=12912;
		int numberofYearsVar =32;
		double rateofReturnVar=.06;
		DataManager.updateTimeValueVars(Userage, currentAssetHoldingVar, futureValueVar, annuityVar, numberofYearsVar, rateofReturnVar);
		
	} 

}
