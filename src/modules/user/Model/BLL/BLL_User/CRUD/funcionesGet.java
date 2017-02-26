package modules.user.Model.BLL.BLL_User.CRUD;

import javax.swing.JOptionPane;

import classes.Lang.Language;
import modules.user.Model.DAO.funciones_users;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import modules.user.Model.classes.singleton;

public class funcionesGet {

	public static void get_admin(admin a1) {
		int location = -1;
		if (singleton.useradmin.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			location = -1;
			a1 = funciones_find.IDadmin();
			location = funciones_find.find_admin(a1);
			if (location != -1) {
				a1 = singleton.useradmin.get(location);
				JOptionPane.showMessageDialog(null, funciones_users.get_user(a1));
			} else {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
						Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public static void get_client(client c1) {
		int location = -1;
		if (singleton.userclient.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			location = -1;
			c1 = funciones_find.IDclient();
			location = funciones_find.find_client(c1);
			if (location != -1) {
				c1 = singleton.userclient.get(location);
				JOptionPane.showMessageDialog(null, funciones_users.get_user(c1));
			} else {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
						Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void get_normal(normal n1) {
		int location = -1;
		if (singleton.usernormal.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			location = -1;
			n1 = funciones_find.IDnormal();
			location = funciones_find.find_normal(n1);
			if (location != -1) {
				n1 = singleton.usernormal.get(location);
				JOptionPane.showMessageDialog(null, funciones_users.get_user(n1));
			} else {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
						Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
