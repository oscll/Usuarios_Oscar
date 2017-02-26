package utils;

import javax.swing.JOptionPane;

public class funciones_generic {

	//////////////////////////////////////////////////////////////////////////////////////////
	/// --------------------------------Enteros Integer
	public static int entero(String message, String titulo) {
		int num = 0;
		String number;
		boolean correcto = true;

		if (message == null)
			message = "Escribe un numero entero";
		if (titulo == null)
			titulo = "Number Int";

		do {
			try {
				number = JOptionPane.showInputDialog(null, message, titulo, JOptionPane.QUESTION_MESSAGE);

				if (number == null) {
					JOptionPane.showMessageDialog(null, "No has introducido un num int", "Error",
							JOptionPane.ERROR_MESSAGE);
					correcto = false;
				} else {
					num = Integer.parseInt(number);
					correcto = true;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido un num int", "Error",
						JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return num;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/// ----------------------------Enteros Integer!=0
	public static int entero_no0(String message, String titulo) {
		int num = 0;
		String number;
		boolean correcto = true;

		if (message == null)
			message = "Escribe un numero entero";
		if (titulo == null)
			titulo = "Number Int";

		do {
			try {
				number = JOptionPane.showInputDialog(null, message, titulo, JOptionPane.QUESTION_MESSAGE);

				if (number == null) {
					JOptionPane.showMessageDialog(null, "No has introducido un num int", "Error",
							JOptionPane.ERROR_MESSAGE);
					correcto = false;
				} else {

					num = Integer.parseInt(number);
					if (num == 0) {
						JOptionPane.showMessageDialog(null, "No puedes introducir el 0", "Error",
								JOptionPane.ERROR_MESSAGE);
						correcto = false;
					} else {
						correcto = true;
					}

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido un num int", "Error",
						JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return num;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/// ---------------------------------Cadena String
	public static String cadena(String message, String titulo) {
		String palabra = "";
		boolean correcto = true;

		if (message == null)
			message = "Escribe una cadena";
		if (titulo == null)
			titulo = "Cadena";

		do {
			try {
				palabra = JOptionPane.showInputDialog(null, message, titulo, JOptionPane.QUESTION_MESSAGE);
				correcto = true;
				if (palabra == null) {
					JOptionPane.showMessageDialog(null, "Vuelve  a escribir la cadena ", "Error",
							JOptionPane.ERROR_MESSAGE);
					correcto = false;
				}
				if (palabra.equals("")) {
					JOptionPane.showMessageDialog(null, "Error de introducción de datos", "Error",
							JOptionPane.ERROR_MESSAGE);
					correcto = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido una cadena", "Error",
						JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return palabra;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/// ---------------------------------------Float
	public static float v_float(String message, String title) {
		float num = 0.0f;
		String number = "";
		boolean correcto = true;

		if (message == null)
			message = "Escribe un num float";
		if (title == null)
			title = "Num float";

		do {
			try {
				number = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				if (number == null) {
					JOptionPane.showMessageDialog(null, "No has introducido un num float", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					num = Float.parseFloat(number);
					correcto = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido un num float", "Error",
						JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return num;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/// -------------------------------------Char-------------------------------------------///
	//////////////////////////////////////////////////////////////////////////////////////////
	public static char v_char(String message, String title) {
		char letter = 0;
		String cad = "";
		boolean correcto = true;

		if (message == null)
			message = "Escribe una letra";
		if (title == null)
			title = "Char Letra";

		do {
			try {
				cad = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				if (cad == null) {
					JOptionPane.showMessageDialog(null, "No has introducido una letra", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					letter = cad.charAt(0);
					correcto = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido una letra", "Error", JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return letter;
	}
}
