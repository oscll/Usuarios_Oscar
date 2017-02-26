package modules.user.Model.classes.Order;

import java.util.Comparator;

import modules.user.Model.classes.client;
import modules.user.Model.classes.user;

public class orderShopping implements Comparator<user> {

	public int compare(user u1, user u2) {
		if (((client) u1).getPasta_que_ha_soltado() > ((client) u2).getPasta_que_ha_soltado())
			return 1;
		if (((client) u1).getPasta_que_ha_soltado() < ((client) u2).getPasta_que_ha_soltado())
			return -1;
		return 0;
	}
}