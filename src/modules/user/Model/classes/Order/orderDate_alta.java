package modules.user.Model.classes.Order;

import java.util.Comparator;

import modules.user.Model.classes.client;
import modules.user.Model.classes.user;

public class orderDate_alta implements Comparator<user> {
	public int compare(user u1, user u2) {
		return ((client) u1).getFecha_Alta().comparafecha((((client) u2).getFecha_Alta()), 0);
	}
}
