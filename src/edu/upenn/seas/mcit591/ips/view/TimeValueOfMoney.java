package edu.upenn.seas.mcit591.ips.view;
import java.util.*;
import java.util.Map.Entry;

/*
 * This class determines the user's required rate of return for the investment goal entered
 */

public class TimeValueOfMoney {

	public double currentAssetHolding; // equal to the user's asset holding input
	public double futureValue;// equal to user's input of future required investment target amount
	public double annuity; // equal to user's input of annual fund available for investment
	public int numberofYears; // equal to the number of years between user's input of expenditure year and now
	public double InternalRateofReturn;// the return objective needed
	public double finalpresentValue;

	// Method 1: to calculate present value given any annuity, number of years, and
	// rate of return

	public double calculatePresentValue(double currentAssetHolding, double futureValue, double annuity,
			int numberofYears, double rateofReturn) {

		double presentValueofFutureValue = futureValue / Math.pow(1.00 + rateofReturn, numberofYears);

		double presentValueofAnnuity = 0;

		for (int i = 1; i <= numberofYears; i++) {

			presentValueofAnnuity = presentValueofAnnuity + annuity / Math.pow(1.00 + rateofReturn, i);

		}

		finalpresentValue = currentAssetHolding + presentValueofAnnuity + presentValueofFutureValue;
		DataManager.setPresentValue(finalpresentValue);
		return finalpresentValue;

	}

	/*
	 * Method 2: to find the lowest value in a HashMap and return it's corresponding Key
	 */

	public void setCurrentAssetHolding() {
		this.currentAssetHolding = DataManager.getCurrentAssetHolding();
	}

	public void setFutureValue() {
		this.futureValue = DataManager.getfutureValue();
	}

	public void setAnnuity() {
		this.annuity = DataManager.getAnnuity();
	}

	public void setNumberofYears() {
		this.numberofYears = DataManager.getNumberofYears();
	}

	public void setInternalRateofReturn() {
		InternalRateofReturn = DataManager.getRateofReturn();
	}

	public <K, V extends Comparable<V>> K minKeyUsingCollections(Map<K, V> map) {
		Entry<K, V> minEntry = Collections.min(map.entrySet(), new Comparator<Entry<K, V>>() {
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		return minEntry.getKey();
	}

	/*
	 * Method 3: to test various rate of return and get the rate that makes the net
	 * present value (NPV) nearest to zero. this rate is called internal rate of
	 * return (IRR)
	 */

	public double calculateIRR(double currentAssetHolding, double futureValue, double annuity, int numberofYears) {

		double guessPresentValue = 0;
		double guessrateofReturn = 0;
		double NPV;

		// build hash map holding NPV and corresponding rate of return
		HashMap<Double, Double> NPVandRateList = new HashMap<Double, Double>();

		for (int i = 0; i < 100; i++) {
			guessrateofReturn = 0.00 + 0.01 * i;
			guessPresentValue = calculatePresentValue(currentAssetHolding, futureValue, annuity, numberofYears,
					guessrateofReturn);
			NPV = Math.abs(guessPresentValue); // the smallest absolute value gives the value closest to zero
			System.out.println(NPV + "  " + guessrateofReturn);
			NPVandRateList.put(guessrateofReturn, NPV);
		}

		InternalRateofReturn = minKeyUsingCollections(NPVandRateList);
		System.out.println(InternalRateofReturn);
		return InternalRateofReturn;
	}




	public static void main(String[] args) {

//		TimeValueOfMoney testor = new TimeValueOfMoney();

//		System.out.print(testor.calculateIRR(5000.0, -5000.0, 0.0, 4));

	}

}
