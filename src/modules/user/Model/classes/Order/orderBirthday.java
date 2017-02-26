package modules.user.Model.classes.Order;

import java.util.Comparator;

import modules.user.Model.classes.user;

public class orderBirthday implements Comparator<user> {

	public int compare(user u1, user u2) {
		// mayor a menor
		return u1.getFecha_nacimiento().comparafecha(u2.getFecha_nacimiento(), 0);
	}
}
