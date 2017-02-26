package modules.user.Model.utils;

import javax.swing.JOptionPane;

import classes.Lang.Language;
import utils.funciones_generic;
import utils.validate_users;

public class funciones_datos_users {

	// Pide DNI

	public static String pideDni() {
		String dni = "";
		boolean val;
		do {
			dni = funciones_generic.cadena(Language.getInstance().getProperty("dni2"),
					Language.getInstance().getProperty("dni"));
			val = validate_users.validaDNI(dni);
			if (val == false)
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("Error"),
						Language.getInstance().getProperty("Error"), JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);
		return dni;
	}// Pide Password

	public static String pidePassword() {
		String s = "";
		boolean val;
		do {
			s = funciones_generic.cadena(Language.getInstance().getProperty("pass"),
					Language.getInstance().getProperty("pass2"));
			val = validate_users.validaPassword(s);
			if (val == false)
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("Error"),
						Language.getInstance().getProperty("Error"), JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);
		return s;
	}// Pide Email

	public static String pideEmail() {
		String s = "";
		boolean val;
		do {
			s = funciones_generic.cadena(Language.getInstance().getProperty("email"),
					Language.getInstance().getProperty("email2"));
			val = validate_users.validaEmail(s);
			if (val == false)
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("Error"),
						Language.getInstance().getProperty("Error"), JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);
		return s;
	}// Pide Nombre

	public static String pideNombre() {
		String s = "";
		boolean val;
		do {
			s = funciones_generic.cadena(Language.getInstance().getProperty("name"),
					Language.getInstance().getProperty("name2"));
			val = validate_users.validaNombre(s);
			if (val == false)
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("Error"),
						Language.getInstance().getProperty("Error"), JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);
		return s;
	}// Pide Edad

	public static Integer pideEdad() {
		String s = "";
		int i = 0;
		boolean val;
		do {
			s = funciones_generic.cadena(Language.getInstance().getProperty("age"),
					Language.getInstance().getProperty("age2"));
			val = validate_users.validarangoedad(s);
			if (val == false)
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("Error"),
						Language.getInstance().getProperty("Error"), JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);
		i = Integer.parseInt(s);
		return i;
	}// Pide Username

	public static String pideUsername() {
		String s = "";
		boolean val;
		do {
			s = funciones_generic.cadena(Language.getInstance().getProperty("user"),
					Language.getInstance().getProperty("user2"));
			val = validate_users.validaUsername(s);
			if (val == false)
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("Error"),
						Language.getInstance().getProperty("Error"), JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);
		return s;
	}// Pide Tipo

	public static String pideTipo() {
		String s = "";
		boolean val;
		do {
			s = funciones_generic.cadena(Language.getInstance().getProperty("tipo"),
					Language.getInstance().getProperty("tipo2"));
			val = validate_users.validatipo(s);
			if (val == false)
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("Error"),
						Language.getInstance().getProperty("Error"), JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);
		return s;
	}

	public static Integer pideComentarios() {
		String s = "";
		int i = 0;
		boolean val;
		do {
			s = funciones_generic.cadena(Language.getInstance().getProperty("comments"),
					Language.getInstance().getProperty("comments2"));
			val = validate_users.validaPuntos(s);
			if (val == false)
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("Error"),
						Language.getInstance().getProperty("Error"), JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);
		i = Integer.parseInt(s);
		return i;
	}

	public static Integer pideVisitas() {
		String s = "";
		int i = 0;
		boolean val;
		do {
			s = funciones_generic.cadena(Language.getInstance().getProperty("n_of_visits"),
					Language.getInstance().getProperty("n_of_visits2"));
			val = validate_users.validaVisitas(s);
			if (val == false)
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("Error"),
						Language.getInstance().getProperty("Error"), JOptionPane.INFORMATION_MESSAGE);
		} while (val == false);
		i = Integer.parseInt(s);
		return i;
	}

}
