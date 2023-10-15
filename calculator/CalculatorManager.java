package com.benny;

//Made By Benny Avnon

public class CalculatorManager {
	String accomulator = "";
	Action lastAction = null;
	boolean beforeAction = true;
	Window win;
	int firstNumber;
	int secondNumber;

	public CalculatorManager(Window window) {
		win = window;
	}

	public void pressedDigit(int val) {

		accomulator += val;
		win.setText(accomulator);
	}

	public void pressedAction(String val) {
		if (lastAction != null) {
			accomulator = "ERROR";
			return;
		}
		firstNumber = (int) Double.parseDouble(accomulator);
		accomulator = "";
		if (val.contains("+")) {
			lastAction = Action.ADD;
		} else if (val.contains("-")) {
			lastAction = Action.SUB;
		} else if (val.contains("X")) {
			lastAction = Action.MUL;
		} else if (val.contains("/")) {
			lastAction = Action.DIV;
		} else if (val.contains("C")) {
			lastAction = Action.C;
			clearAll();
		}
	}

	public void clearAll() {
		secondNumber = 0;
		firstNumber = 0;
		accomulator = "";
		lastAction = null;
		win.setText(accomulator);
	}

	public void pressedEQUAL(String val) {
		if (!isNumeric(accomulator) || firstNumber == 0 || lastAction == null) {
			clearAll();
			return;
		}

		secondNumber = (int) Double.parseDouble(accomulator);

		double result = 0;
		switch (lastAction) {
		case ADD:
			result = CalcUtils.add(firstNumber,secondNumber );
			clearAll();
			break;
		case SUB:
			result = CalcUtils.sub(firstNumber,secondNumber);
			clearAll();
			break;
		case MUL:
			result = CalcUtils.mul(firstNumber,secondNumber);
			clearAll();
			break;
		case DIV:
			result = CalcUtils.dev(firstNumber,secondNumber);
			clearAll();
			break;
		case C:
		default:
			result = 0;
			clearAll();
			break;
		}

		
		accomulator = "" + (int)result;
		win.setText(accomulator);
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}