package modules.user.Model.classes.Order;

import java.util.Comparator;

import modules.user.Model.classes.user;

public class orderNombre implements Comparator<user> {

	public int compare(user u1, user u2) {
		if (u1.getNom().compareTo(u2.getNom()) > 0)
			return 1;
		if (u1.getNom().compareTo(u2.getNom()) < 0)
			return -1;
		return 0;
	}
}
