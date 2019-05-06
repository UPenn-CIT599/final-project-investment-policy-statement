import java.util.*;
import java.util.Map.Entry;

/*
 * This class determines the user's required rate of return for the investment goal entered
 */

public class TimeValueOfMoney {

	double currentAssetHolding; // equal to sum of the user's asset holding input
	double futureValue;// equal to user's input of future required expenditure
	double annuity; // equal to user's input of annual fund available for investment
	int numberofYears; // equal to the number of years between user's input of expenditure year and now
	double InternalRateofReturn;// the return objective needed

	// Method 1: to calculate present value given any annuity, number of years, and
	// rate of return

	public double calculatePresentValue(double currentAssetHolding, double futureValue, double annuity,
			int numberofYears, double rateofReturn) {

		double presentValueofFutureValue = futureValue / Math.pow(1.00 + rateofReturn, numberofYears);

		double presentValueofAnnuity = 0;

		for (int i = 1; i <= numberofYears; i++) {

			presentValueofAnnuity = presentValueofAnnuity + annuity / Math.pow(1.00 + rateofReturn, i);

		}

		double finalpresentValue = currentAssetHolding + presentValueofAnnuity + presentValueofFutureValue;

		return finalpresentValue;

	}

	/*
	 * Method 2: to find the lowest value in a HashMap and return it's corresponding Key
	 */

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

		return InternalRateofReturn;
	}

	/*
	 * Method 4: to test whether the IRR returned is realistic and output the result for the user to understand
	 */

	public void analyzeReturnObjective(double InternalRateofReturn) {
		
		System.out.println("Based on the information you provided, your required rate of return is"
				+ InternalRateofReturn * 100 + "%. ");

		if (InternalRateofReturn > 0.19) {

			System.out.println("Your investment return objective requires an investment return of more than"
					+ InternalRateofReturn * 100 + "%."
					+ " This is difficult to achieve within your length of investment horizon, investment funds, and desired investment goal. "
					+ "Please consider revising your investment goal. You can proceed to check the recomended portfolio based on your risk profile.");

		}
		if (InternalRateofReturn == 0.00) {

			System.out.println("Your investment return objective is zero or negative, which means your current fund is "
					+ "sufficient to cover your investment objective. You can proceed to check the recomended portfolio based on your risk profile.");

		}
		else {
			System.out.println("Please proceed to check the recomended portfolio based on your risk profile.");
		}

	}

	public static void main(String[] args) {

		TimeValueOfMoney testor = new TimeValueOfMoney();

		System.out.print(testor.calculateIRR(5000.0, -5000.0, 0.0, 4));

	}

}
