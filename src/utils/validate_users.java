package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import classes.Settings;

public class validate_users {
	// tel ((\+{1}[1-9]{1,3}))[ ]{1}[0-9]{9}
	private static final String plantilla_nombre = "^[a-zA-Z\\s]*$";
	private static final String plantilla_username = "^[A-Za-z0-9-\\s]*$";
	private static final String plantilla_id = "^([A-Z]{1})([0-9]{4})$";
	private static final String plantilla_CP = "^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$";
	private static final String plantilla_tlf = "((\\+{1}[1-9]{1,2})[ ]{1}[0-9]{9})";
	private static final String plantilla_dni = "([0-9]{8})([A-Z])";
	private static final String plantilla_email = ("^([A-Z|a-z|0-9](\\.|_){0,1})+[A-Z|a-z|0-9]\\@([A-Z|a-z|0-9])+((\\.){0,1}[A-Z|a-z|0-9]){2}\\.[a-z]{2,3}$");
	private static final String plantilla_date1 = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}$";
	private static final String plantilla_date2 = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20)\\d{2}$";
	private static final String plantilla_date3 = "^(19|20)\\d{2}/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$";
	private static final String plantilla_date4 = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
	private static final String plantilla_edad = "^([0-9]{1,2})$";
	private static final String plantilla_password = "^(?=.{8,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
	private static final String plantilla_tipo = "(([M]|[H]))";
	private static final String plantilla_puntos = "([0-9]{1,4})";
	private static final String plantilla_visitas = "([0-9]{1,9})";
	private static final String plantilla_descuentos = "([0-9]{1,2})";

	// validar nombre
	public static boolean validaNombre(String nombre) {
		Pattern pattern = Pattern.compile(plantilla_nombre);
		Matcher matcher = pattern.matcher(nombre);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	// validar puntos
	public static boolean validaPuntos(String puntos) {
		Pattern pattern = Pattern.compile(plantilla_puntos);
		Matcher matcher = pattern.matcher(puntos);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	// validar visitas
	public static boolean validaVisitas(String visitas) {
		Pattern pattern = Pattern.compile(plantilla_visitas);
		Matcher matcher = pattern.matcher(visitas);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	// validar descuento
	public static boolean validarDescuentos(String descuento) {
		Pattern pattern = Pattern.compile(plantilla_descuentos);
		Matcher matcher = pattern.matcher(descuento);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	// validar tipo
	public static boolean validatipo(String tipo) {
		Pattern pattern = Pattern.compile(plantilla_tipo);
		Matcher matcher = pattern.matcher(tipo);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	// validar Username
	public static boolean validaUsername(String nombreMixto) {
		Pattern pattern = Pattern.compile(plantilla_username);
		Matcher matcher = pattern.matcher(nombreMixto);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	// validar ID
	public static boolean validaId(String id) {
		Pattern pattern = Pattern.compile(plantilla_id);
		Matcher matcher = pattern.matcher(id);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	// validamos un apellido usando la misma plantilla de expresion regular del
	// nombre
	public static boolean validaApellido(String apellido) {
		Pattern pattern = Pattern.compile(plantilla_nombre);
		Matcher matcher = pattern.matcher(apellido);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	// Validamos un código postal
	public static boolean validaCodigoPostal(String codigo_postal) {
		Pattern pattern = Pattern.compile(plantilla_CP);
		Matcher matcher = pattern.matcher(codigo_postal);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	// Validamos un DNI
	public static boolean validaDNI(String dni_1) {
		char letter = 0;
		String dni_inv = "";
		Pattern pattern = Pattern.compile(plantilla_dni);
		Matcher matcher = pattern.matcher(dni_1);
		if (matcher.matches()) {
			letter = dni_1.charAt(dni_1.length() - 1);
			letter = Character.toUpperCase(letter);
			for (int i = 0; i <= (dni_1.length() - 2); i++) {
				dni_inv += dni_1.charAt(i);
			}
			System.out.println(dni_inv);
			int resto = ((Integer.parseInt(dni_inv)) % 23);
			char[] letra = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
					'H', 'L', 'C', 'K', 'E', 'T' };
			System.out.println(letter + " -- " + letra[resto]);
			if (letter == letra[resto]) {
				return true;
			}
		}
		return false;
	}

	// Validamos un numero de telefono español que empiece por 9, 6 o 7
	public static boolean validaTelefono(String tlf) {
		Pattern pattern = Pattern.compile(plantilla_tlf);
		Matcher matcher = pattern.matcher(tlf);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	// Validamos la contraseña
	public static boolean validaPassword(String psw) {
		Pattern pattern = Pattern.compile(plantilla_password);
		Matcher matcher = pattern.matcher(psw);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	// Validar un correo electronico
	public static boolean validaEmail(String email) {
		Pattern pattern = Pattern.compile(plantilla_email);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public static boolean validafechacorrecta(String fecha) {
		Pattern pattern = null;
		String formatoFecha = Settings.getInstance().getDate_config();

		switch (formatoFecha) {
		case "dd/mm/yyyy":
			pattern = Pattern.compile(plantilla_date1);
			break;
		case "dd-mm-yyyy":
			pattern = Pattern.compile(plantilla_date2);
			break;
		case "yyyy/mm/dd":
			pattern = Pattern.compile(plantilla_date3);
			break;
		case "yyyy-mm-dd":
			pattern = Pattern.compile(plantilla_date4);
		}
		Matcher matcher = pattern.matcher(fecha);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public static boolean validarangoedad(String edad) {
		Pattern pattern = Pattern.compile(plantilla_edad);
		Matcher matcher = pattern.matcher(edad);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

}
