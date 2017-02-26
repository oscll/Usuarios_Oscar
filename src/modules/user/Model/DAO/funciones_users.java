package modules.user.Model.DAO;

import classes.fecha;
import classes.Lang.Language;
import modules.user.Model.BLL.BLL_User.CRUD.funciones_find;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import modules.user.Model.classes.singleton;
import modules.user.Model.classes.user;
import modules.user.Model.utils.funciones_datos_users;
import modules.user.Model.utils.funciones_fecha_user;
import utils.Format;
import utils.funciones_generic;
import utils.funciones_menus;

public class funciones_users {

	public static user create_user(int i) {
		// i = 0 Normal
		// i = 1 Client
		// i = 2 Admin
		user u = null;

		String dni = singleton.DNI;
		String nom = funciones_datos_users.pideNombre();
		String address = funciones_generic.cadena(Language.getInstance().getProperty("address"),
				Language.getInstance().getProperty("address2"));
		fecha fecha_nacimiento = funciones_fecha_user.pideFnac();
		String email = funciones_datos_users.pideEmail();
		String avatar = funciones_generic.cadena(Language.getInstance().getProperty("avatar"),
				Language.getInstance().getProperty("avatar2"));
		String tipo = funciones_datos_users.pideTipo();
		String username = funciones_datos_users.pideUsername();
		String password = funciones_datos_users.pidePassword();
		if (i == 0) {// Normal

			int n_visitas = funciones_datos_users.pideVisitas();
			int comentarios = funciones_datos_users.pideComentarios();
			u = new normal(dni, nom, address, fecha_nacimiento, email, avatar, tipo, username, password, comentarios,
					n_visitas);
		} else if (i == 1) {// Client

			int pasta_gastada = funciones_generic.entero(Language.getInstance().getProperty("money_spent"),
					Language.getInstance().getProperty("money_spent"));
			int n_visitas = funciones_datos_users.pideVisitas();
			fecha fecha_alta = funciones_fecha_user.pideFcont(fecha_nacimiento,
					Language.getInstance().getProperty("date_alta2"), Language.getInstance().getProperty("date_alta"));

			u = new client(dni, nom, address, fecha_nacimiento, fecha_alta, email, avatar, tipo, username, password,
					pasta_gastada, n_visitas);
		} else if (i == 2) {// Admin

			fecha fecha_contratacion = funciones_fecha_user.pideFcont(fecha_nacimiento,
					Language.getInstance().getProperty("hiring_date2"),
					Language.getInstance().getProperty("hiring_date"));
			u = new admin(dni, nom, address, fecha_nacimiento, fecha_contratacion, email, avatar, tipo, username,
					password);
		}
		return u;
	}

	public static user create_userDNI(int i) {

		user u = null;

		if (i == 0) {// Normal

			singleton.DNI = funciones_datos_users.pideDni();
			u = new normal(singleton.DNI);
		} else if (i == 1) {// Client

			singleton.DNI = funciones_datos_users.pideDni();
			u = new client(singleton.DNI);

		} else if (i == 2) {// Admin
			singleton.DNI = funciones_datos_users.pideDni();
			u = new admin(singleton.DNI);
		}
		return u;
	}

	public static user update_user(user u) {

		String field = "";
		String[] error_Fcont = { Language.getInstance().getProperty("date_birthday2"),
				Language.getInstance().getProperty("hiring_date2") };
		String[] error_Falta = { Language.getInstance().getProperty("date_birthday2"),
				Language.getInstance().getProperty("date_alta2") };
		int field1;
		boolean comparafnac_fcont = false;
		if (u instanceof normal) {
			normal n1 = null;
			field = funciones_menus.menu_combo_normal(Language.getInstance().getProperty("choose_an_option"),
					Language.getInstance().getProperty("Get"), false);
			System.out.println(field);
			switch (field) {
			case "Dni":
				funciones_find.set_normalDNI(n1, u);
				break;
			case "Nombre":
				((normal) u).setNom(funciones_datos_users.pideNombre());
				break;
			case "Address":
				((normal) u).setAddress(funciones_generic.cadena(Language.getInstance().getProperty("address"),
						Language.getInstance().getProperty("address2")));
				break;
			case "Email":
				((normal) u).setEmail(funciones_datos_users.pideEmail());
				break;
			case "Avatar":
				((normal) u).setAvatar(funciones_generic.cadena(Language.getInstance().getProperty("avatar"),
						Language.getInstance().getProperty("avatar2")));
				break;
			case "Tipo":
				((normal) u).setTipo(funciones_datos_users.pideTipo());
				break;
			case "Username":
				((normal) u).setUsername(funciones_datos_users.pideUsername());
				break;
			case "Password":
				((normal) u).setPassword(funciones_datos_users.pidePassword());
				break;
			case "Comentarios":
				((normal) u).setComentarios(funciones_generic.entero(Language.getInstance().getProperty("comments"),
						Language.getInstance().getProperty("comments2")));
				break;
			case "Numero de visitas":
				((normal) u).setN_visitas(funciones_generic.entero(Language.getInstance().getProperty("n_of_visits"),
						Language.getInstance().getProperty("n_of_visits2")));
				break;
			case "Fecha nacimiento":
				((normal) u).setFecha_nacimiento(funciones_fecha_user.pideFnac());
				break;
			}
		} else if (u instanceof client) {
			client c1 = null;
			field = funciones_menus.menu_combo_client(Language.getInstance().getProperty("choose_an_option"),
					Language.getInstance().getProperty("Get"), false);
			switch (field) {
			case "Dni":
				funciones_find.set_clientDNI(c1, u);
				break;
			case "Nombre":
				((client) u).setNom(funciones_datos_users.pideNombre());
				break;
			case "Address":
				((client) u).setAddress(funciones_generic.cadena(Language.getInstance().getProperty("address"),
						Language.getInstance().getProperty("address2")));
				break;

			case "Email":
				((client) u).setEmail(funciones_datos_users.pideEmail());
				break;
			case "Avatar":
				((client) u).setAvatar(funciones_generic.cadena(Language.getInstance().getProperty("avatar"),
						Language.getInstance().getProperty("avatar2")));
				break;
			case "Tipo":
				((client) u).setTipo(funciones_datos_users.pideTipo());
				break;
			case "Username":
				((client) u).setUsername(funciones_datos_users.pideUsername());
				break;
			case "Password":
				((client) u).setPassword(funciones_datos_users.pidePassword());
				break;

			case "Dinero gastado":
				((client) u).setPasta_que_ha_soltado(
						funciones_generic.entero(Language.getInstance().getProperty("money_spent"),
								Language.getInstance().getProperty("money_spent")));
				break;
			case "Numero de visitas":
				((client) u).setN_visitas(funciones_generic.entero(Language.getInstance().getProperty("n_of_visits"),
						Language.getInstance().getProperty("n_of_visits2")));
				break;
			case "Fecha nacimiento":
				do {
					((client) u).setFecha_nacimiento(funciones_fecha_user.pideFnac());
					comparafnac_fcont = funciones_fecha_user.comparaFnac_Fcont(u, 16);
					field1 = 1;
					if (comparafnac_fcont == false) {

						field1 = funciones_menus.menu_buttons(error_Falta,
								Language.getInstance().getProperty("error_set_birthday"),
								Language.getInstance().getProperty("Error"));
					}
				} while ((field1 == 0) && (comparafnac_fcont == false));
				if (comparafnac_fcont == true) {
					break;
				}
			case "Fecha Alta":
				((client) u).setFecha_Alta(funciones_fecha_user.pideFcont(((client) u).getFecha_nacimiento(),
						Language.getInstance().getProperty("date_alta2"),
						Language.getInstance().getProperty("date_alta")));

				break;

			}
		} else if (u instanceof admin) {
			admin a1 = null;
			field = funciones_menus.menu_combo_admin(Language.getInstance().getProperty("choose_an_option"),
					Language.getInstance().getProperty("Get"), false);
			switch (field) {
			case "Dni":
				funciones_find.set_adminDNI(a1, u);

				break;
			case "Nombre":
				((admin) u).setNom(funciones_datos_users.pideNombre());
				break;
			case "Address":
				((admin) u).setAddress(funciones_generic.cadena(Language.getInstance().getProperty("address"),
						Language.getInstance().getProperty("address2")));
				break;
			case "Email":
				((admin) u).setEmail(funciones_datos_users.pideEmail());
				break;
			case "Avatar":
				((admin) u).setAvatar(funciones_generic.cadena(Language.getInstance().getProperty("avatar"),
						Language.getInstance().getProperty("avatar2")));
				break;
			case "Tipo":
				((admin) u).setTipo(funciones_datos_users.pideTipo());
				break;
			case "Username":
				((admin) u).setUsername(funciones_datos_users.pideUsername());
				break;
			case "Password":
				((admin) u).setPassword(funciones_datos_users.pidePassword());
				break;
			case "Fecha nacimiento":
				do {
					((admin) u).setFecha_nacimiento(funciones_fecha_user.pideFnac());
					comparafnac_fcont = funciones_fecha_user.comparaFnac_Fcont(u, 16);
					field1 = 1;
					if (comparafnac_fcont == false) {

						field1 = funciones_menus.menu_buttons(error_Fcont,
								Language.getInstance().getProperty("error_set_birthday"),
								Language.getInstance().getProperty("Error"));
					}
				} while ((field1 == 0) && (comparafnac_fcont == false));
				if (comparafnac_fcont == true) {
					break;
				}
			case "Fecha contratacion":
				((admin) u).setFecha_contratacion(funciones_fecha_user.pideFcont(((admin) u).getFecha_nacimiento(),
						Language.getInstance().getProperty("hiring_date2"),
						Language.getInstance().getProperty("hiring_date")));
				break;
			}
		}
		return u;
	}

	public static String read_user(user u) {
		String cad = "";
		if (u instanceof normal) {
			cad = ((normal) u).toString();
		} else if (u instanceof client) {
			cad = ((client) u).toString();
		} else if (u instanceof admin) {
			cad = ((admin) u).toString();
		}
		return cad;
	}

	public static user delete_user(user u) {
		return u = null;

	}

	public static Object get_user(user u) {
		String field = "";
		Object o = null;

		if (u instanceof normal) {
			field = funciones_menus.menu_combo_normal(Language.getInstance().getProperty("choose_an_option"),
					Language.getInstance().getProperty("Get"), true);
			switch (field) {
			case "Dni":
				o = ((normal) u).getDni();
				break;
			case "Nombre":
				o = ((normal) u).getNom();
				break;
			case "Address":
				o = ((normal) u).getAddress();
				break;
			case "Edad":
				o = ((normal) u).getEdad();
				break;
			case "Email":
				o = ((normal) u).getEmail();
				break;
			case "Avatar":
				o = ((normal) u).getAvatar();
				break;
			case "Tipo":
				o = ((normal) u).getTipo();
				break;
			case "Username":
				o = ((normal) u).getUsername();
				break;
			case "Password":
				o = ((normal) u).getPassword();
				break;
			case "Puntos":
				o = ((normal) u).getPuntos();
				break;
			case "Numero de visitas":
				o = ((normal) u).getN_visitas();
				break;
			case "Fecha nacimiento":
				o = ((normal) u).getFecha_nacimiento().toString();
				break;
			case "Karma":
				o = ((normal) u).getKarma();
				break;
			case "Comentarios":
				o = ((normal) u).getComentarios();
				break;
			}
		} else if (u instanceof client) {
			field = funciones_menus.menu_combo_client(Language.getInstance().getProperty("choose_an_option"),
					Language.getInstance().getProperty("Get"), true);
			switch (field) {
			case "Dni":
				o = ((client) u).getDni();
				break;
			case "Nombre":
				o = ((client) u).getNom();
				break;
			case "Address":
				o = ((client) u).getAddress();
				break;
			case "Edad":
				o = ((client) u).getEdad();
				break;
			case "Email":
				o = ((client) u).getEmail();
				break;
			case "Avatar":
				o = ((client) u).getAvatar();
				break;
			case "Tipo":
				o = ((client) u).getTipo();
				break;
			case "Username":
				o = ((client) u).getUsername();
				break;
			case "Password":
				o = ((client) u).getPassword();
				break;
			case "Descuentos":
				o = ((client) u).getDescuentos();
				break;
			case "Numero de visitas":
				o = ((client) u).getN_visitas();
				break;
			case "Fecha nacimiento":
				o = ((client) u).getFecha_nacimiento().toString();
				break;
			case "Fecha Alta":
				o = ((client) u).getFecha_Alta().toString();
				break;
			case "Antiguitat":
				o = ((client) u).getAntiguitat_alta();
				break;
			case "Dinero gastado":
				o = Format.moneda(((client) u).getPasta_que_ha_soltado());
				break;

			}

		} else if (u instanceof admin) {
			field = funciones_menus.menu_combo_admin(Language.getInstance().getProperty("choose_an_option"),
					Language.getInstance().getProperty("Get"), true);
			switch (field) {
			case "Dni":
				o = ((admin) u).getDni();
				break;
			case "Nombre":
				o = ((admin) u).getNom();
				break;
			case "Address":
				o = ((admin) u).getAddress();
				break;
			case "Edad":
				o = ((admin) u).getEdad();
				break;
			case "Email":
				o = ((admin) u).getEmail();
				break;
			case "Avatar":
				o = ((admin) u).getAvatar();
				break;
			case "Tipo":
				o = ((admin) u).getTipo();
				break;
			case "Username":
				o = ((admin) u).getUsername();
				break;
			case "Password":
				o = ((admin) u).getPassword();
				break;
			case "Sueldo":
				o = Format.moneda(((admin) u).getSueldo());
				break;
			case "Fecha nacimiento":
				o = ((admin) u).getFecha_nacimiento().toString();
				break;
			case "Fecha contratacion":
				o = ((admin) u).getFecha_contratacion().toString();
				break;
			case "Antiguitat":
				o = ((admin) u).getAntiguitat();
				break;
			}
		}
		return o;
	}

}
