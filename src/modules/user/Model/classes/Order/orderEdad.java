package modules.user.Model.classes.Order;

import java.util.Comparator;

import modules.user.Model.classes.user;

public class orderEdad implements Comparator<user> {

	public int compare(user u1, user u2) {
		if (u1.getEdad() > u2.getEdad())
			return 1;
		if (u1.getEdad() < u2.getEdad())
			return -1;
		return 0;
	}
}