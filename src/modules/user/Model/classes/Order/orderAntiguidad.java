package modules.user.Model.classes.Order;

import java.util.Comparator;

import modules.user.Model.classes.admin;
import modules.user.Model.classes.user;

public class orderAntiguidad implements Comparator<user> {

	public int compare(user u1, user u2) {
		return ((admin) u1).getFecha_contratacion().comparafecha((((admin) u2).getFecha_contratacion()), 0);
	}
}