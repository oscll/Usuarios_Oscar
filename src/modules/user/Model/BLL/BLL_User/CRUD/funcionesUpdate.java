package modules.user.Model.BLL.BLL_User.CRUD;

import javax.swing.JOptionPane;

import classes.Lang.Language;
import modules.user.Model.DAO.funciones_users;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import modules.user.Model.classes.singleton;

public class funcionesUpdate {
	public static void update_admin(admin a1) {
		int location1 = -1;

		if (singleton.useradmin.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			location1 = -1;
			a1 = funciones_find.IDadmin();
			location1 = funciones_find.find_admin(a1);
			if (location1 != -1) {
				a1 = singleton.useradmin.get(location1);
				funciones_users.update_user(a1);
				singleton.useradmin.set(location1, a1);
			} else {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
						Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void update_client(client c1) {
		int location1 = -1;

		if (singleton.userclient.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			location1 = -1;
			c1 = funciones_find.IDclient();
			location1 = funciones_find.find_client(c1);
			if (location1 != -1) {
				c1 = singleton.userclient.get(location1);
				funciones_users.update_user(c1);
				singleton.userclient.set(location1, c1);
			} else {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
						Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void update_usernormal(normal u1) {
		int location1 = -1;

		if (singleton.usernormal.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("mainerror"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		} else {
			// location1 = -1;
			u1 = funciones_find.IDnormal();
			location1 = funciones_find.find_normal(u1);
			if (location1 != -1) {
				u1 = singleton.usernormal.get(location1);
				funciones_users.update_user(u1);
				singleton.usernormal.set(location1, u1);
			} else {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("usererror"),
						Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
