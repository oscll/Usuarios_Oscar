package utils;

import classes.Settings;
import classes.Lang.Language;

public class funciones_settings {

	public static void dummies() {
		String title;
		if (Settings.getInstance().getDummies() != true) {
			title = Language.getInstance().getProperty("on");
		} else {
			title = Language.getInstance().getProperty("off");
		}
		String[] menu_idioma = { title, Language.getInstance().getProperty("go_back") };
		int menu;
		menu = funciones_menus.menu_buttons(menu_idioma, Language.getInstance().getProperty("choose_an_option"),
				"Dummies");

		switch (menu) {
		case 0:
			if (title == Language.getInstance().getProperty("on"))
				Settings.getInstance().setDummies(true);
			else if (title == Language.getInstance().getProperty("off"))
				Settings.getInstance().setDummies(false);
			break;
		case 1:
			break;

		}

	}

	public static void formato() {
		String[] menu_idioma = { "XML", "TXT" };
		int menu;

		menu = funciones_menus.menu_buttons(menu_idioma, Language.getInstance().getProperty("choose_an_option"),
				Language.getInstance().getProperty("lang"));

		switch (menu) {
		case 0:
			Settings.getInstance().setFormato(0);
			break;
		case 1:
			Settings.getInstance().setFormato(1);
			break;
		//JSON  case 2:
		//	        Settings.getInstance().setFormato(2);
		//			break;

		}

	}

	public static void idioma() {
		String[] menu_idioma = { Language.getInstance().getProperty("valencia"),
				Language.getInstance().getProperty("espanyol"), Language.getInstance().getProperty("english") };
		int menu;

		menu = funciones_menus.menu_buttons(menu_idioma, Language.getInstance().getProperty("choose_an_option"),
				Language.getInstance().getProperty("lang"));

		switch (menu) {
		case 0:
			Settings.getInstance().setLanguage("Valencia");
			break;
		case 1:
			Settings.getInstance().setLanguage("Spanish");
			break;
		case 2:
			Settings.getInstance().setLanguage("English");
			break;

		}

	}

	// Pide Divisa
	public static void divisa() {
		char divisa = ' ';
		String[] menu_divisa = { "€", "$", "£" };
		int menu = 0;

		menu = funciones_menus.menu_buttons(menu_divisa, Language.getInstance().getProperty("choose_an_options"),
				Language.getInstance().getProperty("currency"));

		switch (menu) {
		case 0:
			divisa = '€';
			break;
		case 1:
			divisa = '$';
			break;
		case 2:
			divisa = '£';
			break;
		}
		Settings.getInstance().setCurrency_config(divisa);
	}

	// Pide Decimal
	public static void decimal() {
		int decimal = 0, menu = 0;
		String[] menu_decimal = { "1", "2", "3" };

		menu = funciones_menus.menu_buttons(menu_decimal, Language.getInstance().getProperty("choose_an_options"),
				"Num decimales");

		switch (menu) {
		case 0:
			decimal = 1;
			break;
		case 1:
			decimal = 2;
			break;
		case 2:
			decimal = 3;
			break;
		}
		Settings.getInstance().setDecimals_config(decimal);
	}

	// Pide Formato Fecha
	public static void formatoFecha() {
		String formato = "";
		String[] menu_formatos = { "dd/mm/yyyy", "yyyy/mm/dd", "dd-mm-yyyy", "yyyy-mm-dd" };
		int menu = 0;

		menu = funciones_menus.menu_buttons(menu_formatos, Language.getInstance().getProperty("choose_an_options"),
				Language.getInstance().getProperty("fomatDate"));

		switch (menu) {
		case 0:
			formato = "dd/mm/yyyy";
			break;
		case 1:
			formato = "yyyy/mm/dd";
			break;
		case 2:
			formato = "dd-mm-yyyy";
			break;
		case 3:
			formato = "yyyy-mm-dd";
			break;
		}
		Settings.getInstance().setDate_config(formato);
	}

	public static void theme() {
		String[] options = { "METAL", "GTK", "MOTIF", "NINBUS" };
		int menu = 0;

		menu = funciones_menus.menu_buttons(options, Language.getInstance().getProperty("themetitle"),
				Language.getInstance().getProperty("asktitle"));
		switch (menu) {
		case 0:// Metal - Predeterminado JAVA
			Settings.getInstance().setTheme("METAL");
			//Functions_theme.theme();
			break;

		case 1:// GTK
			Settings.getInstance().setTheme("GTK");
			//Functions_theme.theme();
			break;

		case 2:// Motif
			Settings.getInstance().setTheme("MOTIF");
			//Functions_theme.theme();
			break;

		case 3:// Nimbus
			Settings.getInstance().setTheme("NINBUS");
			//Functions_theme.theme();
			break;
		}
	}

	public static void reset() {
		Settings.setInstance(new Settings());
		Language.getInstance().setIdioma();
		funciones_theme.theme();

	}

}
