package modules.user.Model.classes.Order;

import java.util.Comparator;

import modules.user.Model.classes.user;

public class orderDni implements Comparator<user> {
	public int compare(user u1, user param) {

		String letra = u1.getDni().charAt(8) + "";
		String letra2 = param.getDni().charAt(8) + "";
		if (letra.compareTo(letra2) > 0)
			return 1;
		if (letra.compareTo(letra2) < 0)
			return -1;
		return 0;
	}
}
