package utils;

import javax.swing.JOptionPane;

import classes.Lang.Language;

public class funciones_menus {
	//////////////////////////////////////////////////////////////////////////////////////////
	/// ---------------------------------Menu Buttons
	public static int menu_buttons(String[] tipo, String message, String titulo) {
		int op = 0;

		if (message == null)
			message = Language.getInstance().getProperty("choose_an_option");
		if (titulo == null)
			titulo = "Menu";

		op = JOptionPane.showOptionDialog(null, message, titulo, 0, JOptionPane.QUESTION_MESSAGE, null, tipo, tipo[0]);
		return op;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/// ---------------------------------Menu Buttons Users
	public static int menu_buttons_users() {
		int op = 0;
		String[] tipo_user = { Language.getInstance().getProperty("normal"),
				Language.getInstance().getProperty("client"), Language.getInstance().getProperty("admin"),
				Language.getInstance().getProperty("config"), Language.getInstance().getProperty("exit") };

		op = funciones_menus.menu_buttons(tipo_user, Language.getInstance().getProperty("choose_an_option"),
				Language.getInstance().getProperty("application_users"));
		return op;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/// ---------------------------------Menu Buttons C.R.U.D
	public static int menu_buttons_crud() {
		int op = 0;
		String[] menu_prin = { Language.getInstance().getProperty("C"), Language.getInstance().getProperty("R"),
				Language.getInstance().getProperty("U"), Language.getInstance().getProperty("D"),
				Language.getInstance().getProperty("G"), Language.getInstance().getProperty("order"),
				Language.getInstance().getProperty("save"), Language.getInstance().getProperty("open"),
				Language.getInstance().getProperty("go_back"), Language.getInstance().getProperty("exit") };

		op = funciones_menus.menu_buttons(menu_prin, Language.getInstance().getProperty("choose_an_option"),
				Language.getInstance().getProperty("C_R_U_D_G"));
		return op;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/// ---------------------------------Menu Buttons Settings
	public static int menu_buttons_settings() {
		int op = 0;
		String[] menu_set = { Language.getInstance().getProperty("formatFecha"),
				Language.getInstance().getProperty("currency"), Language.getInstance().getProperty("decimals"),
				Language.getInstance().getProperty("lang"), Language.getInstance().getProperty("dummies"),
				Language.getInstance().getProperty("formato_save"), Language.getInstance().getProperty("theme"),
				Language.getInstance().getProperty("reset"), Language.getInstance().getProperty("go_back"),
				Language.getInstance().getProperty("exit") };

		op = funciones_menus.menu_buttons(menu_set, Language.getInstance().getProperty("choose_an_option"), "Settings");
		return op;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/// ---------------------------------Menu Combo
	public static String menu_combo(String[] options, String message, String title) {
		Object option = null;
		boolean val = false;
		if (message == null)
			message = Language.getInstance().getProperty("choose_an_option");
		if (title == null)
			title = "Menu";
		System.out.println(options.length + "---<");
		do {
			option = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null, options,
					options[0]);
			for (int i = 0; i < options.length; i++) {
				if (option == options[i])
					val = true;
			}
		} while (val != true);
		return option.toString();
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/// ---------------------------------Menu Combo Normal
	public static String menu_combo_normal(String message, String title, boolean get) {
		String field;
		String[] options_get = { Language.getInstance().getProperty("dni"), Language.getInstance().getProperty("name2"),
				Language.getInstance().getProperty("address2"), Language.getInstance().getProperty("date_birthday2"),
				Language.getInstance().getProperty("age2"), Language.getInstance().getProperty("email2"),
				Language.getInstance().getProperty("avatar2"), Language.getInstance().getProperty("tipo2"),
				Language.getInstance().getProperty("user2"), Language.getInstance().getProperty("pass2"),
				Language.getInstance().getProperty("points2"), Language.getInstance().getProperty("numvisit2"),
				Language.getInstance().getProperty("comments2"), Language.getInstance().getProperty("karma2") };
		String[] options_set = { Language.getInstance().getProperty("dni"), Language.getInstance().getProperty("name2"),
				Language.getInstance().getProperty("address2"), Language.getInstance().getProperty("date_birthday2"),
				Language.getInstance().getProperty("email2"), Language.getInstance().getProperty("avatar2"),
				Language.getInstance().getProperty("tipo2"), Language.getInstance().getProperty("user2"),
				Language.getInstance().getProperty("pass2"),
				Language.getInstance().getProperty("numvisit2", Language.getInstance().getProperty("comments2")) };
		String[] options;
		if (get == true) {
			options = options_get;
		} else {
			options = options_set;
		}
		if (message == null)
			message = Language.getInstance().getProperty("choose_an_option");
		if (title == null)
			title = "Menu";
		field = menu_combo(options, message, title);
		if (field == Language.getInstance().getProperty("dni"))
			field = "Dni";
		else if (field == Language.getInstance().getProperty("name2"))
			field = "Nombre";
		else if (field == Language.getInstance().getProperty("address2"))
			field = "Address";
		else if (field == Language.getInstance().getProperty("date_birthday2"))
			field = "Fecha nacimiento";
		else if (field == Language.getInstance().getProperty("age2"))
			field = "Edad";
		else if (field == Language.getInstance().getProperty("email2"))
			field = "Email";
		else if (field == Language.getInstance().getProperty("avatar2"))
			field = "Avatar";
		else if (field == Language.getInstance().getProperty("tipo2"))
			field = "Tipo";
		else if (field == Language.getInstance().getProperty("user2"))
			field = "Username";
		else if (field == Language.getInstance().getProperty("pass2"))
			field = "Password";
		else if (field == Language.getInstance().getProperty("points2"))
			field = "Puntos";
		else if (field == Language.getInstance().getProperty("numvisit2"))
			field = "Numero de visitas";
		else if (field == Language.getInstance().getProperty("karma2"))
			field = "Karma";
		else if (field == Language.getInstance().getProperty("comments2"))
			field = "Comentarios";
		return field;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/// ---------------------------------Menu Combo Client
	public static String menu_combo_client(String message, String title, boolean get) {
		String field;
		String[] options_get = { Language.getInstance().getProperty("dni"), Language.getInstance().getProperty("name2"),
				Language.getInstance().getProperty("address2"), Language.getInstance().getProperty("date_birthday2"),
				Language.getInstance().getProperty("date_alta2"), Language.getInstance().getProperty("age2"),
				Language.getInstance().getProperty("email2"), Language.getInstance().getProperty("avatar2"),
				Language.getInstance().getProperty("tipo2"), Language.getInstance().getProperty("user2"),
				Language.getInstance().getProperty("pass2"), Language.getInstance().getProperty("antiquity2"),
				Language.getInstance().getProperty("money_spent2"), Language.getInstance().getProperty("discount2"),
				Language.getInstance().getProperty("numvisit2") };
		String[] options_set = { Language.getInstance().getProperty("dni"), Language.getInstance().getProperty("name2"),
				Language.getInstance().getProperty("address2"), Language.getInstance().getProperty("date_birthday2"),
				Language.getInstance().getProperty("date_alta2"), Language.getInstance().getProperty("email2"),
				Language.getInstance().getProperty("avatar2"), Language.getInstance().getProperty("tipo2"),
				Language.getInstance().getProperty("user2"), Language.getInstance().getProperty("pass2"),
				Language.getInstance().getProperty("money_spent2"), Language.getInstance().getProperty("numvisit2") };
		String[] options;
		if (get == true) {
			options = options_get;
		} else {
			options = options_set;
		}
		if (message == null)
			message = Language.getInstance().getProperty("choose_an_option");
		if (title == null)
			title = "Menu";

		field = menu_combo(options, message, title);
		if (field == Language.getInstance().getProperty("dni"))
			field = "Dni";
		else if (field == Language.getInstance().getProperty("name2"))
			field = "Nombre";
		else if (field == Language.getInstance().getProperty("address2"))
			field = "Address";
		else if (field == Language.getInstance().getProperty("date_birthday2"))
			field = "Fecha nacimiento";
		else if (field == Language.getInstance().getProperty("date_alta2"))
			field = "Fecha Alta";
		else if (field == Language.getInstance().getProperty("age2"))
			field = "Edad";
		else if (field == Language.getInstance().getProperty("email2"))
			field = "Email";
		else if (field == Language.getInstance().getProperty("avatar2"))
			field = "Avatar";
		else if (field == Language.getInstance().getProperty("tipo2"))
			field = "Tipo";
		else if (field == Language.getInstance().getProperty("user2"))
			field = "Username";
		else if (field == Language.getInstance().getProperty("pass2"))
			field = "Password";
		else if (field == Language.getInstance().getProperty("antiquity2"))
			field = "Antiguitat";
		else if (field == Language.getInstance().getProperty("numvisit2"))
			field = "Numero de visitas";
		else if (field == Language.getInstance().getProperty("discount2"))
			field = "Descuentos";
		else if (field == Language.getInstance().getProperty("money_spent2"))
			field = "Dinero gastado";
		return field;

	}

	//////////////////////////////////////////////////////////////////////////////////////////
	/// ---------------------------------Menu Combo Admin
	public static String menu_combo_admin(String message, String title, boolean get) {
		String[] options_get = { Language.getInstance().getProperty("dni"), Language.getInstance().getProperty("name2"),
				Language.getInstance().getProperty("address2"), Language.getInstance().getProperty("date_birthday2"),
				Language.getInstance().getProperty("hiring_date2"), Language.getInstance().getProperty("age2"),
				Language.getInstance().getProperty("email2"), Language.getInstance().getProperty("avatar2"),
				Language.getInstance().getProperty("tipo2"), Language.getInstance().getProperty("user2"),
				Language.getInstance().getProperty("pass2"), Language.getInstance().getProperty("antiquity2"),
				Language.getInstance().getProperty("salary2") };
		String[] options_set = { Language.getInstance().getProperty("dni"), Language.getInstance().getProperty("name2"),
				Language.getInstance().getProperty("address2"), Language.getInstance().getProperty("date_birthday2"),
				Language.getInstance().getProperty("hiring_date2"), Language.getInstance().getProperty("email2"),
				Language.getInstance().getProperty("avatar2"), Language.getInstance().getProperty("tipo2"),
				Language.getInstance().getProperty("user2"), Language.getInstance().getProperty("pass2") };
		String[] options;
		String field;
		if (get == true) {
			options = options_get;
		} else {
			options = options_set;
		}
		if (message == null)
			message = Language.getInstance().getProperty("choose_an_option");
		if (title == null)
			title = "Menu";
		field = menu_combo(options, message, title);
		if (field == Language.getInstance().getProperty("dni"))
			field = "Dni";
		else if (field == Language.getInstance().getProperty("name2"))
			field = "Nombre";
		else if (field == Language.getInstance().getProperty("address2"))
			field = "Address";
		else if (field == Language.getInstance().getProperty("date_birthday2"))
			field = "Fecha nacimiento";
		else if (field == Language.getInstance().getProperty("hiring_date2"))
			field = "Fecha contratacion";
		else if (field == Language.getInstance().getProperty("age2"))
			field = "Edad";
		else if (field == Language.getInstance().getProperty("email2"))
			field = "Email";
		else if (field == Language.getInstance().getProperty("avatar2"))
			field = "Avatar";
		else if (field == Language.getInstance().getProperty("tipo2"))
			field = "Tipo";
		else if (field == Language.getInstance().getProperty("user2"))
			field = "Username";
		else if (field == Language.getInstance().getProperty("pass2"))
			field = "Password";
		else if (field == Language.getInstance().getProperty("antiquity2"))
			field = "Antiguitat";
		else if (field == Language.getInstance().getProperty("salary2"))
			field = "Sueldo";
		return field;
	}
}
