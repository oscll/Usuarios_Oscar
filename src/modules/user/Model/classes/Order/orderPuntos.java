package modules.user.Model.classes.Order;

import java.util.Comparator;

import modules.user.Model.classes.normal;
import modules.user.Model.classes.user;

public class orderPuntos implements Comparator<user> {

	public int compare(user u1, user u2) {
		if (((normal) u1).getPuntos() > ((normal) u2).getPuntos())
			return 1;
		if (((normal) u1).getPuntos() < ((normal) u2).getPuntos())
			return -1;
		return 0;
	}
}
