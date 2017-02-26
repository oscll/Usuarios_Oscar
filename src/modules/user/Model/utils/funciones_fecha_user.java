package modules.user.Model.utils;

import java.util.Calendar;

import javax.swing.JOptionPane;

import classes.fecha;
import classes.Lang.Language;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.user;
import utils.funciones_generic;
import utils.validate_users;

public class funciones_fecha_user {

	// Pide Fecha Nacimiento
	public static fecha pideFnac() {
		String fecha_nac = "";
		boolean result = false;
		boolean result2 = false;
		fecha fnac = null;
		int años = 0;
		do {
			fecha_nac = funciones_generic.cadena(Language.getInstance().getProperty("date_birthday"),
					Language.getInstance().getProperty("date_birthday2"));
			result = validate_users.validafechacorrecta(fecha_nac);
			if (result == false) {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("fecha_error_format"));
			} else {
				fnac = new fecha(fecha_nac);
				result2 = fnac.ValidaFecha(true);
				if (result2 == false) {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("fecha_error_no_exist"));
				} else {
					años = fnac.RestaFechas();
					if ((años < 18) || (años > 100)) {
						JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("fecha_error_no18"));
						result2 = false;
					}
				}
			}
		} while ((result == false) || (result2 == false));
		return fnac;
	}

	// Pide Fecha Contratacion
	public static fecha pideFcont(fecha fecha, String message, String title) {
		String fecha_cont = "";
		boolean result = false;
		boolean result2 = false;
		fecha fcont = null;
		int result_compara;
		do {
			fecha_cont = funciones_generic.cadena(message, title);
			result = validate_users.validafechacorrecta(fecha_cont);
			if (result == false) {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("fecha_error_format"));
			} else {
				fcont = new fecha(fecha_cont);
				result2 = fcont.ValidaFecha(true);
				if (result2 == false) {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("fecha_error_no_exist"));
				} else {

					fecha fnac = fecha;
					result_compara = fnac.comparafecha(fcont, 16);
					if (result_compara != (-1)) {
						result = false;
						JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("date_error"));
					}

				}
			}
		} while ((result == false) || (result2 == false));
		return fcont;
	}

	// Calcular años de edad y antiguit
	public static int Edad_Anti(fecha fecha) {
		return fecha.RestaFechas();
	}

	public static boolean comparaFnac_Fcont(user u, int edad_minima) {
		int resultado;
		fecha fnac = u.getFecha_nacimiento();
		Calendar fecha1 = Calendar.getInstance();
		Calendar fecha2 = Calendar.getInstance();
		fecha fcont = null;
		boolean resultado_final = false;

		edad_minima -= 1;

		if (u instanceof admin) {
			fcont = ((admin) u).getFecha_contratacion();
		} else {
			fcont = ((client) u).getFecha_Alta();
		}

		if (fcont != null) {

			fecha1.clear();
			fecha2.clear();

			fecha1.set((fnac.getAnyo() + 16), fnac.getMes() - 1, fnac.getDia());
			fecha2.set(fcont.getAnyo(), fcont.getMes() - 1, fcont.getDia());

			resultado = fecha1.compareTo(fecha2);
			if (resultado == -1)
				resultado_final = true;
			else {
				resultado_final = false;
			}
		}
		return resultado_final;

	}

}
