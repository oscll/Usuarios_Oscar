package utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import classes.Settings;

public class Format {

	// Format decimals

	public static String decimal(float numero, int decimales) {
		String re = "";
		DecimalFormat formato = null;

		if ((decimales < 1) || (decimales > 3))
			decimales = 2;

		switch (decimales) {
		case 1:
			formato = new DecimalFormat(".0");
			re = formato.format(numero);
			break;
		case 2:
			formato = new DecimalFormat(".00");
			re = formato.format(numero);
			break;
		case 3:
			formato = new DecimalFormat(".000");
			re = formato.format(numero);
			break;
		}

		return re;
	}

	public static String moneda(float numero) {
		char divisa = Settings.getInstance().getCurrency_config();
		int decimal = Settings.getInstance().getDecimals_config();
		String newDecimals = "";
		String newNumber = "";
		String number = formatCurrency(numero);
		float number1;
		switch (Settings.getInstance().getCurrency_config()) {
		case '€':
			number1 = numero;
			break;
		case '$':
			number1 = numero * 1.05976f;
			break;
		case '£':
			number1 = numero * 0.83854f;
			break;
		default:
			number1 = numero;

		}
		String decimales = decimal(number1, decimal);
		NumberFormat moneda = null;
		String sueldo_final = "";
		String sueldo_dec;
		String[] sueldo_dec_p;
		String[] sueldo_final_p;
		String sueldo = "";

		switch (divisa) {
		case '€':
			// sueldo_dec = Format.decimal(numero, decimal);
			// sueldo_final = sueldo_dec + " €";
			sueldo_dec = Format.decimal(numero, decimal);
			sueldo_dec_p = sueldo_dec.split(",");
			moneda = NumberFormat.getCurrencyInstance(Locale.FRANCE);
			sueldo_final = moneda.format(numero);
			sueldo_final_p = sueldo_final.split(",");
			sueldo = sueldo_final_p[0] + "," + sueldo_dec_p[1] + " €";
			System.out.println(sueldo_final);
			System.out.println(sueldo_dec_p[1]);
			break;
		case '$':

			for (int i = 0; i < (number.length() - 2); i++) {
				newNumber += number.charAt(i);
				System.out.println(newNumber);//Format sin decimales pero con el punto
			}
			System.out.println(decimales);
			for (int i = (decimales.length() - decimal); i < decimales.length(); i++) {
				newDecimals += decimales.charAt(i);//Solo los decimales
			}
			System.out.println(newDecimals);
			sueldo = newNumber + newDecimals;
			break;
		case '£':
			for (int i = 0; i < (number.length() - 2); i++) {
				newNumber += number.charAt(i);
				System.out.println(newNumber);//Format sin decimales pero con el punto
			}
			System.out.println(decimales);
			for (int i = (decimales.length() - decimal); i < decimales.length(); i++) {
				newDecimals += decimales.charAt(i);//Solo los decimales
			}
			System.out.println(newDecimals);
			sueldo = newNumber + newDecimals;
			break;
		}
		return sueldo;
	}

	public static String formatCurrency(float moneda) {
		NumberFormat coin = null;
		switch (Settings.getInstance().getCurrency_config()) {
		case '$':
			coin = NumberFormat.getCurrencyInstance(Locale.US);
			moneda = moneda * 1.05976f;
			decimal(moneda, 3);
			break;
		case '£':
			coin = NumberFormat.getCurrencyInstance(Locale.UK);
			moneda = moneda * 0.83854f;
			break;
		case '€':
			coin = NumberFormat.getCurrencyInstance(Locale.FRANCE);
			break;
		}
		return (coin.format(moneda));
	}
}
