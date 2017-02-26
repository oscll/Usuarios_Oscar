package modules.user.Model.classes.Order;

import java.util.Comparator;

import modules.user.Model.classes.admin;
import modules.user.Model.classes.user;

public class orderSalario implements Comparator<user> {

	public int compare(user u1, user u2) {
		if (((admin) u1).getSueldo() > ((admin) u2).getSueldo())
			return 1;
		if (((admin) u1).getSueldo() < ((admin) u2).getSueldo())
			return -1;
		return 0;
	}
}