package modules.user.Model.BLL.BLL_User.CRUD;

import java.util.Collections;

import javax.swing.JOptionPane;

import classes.Lang.Language;
import modules.user.Model.classes.singleton;
import modules.user.Model.classes.Order.orderAntiguidad;
import modules.user.Model.classes.Order.orderBirthday;
import modules.user.Model.classes.Order.orderDate_alta;
import modules.user.Model.classes.Order.orderDni;
import modules.user.Model.classes.Order.orderEdad;
import modules.user.Model.classes.Order.orderNombre;
import modules.user.Model.classes.Order.orderPuntos;
import modules.user.Model.classes.Order.orderSalario;
import modules.user.Model.classes.Order.orderShopping;
import utils.funciones_menus;

public class funcionesOrder {
	public static void change_orderadmin() {
		String[] options = { Language.getInstance().getProperty("dni"), Language.getInstance().getProperty("name2"),
				Language.getInstance().getProperty("date_birthday2"), Language.getInstance().getProperty("age2"),
				Language.getInstance().getProperty("salary2"), Language.getInstance().getProperty("antiquity2") };
		String menu = "";

		if (singleton.useradmin.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			menu = funciones_menus.menu_combo(options, Language.getInstance().getProperty("choose_an_option"),
					Language.getInstance().getProperty("asktitle"));
			if (menu == Language.getInstance().getProperty("dni"))
				Collections.sort(singleton.useradmin, new orderDni());
			else if (menu == Language.getInstance().getProperty("name2"))
				Collections.sort(singleton.useradmin, new orderNombre());
			else if (menu == Language.getInstance().getProperty("date_birthday2"))
				Collections.sort(singleton.useradmin, new orderBirthday());
			else if (menu == Language.getInstance().getProperty("age2"))
				Collections.sort(singleton.useradmin, new orderEdad());
			else if (menu == Language.getInstance().getProperty("salary2")) {
				Collections.sort(singleton.useradmin, new orderSalario());
			} else if (menu == Language.getInstance().getProperty("antiquity2")) {
				Collections.sort(singleton.useradmin, new orderAntiguidad());

			}

		}
	}

	public static void change_orderclient() {
		String[] options = { Language.getInstance().getProperty("dni"), Language.getInstance().getProperty("name2"),
				Language.getInstance().getProperty("date_birthday2"), Language.getInstance().getProperty("age2"),
				Language.getInstance().getProperty("money_spent2"), Language.getInstance().getProperty("date_alta2") };
		String menu = "";

		if (singleton.useradmin.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {

			menu = funciones_menus.menu_combo(options, Language.getInstance().getProperty("choose_an_option"),
					Language.getInstance().getProperty("asktitle"));

			if (menu == Language.getInstance().getProperty("dni"))
				Collections.sort(singleton.userclient, new orderDni());
			else if (menu == Language.getInstance().getProperty("name2"))
				Collections.sort(singleton.userclient, new orderNombre());
			else if (menu == Language.getInstance().getProperty("date_birthday2"))
				Collections.sort(singleton.userclient, new orderBirthday());
			else if (menu == Language.getInstance().getProperty("age2"))
				Collections.sort(singleton.userclient, new orderEdad());
			else if (menu == Language.getInstance().getProperty("money_spent2")) {
				Collections.sort(singleton.userclient, new orderShopping());
			} else if (menu == Language.getInstance().getProperty("date_alta2")) {
				Collections.sort(singleton.userclient, new orderDate_alta());
			}

		}
	}

	public static void change_ordernormal() {
		String[] options = { Language.getInstance().getProperty("dni"), Language.getInstance().getProperty("name2"),
				Language.getInstance().getProperty("date_birthday2"), Language.getInstance().getProperty("age2"),
				Language.getInstance().getProperty("points2") };
		String menu = "";

		if (singleton.useradmin.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			menu = funciones_menus.menu_combo(options, Language.getInstance().getProperty("choose_an_option"),
					Language.getInstance().getProperty("asktitle"));
			if (menu == Language.getInstance().getProperty("dni"))
				Collections.sort(singleton.usernormal, new orderDni());
			else if (menu == Language.getInstance().getProperty("name2"))
				Collections.sort(singleton.usernormal, new orderNombre());
			else if (menu == Language.getInstance().getProperty("date_birthday2"))
				Collections.sort(singleton.usernormal, new orderBirthday());
			else if (menu == Language.getInstance().getProperty("age2"))
				Collections.sort(singleton.usernormal, new orderEdad());
			else if (menu == Language.getInstance().getProperty("points2")) {
				Collections.sort(singleton.usernormal, new orderPuntos());
			}

		}
	}

}