package modules.user.Model.BLL.BLL_User.CRUD;

import javax.swing.JOptionPane;

import classes.Lang.Language;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import modules.user.Model.classes.singleton;
import utils.funciones_menus;

public class funcionesRead {

	public static void read_admin(admin a1) {
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
				for (int i = 0; i < singleton.useradmin.size(); i++) {
					String cad = "";
					cad = cad + (singleton.useradmin.get(i).toString());
					JOptionPane.showMessageDialog(null, cad);
				}
				break;
			case 1:
				location = -1;
				a1 = funciones_find.IDadmin();
				location = funciones_find.find_admin(a1);
				if (location != -1) {
					a1 = singleton.useradmin.get(location);
					JOptionPane.showMessageDialog(null, a1.toString());
				} else {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
							Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
		}
	}

	public static void read_client(client c1) {
		int menu = 0, location = -1;
		String[] menu_print = { Language.getInstance().getProperty("all"), Language.getInstance().getProperty("one") };

		if (singleton.userclient.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			menu = funciones_menus.menu_buttons(menu_print, Language.getInstance().getProperty("menu_secondtitle"),
					Language.getInstance().getProperty("asktitle"));
			switch (menu) {
			case 0:
				for (int i = 0; i < singleton.userclient.size(); i++) {
					String cad = "";
					cad = cad + (singleton.userclient.get(i).toString());
					JOptionPane.showMessageDialog(null, cad);
				}
				break;
			case 1:
				location = -1;
				c1 = funciones_find.IDclient();
				location = funciones_find.find_client(c1);
				if (location != -1) {
					c1 = singleton.userclient.get(location);
					JOptionPane.showMessageDialog(null, c1.toString());
				} else {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
							Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
		}
	}

	public static void read_usernormal(normal u1) {
		int menu = 0, location = -1;
		String[] menu_print = { Language.getInstance().getProperty("all"), Language.getInstance().getProperty("one") };

		if (singleton.usernormal.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			menu = funciones_menus.menu_buttons(menu_print, Language.getInstance().getProperty("menu_secondtitle"),
					Language.getInstance().getProperty("asktitle"));
			switch (menu) {
			case 0:
				for (int i = 0; i < singleton.usernormal.size(); i++) {
					String cad = "";
					cad = cad + (singleton.usernormal.get(i).toString());
					JOptionPane.showMessageDialog(null, cad);
				}
				break;
			case 1:
				location = -1;
				u1 = funciones_find.IDnormal();
				location = funciones_find.find_normal(u1);
				if (location != -1) {
					u1 = singleton.usernormal.get(location);
					JOptionPane.showMessageDialog(null, u1.toString());
				} else {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
							Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
		}
	}
}
