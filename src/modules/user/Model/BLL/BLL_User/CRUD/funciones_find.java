package modules.user.Model.BLL.BLL_User.CRUD;

import javax.swing.JOptionPane;

import classes.Lang.Language;
import modules.user.Model.DAO.funciones_users;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import modules.user.Model.classes.singleton;
import modules.user.Model.classes.user;
import utils.funciones_menus;

public class funciones_find {

	public static int find_admin(admin admin) {
		for (int i = 0; i <= (singleton.useradmin.size() - 1); i++) {
			if ((singleton.useradmin.get(i)).equals(admin))
				return i;
		}
		return -1;
	}

	public static int find_client(client client) {
		for (int i = 0; i <= (singleton.userclient.size() - 1); i++) {
			if ((singleton.userclient.get(i)).equals(client))
				return i;
		}
		return -1;
	}

	public static int find_normal(normal normal) {
		for (int i = 0; i <= (singleton.usernormal.size() - 1); i++) {
			if ((singleton.usernormal.get(i)).equals(normal))
				return i;
		}
		return -1;
	}

	public static String[] generate_vector_admin() {
		admin a1 = null;
		String s = "";
		int arraylist = singleton.useradmin.size();
		String[] user = new String[arraylist];
		for (int i = 0; i < arraylist; i++) {
			a1 = (admin) singleton.useradmin.get(i);
			s = a1.getDni() + "-----" + a1.getNom() + " " + a1.getUsername();
			user[i] = s;
		}

		return user;
	}

	public static String[] generate_vector_client() {
		client c1 = null;
		String s = "";
		int arraylist = singleton.userclient.size();
		String[] user = new String[arraylist];
		for (int i = 0; i < arraylist; i++) {
			c1 = (client) singleton.userclient.get(i);
			s = c1.getDni() + "-----" + c1.getNom() + " " + c1.getUsername();
			user[i] = s;
		}

		return user;
	}

	public static String[] generate_vector_normal() {
		normal u1 = null;
		String s = "";
		int arraylist = singleton.usernormal.size();
		String[] user = new String[arraylist];
		for (int i = 0; i < arraylist; i++) {
			u1 = (normal) singleton.usernormal.get(i);
			s = u1.getDni() + "-----" + u1.getNom() + " " + u1.getUsername();
			user[i] = s;
		}

		return user;
	}

	public static admin IDadmin() {
		admin a1 = null;
		boolean val = false;
		String ID = "";
		String search = "";
		do {
			String[] admin = generate_vector_admin();
			try {
				search = funciones_menus.menu_combo(admin, Language.getInstance().getProperty("select_user"),
						Language.getInstance().getProperty("asktitle"));
			} catch (Exception oa) {
				System.out.println("peto");
			}
			if (search != "") {
				for (int i = 0; i < 9; i++) {
					ID += search.charAt(i);
				}
				a1 = new admin(ID);
				val = true;
			}
		} while (val == false);
		return a1;
	}

	public static client IDclient() {
		client c1 = null;
		String ID = "";
		String search = "";
		boolean val = false;
		do {
			String[] client = generate_vector_client();
			try {
				search = funciones_menus.menu_combo(client, Language.getInstance().getProperty("select_user"),
						Language.getInstance().getProperty("asktitle"));
			} catch (Exception a) {
				System.out.println("peto");
			}
			if (search != "") {
				for (int i = 0; i < 9; i++) {
					ID += search.charAt(i);
				}
				c1 = new client(ID);
				val = true;
			}
		} while (val == false);
		return c1;
	}

	public static normal IDnormal() {
		normal u1 = null;
		String ID = "";
		String search = "";
		boolean val = false;
		do {
			String[] userregister = generate_vector_normal();
			try {
				search = funciones_menus.menu_combo(userregister, Language.getInstance().getProperty("select_user"),
						Language.getInstance().getProperty("asktitle"));
			} catch (Exception ao) {
				System.out.println("peto");
			}
			System.out.println("-------->>>>" + search);
			if (search != "") {
				for (int i = 0; i < 9; i++) {
					ID += search.charAt(i);
				}
				u1 = new normal(ID);
				val = true;
			}
		} while (val == false);
		return u1;
	}

	public static void set_adminDNI(admin a1, user param) {
		int location = -22;
		while (location != -1) {
			a1 = (admin) funciones_users.create_userDNI(2);
			location = funciones_find.find_admin(a1);
			if (location != -1) {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("errorDNI"),
						Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
			} else {
				param.setDni(singleton.DNI);
				System.out.println(singleton.DNI + " <---");
			}
			System.out.println("location -> " + location);
		}

	}

	public static void set_clientDNI(client c1, user param) {
		int location = -22;
		while (location != -1) {
			c1 = (client) funciones_users.create_userDNI(1);
			location = funciones_find.find_client(c1);
			if (location != -1) {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("errorDNI"),
						Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
			} else {
				param.setDni(singleton.DNI);
				System.out.println(singleton.DNI);
			}
		}
	}

	public static void set_normalDNI(normal u1, user param) {
		int location = -22;
		while (location != -1) {
			u1 = (normal) funciones_users.create_userDNI(0);
			location = funciones_find.find_normal(u1);
			if (location != -1) {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("errorDNI"),
						Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
			} else {
				param.setDni(singleton.DNI);
			}
		}

	}
}
