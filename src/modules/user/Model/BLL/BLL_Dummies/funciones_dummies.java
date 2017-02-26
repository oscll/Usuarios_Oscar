package modules.user.Model.BLL.BLL_Dummies;

import java.util.Calendar;
import java.util.GregorianCalendar;

import classes.fecha;
import modules.user.Model.BLL.BLL_User.CRUD.funciones_find;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import modules.user.Model.classes.singleton;

public class funciones_dummies {
	/* User
	 * 
	 */
	public static String DNI(String dni) {
		String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKET";
		System.out.println(dni + NIF_STRING_ASOCIATION.charAt(Integer.parseInt(dni) % 23));
		return dni + NIF_STRING_ASOCIATION.charAt(Integer.parseInt(dni) % 23);
	}

	public static String dni() {
		String dni = "";

		for (int i = 0; i < 8; i++) {

			dni += String.valueOf((int) (Math.random() * (0 - 9) + 9));
		}

		return DNI(dni);
	}

	public static String username() {
		String[] users = { "Vicent", "Walter", "Joan", "Maria", "Daniel", "Josep", "Sara", "Pepa", "Felipe", "Jaume",
				"Sergio", "Paco", "Emilio", "Nando", "Alfons", "Eduard", "Atalia", "Veronica", "Fina", "Pepe", "Oscar",
				"Lorelay", "Jim", "Lola", "Laia", "Ismael", "Jordi", "Ramon", "Javier", "Nuria", "Elena", "Beltran",
				"Pablo", "Juanjo" };

		int position = (int) (Math.random() * 222) % 10;
		return users[position];
	}

	public static String password() {
		String[] passwords = { "dRepefA7a6Ru", "4Aremuchub2p", "pha5EyesTaxu", "Zu5rabRevUGe", "spasaCHEst2g",
				"kEmekAF4nuna", "swamABebRU2A", "ka2AcrEy3sEc", "haDRAtaruS2u", "FafR5zEstaw5", "zuyEh6yec6az",
				"q5Kewubrazep", "bapru7UquG4g", "BufRUfrefU4R", "s5esTAPUp2ub", "RujuthuCe7aM", "c27zUreSaCRu",
				"me8Ac5UYEpuj", "s34hEjUFrUbr", "ChaZakaTh4mE" };

		int position = (int) (Math.random() * 222) % 10;
		return passwords[position];
	}

	public static String avatar() {
		String[] avatars = { "vicent", "walter", "joan", "maria", "daniel", "josep", "sara", "pepa", "felipe", "jaume",
				"sergio", "paco", "emilio", "nando", "alfons", "eduard", "atalia", "veronica", "fina", "pepe", "oscar",
				"lorelay", "jim", "lola", "laia", "ismael", "jordi", "ramon", "javier", "nuria", "elena", "beltran",
				"pablo", "juanjo" };

		int position = (int) (Math.random() * 222) % 10;
		return avatars[position] + ".jpeg";
	}

	public static String tipo() {
		String[] states = { "M", "H" };
		int position = (int) (Math.random() * 222) % 2;
		return states[position];
	}

	public static String nom() {
		String[] names = { "Vicent", "Walter", "Joan", "Maria", "Daniel", "Josep", "Sara", "Pepa", "Felipe", "Jaume",
				"Sergio", "Paco", "Emilio", "Nando", "Alfons", "Eduard", "Atalia", "Veronica", "Fina", "Pepe", "Oscar",
				"Lorelay", "Jim", "Lola", "Laia", "Ismael", "Jordi", "Ramon", "Javier", "Nuria", "Elena", "Beltran",
				"Pablo", "Juanjo" };

		int position = (int) (Math.random() * 222) % 10;
		return names[position];
	}

	public static String address() {
		String[] address = { "Crta. Cádiz-Málaga, 13", "Avenida Cervantes, 25", "Calle Maestre 59", "Calle Aduana, 51",
				"Calle Aduana, 20", "Avda. Los llanos, 13", "Quevedo, 73", " Puerto Lugar, 8", " Rúa do Paseo, 74",
				" Rio Segura, 60", " Bouciña, 91", "Plaza de España, 2", " Rosa de los Vientos, 64",
				" Calle Carril de la Fuente, 23", " Outid de Arriba, 78", " Avda. de Andalucía, 82", " Escuadro, 95",
				" Boriñaur enparantza, 59", " Quevedo, 28", " Alvaro Cunqueiro, 83", " Avda. Enrique Peinador, 82",
				" Plaza de España, 98", "Pl. Virgen Blanca, 24", "Zumalakarregi etorbidea, 41", "San Andrés, 68",
				" Extramuros, 87", "Calle Carril de la Fuente, 80", "C/ Cuesta del Álamo, 7", "Ctra. de Siles, 41",
				"Ctra. de Fuentenueva, 73", "Avda. Generalísimo, 34", "Alcon Molina, 88", "La Fontanilla, 71",
				"Apartado de Correos, 73" };

		int position = (int) (Math.random() * 222) % 10;
		return address[position];
	}

	public static String email() {
		String[] emails = { "vicent", "walter", "joan", "maria", "daniel", "josep", "sara", "pepa", "felipe", "jaume",
				"sergio", "paco", "emilio", "nando", "alfons", "eduard", "atalia", "veronica", "fina", "pepe", "oscar",
				"lorelay", "jim", "lola", "laia", "ismael", "jordi", "ramon", "javier", "nuria", "elena", "beltran",
				"pablo", "juanjo" };

		int position = (int) (Math.random() * 222) % 10;
		return emails[position] + "@gmail.com";
	}

	public static fecha fecha_nacimiento() {

		int anyoactual = anyoactual();
		int anyos2 = (int) (Math.random() * (70 - 18) + 18);//max 70 anys i minim 18 anys 
		//int yyear = (int) (Math.random() * ((anyoactual() - 18) - (anyoactual() - 70)) + (anyoactual() - 70));//tart pero mes simple
		int anyos = anyoactual - anyos2;
		int day = (int) (Math.random() * (1 - 31) + 31);
		int month = (int) (Math.random() * (1 - 12) + 12);
		int year = anyos;
		return new fecha(String.valueOf(day), String.valueOf(month), String.valueOf(year));
	}

	public static int anyoactual() {
		Calendar fecha = new GregorianCalendar();
		int anyo = fecha.get(Calendar.YEAR);
		return anyo;
	}

	public static fecha fecha_contratacion(fecha Hola) {
		int anyoactual = anyoactual();
		int anyos = (int) (Math.random() * ((anyoactual - Hola.getAnyo()) - 16)) + 0;//minim 16 pa treballar
		//int yearr = (int) (Math.random() * (anyoactual - (Hola.getAnyo() + 16)) + (Hola.getAnyo() + 16));//tart pero mes simple
		int year = anyoactual - anyos;
		int day = (int) (Math.random() * (1 - 31) + 31);
		int month = (int) (Math.random() * (1 - 12) + 12);

		return new fecha(String.valueOf(day), String.valueOf(month), String.valueOf(year));
	}

	public static float salary() {
		float salary = (float) (Math.random() * (600 - 2000) + 2000);
		return (float) Math.rint(salary * 100) / 100;
	}

	public static float incentive() {
		float incentive = (float) (Math.random() * (200 - 500) + 500);
		return (float) Math.rint(incentive * 100) / 100;
	}

	public static int activity() {
		int activity = (int) (Math.random() * (10 - 100) + 100);
		return (int) Math.rint(activity * 100) / 100;
	}

	public static float shopping() {
		float shopping = (float) (Math.random() * (50 - 1000) + 1000);
		return (float) Math.rint(shopping * 100) / 100;
	}

	public static int dtos() {
		int dtos = (int) (Math.random() * (5 - 100) + 100);
		return (int) Math.rint(dtos * 100) / 100;
	}

	/* BUILDER
	 * 
	 */

	public static void makedummies_admin() {
		for (int i = 0; i < 6; i++) {
			create_admin();

		}
	}

	public static void create_admin() {
		int location = -1;
		admin a1 = null;
		String dni = "";
		do {
			location = -1;
			dni = dni();
			a1 = new admin(dni);
			location = funciones_find.find_admin(a1);

		} while (location != -1);
		fecha date_birthday = fecha_nacimiento();
		a1 = new admin(dni, nom(), address(), date_birthday, fecha_contratacion(date_birthday), email(), avatar(),
				tipo(), username(), password());
		singleton.useradmin.add(a1);
	}

	public static void makedummies_client() {
		for (int i = 0; i < 6; i++) {
			create_client();
		}
	}

	public static void create_client() {
		int location = -1;
		String dni = dni();
		client c1 = null;
		do {
			location = -1;
			dni = dni();
			c1 = new client(dni);
			location = funciones_find.find_client(c1);

		} while (location != -1);
		fecha date_birthday = fecha_nacimiento();
		c1 = new client(dni, nom(), address(), date_birthday, fecha_contratacion(date_birthday), email(), avatar(),
				tipo(), username(), password(), shopping(), dtos());
		singleton.userclient.add(c1);
	}

	public static void makedummies_normal() {
		for (int i = 0; i < 6; i++) {
			create_normal();
		}
	}

	public static void create_normal() {
		int location = -1;
		String dni = dni();
		normal n1 = null;
		do {
			location = -1;
			dni = dni();
			n1 = new normal(dni);
			location = funciones_find.find_normal(n1);

		} while (location != -1);
		n1 = new normal(dni, nom(), address(), fecha_nacimiento(), email(), avatar(), tipo(), username(), password(),
				dtos(), dtos());
		singleton.usernormal.add(n1);
	}
}
