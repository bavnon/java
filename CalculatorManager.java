package roman;

import java.util.HashMap;
import java.util.TreeMap;

public class CalculatorManager {

	static HashMap<String, Integer> Romap = new HashMap<>();
	static int RomanVals[] = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
	static TreeMap<Integer, String> Digmap = new TreeMap<>();

	static {
		Romap.put("I", 1);
		Romap.put("IV", 4);
		Romap.put("V", 5);
		Romap.put("IX", 9);
		Romap.put("X", 10);
		Romap.put("XL", 40);
		Romap.put("XC", 50);
		Romap.put("C", 100);
		Romap.put("CD", 400);
		Romap.put("D", 500);
		Romap.put("CM", 900);
		Romap.put("M", 1000);

		Digmap.put(1, "I");
		Digmap.put(4, "IV");
		Digmap.put(5, "V");
		Digmap.put(9, "IX");
		Digmap.put(10, "X");
		Digmap.put(40, "XL");
		Digmap.put(50, "L");
		Digmap.put(90, "XC");
		Digmap.put(100, "C");
		Digmap.put(400, "CD");
		Digmap.put(500, "D");
		Digmap.put(900, "CM");
		Digmap.put(1000, "M");
	}

	private static int getMax(int value) {

		int last = 0;
		for (int i = RomanVals.length - 1; i >= 0; i--)

		{
			int romy = RomanVals[i];
			if (value > romy)
				return romy;
		}
		return 1;
	}

	public String DigitsToRoman(int value) {
		String result = "";

		while (value > 0) {
			int numberToRemove = getMax(value);
			String romy = Digmap.get(numberToRemove);
			result += romy;
			value -= numberToRemove;

		}
		return result;
	}

	public int RomanToDigis(String source) {
		if (source == null || source.length() ==0)
			return 0;
		int val = 0;
		try {
			String tmp2, tmp1;
			while (true) {

				tmp2 = "";
				tmp1 = "";
				if (source.length() >= 2)
					tmp2 = source.substring(0, 2);
				tmp1 = source.substring(0, 1);
				Integer val2 = Romap.get(tmp2);
				Integer val1 = Romap.get(tmp1);
				if (val2 != null) {
					source = source.substring(2);
					val += val2;
				} else if (val1 != null) {
					source = source.substring(1);
					val += val1;
				} else
					break;

				// System.out.println("source ="+ source);
				// System.out.println("val ="+ val);

				if (source.length() == 0)
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	String accomulator = "";
	String convert = "";
	Action lastAction = null;
	boolean beforeAction = true;
	Window win;
	int firstNumber;
	int secondNumber;

	public CalculatorManager(Window window) {
		win = window;
	}

	public void pressedDigit(String val) {

		convert = "";
		accomulator += val;

		// TODO:convert function

		win.setText(accomulator, convert);
	}

	public void pressedAction(String val) {
		if (val.contains("C")) {
			lastAction = Action.C;
			clearAll();
			return;
		}

		if (lastAction != null) {
			accomulator = "ERROR";
			return;
		}
		
		if (val.contains("+")) {
			lastAction = Action.ADD;
		} else if (val.contains("-")) {
			lastAction = Action.SUB;
		} else if (val.contains("*")) {
			lastAction = Action.MUL;
		} else if (val.contains("/")) {
			lastAction = Action.DIV;
		}

		firstNumber = RomanToDigis(accomulator.trim());
		accomulator ="";
	}

	public void clearAll() {
		secondNumber = 0;
		firstNumber = 0;
		accomulator = "";
		lastAction = null;
		win.setText(accomulator, "");
	}

	public void pressedEQUAL(String val) {
		if (accomulator.equals("") || firstNumber == 0 || lastAction == null) {
			clearAll();
			return;
		}
		secondNumber = RomanToDigis(accomulator.trim());
		// secondNumber = (int) Double.parseDouble(accomulator);

		double result = 0;
		switch (lastAction) {
		case ADD:
			result = CalcUtils.add(firstNumber, secondNumber);
			clearAll();
			break;
		case SUB:
			result = CalcUtils.sub(firstNumber, secondNumber);
			clearAll();
			break;
		case MUL:
			result = CalcUtils.mul(firstNumber, secondNumber);
			clearAll();
			break;
		case DIV:
			result = CalcUtils.dev(firstNumber, secondNumber);
			clearAll();
			break;
		case C:
		default:
			result = 0;
			clearAll();
			break;
		}

		convert = "" + (int) result;
		accomulator = DigitsToRoman((int)result);
		win.setText(accomulator, convert);
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

	public void pressedConvert(String val) {
		if (val.contains("R>")) {
			lastAction = Action.CONV2DIG;
			int input = RomanToDigis(accomulator.trim());
			win.setText(accomulator, "" + input);

		} else if (val.contains("D>")) {
			lastAction = Action.CONV2ROM;
			int val3 = win.getDigit();
			accomulator = DigitsToRoman(val3);
			win.setText(accomulator, "" + val3);

		}

		lastAction = null;

	}
}