package modules.user.Model.BLL.BLL_User.CRUD;

import javax.swing.JOptionPane;

import classes.Lang.Language;
import modules.user.Model.DAO.funciones_users;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import modules.user.Model.classes.singleton;

public class funcionesCreate {
	public static void create_admin(admin a1) {
		int location = -1;

		a1 = (admin) funciones_users.create_userDNI(2);
		location = funciones_find.find_admin(a1);
		if (location != -1) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror2"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {

			a1 = (admin) funciones_users.create_user(2);
			singleton.useradmin.add(a1);
		}
	}

	public static void create_client(client c1) {
		int location = -1;

		c1 = (client) funciones_users.create_userDNI(1);
		location = funciones_find.find_client(c1);
		if (location != -1) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror2"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			c1 = (client) funciones_users.create_user(1);
			singleton.userclient.add(c1);
		}
	}

	public static void create_normal(normal n1) {
		int location = -1;

		n1 = (normal) funciones_users.create_userDNI(0);
		location = funciones_find.find_normal(n1);
		if (location != -1) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror2"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			n1 = (normal) funciones_users.create_user(0);
			singleton.usernormal.add(n1);
		}
	}

}
