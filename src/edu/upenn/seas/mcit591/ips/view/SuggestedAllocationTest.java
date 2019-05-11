package edu.upenn.seas.mcit591.ips.view;

import org.junit.jupiter.api.Test;

class SuggestedAllocationTest {

	@Test
	void testGetBenchmarkCoefficient() {
		SuggestedAllocation newAllocationTest = new SuggestedAllocation();
		int RiskScore = 5;
		newAllocationTest.getBenchmarkCoefficient(RiskScore);
	}

}
 