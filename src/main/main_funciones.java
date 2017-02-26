package main;

import javax.swing.JOptionPane;

import classes.Settings;
import classes.Lang.Language;
import modules.user.Model.BLL.BLL_User.CRUD.funcionesCreate;
import modules.user.Model.BLL.BLL_User.CRUD.funcionesDelete;
import modules.user.Model.BLL.BLL_User.CRUD.funcionesGet;
import modules.user.Model.BLL.BLL_User.CRUD.funcionesOrder;
import modules.user.Model.BLL.BLL_User.CRUD.funcionesRead;
import modules.user.Model.BLL.BLL_User.CRUD.funcionesUpdate;
import modules.user.Model.BLL.BLL_User.Save_Open.generic.open;
import modules.user.Model.BLL.BLL_User.Save_Open.generic.save;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import utils.funciones_menus;
import utils.funciones_settings;

public class main_funciones {

	public static void main(String[] args) {

		Settings.getInstance();

		int menu_settings = 0;
		int menu_p = 0;
		int t_user = 0;
		normal n = null;
		client c = null;
		admin a = null;

		do {
			t_user = funciones_menus.menu_buttons_users();
			if (t_user == -1) {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("goodbye"),
						Language.getInstance().getProperty("exit"), JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} else {
				do {
					if (t_user == 0) {// CRUD Normal
						menu_settings = 0;
						menu_p = funciones_menus.menu_buttons_crud();
						if (menu_p == -1) {
							JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("goodbye"),
									Language.getInstance().getProperty("exit"), JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} else {
							switch (menu_p) {
							case 0:
								funcionesCreate.create_normal(n);
								break;
							case 1:
								funcionesRead.read_usernormal(n);
								break;
							case 2:
								funcionesUpdate.update_usernormal(n);
								break;
							case 3:
								funcionesDelete.delete_normal(n);

								break;
							case 4:
								funcionesGet.get_normal(n);
								break;
							case 5:
								funcionesOrder.change_ordernormal();
								break;
							case 6:
								save.ondemand(t_user);
								break;
							case 7:
								open.ondemand(t_user);
								break;
							}
						}
					} else if (t_user == 1) {// CRUD Client
						menu_settings = 0;
						menu_p = funciones_menus.menu_buttons_crud();
						if (menu_p == -1) {
							JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("goodbye"),
									Language.getInstance().getProperty("exit"), JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} else {
							switch (menu_p) {
							case 0:
								funcionesCreate.create_client(c);
								break;
							case 1:
								funcionesRead.read_client(c);
								break;
							case 2:
								funcionesUpdate.update_client(c);
								break;

							case 3:
								funcionesDelete.delete_client(c);
								break;
							case 4:
								funcionesGet.get_client(c);
								break;
							case 5:
								funcionesOrder.change_orderclient();
								break;
							case 6:
								save.ondemand(t_user);
								break;
							case 7:
								open.ondemand(t_user);
								break;
							}
						}
					} else if (t_user == 2) { // CRUD Admin
						menu_settings = 0;
						menu_p = funciones_menus.menu_buttons_crud();
						if (menu_p == -1) {
							JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("goodbye"),
									Language.getInstance().getProperty("exit"), JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} else {
							switch (menu_p) {
							case 0:
								funcionesCreate.create_admin(a);
								break;
							case 1:
								funcionesRead.read_admin(a);
								break;
							case 2:
								funcionesUpdate.update_admin(a);
								break;
							case 3:
								funcionesDelete.delete_admin(a);
								break;
							case 4:
								funcionesGet.get_admin(a);
								break;
							case 5:
								funcionesOrder.change_orderadmin();
								break;
							case 6:
								save.ondemand(t_user);
								break;
							case 7:
								open.ondemand(t_user);
								break;

							}
						}
					} else if (t_user == 3) {
						menu_settings = funciones_menus.menu_buttons_settings();
						menu_p = -4;
						if (menu_settings == -1) {
							JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("goodbye"),
									Language.getInstance().getProperty("exit"), JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} else {
							switch (menu_settings) {
							case 0:// FormatoFecha
								funciones_settings.formatoFecha();
								break;
							case 1:// Divisa
								funciones_settings.divisa();
								break;
							case 2:// Decimales
								funciones_settings.decimal();
								break;
							case 3:// Idioma
								funciones_settings.idioma();
								break;
							case 4:// Dummies
								funciones_settings.dummies();
								break;
							case 5://Formato
								funciones_settings.formato();
								break;
							case 6://Theme
								funciones_settings.theme();
								break;
							case 7://Reset
								funciones_settings.reset();

							}
						}
					}
				} while ((menu_p != 8) && (menu_p != 9) && (menu_settings != 8) && (menu_settings != 9)
						&& (t_user != 4));

			}
		} while (((t_user != 4) && (menu_p != 9)) && (menu_settings != 9));
		save.auto();

	}
}
