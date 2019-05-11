package edu.upenn.seas.mcit591.ips.view;

public class ErrorControl {
	// Variables
	private static boolean PersonalInfoError = true;

	private static String errorToSend = "";
	private static boolean tolerancePanelError = true;

	public static void setPersonalInfoError(boolean value) {
		PersonalInfoError = value;
	}

	public static boolean getPersonalInfoError() {
		return PersonalInfoError;
	}

	public static boolean errorCheck(int cardPanel) {
		switch (cardPanel) {
		case 2:
			if (getPersonalInfoError()) {
				return true;

			}
			break;
		case 3:
			if (getTolerancePanelError()) {
				setError("You did not select all the options, please select them all be for proceeding");
				return true;

			}
		case 4:
			if (getTolerancePanelError()) {
				setError("You did not select all the options, please select them all be for proceeding");
				return true;

			}

			break;

		}

		return false;
	}

	public static void setTolerancePanelError(boolean value) {
		tolerancePanelError = value;
	}

	public static boolean getTolerancePanelError() {
		return tolerancePanelError;
	}

//	public static boolean 

	public static void setError(String phrase) {
		errorToSend = phrase;
	}

	public static String getError() {
		return errorToSend;
	}

}
