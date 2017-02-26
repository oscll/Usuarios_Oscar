package modules.user.Model.BLL.BLL_User.CRUD;

import javax.swing.JOptionPane;

import classes.Lang.Language;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import modules.user.Model.classes.singleton;
import utils.funciones_menus;

public class funcionesDelete {
	public static void delete_admin(admin a1) {
		int menu = 0, location = -1;
		String[] menu_print = { Language.getInstance().getProperty("all"), Language.getInstance().getProperty("one") };

		if (singleton.useradmin.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			menu = funciones_menus.menu_buttons(menu_print, Language.getInstance().getProperty("menu_secondtitle"),
					Language.getInstance().getProperty("asktitle"));
			switch (menu) {
			case 0:

				for (int i = (singleton.useradmin.size() - 1); i >= 0; i--) {
					singleton.useradmin.remove(i);
				}
				break;
			case 1:
				location = -1;
				a1 = funciones_find.IDadmin();
				location = funciones_find.find_admin(a1);
				if (location != -1) {
					singleton.useradmin.remove(location);
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("delete"));
				} else {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
							Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
		}
	}

	public static void delete_client(client c1) {
		int location = -1;
		int menu = 0;
		String[] menu_print = { Language.getInstance().getProperty("all"), Language.getInstance().getProperty("one") };

		if (singleton.userclient.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			menu = funciones_menus.menu_buttons(menu_print, Language.getInstance().getProperty("menu_secondtitle"),
					Language.getInstance().getProperty("asktitle"));
			switch (menu) {
			case 0:

				for (int i = (singleton.userclient.size() - 1); i >= 0; i--) {
					singleton.userclient.remove(i);
				}
				break;
			case 1:
				location = -1;
				c1 = funciones_find.IDclient();
				location = funciones_find.find_client(c1);
				if (location != -1) {
					singleton.userclient.remove(location);
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("delete"));
				} else {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
							Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
		}
	}

	public static void delete_normal(normal u1) {
		int location = -1;
		int menu = 0;
		String[] menu_print = { Language.getInstance().getProperty("all"), Language.getInstance().getProperty("one") };

		if (singleton.usernormal.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			menu = funciones_menus.menu_buttons(menu_print, Language.getInstance().getProperty("menu_secondtitle"),
					Language.getInstance().getProperty("asktitle"));
			switch (menu) {
			case 0:

				for (int i = (singleton.usernormal.size() - 1); i >= 0; i--) {
					singleton.usernormal.remove(i);
				}
				break;
			case 1:
				location = -1;
				u1 = funciones_find.IDnormal();
				location = funciones_find.find_normal(u1);
				if (location != -1) {
					singleton.usernormal.remove(location);
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("delete"));
				} else {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
							Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
				}
				break;
			}

		}
	}
}
